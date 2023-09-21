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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.InputStream;

import javax.swing.ImageIcon;

import org.apache.batik.transcoder.TranscoderException;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.icon.ImageIconFactory;
import io.github.astrapi69.lang.ClassExtensions;

/**
 * The unit test class for the class {@link ImageIconFactory}
 *
 * @author Asterios Raptis
 */
class ImageIconFactoryTest
{

	/**
	 * Test for method
	 * {{@link BatikImageIconFactory#newImageIconFromSVG(String, float, float, String)}
	 *
	 * @throws TranscoderException
	 *             is thrown when a transcoder is not able to transcode its input
	 */
	@Test
	public void testNnewImageIconFromSVG() throws TranscoderException
	{
		ImageIcon actual;
		String relativeImagePath;
		float targetWidth;
		float targetHeight;
		String description;

		relativeImagePath = "img/xmas/greendices.svg";
		targetWidth = 10f;
		targetHeight = 10f;
		description = "A description";
		actual = BatikImageIconFactory.newImageIconFromSVG(relativeImagePath, targetWidth,
			targetHeight, description);
		assertNotNull(actual);
	}

	/**
	 * Test for method
	 * {{@link BatikImageIconFactory#newImageIconFromSVG(InputStream, float, float, String)}
	 *
	 * @throws TranscoderException
	 *             is thrown when a transcoder is not able to transcode its input
	 */
	@Test
	public void testNnewImageIconFromSVGWithInputStream() throws TranscoderException
	{
		ImageIcon actual;
		String relativeImagePath;
		float targetWidth;
		float targetHeight;
		String description;
		InputStream svgImageAsStream;

		relativeImagePath = "img/xmas/greendices.svg";

		svgImageAsStream = ClassExtensions.getResourceAsStream(relativeImagePath);
		targetWidth = 10f;
		targetHeight = 10f;
		description = "A description";
		actual = BatikImageIconFactory.newImageIconFromSVG(svgImageAsStream, targetWidth,
			targetHeight, description);
		assertNotNull(actual);
	}

	/**
	 * Test for method {{@link BatikImageIconFactory#newImageIconFromSVG(String, float, float)}
	 *
	 * @throws TranscoderException
	 *             is thrown when a transcoder is not able to transcode its input
	 */
	@Test
	public void testNewImageIconFromSVGWithRelativePathWidthAndHeight() throws TranscoderException
	{
		ImageIcon actual;
		String relativeImagePath;
		float targetWidth;
		float targetHeight;

		relativeImagePath = "img/xmas/greendices.svg";
		targetWidth = 10f;
		targetHeight = 10f;
		actual = BatikImageIconFactory.newImageIconFromSVG(relativeImagePath, targetWidth,
			targetHeight);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link ImageIconFactory} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ImageIconFactory.class);
	}

}
