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

import de.alpharogroup.model.api.Model;

/**
 * The class {@link EnumRadioButtonGroupBean} represents a model object that can be used with
 * {@link JRadioButton}'s that are assosiated with an {@linkplain Enum}.
 *
 * @param <E>
 *            the generic enum type
 */
public class EnumRadioButtonGroupBean<E extends Enum<E>>
{

	/** The map with the {@linkplain JRadioButton} objects. */
	private final Map<E, JRadioButton> radioButtonMap;

	/** The model of the selected enum. */
	private Model<E> selected;

	/**
	 * Instantiates a new {@link EnumRadioButtonGroupBean}.
	 *
	 * @param enumClass
	 *            the enum class
	 */
	public EnumRadioButtonGroupBean(Class<E> enumClass)
	{
		this.radioButtonMap = new EnumMap<>(enumClass);
	}

	/**
	 * Instantiates a new {@link EnumRadioButtonGroupBean}.
	 *
	 * @param enumClass
	 *            the enum class
	 * @param selected
	 *            the model where the selected enum is kept.
	 */
	public EnumRadioButtonGroupBean(Class<E> enumClass, Model<E> selected)
	{
		this.radioButtonMap = new EnumMap<>(enumClass);
		this.selected = selected;
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
		this.radioButtonMap.put(enumValue, radioButton);
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public E getValue()
	{
		return selected.getObject();
	}

	/**
	 * Import the given {@linkplain Map} with the {@linkplain JRadioButton} objects as values and
	 * the enum values as keys and associates them.
	 *
	 * @param map
	 *            the map
	 */
	public void importMap(Map<E, JRadioButton> map)
	{
		this.radioButtonMap.putAll(map);
	}

	/**
	 * Sets the value.
	 *
	 * @param enumValue
	 *            the new enum value to set
	 */
	public void setValue(E enumValue)
	{
		selected.setObject(enumValue);
		setSelectedRadioButton(enumValue);
	}

	/**
	 * Sets the selected radio button.
	 *
	 * @param enumValue
	 *            the new enum value to set
	 */
	private void setSelectedRadioButton(E enumValue)
	{
		if (enumValue != null)
		{
			final JRadioButton radioButton = this.radioButtonMap.get(enumValue);
			radioButton.setSelected(true);
		}
		else
		{
			for (final JRadioButton radioButton : this.radioButtonMap.values())
			{
				radioButton.setSelected(false);
			}
		}
	}

}
