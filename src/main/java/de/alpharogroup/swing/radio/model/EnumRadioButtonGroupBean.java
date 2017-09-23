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

import java.util.Map;

import javax.swing.JRadioButton;

import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The class {@link EnumRadioButtonGroupBean} represents a model object that can be used with
 * {@link JRadioButton}'s that are assosiated with an {@linkplain Enum}.
 *
 * @param <E>
 *            the generic enum type
 */
@EqualsAndHashCode
@ToString
@Builder(toBuilder=true)
public class EnumRadioButtonGroupBean<E extends Enum<E>>
{

	/** The map with the mapped {@linkplain JRadioButton} objects. */
	@Builder.Default
	private Map<E, JRadioButton> radioButtonMap;

	/** The model of the selected enum. */
	private Model<E> selected;

	/**
	 * Instantiates a new {@link EnumRadioButtonGroupBean}.
	 */
	public EnumRadioButtonGroupBean()
	{
		this(BaseModel.<E> of());
	}

	/**
	 * Instantiates a new {@link EnumRadioButtonGroupBean}.
	 *
	 * @param selected
	 *            the model where the selected enum is kept.
	 */
	public EnumRadioButtonGroupBean(final Model<E> selected)
	{
		this.selected = selected;
	}

	/**
	 * Instantiates a new {@link EnumRadioButtonGroupBean}.
	 *
	 * @param radioButtonMap
	 *            The map with the mapped {@linkplain JRadioButton} objects.
	 * @param selected
	 *            the model where the selected enum is kept.
	 */
	public EnumRadioButtonGroupBean(final Map<E, JRadioButton> radioButtonMap, final Model<E> selected)
	{
		this.radioButtonMap = radioButtonMap;
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
	public void associate(final E enumValue, final JRadioButton radioButton)
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
		selected.setObject(getSelectedEnumFromRadioButtons());
		return selected.getObject();
	}

	/**
	 * Resolves the selected enum from the radio buttons.
	 *
	 * @return the selected enum or null if none is selected.
	 */
	protected E getSelectedEnumFromRadioButtons() {
		for (final E enumValue : this.radioButtonMap.keySet())
		{
			final JRadioButton btn = this.radioButtonMap.get(enumValue);
			if (btn.isSelected())
			{
				return enumValue;
			}
		}
		return null;
	}

	/**
	 * Associate the given {@linkplain Map} with the {@linkplain JRadioButton} objects as values and
	 * the enum values as keys and associates them.
	 *
	 * @param map
	 *            the map
	 */
	public void associateMap(final Map<E, JRadioButton> map)
	{
		this.radioButtonMap.putAll(map);
	}

	/**
	 * Sets the value.
	 *
	 * @param enumValue
	 *            the new enum value to set
	 */
	public void setValue(final E enumValue)
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
	private void setSelectedRadioButton(final E enumValue)
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

	public Model<E> getSelected()
	{
		selected.setObject(getSelectedEnumFromRadioButtons());
		return selected;
	}

	public E getSelectedEnum()
	{
		return getSelected().getObject();
	}

}