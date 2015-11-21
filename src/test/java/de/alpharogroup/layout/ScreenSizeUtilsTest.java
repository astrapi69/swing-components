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
package de.alpharogroup.layout;

import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.alpharogroup.BaseTestCase;

/**
 * Test class for the class ScreenSizeUtils.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public class ScreenSizeUtilsTest extends BaseTestCase
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
	 * {@link de.alpharogroup.layout.ScreenSizeUtils#computeDialogPositions(int, int)} .
	 */
	@Test(enabled = false)
	public void testComputeDialogPositions()
	{
		final List<Point> expected = new ArrayList<Point>();
		final int dialogHeight = 200;
		final int dialogWidth = 250;
		final int windowBesides = ScreenSizeUtils.getScreenWidth() / dialogWidth;
		final int windowBelow = ScreenSizeUtils.getScreenHeight() / dialogHeight;
		final int listSize = windowBesides * windowBelow;
		final List<Point> dialogPositions = ScreenSizeUtils.computeDialogPositions(dialogWidth,
			dialogHeight);
		this.result = listSize == dialogPositions.size();
		AssertJUnit.assertTrue("", this.result);
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
			this.result = expected.contains(point);
			AssertJUnit.assertTrue("", this.result);

		}

	}

	/**
	 * Test method for.
	 *
	 * {@link de.alpharogroup.layout.ScreenSizeUtils#getPoint()}.
	 */
	@Test(enabled = false)
	public void testGetPoint()
	{
		final Point screenpoint = ScreenSizeUtils.getPoint();
		this.result = screenpoint.x == ScreenSizeUtils.getScreenWidth();
		AssertJUnit.assertTrue("", this.result);

		this.result = screenpoint.y == ScreenSizeUtils.getScreenHeight();
		AssertJUnit.assertTrue("", this.result);
	}

	/**
	 * Test method for.
	 *
	 * {@link de.alpharogroup.layout.ScreenSizeUtils#getScreenHeight()}.
	 */
	@Test(enabled = false)
	public void testGetScreenHeight()
	{
		final int expected = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		final int compare = ScreenSizeUtils.getScreenHeight();
		this.result = expected == compare;
		AssertJUnit.assertTrue("", this.result);
	}

	/**
	 * Test method for.
	 *
	 * {@link de.alpharogroup.layout.ScreenSizeUtils#getScreenWidth()}.
	 */
	@Test(enabled = false)
	public void testGetScreenWidth()
	{
		final int expected = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		final int compare = ScreenSizeUtils.getScreenWidth();
		this.result = expected == compare;
		AssertJUnit.assertTrue("", this.result);
	}

}
