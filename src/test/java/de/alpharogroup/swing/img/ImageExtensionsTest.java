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
package de.alpharogroup.swing.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.file.create.FileFactory;
import de.alpharogroup.file.delete.DeleteFileExtensions;
import de.alpharogroup.file.search.PathFinder;
import de.alpharogroup.lang.ClassExtensions;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

/**
 * The class {@link ImageExtensionsTest}.
 */
public class ImageExtensionsTest
{

	@Test(enabled = false)
	public void testConcatenateImages() throws IOException
	{
		final BufferedImage img1 = ImageIO
			.read(ClassExtensions.getResourceAsStream("img/xmas/bell.png"));
		final BufferedImage img2 = ImageIO
			.read(ClassExtensions.getResourceAsStream("img/xmas/greendices.png"));
		final BufferedImage img3 = ImageIO
			.read(ClassExtensions.getResourceAsStream("img/xmas/stars.png"));

		final List<BufferedImage> imgCollection = new ArrayList<>();
		imgCollection.add(img1);
		imgCollection.add(img2);
		imgCollection.add(img3);
		final BufferedImage verticalImage = ImageExtensions.concatenateImages(imgCollection,
			img1.getWidth(), img1.getHeight() + img2.getHeight() + img3.getHeight(),
			BufferedImage.TYPE_INT_RGB, Direction.vertical);
		final BufferedImage horizontalImage = ImageExtensions.concatenateImages(imgCollection,
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

	/**
	 * Test get resized.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	// @Test(enabled = false)
	// public void testGetResized() throws IOException
	// {
	// final File hImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img",
	// "xmas", "bell.png");
	// String extension = Mimetypes.getExtension(hImg);
	// extension = Mimetypes.getExtension(hImg.getName());
	// final BufferedImage horizontalImg = ImageIO.read(hImg);
	// final BufferedImage result = ImageExtensions.getResized(horizontalImg, Scalr.Method.SPEED,
	// Scalr.Mode.FIT_EXACT, extension, horizontalImg.getWidth(), horizontalImg.getHeight());
	//
	// final File verticalImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(),
	// "img", "xmas", "resultImg." + extension);
	// ImageIO.write(result, extension, verticalImg);
	// }

	/**
	 * Test for method {@ImageExtensions#randomBufferedImage(int, int, int)}.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test(enabled = true)
	public void testRandomBufferedImage() throws IOException
	{
		// file object
		final String filenameprefix = "random-generated";
		final String ext = "png";
		final File imgFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img",
			filenameprefix + "." + ext);

		final boolean imgWritten = ImageIO.write(
			ImageExtensions.randomBufferedImage(340, 120, BufferedImage.TYPE_INT_ARGB), "png",
			imgFile);
		AssertJUnit.assertTrue(imgWritten);
		if (imgWritten)
		{
			DeleteFileExtensions.delete(imgFile);
		}
	}


	/**
	 * Test resize.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	// @Test(enabled = false)
	// public void testResize() throws IOException
	// {
	// String filenameprefix = "bell";
	// String ext = "png";
	// File hImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img", "xmas",
	// filenameprefix + "." + ext);
	// String extension = Mimetypes.getExtension(hImg);
	// extension = Mimetypes.getExtension(hImg.getName());
	// BufferedImage horizontalImg = ImageIO.read(hImg);
	// byte[] resized = ImageExtensions.resize(horizontalImg, Scalr.Method.ULTRA_QUALITY,
	// Scalr.Mode.FIT_EXACT, extension, horizontalImg.getWidth() / 2,
	// horizontalImg.getHeight() / 2);
	// BufferedImage result = ImageExtensions.read(resized);
	// File verticalImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img",
	// "xmas", "resultImg." + extension);
	// ImageIO.write(result, extension, verticalImg);
	// AssertJUnit.assertTrue("original image size should be greater than the resulted.",
	// verticalImg.length() < hImg.length());
	//
	// filenameprefix = "horizontalImg";
	// ext = "jpg";
	//
	// final int scale = 2;
	// hImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img", "xmas",
	// filenameprefix + "." + ext);
	// extension = Mimetypes.getExtension(hImg);
	// extension = Mimetypes.getExtension(hImg.getName());
	// horizontalImg = ImageIO.read(hImg);
	// resized = ImageExtensions.resize(horizontalImg, Scalr.Method.ULTRA_QUALITY,
	// Scalr.Mode.FIT_EXACT, extension, horizontalImg.getWidth() / scale,
	// horizontalImg.getHeight() / scale);
	// result = ImageExtensions.read(resized);
	// verticalImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img", "xmas",
	// "resultImg." + extension);
	// ImageIO.write(result, extension, verticalImg);
	// System.out.println("Length:" + verticalImg.length());
	//
	// extension = Mimetypes.getExtension(verticalImg);
	// extension = Mimetypes.getExtension(verticalImg.getName());
	// final BufferedImage backToOriginalSize = ImageIO.read(verticalImg);
	// resized = ImageExtensions.resize(backToOriginalSize, Scalr.Method.ULTRA_QUALITY,
	// Scalr.Mode.FIT_EXACT, extension, backToOriginalSize.getWidth() * scale,
	// backToOriginalSize.getHeight() * scale);
	// result = ImageExtensions.read(resized);
	// verticalImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img", "xmas",
	// filenameprefix + "_backToOriginalSizeImg." + extension);
	// ImageIO.write(result, extension, verticalImg);
	// System.out.println("Length:" + verticalImg.length());
	// }

	/**
	 * Test weave.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test(enabled = true)
	public void testWeave() throws IOException
	{
		final String filenameprefix = "bell";
		final String ext = "png";
		final File hImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img",
			"xmas", filenameprefix + "." + ext);

		final BufferedImage horizontalImg = ImageIO.read(hImg);
		final String expected = "foo bar";
		ImageExtensions.weaveInto(horizontalImg, expected);
		String actual = ImageExtensions.unweaveFrom(horizontalImg);
		AssertJUnit.assertEquals(expected, actual);

		final String output = filenameprefix + "output";
		File outputfile = new File(PathFinder.getSrcTestResourcesDir(), output + ext);
		FileFactory.newFile(outputfile);

		outputfile = ImageExtensions.write(horizontalImg, ext, outputfile);

		final BufferedImage outputImg = ImageIO.read(outputfile);
		actual = ImageExtensions.unweaveFrom(outputImg);

		AssertJUnit.assertEquals(expected, actual);

		DeleteFileExtensions.delete(outputfile);
	}

	/**
	 * Test zip.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test(enabled = true)
	public void testZip() throws Exception
	{
		final String filenameprefix = "bell";
		final String ext = "png";
		final File hImg = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img",
			"xmas", filenameprefix + "." + ext);

		final File imgDir = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "img",
			"xmas");

		final ZipFile zipFile4j = new ZipFile(
			imgDir.getAbsolutePath() + File.separator + "testZip.zip");
		// Initiate Zip Parameters which define various properties such
		// as compression method, etc.
		final ZipParameters parameters = new ZipParameters();

		// set compression method to store compression
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

		// Set the compression level
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_ULTRA);

		// Add folder to the zip file
		zipFile4j.addFile(hImg, parameters);
		DeleteFileExtensions.delete(zipFile4j.getFile());

	}

}
