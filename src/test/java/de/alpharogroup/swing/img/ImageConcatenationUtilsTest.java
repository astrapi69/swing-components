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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;

import de.alpharogroup.file.search.PathFinder;
import de.alpharogroup.lang.ClassExtensions;
import de.alpharogroup.swing.img.ImageUtils.Direction;

public class ImageConcatenationUtilsTest
{

	@Test(enabled = false)
	public void testConcatenateImages() throws IOException
	{
		final BufferedImage img1 = ImageIO.read(ClassExtensions
			.getResourceAsStream("img/xmas/bell.png"));
		final BufferedImage img2 = ImageIO.read(ClassExtensions
			.getResourceAsStream("img/xmas/greendices.png"));
		final BufferedImage img3 = ImageIO.read(ClassExtensions
			.getResourceAsStream("img/xmas/stars.png"));

		final List<BufferedImage> imgCollection = new ArrayList<>();
		imgCollection.add(img1);
		imgCollection.add(img2);
		imgCollection.add(img3);
		final BufferedImage verticalImage = ImageUtils.concatenateImages(imgCollection,
			img1.getWidth(), img1.getHeight() + img2.getHeight() + img3.getHeight(),
			BufferedImage.TYPE_INT_RGB, Direction.vertical);
		final BufferedImage horizontalImage = ImageUtils.concatenateImages(imgCollection,
			img1.getWidth() + img2.getWidth() + img3.getWidth(), img1.getHeight(),
			BufferedImage.TYPE_INT_RGB, Direction.horizontal);
		final File imgDir = new File(PathFinder.getSrcTestResourcesDir(), "img");
		final File xmasDir = new File(imgDir, "xmas");
		final File verticalImg = new File(xmasDir, "verticalImg.jpg");
		ImageIO.write(verticalImage, "jpeg", verticalImg);

		final File horizontalImg = new File(xmasDir, "horizontalImg.jpg");
		ImageIO.write(horizontalImage, "jpeg", horizontalImg);
		// comment the following two lines to see the result.
		// DeleteFileUtils.delete(horizontalImg);
		// DeleteFileUtils.delete(verticalImg);
	}


}
