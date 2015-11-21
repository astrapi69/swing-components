/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
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
package de.alpharogroup.swing.utils;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

import de.alpharogroup.lang.ClassExtensions;

/**
 * The Class AwtUtils.
 */
public final class AwtUtils
{
	/**
	 * Gets the root JDialog from the given Component Object.
	 * 
	 * @param component
	 *            The Component to find the root JDialog.
	 * @return 's the root JDialog.
	 */
	public static Component getRootJDialog(Component component)
	{
		while (null != component.getParent())
		{
			component = component.getParent();
			if (component instanceof JDialog)
			{
				break;
			}
		}
		return component;
	}

	/**
	 * Gets the root JFrame from the given Component Object.
	 * 
	 * @param component
	 *            The Component to find the root JFrame.
	 * @return 's the root JFrame.
	 */
	public static Component getRootJFrame(Component component)
	{
		while (null != component.getParent())
		{
			component = component.getParent();
			if (component instanceof JFrame)
			{
				break;
			}
		}
		return component;
	}

	/**
	 * Gets the root parent from the given Component Object.
	 * 
	 * @param component
	 *            The Component to find the root parent.
	 * @return 's the root parent.
	 */
	public static Component getRootParent(Component component)
	{
		while (null != component.getParent())
		{
			component = component.getParent();
		}
		return component;
	}

	/**
	 * Creates an invisible cursor.
	 * 
	 * @return s the created invisible cursor.
	 */
	public static Cursor newInvisibleCursor()
	{
		return Toolkit.getDefaultToolkit().createCustomCursor(
			Toolkit.getDefaultToolkit().createImage(new byte[0]), new Point(0, 0),
			"InvisibleCursor");
	}

	/**
	 * Sets the icon image from the given resource name and add it to the given window object.
	 * 
	 * @param resourceName
	 *            The name from the resource. This includes the absolute path to the image icon from
	 *            the classpath.
	 * @param window
	 *            the window in which to set the icon image.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void setIconImage(final String resourceName, final Window window)
		throws IOException
	{
		final InputStream isLogo = ClassExtensions.getResourceAsStream(resourceName);
		final BufferedImage biLogo = ImageIO.read(isLogo);
		window.setIconImage(biLogo);
	}
}
