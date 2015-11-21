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
package de.alpharogroup.swing.img;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

import de.alpharogroup.io.StreamUtils;

/**
 * The Class ImageUtils.
 */
public class ImageUtils
{

	/**
	 * The Enum Direction.
	 */
	public enum Direction
	{

		/** Indicates the horizontal direction. */
		horizontal,
		/** Indicates the vertical direction. */
		vertical
	}

	/**
	 * Concatenate the given list of BufferedImage objects to one image and returns the concatenated
	 * BufferedImage object.
	 * 
	 * @param imgCollection
	 *            the BufferedImage collection
	 * @param width
	 *            the width of the image that will be returned.
	 * @param height
	 *            the height of the image that will be returned.
	 * @param imageType
	 *            type of the created image
	 * @param concatenationDirection
	 *            the direction of the concatenation.
	 * @return the buffered image
	 */
	public static BufferedImage concatenateImages(final List<BufferedImage> imgCollection,
		final int width, final int height, final int imageType,
		final Direction concatenationDirection)
	{
		final BufferedImage img = new BufferedImage(width, height, imageType);
		int x = 0;
		int y = 0;
		for (final BufferedImage bi : imgCollection)
		{
			final boolean imageDrawn = img.createGraphics().drawImage(bi, x, y, null);
			if (!imageDrawn)
			{
				throw new RuntimeException("BufferedImage could not be drawn:" + bi.toString());
			}
			if (concatenationDirection.equals(Direction.vertical))
			{
				y += bi.getHeight();
			}
			else
			{
				x += bi.getWidth();
			}
		}
		return img;
	}

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
	 *            the format name
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
		return read(resize(originalImage, scalingMethod, resizeMode, formatName, targetWidth,
			targetHeight));
	}

	/**
	 * Resize the given BufferedImage and returns the resized BufferedImage.
	 *
	 * @param originalImage
	 *            the original image
	 * @param formatName
	 *            the format name
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
		return read(resize(originalImage, formatName, targetWidth, targetHeight));
	}

	/**
	 * Gets the buffered image from the given byte array.
	 * 
	 * @param byteArray
	 *            the byte array
	 * @return the buffered image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static BufferedImage read(final byte[] byteArray) throws IOException
	{
		return ImageIO.read(new ByteArrayInputStream(byteArray));
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
	 *            the format name
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
			return toByteArray(resizedImage, formatName);
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
	 *            the format name
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

	/**
	 * Converts the given BufferedImage to a byte array.
	 *
	 * @param bi
	 *            the bi
	 * @param formatName
	 *            the format name
	 * @return the byte[]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static byte[] toByteArray(final BufferedImage bi, final String formatName)
		throws IOException
	{
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			ImageIO.write(bi, formatName, baos);
			baos.flush();
			final byte[] byteArray = baos.toByteArray();
			return byteArray;
		}
		catch (final IOException e)
		{
			throw e;
		}
		finally
		{
			StreamUtils.close(baos);
		}
	}

	/**
	 * Unweave a secret message from the given {@link BufferedImage}.
	 *
	 * @param bufferedImage
	 *            the buffered image
	 * @return the secret message
	 */
	public static String unweaveFrom(final BufferedImage bufferedImage)
	{
		final int width = bufferedImage.getWidth();
		final int height = bufferedImage.getHeight();
		final int messageLength = bufferedImage.getRGB(0, 0) & 0xff;
		final StringBuilder sb = new StringBuilder();
		for (int row = 0, j = 0, i = 1; row < height; row++)
		{
			for (int column = 0; column < width && j < messageLength; column++, i++)
			{

				if (i % 11 == 0)
				{
					final int result = bufferedImage.getRGB(column, row);

					int charAtPosition = (result >> 16 & 0x7) << 5;

					charAtPosition |= (result >> 8 & 0x7) << 2;

					charAtPosition |= result & 0x3;
					sb.append((char)charAtPosition);
					j++;
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Weave the given secret message into the given {@link BufferedImage}.
	 *
	 * @param bufferedImage
	 *            the buffered image
	 * @param message
	 *            the secret message
	 * @return the buffered image with the secret message weaved in.
	 */
	public static BufferedImage weaveInto(final BufferedImage bufferedImage, final String message)
	{

		final int width = bufferedImage.getWidth();
		final int height = bufferedImage.getHeight();

		if (message.length() > 255)
		{
			throw new IllegalArgumentException("Given message is to large(max 255 characters)");
		}
		if (message.length() * 11 > width * height)
		{
			throw new IllegalArgumentException("Given image is to small");
		}

		final byte[] messageBytes = message.getBytes();

		int messageLengthDecode = bufferedImage.getRGB(0, 0) >> 8 << 8;

		messageLengthDecode |= message.length();
		bufferedImage.setRGB(0, 0, messageLengthDecode);

		for (int i = 1, messagePosition = 0, row = 0, j = 0; row < height; row++)
		{
			for (int column = 0; column < width && j < messageBytes.length; column++, i++)
			{

				if (i % 11 == 0)
				{

					int rgb = bufferedImage.getRGB(column, row);

					final int a = rgb >> 24 & 0xff;

					int r = (rgb >> 16 & 0xff) >> 3 << 3;
					r = r | messageBytes[messagePosition] >> 5;

					int g = (rgb >> 8 & 0xff) >> 3 << 3;
					g = g | messageBytes[messagePosition] >> 2 & 7;

					int b = (rgb & 0xff) >> 2 << 2;
					b = b | messageBytes[messagePosition] & 0x3;

					rgb = 0;
					rgb = rgb | a << 24;
					rgb = rgb | r << 16;
					rgb = rgb | g << 8;

					rgb = rgb | b;

					bufferedImage.setRGB(column, row, rgb);
					messagePosition++;
					j++;
				}
			}
		}
		return bufferedImage;
	}
}
