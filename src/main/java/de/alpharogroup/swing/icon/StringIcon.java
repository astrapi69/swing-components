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
package de.alpharogroup.swing.icon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JComponent;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link StringIcon} creates an icon with the given text
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StringIcon implements Icon
{

	/** The component. */
	JComponent component;

	/** The font. */
	Font font;

	/** The foreground. */
	Color foreground;

	/** The icon dimensions. */
	IconDimensions iconDimensions;

	/** The text. */
	String text;

	/**
	 * Instantiates a new {@link StringIcon} object
	 *
	 * @param component
	 *            the component
	 * @param text
	 *            the text
	 */
	public StringIcon(JComponent component, String text)
	{
		this(component, text, null, null);
	}

	/**
	 * Instantiates a new {@link StringIcon} object
	 *
	 * @param component
	 *            the component
	 * @param text
	 *            the text
	 * @param font
	 *            the font
	 * @param foreground
	 *            the foreground
	 */
	public StringIcon(@NonNull JComponent component, @NonNull String text, Font font,
		Color foreground)
	{
		this.component = component;
		this.iconDimensions = IconDimensions.builder().build();
		this.font = font != null ? font : component.getFont();
		this.foreground = foreground != null ? foreground : component.getForeground();
		this.text = text;
		setIconDimensions(component.getFontMetrics(this.font), text, this.iconDimensions);
		component.revalidate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getIconHeight()
	{
		return iconDimensions.getIconHeight();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getIconWidth()
	{
		return iconDimensions.getIconWidth();
	}

	/**
	 * Factory method for create a new {@link Graphics2D} object from the given {@link Graphics}
	 * object
	 *
	 * @param graphics
	 *            the graphics
	 * @return the new {@link Graphics2D} object
	 */
	@SuppressWarnings("rawtypes")
	private Graphics2D newGraphics2D(Graphics graphics)
	{
		Graphics2D graphics2d = (Graphics2D)graphics.create();
		Map map = (Map)(Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints"));

		if (map != null)
		{
			graphics2d.addRenderingHints(map);
		}
		else
		{
			graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		graphics2d.setFont(getFont());
		graphics2d.setColor(getForeground());
		return graphics2d;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void paintIcon(Component component, Graphics graphics, int x, int y)
	{
		Graphics2D graphics2d = newGraphics2D(graphics);
		FontMetrics fontMetrics = graphics2d.getFontMetrics();
		graphics2d.translate(x, y + fontMetrics.getAscent());
		graphics2d.drawString(text, iconDimensions.getPadding(), 0);
		graphics2d.dispose();
	}

	/**
	 * Sets the bean with the icon dimensions.
	 *
	 * @param fontMetrics
	 *            the font metrics
	 * @param text
	 *            the text
	 * @param iconDimensions
	 *            the icon dimensions
	 * @return the icon dimensions
	 */
	private IconDimensions setIconDimensions(FontMetrics fontMetrics, String text,
		IconDimensions iconDimensions)
	{
		iconDimensions
			.setIconWidth(fontMetrics.stringWidth(text) + (iconDimensions.getPadding() * 2));
		iconDimensions.setIconHeight(fontMetrics.getHeight());
		return iconDimensions;
	}

}