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
package io.github.astrapi69.swing.document;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import io.github.astrapi69.math.MathExtensions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link RangeDocument} can take any character in the range of the given minimum and
 * maximum
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RangeDocument extends PlainDocument
{

	private static final long serialVersionUID = 1L;

	int maximum;
	int minimum;

	/**
	 * Instantiates a new {@link RangeDocument} object
	 *
	 * @param minimum
	 *            the minimum
	 * @param maximum
	 *            the maximum
	 */
	public RangeDocument(int minimum, int maximum)
	{
		this.minimum = minimum;
		this.maximum = maximum;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertString(int offset, String string, AttributeSet attributes)
		throws BadLocationException
	{
		if (string == null)
		{
			return;
		}
		else
		{
			String newValue;
			int length = getLength();
			if (length == 0)
			{
				newValue = string;
			}
			else
			{
				String currentContent = getText(0, length);
				StringBuffer currentBuffer = new StringBuffer(currentContent);
				currentBuffer.insert(offset, string);
				newValue = currentBuffer.toString();
			}
			try
			{
				validate(newValue);
				super.insertString(offset, string, attributes);
			}
			catch (Exception exception)
			{
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove(int offset, int length) throws BadLocationException
	{
		int currentLength = getLength();
		String currentContent = getText(0, currentLength);
		String before = currentContent.substring(0, offset);
		String after = currentContent.substring(length + offset, currentLength);
		String newValue = before + after;
		try
		{
			validate(newValue);
			super.remove(offset, length);
		}
		catch (Exception exception)
		{
			Toolkit.getDefaultToolkit().beep();
		}
	}

	/**
	 * Validate the given value by this {@link RangeDocument} object
	 * 
	 * @param proposedValue
	 *            the proposed value
	 * @return the proposed value or throws an IllegalArgumentException if the validation fails
	 * @throws IllegalArgumentException
	 *             if the validation fails
	 */
	public String validate(String proposedValue) throws IllegalArgumentException
	{
		if (MathExtensions.isBetween(minimum, maximum, proposedValue.length(), true, true))
		{
			return proposedValue;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
}