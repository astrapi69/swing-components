package io.github.astrapi69.swing.robot;

import java.awt.*;

/**
 * The class {@link MouseExtensions} provides utility methods for mouse information
 */
public class MouseExtensions
{

	/**
	 * Get the position of the mouse as {@link Point} object
	 *
	 * @return the position of the mouse as {@link Point} object
	 */
	public static Point getMousePosition()
	{
		return MouseInfo.getPointerInfo().getLocation();
	}

	/**
	 * Checks if the mouse position is in the bounds of the given {@link Component} object
	 * 
	 * @param component
	 *            the component
	 *
	 * @return true if the mouse position is in the bounds of the given {@link Component} object
	 *         otherwise false
	 */
	public static boolean isMouseWithin(Component component)
	{
		Point mousePos = MouseExtensions.getMousePosition();
		Rectangle bounds = component.getBounds();
		bounds.setLocation(component.getLocationOnScreen());
		return bounds.contains(mousePos);
	}
}
