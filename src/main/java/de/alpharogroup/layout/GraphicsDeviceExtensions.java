package de.alpharogroup.layout;

import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

/**
 * The class {@link GraphicsDeviceExtensions} helps you if the user have more than one screen to determine which screen is currently shown.
 */
public class GraphicsDeviceExtensions
{

	/**
	 * Gets the available screens.
	 *
	 * @return the available screens
	 */
	public static GraphicsDevice[] getAvailableScreens() {
		final GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
	        .getLocalGraphicsEnvironment();
	    final GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
	    return graphicsDevices;
	}

	/**
	 * Gets the graphics device (screen) is showing on.
	 *
	 * @param component the component
	 * @return the graphics device is showing on
	 */
	public static GraphicsDevice getGraphicsDeviceIsShowingOn(final Component component) {
		final GraphicsDevice graphicsDevice = component.getGraphicsConfiguration().getDevice();
		return graphicsDevice;
	}


	/**
	 * Gets the array index(in the available {@link GraphicsDevice} array) of the given component is showing on.
	 *
	 * @param component the component
	 * @return the array index(in the available {@link GraphicsDevice} array) of the given component is showing on.
	 */
	public static int getGraphicsDeviceIndexIsShowingOn(final Component component) {
		final GraphicsDevice graphicsDevice = getGraphicsDeviceIsShowingOn(component);
		final GraphicsDevice[] graphicsDevices = getAvailableScreens();
		for (int i = 0; i < graphicsDevices.length; i++)
		{
			if(graphicsDevices[i].equals(graphicsDevice)) {
				return i;
			}
		}
		return 0;
	}


	/**
	 * Checks if the given screen number is available to show.
	 *
	 * @param screen the screen
	 * @return true, if is screen available to show
	 */
	public static boolean isScreenAvailableToShow(final int screen) {
		final GraphicsDevice[] graphicsDevices = getAvailableScreens();
	    boolean screenAvailableToShow = false;
	    if( (screen > -1 && screen < graphicsDevices.length) || ( graphicsDevices.length > 0 ) )
	    {
	    	screenAvailableToShow = true;
	    }
	    return screenAvailableToShow;
	}

	/**
	 * If the screen is available the given {@link JFrame} will be show in the given screen.
	 *
	 * @param screen the screen number.
	 * @param frame the {@link JFrame}
	 */
	public static void showOnScreen( final int screen, final JFrame frame )
	{
		if( isScreenAvailableToShow(screen) ) {
			final GraphicsDevice[] graphicsDevices = getAvailableScreens();
			graphicsDevices[screen].setFullScreenWindow( frame );
		}
	}
}
