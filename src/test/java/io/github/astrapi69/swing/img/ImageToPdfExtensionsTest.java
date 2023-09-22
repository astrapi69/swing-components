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

import java.io.File;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;

/**
 * The class {@link ImageToPdfExtensionsTest}.
 */
public class ImageToPdfExtensionsTest
{

	/**
	 * Test zip.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
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

		// Add folder to the zip file
		zipFile4j.addFile(hImg, parameters);
		DeleteFileExtensions.delete(zipFile4j.getFile());

	}

}
