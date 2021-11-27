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
package io.github.astrapi69.swing.icon;

import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShapeIcon implements Icon
{
	Color backgroundColor;
	int iconWidth;
	int iconHeight;
	final Shape shape;
	final Color shapeColor;

	@Override
	public void paintIcon(Component component, Graphics graphics, int x, int y)
	{
		Graphics2D graphics2D = (Graphics2D)graphics;
		graphics2D.setColor(backgroundColor);
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2D.fillRect(x, y, getIconWidth(), getIconHeight());
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.translate(x, y);
		affineTransform.scale(getIconWidth(), getIconHeight());

		Shape transformedShape = affineTransform.createTransformedShape(shape);
		graphics2D.setColor(shapeColor);
		graphics2D.fill(transformedShape);
		graphics2D.setColor(Color.BLACK);
		graphics2D.draw(transformedShape);
	}
}
