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

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.github.astrapi69.junit.jupiter.callback.before.test.IgnoreHeadlessExceptionExtension;
import io.github.astrapi69.swing.test.IgnoreAWTExceptionExtension;

/**
 * The unit test class for the class {@link RobotExtensions}
 */
@ExtendWith({ IgnoreHeadlessExceptionExtension.class, IgnoreAWTExceptionExtension.class })
public class RobotExtensionsTest
{

	/**
	 * Test method for {@link RobotExtensions#clickMouseButton(Robot, int, int, int)}
	 */
	@Test
	public void testClickMouse() throws AWTException
	{
		RobotExtensions.clickMouseButton(new Robot(), 400, 400, InputEvent.BUTTON1_DOWN_MASK);
	}

	/**
	 * Test method for {@link RobotExtensions#clickLeftMouseButton(Robot, int, int)}
	 */
	@Test
	public void clickLeftMouseButton() throws AWTException, InterruptedException
	{
		RobotExtensions.clickLeftMouseButton(new Robot(), 400, 400);
	}

	/**
	 * Test method for {@link RobotExtensions#clickMiddleMouseButton(Robot, int, int)}
	 */
	@Test
	public void clickMiddleMouseButton() throws AWTException, InterruptedException
	{
		RobotExtensions.clickMiddleMouseButton(new Robot(), 400, 400);
	}

	/**
	 * Test method for {@link RobotExtensions#clickRightMouseButton(Robot, int, int)}
	 */
	@Test
	public void clickRightMouseButton() throws AWTException, InterruptedException
	{
		RobotExtensions.clickRightMouseButton(new Robot(), 400, 400);
	}

	/**
	 * Test method for {@link RobotExtensions#infiniteMoveMouse(Robot, int, int, long)}
	 */
	@Test
	@Disabled
	public void testInfiniteMoveMouse() throws AWTException, InterruptedException
	{
		RobotExtensions.infiniteMoveMouse(new Robot(), 400, 400, 200);
	}

	/**
	 * Test method for
	 * {@link RobotExtensions#moveMouseForSpecificDuration(Robot, int, int, long, long)}
	 */
	@Test
	public void testMoveMouse() throws AWTException, InterruptedException
	{
		RobotExtensions.moveMouseForSpecificDuration(new Robot(), 400, 400, 20, 2000);
	}
}
