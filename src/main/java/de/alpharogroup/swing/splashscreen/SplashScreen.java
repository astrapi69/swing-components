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
package de.alpharogroup.swing.splashscreen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * The SplashScreen from the application.
 *
 * @version 1.0
 *
 * @author Asterios Raptis
 *
 */
public class SplashScreen extends JWindow
{
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 4667236770554004675L;
	private boolean showing;

	public SplashScreen(final String image, final String text)
	{
		final JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		final Border bd1 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		final Border bd2 = BorderFactory.createEtchedBorder();
		final Border bd3 = BorderFactory.createCompoundBorder(bd1, bd2);
		contentPane.setBorder(bd3);
		final ImageIcon icon = new ImageIcon(image);
		contentPane.add("North", new JLabel(" ", SwingConstants.CENTER));
		contentPane.add("Center", new JLabel(icon, SwingConstants.CENTER));
		contentPane.add("South", new JLabel(text, SwingConstants.CENTER));
		setContentPane(contentPane);
	}

	/**
	 * Returns the field <code>showme</code>.
	 * 
	 * @return The field <code>showme</code>.
	 */
	@Override
	public boolean isShowing()
	{
		return showing;
	}

	/**
	 * Sets the field <code>showme</code>.
	 * 
	 * @param showing
	 *            The <code>showme</code> to set.
	 */
	public void setShowing(final boolean showing)
	{
		this.showing = showing;
	}

	public void showFor(final int millis)
	{
		final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 3, dim.height / 3);
		setSize(dim.width / 3, dim.height / 3);
		setVisible(true);
		try
		{
			Thread.sleep(millis);
		}
		catch (final InterruptedException e)
		{
		}
		setVisible(false);
	}

	public void showing()
	{
		final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 3, dim.height / 3);
		setSize(dim.width / 3, dim.height / 3);
		setVisible(true);
		toFront();
		while (showing)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (final InterruptedException e)
			{
			}
		}
		setVisible(false);
	}

}