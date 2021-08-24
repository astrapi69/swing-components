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

import javax.swing.filechooser.FileFilter;

/**
 * The class {@link SuffixFileFilter} is an implementation of the abstract {@link FileFilter} for
 * use with a {@link javax.swing.JFileChooser} for a generic FileFilter with file suffix and
 * description
 */
public class SuffixFileFilter extends FileFilter
{
	/** The suffix of the file name */
	private final String suffix;

	/** The description of this filter */
	private final String description;

	/**
	 * Instantiates a new {@link SuffixFileFilter} with the given suffix and the given description
	 *
	 * @param suffix
	 *            the suffix
	 * @param description
	 *            The description of this filter
	 */
	public SuffixFileFilter(final String suffix, final String description)
	{
		this.suffix = suffix;
		this.description = description;
	}

	/**
	 * Instantiates a new {@link SuffixFileFilter} with the given suffix
	 *
	 * @param suffix
	 *            the suffix
	 */
	public SuffixFileFilter(final String suffix)
	{
		this(suffix, "(*" + suffix + ") Files");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean accept(File file)
	{
		if (file.isDirectory())
		{
			return true;
		}
		final String fileName = file.getName().toLowerCase();
		return fileName.endsWith(suffix);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription()
	{
		return description;
	}

	/**
	 * Factory method for create a new {@link SuffixFileFilter} with the given suffix and the given
	 * flag for recursion
	 *
	 * @param suffix
	 *            the suffix
	 * @param description
	 *            The description of this filter
	 * @return the new created {@link SuffixFileFilter} object
	 */
	public static FileFilter of(final String suffix, final String description)
	{
		return new SuffixFileFilter(suffix, description);
	}

	/**
	 * Factory method for create a new {@link SuffixFileFilter} with the given suffix and the given
	 * flag for recursion
	 *
	 * @param suffix
	 *            the suffix
	 * @return the new created {@link SuffixFileFilter} object
	 */
	public static FileFilter of(final String suffix)
	{
		return new SuffixFileFilter(suffix);
	}

}
