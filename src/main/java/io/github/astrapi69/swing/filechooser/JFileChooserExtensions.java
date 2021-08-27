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
package io.github.astrapi69.swing.filechooser;

import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * The class {@link JFileChooserExtensions} holds extension methods for the {@link JFileChooser}
 */
public class JFileChooserExtensions
{

	/**
	 * Returns the selected file from the given {@link JFileChooser}, that ends with the first
	 * extension of the {@link FileNameExtensionFilter} from the {@link JFileChooser}
	 *
	 * @param fileChooser
	 *            the file chooser
	 *
	 * @return the file with the first extension of the {@link FileNameExtensionFilter} from the
	 *         {@link JFileChooser}
	 */
	public static File getSelectedFileWithFirstExtension(JFileChooser fileChooser)
	{
		File file = fileChooser.getSelectedFile();
		FileFilter fileFilter = fileChooser.getFileFilter();
		if (fileFilter instanceof FileNameExtensionFilter)
		{
			FileNameExtensionFilter fileNameExtensionFilter = (FileNameExtensionFilter)fileFilter;
			String[] extensions = fileNameExtensionFilter.getExtensions();
			String fileNameToLowerCase = file.getName().toLowerCase();
			for (String extension : extensions)
			{
				if (fileNameToLowerCase.endsWith('.' + extension.toLowerCase()))
				{
					return file;
				}
			}
			file = new File(file.getAbsolutePath() + '.' + extensions[0]);
		}
		return file;
	}

}
