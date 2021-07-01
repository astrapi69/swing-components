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
package io.github.astrapi69.layout;

import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.astrapi69.BaseTestCase;

/**
 * The unit test class for the class {@link ScreenSizeExtensions}.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public class ScreenSizeExtensionsTest extends BaseTestCase
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	@BeforeMethod
	protected void setUp() throws Exception
	{
		super.setUp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@AfterMethod
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	/**
	 * Test method for.
	 *
	 * {@link io.github.astrapi69.layout.ScreenSizeExtensions#computeDialogPositions(int, int)} .
	 */
	@Test(enabled = false)
	public void testComputeDialogPositions()
	{
		final List<Point> expected = new ArrayList<>();
		final int dialogHeight = 200;
		final int dialogWidth = 250;
		final int windowBesides = ScreenSizeExtensions.getScreenWidth() / dialogWidth;
		final int windowBelow = ScreenSizeExtensions.getScreenHeight() / dialogHeight;
		final int listSize = windowBesides * windowBelow;
		final List<Point> dialogPositions = ScreenSizeExtensions.computeDialogPositions(dialogWidth,
			dialogHeight);
		actual = listSize == dialogPositions.size();
		AssertJUnit.assertTrue("", actual);
		int dotWidth = 0;
		int dotHeight = 0;

		for (int y = 0; y < windowBelow; y++)
		{
			dotWidth = 0;
			for (int x = 0; x < windowBesides; x++)
			{
				final Point p = new Point(dotWidth, dotHeight);
				expected.add(p);
				dotWidth = dotWidth + dialogWidth;
			}
			dotHeight = dotHeight + dialogHeight;
		}

		for (final Point point : dialogPositions)
		{
			actual = expected.contains(point);
			AssertJUnit.assertTrue("", actual);

		}

	}

	/**
	 * Test method for.
	 *
	 * {@link io.github.astrapi69.layout.ScreenSizeExtensions#getPoint()}.
	 */
	@Test(enabled = false)
	public void testGetPoint()
	{
		final Point screenpoint = ScreenSizeExtensions.getPoint();
		actual = screenpoint.x == ScreenSizeExtensions.getScreenWidth();
		AssertJUnit.assertTrue("", actual);

		actual = screenpoint.y == ScreenSizeExtensions.getScreenHeight();
		AssertJUnit.assertTrue("", actual);
	}

	/**
	 * Test method for.
	 *
	 * {@link io.github.astrapi69.layout.ScreenSizeExtensions#getScreenHeight()}.
	 */
	@Test(enabled = false)
	public void testGetScreenHeight()
	{
		final int expected = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		final int compare = ScreenSizeExtensions.getScreenHeight();
		actual = expected == compare;
		AssertJUnit.assertTrue("", actual);
	}

	/**
	 * Test method for.
	 *
	 * {@link io.github.astrapi69.layout.ScreenSizeExtensions#getScreenWidth()}.
	 */
	@Test(enabled = false)
	public void testGetScreenWidth()
	{
		final int expected = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		final int compare = ScreenSizeExtensions.getScreenWidth();
		actual = expected == compare;
		AssertJUnit.assertTrue("", actual);
	}

}
