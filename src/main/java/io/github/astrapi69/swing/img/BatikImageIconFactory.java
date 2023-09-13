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

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import io.github.astrapi69.icon.SvgImageTranscoder;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscodingHints;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.util.SVGConstants;

import io.github.astrapi69.lang.ClassExtensions;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

/**
 * The factory class {@link BatikImageIconFactory} provides factory methods for create ImageIcon objects
 */
public class BatikImageIconFactory
{

	/**
	 * Factory method for create a new {@link ImageIcon}
	 *
	 * @param imagePath
	 *            the image path
	 * @param targetWidth
	 *            the target width
	 * @param targetHeight
	 *            the target height
	 * @throws TranscoderException
	 *             is thrown when a transcoder is not able to transcode its input
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIconFromSVG(final String imagePath, final float targetWidth,
		final float targetHeight) throws TranscoderException
	{
		return newImageIconFromSVG(imagePath, targetWidth, targetHeight, null);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given {@link File} object
	 *
	 * @param image
	 *            the file that contains the image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(File image)
	{
		return newImageIcon(image, null);
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
	 * @param newWidth
	 *            the new width
	 * @param newHeight
	 *            the new height
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
		return newImageIcon(imagePath, relativePath, null);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given image path as {@link String}
	 * object
	 *
	 * @param imagePath
	 *            the image path
	 * @param relativePath
	 *            the flag that indicates if the given path is relative
	 * @param newWidth
	 *            the new width
	 * @param newHeight
	 *            the new height
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(String imagePath, boolean relativePath, int newWidth,
		int newHeight)
	{
		return newImageIcon(imagePath, relativePath, newWidth, newHeight, null);
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
		return newImageIcon(location, null);
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
		return newImageIcon(bufferedImage, null);
	}

	/**
	 * Factory method for create a new {@link ImageIcon}from the given {@link BufferedImage} object
	 *
	 * @param bufferedImage
	 *            the buffered image
	 * @param description
	 *            the textual description of the image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(BufferedImage bufferedImage, String description)
	{
		return description == null
			? new ImageIcon(bufferedImage)
			: new ImageIcon(bufferedImage, description);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given {@link URL} object
	 *
	 * @param location
	 *            the URL for the image
	 * @param description
	 *            the textual description of the image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(URL location, String description)
	{
		return description == null ? new ImageIcon(location) : new ImageIcon(location, description);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given image path as {@link String}
	 * object
	 *
	 * @param imagePath
	 *            the image path
	 * @param relativePath
	 *            the flag that indicates if the given path is relative
	 * @param newWidth
	 *            the new width
	 * @param newHeight
	 *            the new height
	 * @param description
	 *            the textual description of the image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(String imagePath, boolean relativePath, int newWidth,
		int newHeight, String description)
	{
		if (relativePath)
		{
			final BufferedImage bufferedImage = RuntimeExceptionDecorator
				.decorate(() -> ImageIO.read(ClassExtensions.getResourceAsStream(imagePath)));
			return new ImageIcon(
				bufferedImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT));
		}
		return description == null
			? new ImageIcon(imagePath)
			: new ImageIcon(imagePath, description);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given image path as {@link String}
	 * object
	 *
	 * @param imagePath
	 *            the image path
	 * @param relativePath
	 *            the flag that indicates if the given path is relative
	 * @param description
	 *            the textual description of the image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(String imagePath, boolean relativePath, String description)
	{
		if (relativePath)
		{
			final BufferedImage bufferedImage = RuntimeExceptionDecorator
				.decorate(() -> ImageIO.read(ClassExtensions.getResourceAsStream(imagePath)));
			return new ImageIcon(bufferedImage);
		}
		return description == null
			? new ImageIcon(imagePath)
			: new ImageIcon(imagePath, description);
	}

	/**
	 * Factory method for create a new {@link ImageIcon} from the given {@link File} object
	 *
	 * @param image
	 *            the file that contains the image
	 * @param description
	 *            the textual description of the image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(File image, String description)
	{
		return newImageIcon(image.getAbsolutePath(), false, description);
	}


	/**
	 * Factory method for create a new {@link ImageIcon} object from a svg formatted image
	 *
	 * @param imagePath
	 *            the svg image path
	 * @param targetWidth
	 *            the target width
	 * @param targetHeight
	 *            the target height
	 * @param description
	 *            the textual description of the image
	 * @throws TranscoderException
	 *             is thrown when a transcoder is not able to transcode its input
	 * @return the new {@link ImageIcon} object
	 */
	public static ImageIcon newImageIconFromSVG(final String imagePath, final float targetWidth,
		final float targetHeight, String description) throws TranscoderException
	{
		InputStream resourceAsStream = ClassExtensions.getResourceAsStream(imagePath);
		return newImageIconFromSVG(resourceAsStream, targetWidth, targetHeight, description);
	}


	/**
	 * Factory method for create a new {@link ImageIcon} object from a svg formatted image
	 *
	 * @param svgImageAsStream
	 *            the svg image stream
	 * @param targetWidth
	 *            the target width
	 * @param targetHeight
	 *            the target height
	 * @param description
	 *            the textual description of the image
	 * @throws TranscoderException
	 *             is thrown when a transcoder is not able to transcode its input
	 * @return the new {@link ImageIcon} object
	 */
	public static ImageIcon newImageIconFromSVG(final InputStream svgImageAsStream,
		final float targetWidth, final float targetHeight, String description)
		throws TranscoderException
	{
		TranscoderInput input = new TranscoderInput(svgImageAsStream);
		SvgImageTranscoder transcoder = new SvgImageTranscoder();
		SVGDOMImplementation impl = (SVGDOMImplementation)SVGDOMImplementation
			.getDOMImplementation();
		TranscodingHints hints = new TranscodingHints();
		hints.put(ImageTranscoder.KEY_WIDTH, targetWidth);
		hints.put(ImageTranscoder.KEY_HEIGHT, targetHeight);
		hints.put(ImageTranscoder.KEY_DOM_IMPLEMENTATION, impl.getDOMImplementation());
		hints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT_NAMESPACE_URI,
			SVGConstants.SVG_NAMESPACE_URI);
		hints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT, SVGConstants.SVG_SVG_TAG);
		hints.put(ImageTranscoder.KEY_XML_PARSER_VALIDATING, false);
		transcoder.setTranscodingHints(hints);
		transcoder.transcode(input, null);
		BufferedImage bufferedImage = transcoder.getImage();
		return description == null
			? new ImageIcon(bufferedImage)
			: new ImageIcon(bufferedImage, description);
	}


	/**
	 * Factory method for create a new {@link ImageIcon} from the given relative image path as
	 * {@link String} object
	 *
	 * @param relativeImagePath
	 *            the relative image path
	 * @param description
	 *            the textual description of the image
	 * @return the new {@link ImageIcon}
	 */
	public static ImageIcon newImageIcon(String relativeImagePath, String description)
	{
		return newImageIcon(relativeImagePath, true, description);
	}
}
