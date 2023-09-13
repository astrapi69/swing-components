/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
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
package io.github.astrapi69.swing.img;

import java.awt.image.BufferedImage;

import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;

import lombok.Getter;

/**
 * The class {@link SvgImageTranscoder} can transcode a svg image
 */
public class SvgImageTranscoder extends ImageTranscoder
{
	/**
	 * The {@link BufferedImage} object
	 */
	@Getter
	private BufferedImage image;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BufferedImage createImage(int width, int height)
	{
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		return image;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeImage(BufferedImage img, TranscoderOutput out)
	{
	}

}