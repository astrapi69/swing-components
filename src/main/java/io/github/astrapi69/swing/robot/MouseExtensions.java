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
package io.github.astrapi69.swing.robot;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

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
	 * Set the position of the mouse to the given coordinates x and y
	 *
	 * @param robot
	 *            the robot
	 * @param x
	 *            the X position
	 * @param y
	 *            the Y position
	 */
	public static void setMousePosition(Robot robot, int x, int y)
	{
		robot.mouseMove(x, y);
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
		Point mousePosition = MouseExtensions.getMousePosition();
		Rectangle bounds = component.getBounds();
		bounds.setLocation(component.getLocationOnScreen());
		return bounds.contains(mousePosition);
	}
}
