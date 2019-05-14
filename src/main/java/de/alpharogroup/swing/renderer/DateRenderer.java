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
package de.alpharogroup.swing.renderer;

import java.text.SimpleDateFormat;
import java.util.Objects;

import javax.swing.table.DefaultTableCellRenderer;

import lombok.Getter;

/**
 * The class DateRenderer.
 */
public class DateRenderer extends DefaultTableCellRenderer
{

	/** The constant for the default date pattern. */
	public static final String DEFAULT_PATTERN = "dd.MM.yyyy";

	/** The constant for the serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The date formatter. */
	private final SimpleDateFormat dateFormatter;

	/** The date pattern. */
	@Getter
	private String datePattern;

	/**
	 * Instantiates a new {@link DateRenderer}.
	 */
	public DateRenderer()
	{
		this(DEFAULT_PATTERN);
	}

	/**
	 * Instantiates a new {@link DateRenderer}.
	 *
	 * @param pattern
	 *            the pattern
	 */
	public DateRenderer(String pattern)
	{
		this.datePattern = pattern;
		this.dateFormatter = new SimpleDateFormat(this.datePattern);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValue(Object value)
	{
		setText((Objects.isNull(value)) ? "" : dateFormatter.format(value));
	}

}
