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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import javax.swing.JComponent;

/**
 * The Class DrawMessage draws a message to a JComponent to the given Color. You can use it for
 * JList to put different list items in different colors.
 * 
 * @version 1.0
 * @author Asterios Raptis
 */
public class DrawMessage extends JComponent
{

	/**
	 * The generated serialVersionUID.
	 */
	private static final long serialVersionUID = 1482171136672852023L;

	/** The color. */
	private Color color;

	/** The message. */
	private String message = null;

	/**
	 * Instantiates a new draw message.
	 * 
	 * @param message
	 *            the message
	 * @param color
	 *            the color
	 */
	public DrawMessage(final String message, final Color color)
	{
		this.message = message;
		this.color = color;
	}

	/**
	 * Returns the field <code>color</code>.
	 *
	 * @return The field .
	 */
	public Color getColor()
	{
		return this.color;
	}

	/**
	 * Returns the field <code>message</code>.
	 *
	 * @return The field .
	 */
	public String getMessage()
	{
		return this.message;
	}

	/**
	 * Gets the minimum size.
	 *
	 * @return the minimum size {@inheritDoc}
	 * @see javax.swing.JComponent#getMinimumSize()
	 */
	@Override
	public Dimension getMinimumSize()
	{
		return new Dimension(150, 5);
	}

	/**
	 * Gets the preferred size.
	 *
	 * @return the preferred size {@inheritDoc}
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(200, 16);
	}

	/**
	 * Inits the graphics2D object.
	 * 
	 * @param g
	 *            the Graphics object.
	 * @return the graphics2 d
	 */
	private Graphics2D initGraphics2D(final Graphics g)
	{
		Graphics2D g2;
		g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setColor(this.color);
		return g2;
	}

	/**
	 * Paint.
	 *
	 * @param g
	 *            the g {@inheritDoc}
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(final Graphics g)
	{
		Graphics2D g2;
		g2 = this.initGraphics2D(g);
		final FontRenderContext frc = g2.getFontRenderContext();
		final Font font = new Font("Arial", Font.BOLD, 16);
		final String display = new String(this.message.getBytes());
		final TextLayout textLayout = new TextLayout(display, font, frc);
		final Dimension dimension = this.getSize();
		textLayout.draw(g2, 0, dimension.height);
	}

	/**
	 * Sets the field <code>color</code>.
	 * 
	 * @param color
	 *            The <code>color</code> to set
	 */
	public void setColor(final Color color)
	{
		this.color = color;
	}

	/**
	 * Sets the field <code>message</code>.
	 * 
	 * @param message
	 *            The <code>message</code> to set
	 */
	public void setMessage(final String message)
	{
		this.message = message;
	}
}
