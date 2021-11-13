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
