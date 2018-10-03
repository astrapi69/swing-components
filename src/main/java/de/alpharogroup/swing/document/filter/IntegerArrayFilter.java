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
package de.alpharogroup.swing.document.filter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 * The class {@link IntegerArrayFilter} provide a document filter that accepts only int arrays
 */
public class IntegerArrayFilter extends DocumentFilter
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
		throws BadLocationException
	{
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.insert(offset, string);

		if (validate(sb.toString()))
		{
			super.insertString(fb, offset, string, attr);
		}
		else
		{
			onValidationError(sb.toString());
		}
	}

	/**
	 * Callback method when an validation error occurs.
	 *
	 * @param text
	 *            the text to validate
	 */
	public void onValidationError(String text)
	{
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException
	{
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.delete(offset, offset + length);

		if (validate(sb.toString()))
		{
			super.remove(fb, offset, length);
		}
		else
		{
			onValidationError(sb.toString());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
		throws BadLocationException
	{
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.replace(offset, offset + length, text);

		if (validate(sb.toString()))
		{
			super.replace(fb, offset, length, text, attrs);
		}
		else
		{
			onValidationError(sb.toString());
		}
	}

	/**
	 * Validate the given string that it is a int array
	 *
	 * @param text
	 *            the text
	 * @return true, if successful
	 */
	protected boolean validate(String text)
	{
		try
		{
			String[] strings = text.split(",");
			for (int i = 0; i < strings.length; i++)
			{
				Integer.parseInt(strings[i].trim());
			}
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}

}
