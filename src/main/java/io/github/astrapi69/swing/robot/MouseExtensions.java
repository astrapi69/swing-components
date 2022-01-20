package io.github.astrapi69.swing.robot;

import java.awt.*;

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


	public static boolean isMouseWithin(Component component)
	{
		Point mousePos = MouseInfo.getPointerInfo().getLocation();
		Rectangle bounds = component.getBounds();
		bounds.setLocation(component.getLocationOnScreen());
		return bounds.contains(mousePos);
	}
}
