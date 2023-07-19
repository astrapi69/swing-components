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
package io.github.astrapi69.swing.model.combobox;

import java.util.List;
import java.util.Set;

/**
 * The class {@link GenericComboBoxModel} is an implementation of the abstract class
 * {@link AbstractComboBoxModel} for generic values.
 */
public class GenericComboBoxModel<T> extends AbstractComboBoxModel<T>
{

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link GenericComboBoxModel} with a new list.
	 */
	public GenericComboBoxModel()
	{
		super();
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given list
	 *
	 * @param comboList
	 *            the combo list
	 */
	public GenericComboBoxModel(final List<T> comboList)
	{
		super(comboList);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given list and set as selected item
	 * the given value
	 *
	 * @param comboList
	 *            the combo list
	 * @param selectedItem
	 *            the selected item
	 */
	public GenericComboBoxModel(final List<T> comboList, final T selectedItem)
	{
		super(comboList, selectedItem);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given {@link Set}.
	 *
	 * @param set
	 *            the combo set
	 */
	public GenericComboBoxModel(final Set<T> set)
	{
		super(set);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given array
	 *
	 * @param comboArray
	 *            the combo array
	 */
	public GenericComboBoxModel(final T[] comboArray)
	{
		super(comboArray);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given array and set as selected item
	 * the given value
	 *
	 * @param comboArray
	 *            the combo array
	 * @param selectedItem
	 *            the selected item
	 */
	public GenericComboBoxModel(final T[] comboArray, final T selectedItem)
	{
		super(comboArray, selectedItem);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given array and set as selected item
	 * the given value
	 *
	 * @param comboArray
	 *            the combo array
	 * @param selectedItem
	 *            the selected item
	 * @param excludeValues
	 *            the values to exclude
	 */
	public GenericComboBoxModel(final T[] comboArray, final T selectedItem,
		final Set<T> excludeValues)
	{
		super(comboArray, selectedItem, excludeValues);
	}

}
