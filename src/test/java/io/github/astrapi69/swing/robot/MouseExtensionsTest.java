package io.github.astrapi69.swing.robot;

import org.testng.annotations.Test;

import java.awt.Point;

import static org.testng.Assert.*;

public class MouseExtensionsTest
{

	@Test
	public void testGetMousePosition()
	{
		Point currentMousePosition;

		currentMousePosition = MouseExtensions.getMousePosition();
		assertNotNull(currentMousePosition);
	}
}
