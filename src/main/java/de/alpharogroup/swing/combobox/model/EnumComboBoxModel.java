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
package de.alpharogroup.swing.combobox.model;

import java.util.ArrayList;
import java.util.EnumSet;


/**
 * The class {@link EnumComboBoxModel} is an implementation that safely wraps an {@link Enum}.
 *
 * @param <E>
 *            the generic type of the enum
 */
public class EnumComboBoxModel<E extends Enum<E>> extends AbstractComboBoxModel<E>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link EnumComboBoxModel} from the given enum class.
	 *
	 * @param enumClass
	 *            the enum class
	 */
	public EnumComboBoxModel(final Class<E> enumClass)
	{
		super(new ArrayList<E>(EnumSet.allOf(enumClass)));
	}

	/**
	 * Instantiates a new {@link EnumComboBoxModel} from the given enum class and set as selected item the given value.
	 *
	 * @param enumClass
	 *            the enum class
	 * @param selectedItem
	 *            the selected item
	 */
	public EnumComboBoxModel(final Class<E> enumClass, final E selectedItem)
	{
		super(new ArrayList<E>(EnumSet.allOf(enumClass)), selectedItem);
	}

	/**
	 * Instantiates a new {@link EnumComboBoxModel} from the given enum values.
	 *
	 * @param enumValues
	 *            the enum values
	 */
	public EnumComboBoxModel(final E[] enumValues)
	{
		super(enumValues);
	}

	/**
	 * Instantiates a new {@link EnumComboBoxModel} from the given arguments.
	 *
	 * @param enumValues
	 *            the enum values
	 * @param selectedItem
	 *            the selected item
	 */
	public EnumComboBoxModel(final E[] enumValues, final E selectedItem)
	{
		super(enumValues, selectedItem);
	}

}
