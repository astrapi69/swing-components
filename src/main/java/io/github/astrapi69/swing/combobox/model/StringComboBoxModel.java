/**
 * The MIT License
 * <p>
 * Copyright (C) 2015 Asterios Raptis
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.combobox.model;

import io.github.astrapi69.collection.array.ArrayExtensions;

import java.util.List;

/**
 * The class {@link StringComboBoxModel} is an implementation of the abstract class
 * {@link GenericComboBoxModel} for {@link String} values.
 * 
 * @deprecated use instead the class {@link GenericComboBoxModel}
 */
@Deprecated
public class StringComboBoxModel extends GenericComboBoxModel<String>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link StringComboBoxModel} from the given list
	 *
	 * @param comboList
	 *            the combo list
	 */
	public StringComboBoxModel(final List<String> comboList)
	{
		super(comboList);
	}

	/**
	 * Instantiates a new {@link StringComboBoxModel} from the given list and set as selected item
	 * the given value
	 *
	 * @param comboList
	 *            the combo list
	 * @param selectedItem
	 *            the selected item
	 */
	public StringComboBoxModel(final List<String> comboList, final String selectedItem)
	{
		super(comboList, selectedItem);
	}

	/**
	 * Instantiates a new {@link StringComboBoxModel} from the given array
	 *
	 * @param comboArray
	 *            the combo array
	 */
	public StringComboBoxModel(final String[] comboArray)
	{
		super(ArrayExtensions.asList(comboArray));
	}

	/**
	 * Instantiates a new {@link StringComboBoxModel} from the given array and set as selected item
	 * the given value
	 *
	 * @param comboArray
	 *            the combo array
	 * @param selectedItem
	 *            the selected item
	 */
	public StringComboBoxModel(final String[] comboArray, final String selectedItem)
	{
		super(ArrayExtensions.asList(comboArray), selectedItem);
	}

}
