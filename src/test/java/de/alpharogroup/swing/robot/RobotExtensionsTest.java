package de.alpharogroup.swing.robot;

import org.testng.annotations.Test;

import java.awt.*;
import java.util.Random;

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
		RobotExtensions.moveMouseForSpecificDuration(new Robot(), 400, 400, 20, 20000);
	}
}