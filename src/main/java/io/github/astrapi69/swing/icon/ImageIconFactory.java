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
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import io.github.astrapi69.lang.ClassExtensions;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

/**
 * The factory class {@link ImageIconFactory} provides factory methods for create ImageIcon objects
 */
public class ImageIconFactory
{

	/**
	 * Factory method for create a new {@link ImageIcon} from the given {@link File} object
	 *
	 * @param image
	 *            the file that contains the image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(File image)
	{
		ImageIcon img = newImageIcon(image.getAbsolutePath());
		return img;
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given relative image path as
	 * {@link String} object
	 *
	 * @param relativeImagePath
	 *            the relative image path
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(String relativeImagePath)
	{
		return newImageIcon(relativeImagePath, true);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given relative image path as
	 * {@link String} object
	 *
	 * @param relativeImagePath
	 *            the relative image path
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(String relativeImagePath, int newWidth, int newHeight)
	{
		return newImageIcon(relativeImagePath, true, newWidth, newHeight);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given image path as {@link String}
	 * object
	 *
	 * @param imagePath
	 *            the image path
	 * @param relativePath
	 *            the flag that indicates if the given path is relative
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(String imagePath, boolean relativePath)
	{
		if (relativePath)
		{
			final BufferedImage bufferedImage = RuntimeExceptionDecorator
				.decorate(() -> ImageIO.read(ClassExtensions.getResourceAsStream(imagePath)));
			return new ImageIcon(bufferedImage);
		}
		return new ImageIcon(imagePath);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given image path as {@link String}
	 * object
	 *
	 * @param imagePath
	 *            the image path
	 * @param relativePath
	 *            the flag that indicates if the given path is relative
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(String imagePath, boolean relativePath, int newWidth,
		int newHeight)
	{
		if (relativePath)
		{
			final BufferedImage bufferedImage = RuntimeExceptionDecorator
				.decorate(() -> ImageIO.read(ClassExtensions.getResourceAsStream(imagePath)));
			return new ImageIcon(
				bufferedImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT));
		}
		return new ImageIcon(imagePath);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given {@link URL} object
	 *
	 * @param location
	 *            the URL for the image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(URL location)
	{
		ImageIcon img = new ImageIcon(location);
		return img;
	}

	/**
	 * Factory method for create a new {@link ImageIcon}from the given {@link BufferedImage} object
	 *
	 * @param bufferedImage
	 *            the buffered image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(BufferedImage bufferedImage)
	{
		ImageIcon img = new ImageIcon(bufferedImage);
		return img;
	}
}
