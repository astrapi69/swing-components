package de.alpharogroup.swing.document;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import de.alpharogroup.math.MathExtensions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link RangeDocument} can take any character in the range of the given minimum and
 * maximum
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal=true)
public class RangeDocument extends PlainDocument
{

	private static final long serialVersionUID = 1L;

	int minimum;
	int maximum;

	/**
	 * Instantiates a new {@link RangeDocument} object
	 *
	 * @param minimum the minimum
	 * @param maximum the maximum
	 */
	public RangeDocument(int minimum, int maximum)
	{
		this.minimum = minimum;
		this.maximum = maximum;
	}

	/**
	 * {@inheritDoc}
	 */
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
	 * @param proposedValue the proposed value
	 * @return the proposed value or throws an IllegalArgumentException if the validation fails
	 * @throws IllegalArgumentException if the validation fails
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