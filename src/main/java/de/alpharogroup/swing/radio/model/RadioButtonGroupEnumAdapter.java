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
package de.alpharogroup.swing.radio.model;

import java.util.EnumMap;
import java.util.Map;

import javax.swing.JRadioButton;

/**
 * The class {@link RadioButtonGroupEnumAdapter} can be used with {@link JRadioButton}.
 *
 * @param <E>
 *            the generic enum type
 */
public class RadioButtonGroupEnumAdapter<E extends Enum<E>>
{

	/** The button map. */
	private final Map<E, JRadioButton> buttonMap;

	/**
	 * Instantiates a new {@link RadioButtonGroupEnumAdapter}.
	 *
	 * @param enumClass
	 *            the enum class
	 */
	public RadioButtonGroupEnumAdapter(Class<E> enumClass)
	{
		this.buttonMap = new EnumMap<>(enumClass);
	}

	/**
	 * Associate the given enum value with the given {@link JRadioButton}.
	 *
	 * @param enumValue
	 *            the enum value
	 * @param radioButton
	 *            the radio button
	 */
	public void associate(E enumValue, JRadioButton radioButton)
	{
		this.buttonMap.put(enumValue, radioButton);
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public E getValue()
	{
		for (final E e : this.buttonMap.keySet())
		{
			final JRadioButton btn = this.buttonMap.get(e);
			if (btn.isSelected())
			{
				return e;
			}
		}
		return null;
	}

	/**
	 * Import map.
	 *
	 * @param map
	 *            the map
	 */
	public void importMap(Map<E, JRadioButton> map)
	{
		for (final E e : map.keySet())
		{
			this.buttonMap.put(e, map.get(e));
		}
	}

	/**
	 * Sets the value.
	 *
	 * @param e
	 *            the new value
	 */
	public void setValue(E e)
	{
		final JRadioButton btn = (e == null) ? null : this.buttonMap.get(e);
		if (btn == null)
		{
			// the following doesn't seem efficient...
			// but since when do we have more than say 10 radiobuttons?
			for (final JRadioButton b : this.buttonMap.values())
			{
				b.setSelected(false);
			}

		}
		else
		{
			btn.setSelected(true);
		}
	}

}
