package de.alpharogroup.swing.components.factories;

import java.awt.Dimension;

import lombok.experimental.UtilityClass;

/**
 * A factory {@link DimensionFactory} provides factory methods for create Dimension objects
 */
@UtilityClass
public class DimensionFactory
{

	/**
	 *
	 * Factory method for creating the new {@link Dimension}
	 *
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 *
	 * @return the new {@link Dimension}
	 */
	public static Dimension newDimension(int width, int height)
	{
		return new Dimension(width, height);
	}
}
