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
package io.github.astrapi69.swing.table.model;

/**
 * The class NoRowsSelectedException are thrown when there are no rows from the table selected.
 */
public class NoRowsSelectedException extends Exception
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 237525465952351371L;

	/**
	 * Instantiates a new no rows selected exception.
	 */
	public NoRowsSelectedException()
	{
	}

	/**
	 * Instantiates a new no rows selected exception.
	 *
	 * @param message
	 *            the message
	 */
	public NoRowsSelectedException(final String message)
	{
		super(message);
	}

	/**
	 * Instantiates a new no rows selected exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public NoRowsSelectedException(final String message, final Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Instantiates a new no rows selected exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public NoRowsSelectedException(final Throwable cause)
	{
		super(cause);
	}

}
