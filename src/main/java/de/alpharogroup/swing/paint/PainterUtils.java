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
package de.alpharogroup.swing.paint;

import java.awt.Color;
import java.awt.LinearGradientPaint;

import org.jdesktop.swingx.painter.CompoundPainter;
import org.jdesktop.swingx.painter.GlossPainter;
import org.jdesktop.swingx.painter.MattePainter;
import org.jdesktop.swingx.painter.PinstripePainter;

/**
 * The Class PainterUtils.
 */
public class PainterUtils
{

	/**
	 * Gets a CompoundPainter object.
	 *
	 * @param matte
	 *            the matte color
	 * @param gloss
	 *            the gloss color
	 * @param position
	 *            the position
	 * @param angle
	 *            the angle
	 * @param pinstripe
	 *            the pinstripe painter
	 * @return the CompoundPainter object.
	 */
	@SuppressWarnings("rawtypes")
	public static CompoundPainter getCompoundPainter(final Color matte, final Color gloss,
		final GlossPainter.GlossPosition position, final double angle, final Color pinstripe)
	{
		final MattePainter mp = new MattePainter(matte);
		final GlossPainter gp = new GlossPainter(gloss, position);
		final PinstripePainter pp = new PinstripePainter(pinstripe, angle);
		final CompoundPainter compoundPainter = new CompoundPainter(mp, pp, gp);
		return compoundPainter;

	}

	/**
	 * Gets the compound painter.
	 *
	 * @param color
	 *            the color
	 * @param position
	 *            the position
	 * @param angle
	 *            the angle
	 * @return the compound painter
	 */
	@SuppressWarnings("rawtypes")
	public static CompoundPainter getCompoundPainter(final Color color,
		final GlossPainter.GlossPosition position, final double angle)
	{
		final MattePainter mp = new MattePainter(color);
		final GlossPainter gp = new GlossPainter(color, position);
		final PinstripePainter pp = new PinstripePainter(color, angle);
		final CompoundPainter compoundPainter = new CompoundPainter(mp, pp, gp);
		return compoundPainter;

	}

	/**
	 * Gets a MattePainter object.
	 *
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 * @param fractions
	 *            the fractions
	 * @param colors
	 *            the colors
	 * @return the MattePainter object
	 */
	public static MattePainter getMattePainter(final int width, final int height,
		final float[] fractions, final Color... colors)
	{
		final LinearGradientPaint gradientPaint = new LinearGradientPaint(0.0f, 0.0f, width,
			height, fractions, colors);
		final MattePainter mattePainter = new MattePainter(gradientPaint);
		return mattePainter;

	}
}
