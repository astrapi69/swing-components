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

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.security.SecureRandom;

import io.github.astrapi69.random.SecureRandomFactory;

/**
 * The class {@link RobotExtensions} provides utility methods for the class {@link Robot}
 */
public class RobotExtensions
{

	/**
	 * Clicks the given mouse button
	 * @param robot
	 *            the robot
	 * @param x
	 *            the X position
	 * @param y
	 *            the Y position
	 * @param mouseButtonMask
	 */
	public static void clickMouseButton(Robot robot, int x, int y, int mouseButtonMask) {
		robot.mouseMove(x, y);
		robot.mousePress(mouseButtonMask);
		robot.mouseRelease(mouseButtonMask);
	}

	/**
	 * Clicks the left mouse button
	 * 
	 * @param robot
	 *            the robot
	 * @param x
	 *            the X position
	 * @param y
	 *            the Y position
	 */
	public static void clickLeftMouseButton(Robot robot, int x, int y)
	{
		clickMouseButton(robot, x, y, InputEvent.BUTTON1_DOWN_MASK);
	}

	/**
	 * Clicks the middle mouse button
	 * 
	 * @param robot
	 *            the robot
	 * @param x
	 *            the X position
	 * @param y
	 *            the Y position
	 */
	public static void clickMiddleMouseButton(Robot robot, int x, int y)
	{
		clickMouseButton(robot, x, y, InputEvent.BUTTON2_DOWN_MASK);
	}

	/**
	 * Clicks the right mouse button
	 * 
	 * @param robot
	 *            the robot
	 * @param x
	 *            the X position
	 * @param y
	 *            the Y position
	 */
	public static void clickRightMouseButton(Robot robot, int x, int y)
	{
		clickMouseButton(robot, x, y, InputEvent.BUTTON3_DOWN_MASK);
	}

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
	public static int getKeyCode(final char character)
		throws IllegalAccessException, NoSuchFieldException
	{
		final String c = String.valueOf(character).toUpperCase();
		final String variableName = "VK_" + c;
		final Class<KeyEvent> clazz = KeyEvent.class;
		final Field field = clazz.getField(variableName);
		final int keyCode = field.getInt(null);
		return keyCode;
	}

	/**
	 * Move the mouse with the given robot in infinity mode
	 *
	 * @param robot
	 *            the robot
	 * @param x
	 *            the X position
	 * @param y
	 *            the Y position
	 * @param everyMilliSeconds
	 *            * the milli seconds to execute every time
	 * @throws InterruptedException
	 *             is thrown if the current thread is interrupted
	 */
	public static void infiniteMoveMouse(final Robot robot, int x, int y, long everyMilliSeconds)
		throws InterruptedException
	{
		infiniteMoveMouse(robot, x, y, everyMilliSeconds, Thread.MIN_PRIORITY);
	}

	/**
	 * Move the mouse with the given robot in infinity mode
	 *
	 * @param robot
	 *            the robot
	 * @param x
	 *            the X position
	 * @param y
	 *            the Y position
	 * @param everyMilliSeconds
	 *            * the milli seconds to execute every time
	 * @param threadPriority
	 *            the thread priority of the current thread. Note: the thread priority is between 1
	 *            till 10, if smaller or greater 1 will be taken
	 * @throws InterruptedException
	 *             is thrown if the current thread is interrupted
	 */
	public static void infiniteMoveMouse(final Robot robot, int x, int y, long everyMilliSeconds,
		int threadPriority) throws InterruptedException
	{
		SecureRandom secureRandom = SecureRandomFactory.newSecureRandom();
		setCurrentThreadPriority(threadPriority);
		while (true)
		{
			robot.mouseMove(secureRandom.nextInt(x), secureRandom.nextInt(y));
			Thread.sleep(everyMilliSeconds);
		}
	}

	/**
	 * Move the mouse with the given robot in infinity mode
	 *
	 * @param robot
	 *            the robot
	 * @param x
	 *            the X position
	 * @param y
	 *            the Y position
	 * @param everyMilliSeconds
	 *            * the milli seconds to execute every time
	 * @param duration
	 *            * the milli seconds of the duration
	 * @throws InterruptedException
	 *             is thrown if the current thread is interrupted
	 */
	public static void moveMouseForSpecificDuration(final Robot robot, int x, int y,
		long everyMilliSeconds, long duration) throws InterruptedException
	{
		moveMouseForSpecificDuration(robot, x, y, everyMilliSeconds, duration, Thread.MIN_PRIORITY);
	}

	/**
	 * Move the mouse with the given robot in the given duration and the given thread priority
	 *
	 * @param robot
	 *            the robot
	 * @param x
	 *            the X position
	 * @param y
	 *            the Y position
	 * @param everyMilliSeconds
	 *            * the milli seconds to execute every time
	 * @param threadPriority
	 *            the thread priority of the current thread. Note: the thread priority is between 1
	 *            till 10, if smaller or greater 1 will be taken
	 * @param duration
	 *            * the milli seconds of the duration
	 * @throws InterruptedException
	 *             is thrown if the current thread is interrupted
	 */
	public static void moveMouseForSpecificDuration(final Robot robot, int x, int y,
		long everyMilliSeconds, long duration, int threadPriority) throws InterruptedException
	{
		SecureRandom secureRandom = SecureRandomFactory.newSecureRandom();
		setCurrentThreadPriority(threadPriority);
		long counter = 0;
		while (counter < duration)
		{
			robot.mouseMove(secureRandom.nextInt(x), secureRandom.nextInt(y));
			counter += everyMilliSeconds;
			Thread.sleep(everyMilliSeconds);
		}
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

	/**
	 * Set the given priority of the current thread<br>
	 * <br>
	 * Note: the thread priority is between 1 till 10, if smaller or greater the minimum priority 1
	 * will be taken
	 *
	 * @param threadPriority
	 */
	public static void setCurrentThreadPriority(int threadPriority)
	{
		if (threadPriority >= 1 && threadPriority <= 10)
		{
			Thread.currentThread().setPriority(threadPriority);
		}
		else
		{
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		}
	}

}
