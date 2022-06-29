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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowListener;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.github.astrapi69.window.adapter.CloseWindow;
import io.github.astrapi69.window.adapter.DisposeWindow;

/**
 * The unit test class for the class DrawMessage.
 * 
 * @version 1.0
 * @author Asterios Raptis
 */
public class DrawMessageTest
{

	/** The dispose window. */
	DisposeWindow disposeWindow = null;

	/**
	 * Sets up method will be invoked before every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeEach
	protected void setUp() throws Exception
	{
	}

	/**
	 * Tear down method will be invoked after every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@AfterEach
	protected void tearDown() throws Exception
	{
	}

	/**
	 * Test method for.
	 *
	 * {@link io.github.astrapi69.layout.DrawMessage#paint(java.awt.Graphics)} .
	 */
	@Test
	@Disabled
	public void testPaintGraphics()
	{
		final WindowListener l = new CloseWindow();
		final Frame f = new Frame("DrawMessage 2D Text");
		f.addWindowListener(l);
		final Color color = new Color(0, 180, 0);
		final DrawMessage message = new DrawMessage("Drawed Message with DrawMessage", color);
		f.add("Center", message);
		f.pack();
		f.setSize(new Dimension(400, 80));
		f.setVisible(true);
		try
		{
			Thread.sleep(7000);
		}
		catch (final InterruptedException e1)
		{
			e1.printStackTrace();
		}
		f.setVisible(false);
		f.dispose();
	}

}
