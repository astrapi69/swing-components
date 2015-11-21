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
package de.alpharogroup.swing.robot;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

/**
 * The Class RobotUtils.
 */
public class RobotUtils
{

	/**
	 * Gets the key code from the given char.
	 *
	 * @param character
	 *            the character
	 * @return the key code
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws NoSuchFieldException
	 *             the no such field exception
	 */
	public static int getKeyCode(final char character) throws IllegalAccessException,
		NoSuchFieldException
	{
		final String c = String.valueOf(character).toUpperCase();
		final String variableName = "VK_" + c;
		final Class<KeyEvent> clazz = KeyEvent.class;
		final Field field = clazz.getField(variableName);
		final int keyCode = field.getInt(null);
		return keyCode;
	}

	/**
	 * Types the given char with the given robot.
	 *
	 * @param robot
	 *            the robot
	 * @param character
	 *            the character
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws NoSuchFieldException
	 *             the no such field exception
	 */
	public static void typeCharacter(final Robot robot, final char character)
		throws IllegalAccessException, NoSuchFieldException
	{
		final boolean upperCase = Character.isUpperCase(character);
		final int keyCode = getKeyCode(character);
		if (upperCase)
		{
			robot.keyPress(KeyEvent.VK_SHIFT);
		}
		robot.keyPress(keyCode);
		robot.keyRelease(keyCode);
		if (upperCase)
		{
			robot.keyRelease(KeyEvent.VK_SHIFT);
		}
	}

	/**
	 * Type the given string with the given robot.
	 *
	 * @param robot
	 *            the robot
	 * @param input
	 *            the input
	 * @throws NoSuchFieldException
	 *             the no such field exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 */
	public static void typeString(final Robot robot, final String input)
		throws NoSuchFieldException, IllegalAccessException
	{
		if (input != null && !input.isEmpty())
		{
			for (final char character : input.toCharArray())
			{
				typeCharacter(robot, character);
			}
		}
	}
}
