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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import lombok.Getter;
import lombok.Setter;
import io.github.astrapi69.check.Argument;
import io.github.astrapi69.collection.array.ArrayExtensions;
import io.github.astrapi69.collection.list.ListExtensions;
import io.github.astrapi69.collection.list.ListFactory;
import io.github.astrapi69.collection.set.SetFactory;

/**
 * The abstract class {@link AbstractComboBoxModel} contains the data for a combo list and the
 * current selected item.
 *
 * @param <T>
 *            the generic type of the Model
 */
@Getter
public abstract class AbstractComboBoxModel<T> extends AbstractListModel<T>
	implements
		ComboBoxModel<T>,
		ActionListener
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The generic combo list.
	 */
	@Setter
	protected List<T> comboList;

	/**
	 * The current selected item.
	 */
	protected T selectedItem;

	/**
	 * Instantiates a new {@link AbstractComboBoxModel} with a new list.
	 */
	public AbstractComboBoxModel()
	{
		this(ListFactory.newArrayList());
	}

	/**
	 * Instantiates a new {@link AbstractComboBoxModel} from the given list.
	 *
	 * @param comboList
	 *            the list
	 */
	public AbstractComboBoxModel(final List<T> comboList)
	{
		this(comboList, ListExtensions.getFirst(comboList));
	}

	/**
	 * Instantiates a new {@link AbstractComboBoxModel} from the given arguments.
	 *
	 * @param comboList
	 *            the combo list
	 * @param selectedItem
	 *            the selected item
	 */
	public AbstractComboBoxModel(final List<T> comboList, final T selectedItem)
	{
		this.comboList = Argument.notNull(comboList, "comboList");
		this.selectedItem = selectedItem == null
			? ListExtensions.getFirst(comboList)
			: selectedItem;
	}

	/**
	 * Instantiates a new {@link AbstractComboBoxModel} from the given {@link Set}.
	 *
	 * @param set
	 *            the combo set
	 */
	public AbstractComboBoxModel(final Set<T> set)
	{
		this(ListExtensions.toList(set));
	}

	/**
	 * Instantiates a new {@link AbstractComboBoxModel} from the given {@link Set}.
	 *
	 * @param set
	 *            the combo set
	 * @param selectedItem
	 *            the selected item
	 */
	public AbstractComboBoxModel(final Set<T> set, final T selectedItem)
	{
		this(ListExtensions.toList(set), selectedItem);
	}

	/**
	 * Instantiates a new {@link AbstractComboBoxModel} from the given array.
	 *
	 * @param comboArray
	 *            the combo array
	 */
	public AbstractComboBoxModel(final T[] comboArray)
	{
		this(ArrayExtensions.asList(comboArray));
	}

	/**
	 * Instantiates a new {@link AbstractComboBoxModel} from the given arguments.
	 *
	 * @param comboArray
	 *            the combo array
	 * @param selectedItem
	 *            the selected item
	 */
	public AbstractComboBoxModel(final T[] comboArray, final T selectedItem)
	{
		this(ArrayExtensions.asList(comboArray), selectedItem);
	}

	/**
	 * Instantiates a new {@link AbstractComboBoxModel} from the given array and removes the given
	 * excluded values and sets the given selected item value
	 *
	 * @param comboArray
	 *            the combo array
	 * @param selectedItem
	 *            the selected item
	 * @param excludeValues
	 *            the values to exclude
	 */
	public AbstractComboBoxModel(final T[] comboArray, final T selectedItem,
		final Set<T> excludeValues)
	{
		this(newHashSet(ArrayExtensions.asList(comboArray), excludeValues), selectedItem);
	}

	/**
	 * Factory method for create new {@link HashSet} and will be returned as {@link Set}
	 *
	 * @param <T>
	 *            the generic type of the elements
	 * @param collection
	 *            the optional collection that will be added to the new list
	 * @param exclude
	 *            the element that have to be excluded
	 * @param elements
	 *            the elements to add in the new {@link HashSet}
	 * @return the new {@link HashSet}
	 */
	@SafeVarargs
	private static <T> Set<T> newHashSet(final Collection<T> collection,
		final Collection<T> exclude, final T... elements)
	{
		final Set<T> set = SetFactory.newHashSet(collection, elements);
		set.removeAll(exclude);
		return set;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent evt)
	{
		if (evt.getActionCommand().equals("update"))
		{
			this.fireContentsChanged(this, 0, getSize() - 1);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T getElementAt(final int index)
	{
		return comboList.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSize()
	{
		return comboList.size();
	}

	/**
	 * Sets the combo list from the given set.
	 *
	 * @param set
	 *            the new combo set
	 */
	public void setComboSet(final Set<T> set)
	{
		setComboList(ListFactory.newArrayList(set));
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setSelectedItem(final Object anItem)
	{
		selectedItem = (T)anItem;
		this.fireContentsChanged(this, 0, getSize());
	}

}
