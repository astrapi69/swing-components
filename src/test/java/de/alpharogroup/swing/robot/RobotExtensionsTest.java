package de.alpharogroup.swing.robot;

import java.awt.AWTException;
import java.awt.Robot;

import org.testng.annotations.Test;

public class RobotExtensionsTest
{

	@Test(enabled = false)
	public void testInfiniteMoveMouse() throws AWTException, InterruptedException
	{
		RobotExtensions.infiniteMoveMouse(new Robot(), 400, 400, 200);
	}

	@Test
	public void testMoveMouse() throws AWTException, InterruptedException
	{
		RobotExtensions.moveMouseForSpecificDuration(new Robot(), 400, 400, 20, 2000);
	}
}