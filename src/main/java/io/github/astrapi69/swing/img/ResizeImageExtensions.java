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
package io.github.astrapi69.swing.img;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import lombok.extern.java.Log;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

import io.github.astrapi69.img.ImageExtensions;

/**
 * The class {@link ResizeImageExtensions} provides extension methods for several operations with
 * {@link BufferedImage} objects
 */
@Log
public class ResizeImageExtensions
{


	/**
	 * Resize the given BufferedImage and returns the resized BufferedImage.
	 *
	 * @param originalImage
	 *            the original image
	 * @param scalingMethod
	 *            the scaling method
	 * @param resizeMode
	 *            the resize mode
	 * @param formatName
	 *            the format name examples 'png' or 'jpg' description: Standard BMP Image Writer
	 *            format names: [bmp, BMP] description: Standard JPEG Image Writer format names:
	 *            [JPEG, jpeg, JPG, jpg] description: Standard WBMP Image Writer format names:
	 *            [wbmp, WBMP] description: Standard PNG image writer format names: [png, PNG]
	 *            description: Standard GIF image writer format names: [gif, GIF] description:
	 *            Standard TIFF image writer format names: [tif, TIF, tiff, TIFF]
	 * @param targetWidth
	 *            the target width
	 * @param targetHeight
	 *            the target height
	 * @return the resized
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static BufferedImage getResized(final BufferedImage originalImage,
		final Method scalingMethod, final Mode resizeMode, final String formatName,
		final int targetWidth, final int targetHeight) throws IOException
	{
		return ImageExtensions.read(resize(originalImage, scalingMethod, resizeMode, formatName,
			targetWidth, targetHeight));
	}

	/**
	 * Resize the given BufferedImage and returns the resized BufferedImage.
	 *
	 * @param originalImage
	 *            the original image
	 * @param formatName
	 *            the format name examples 'png' or 'jpg' description: Standard BMP Image Writer
	 *            format names: [bmp, BMP] description: Standard JPEG Image Writer format names:
	 *            [JPEG, jpeg, JPG, jpg] description: Standard WBMP Image Writer format names:
	 *            [wbmp, WBMP] description: Standard PNG image writer format names: [png, PNG]
	 *            description: Standard GIF image writer format names: [gif, GIF] description:
	 *            Standard TIFF image writer format names: [tif, TIF, tiff, TIFF]
	 * @param targetWidth
	 *            the target width
	 * @param targetHeight
	 *            the target height
	 * @return the resized
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static BufferedImage getResized(final BufferedImage originalImage,
		final String formatName, final int targetWidth, final int targetHeight) throws IOException
	{
		return ImageExtensions.read(resize(originalImage, formatName, targetWidth, targetHeight));
	}

	/**
	 * Gets the buffered image from the given byte array quietly.
	 *
	 * @param input
	 *            the input
	 * @return the buffered image or null if the read process failed.
	 */
	public static BufferedImage readQuietly(final InputStream input)
	{
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(input);
		}
		catch (IOException e)
		{
			log.log(Level.SEVERE, "Reading image failed.", e);
		}
		return img;
	}

	/**
	 * Resize the given image.
	 *
	 * @param originalImage
	 *            the original image
	 * @param scalingMethod
	 *            the scaling method
	 * @param resizeMode
	 *            the resize mode
	 * @param formatName
	 *            the format name examples 'png' or 'jpg' description: Standard BMP Image Writer
	 *            format names: [bmp, BMP] description: Standard JPEG Image Writer format names:
	 *            [JPEG, jpeg, JPG, jpg] description: Standard WBMP Image Writer format names:
	 *            [wbmp, WBMP] description: Standard PNG image writer format names: [png, PNG]
	 *            description: Standard GIF image writer format names: [gif, GIF] description:
	 *            Standard TIFF image writer format names: [tif, TIF, tiff, TIFF]
	 * @param targetWidth
	 *            the target width
	 * @param targetHeight
	 *            the target height
	 * @return the byte[]
	 */
	public static byte[] resize(final BufferedImage originalImage, final Method scalingMethod,
		final Mode resizeMode, final String formatName, final int targetWidth,
		final int targetHeight)
	{
		try
		{
			final BufferedImage resizedImage = Scalr.resize(originalImage, scalingMethod,
				resizeMode, targetWidth, targetHeight);
			return ImageExtensions.toByteArray(resizedImage, formatName);
		}
		catch (final Exception e)
		{
			return null;
		}
	}

	/**
	 * Resize the given BufferedImage.
	 *
	 * @param originalImage
	 *            the original image
	 * @param formatName
	 *            the format name examples 'png' or 'jpg' description: Standard BMP Image Writer
	 *            format names: [bmp, BMP] description: Standard JPEG Image Writer format names:
	 *            [JPEG, jpeg, JPG, jpg] description: Standard WBMP Image Writer format names:
	 *            [wbmp, WBMP] description: Standard PNG image writer format names: [png, PNG]
	 *            description: Standard GIF image writer format names: [gif, GIF] description:
	 *            Standard TIFF image writer format names: [tif, TIF, tiff, TIFF]
	 * @param targetWidth
	 *            the target width
	 * @param targetHeight
	 *            the target height
	 * @return the byte[]
	 */
	public static byte[] resize(final BufferedImage originalImage, final String formatName,
		final int targetWidth, final int targetHeight)
	{
		return resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, formatName,
			targetWidth, targetHeight);
	}

}
