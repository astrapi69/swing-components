/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.layout;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import javax.swing.*;

import lombok.NonNull;
import io.github.astrapi69.collections.array.ArrayExtensions;
import io.github.astrapi69.reflection.ReflectionExtensions;
import io.github.astrapi69.swing.utils.AwtExtensions;

/**
 * Utility class for handle with screensize.
 *
 * @author Asterios Raptis
 * @version 1.0
 */
public class ScreenSizeExtensions
{

	/**
	 * Set given {@link Window} to the center of the device and divide them with the given arguments
	 *
	 * @param component
	 *            the component
	 * @param divideScreenWith
	 *            the value to divide with the screen with
	 * @param divideScreenHeight
	 *            the value to divide with the screen height
	 */
	public static void centralize(@NonNull Component component, int divideScreenWith,
		int divideScreenHeight)
	{
		Window window = AwtExtensions.getWindowForComponent(component);
		centralize(window, divideScreenWith, divideScreenHeight);
	}

	/**
	 * Set given {@link Window} to the center of the device and divide them with the given arguments
	 *
	 * @param window
	 *            the window
	 * @param divideScreenWith
	 *            the value to divide with the screen with
	 * @param divideScreenHeight
	 *            the value to divide with the screen height
	 */
	public static void centralize(@NonNull Window window, int divideScreenWith,
		int divideScreenHeight)
	{
		final int x = ScreenSizeExtensions.getScreenWidth(window);
		final int y = ScreenSizeExtensions.getScreenHeight(window);
		final int width = x;
		final int height = y;
		window.setLocation((width / divideScreenWith), (height / divideScreenHeight));
		window.setSize((width / divideScreenWith), (height / divideScreenHeight));
	}

	/**
	 * Compute how much dialog can be put into the screen and returns a list with the coordinates
	 * from the dialog positions as Point objects.
	 *
	 * @param dialogWidth
	 *            the dialog width
	 * @param dialogHeight
	 *            the dialog height
	 * @return the list with the computed Point objects.
	 */
	public static List<Point> computeDialogPositions(final int dialogWidth, final int dialogHeight)
	{
		List<Point> dialogPosition = null;
		final int windowBesides = ScreenSizeExtensions.getScreenWidth() / dialogWidth;
		final int windowBelow = ScreenSizeExtensions.getScreenHeight() / dialogHeight;
		final int listSize = windowBesides * windowBelow;
		dialogPosition = new ArrayList<>(listSize);
		int dotWidth = 0;
		int dotHeight = 0;
		for (int y = 0; y < windowBelow; y++)
		{
			dotWidth = 0;
			for (int x = 0; x < windowBesides; x++)
			{
				final Point p = new Point(dotWidth, dotHeight);
				dialogPosition.add(p);
				dotWidth = dotWidth + dialogWidth;
			}
			dotHeight = dotHeight + dialogHeight;
		}
		return dialogPosition;
	}

	/**
	 * Gets the first screen width.
	 *
	 * @return the first screen width.
	 */
	public static int getFirstScreenHeight()
	{
		final GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
			.getLocalGraphicsEnvironment();
		final GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
		int height = getScreenHeight();
		for (final GraphicsDevice graphicsDevice : graphicsDevices)
		{
			final GraphicsConfiguration[] graphicsConfigurations = graphicsDevice
				.getConfigurations();
			final GraphicsConfiguration graphicsConfiguration = ArrayExtensions
				.getFirst(graphicsConfigurations);
			if (graphicsConfiguration != null)
			{
				height = (int)getScreenHeight(graphicsConfiguration);
				break;
			}
		}
		return height;
	}

	/**
	 * Gets the first screen width.
	 *
	 * @return the first screen width.
	 */
	public static int getFirstScreenWidth()
	{
		final GraphicsDevice[] graphicsDevices = getScreenDevices();
		int width = getScreenWidth();
		for (final GraphicsDevice graphicsDevice : graphicsDevices)
		{
			final GraphicsConfiguration[] graphicsConfigurations = graphicsDevice
				.getConfigurations();
			final GraphicsConfiguration graphicsConfiguration = ArrayExtensions
				.getFirst(graphicsConfigurations);
			if (graphicsConfiguration != null)
			{
				width = (int)getScreenWidth(graphicsConfiguration);
				break;
			}
		}
		return width;
	}

	/**
	 * Gets the {@link GraphicsConfiguration} from the given screen id
	 *
	 * @param screenID
	 *            the screen id
	 *
	 * @return the {@link GraphicsConfiguration} object from the given screen id
	 */
	public static GraphicsConfiguration getGraphicsConfiguration(int screenID)
	{
		return getScreenDevice(screenID).getDefaultConfiguration();
	}

	/**
	 * Gets the Screensize and returns it as a Point object.
	 *
	 * @return A Point object.
	 */
	public static Point getPoint()
	{
		final Point p = new Point(getScreenWidth(), getScreenHeight());
		return p;
	}

	/**
	 * Gets the screen device from the given screen id
	 *
	 * @param screenID
	 *            the screen id
	 *
	 * @return the {@link GraphicsDevice} object from the given screen id
	 */
	public static GraphicsDevice getScreenDevice(int screenID)
	{
		return getScreenDevices()[screenID];
	}

	/**
	 * Gets all the screen devices.
	 *
	 * @return the screen devices
	 */
	public static GraphicsDevice[] getScreenDevices()
	{
		final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		final GraphicsDevice[] gs = ge.getScreenDevices();
		return gs;
	}

	/**
	 * Gets the screen dimension.
	 *
	 * @param component
	 *            the component
	 * @return the screen dimension
	 */
	public static Dimension getScreenDimension(Component component)
	{
		int screenID = getScreenID(component);
		Dimension dimension = new Dimension(0, 0);

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsConfiguration defaultConfiguration = ge.getScreenDevices()[screenID]
			.getDefaultConfiguration();
		Rectangle rectangle = defaultConfiguration.getBounds();
		dimension.setSize(rectangle.getWidth(), rectangle.getHeight());
		return dimension;
	}

	/**
	 * Gets the height from the current screen.
	 *
	 * @return Returns the height from the current screen.
	 */
	public static int getScreenHeight()
	{
		final int y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		return y;
	}

	/**
	 * Gets the screen height of the {@link GraphicsDevice} that is displayed from the given
	 * component
	 *
	 * @param component
	 *            the component
	 * @return the screen height
	 */
	public static int getScreenHeight(Component component)
	{
		Dimension dimension = getScreenDimension(component);
		return dimension.height;
	}

	/**
	 * Gets the screen width from the given {@link GraphicsConfiguration} object
	 *
	 * @param graphicsConfiguration
	 *            the graphic configuration object
	 *
	 * @return the screen width.
	 */
	public static double getScreenHeight(final GraphicsConfiguration graphicsConfiguration)
	{
		final Rectangle bounds = graphicsConfiguration.getBounds();
		final double height = bounds.getHeight();
		return height;
	}

	/**
	 * Gets the screen height from the given {@link GraphicsDevice} object.
	 *
	 * @param graphicsDevice
	 *            the {@link GraphicsDevice} object.
	 * @return the screen height from the given {@link GraphicsDevice} object.
	 */
	public static int getScreenHeight(final GraphicsDevice graphicsDevice)
	{
		final GraphicsConfiguration[] graphicsConfigurations = graphicsDevice.getConfigurations();
		final GraphicsConfiguration graphicsConfiguration = ArrayExtensions
			.getFirst(graphicsConfigurations);
		if (graphicsConfiguration != null)
		{
			final double height = getScreenHeight(graphicsConfiguration);
			return (int)height;
		}
		return getScreenHeight();
	}

	/**
	 * Gets the screen ID from the given component
	 *
	 * @param component
	 *            the component
	 * @return the screen ID
	 */
	public static int getScreenID(Component component)
	{
		int screenID;
		final AtomicInteger counter = new AtomicInteger(-1);
		Stream.of(getScreenDevices()).forEach(graphicsDevice -> {

			GraphicsConfiguration gc = graphicsDevice.getDefaultConfiguration();
			Rectangle rectangle = gc.getBounds();
			if (rectangle.contains(component.getLocation()))
			{
				try
				{
					Object object = ReflectionExtensions.getFieldValue(graphicsDevice, "screen");
					Integer sid = (Integer)object;
					counter.set(sid);
				}
				catch (NoSuchFieldException | SecurityException | IllegalArgumentException
					| IllegalAccessException e)
				{
					e.printStackTrace();
				}
			}
		});
		screenID = counter.get();
		return screenID;
	}

	/**
	 * Gets the width from the current screen.
	 *
	 * @return Returns the width from the current screen.
	 */
	public static int getScreenWidth()
	{
		final int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		return x;
	}

	/**
	 * Gets the screen width of the {@link GraphicsDevice} that is displayed from the given
	 * component
	 *
	 * @param component
	 *            the component
	 * @return the screen width
	 */
	public static int getScreenWidth(Component component)
	{
		Dimension dimension = getScreenDimension(component);
		return dimension.width;
	}

	/**
	 * Gets the screen width from the given {@link GraphicsConfiguration} object
	 *
	 * @param graphicsConfiguration
	 *            the graphic configuration object
	 *
	 * @return the screen width.
	 */
	public static double getScreenWidth(final GraphicsConfiguration graphicsConfiguration)
	{
		final Rectangle bounds = graphicsConfiguration.getBounds();
		final double width = bounds.getWidth();
		return width;
	}

	/**
	 * Gets the screen width from the given {@link GraphicsDevice} object.
	 *
	 * @param graphicsDevice
	 *            the {@link GraphicsDevice} object.
	 * @return the screen width from the given {@link GraphicsDevice} object.
	 */
	public static int getScreenWidth(final GraphicsDevice graphicsDevice)
	{
		final GraphicsConfiguration[] graphicsConfigurations = graphicsDevice.getConfigurations();
		final GraphicsConfiguration graphicsConfiguration = ArrayExtensions
			.getFirst(graphicsConfigurations);
		if (graphicsConfiguration != null)
		{
			return (int)getScreenWidth(graphicsConfiguration);
		}
		return getScreenWidth();
	}

	/**
	 * Bring the given {@link Frame} to the front
	 *
	 * @param frame
	 *            the frame
	 */
	public static void showFrame(@NonNull Frame frame)
	{
		// Show the Frame.
		frame.setVisible(true);
		// bring to front
		if (!frame.isActive())
		{
			frame.toFront();
		}
	}

	/**
	 * Toggle given {@link Frame} to full screen mode or if it is in full screen mode its returns to
	 * normal mode
	 *
	 * @param frame
	 *            the frame
	 */
	public static void toggleFullScreen(@NonNull JFrame frame)
	{
		GraphicsDevice device = frame.getGraphicsConfiguration().getDevice();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		if (frame.equals(device.getFullScreenWindow()))
		{
			device.setFullScreenWindow(null);
		}
		else
		{
			frame.setVisible(true);
			device.setFullScreenWindow(frame);
		}
	}

}
