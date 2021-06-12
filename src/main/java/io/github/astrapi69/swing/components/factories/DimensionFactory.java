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
package io.github.astrapi69.swing.components.factories;

import java.awt.Dimension;

import javax.swing.JComponent;

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

	/**
	 * Factory method for creating the new preferred size {@link Dimension} of the given two
	 * component
	 *
	 * @param first
	 *            the first component
	 * @param second
	 *            the second component
	 * @return the new preferred size {@link Dimension}
	 */
	public static Dimension getPreferredSize(JComponent first, JComponent second)
	{
		Dimension firstDimension = first.getPreferredSize();
		Dimension secondDimension = second.getPreferredSize();
		return new Dimension(firstDimension.width + secondDimension.width,
			(firstDimension.height < secondDimension.height
				? secondDimension.height
				: firstDimension.height));

	}
}
