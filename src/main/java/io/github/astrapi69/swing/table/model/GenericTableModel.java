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
package io.github.astrapi69.swing.table.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import io.github.astrapi69.collections.list.ListFactory;

/**
 * The class {@link GenericTableModel} as the name presume it can take a generic type of the model
 * object.
 *
 * @param <T>
 *            the generic type of the model
 */
public abstract class GenericTableModel<T> extends AbstractTableModel
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = -2953355508541913548L;

	/** The data. */
	private List<T> data = new ArrayList<>();

	/**
	 * Instantiates a new generic table model.
	 */
	public GenericTableModel()
	{
	}

	/**
	 * Instantiates a new generic table model.
	 *
	 * @param list
	 *            The list with the data to set.
	 */
	public GenericTableModel(final List<T> list)
	{
		data.addAll(list);
	}

	/**
	 * Adds the row.
	 *
	 * @param row
	 *            the row to add.
	 */
	public void add(final T row)
	{
		data.add(row);
		fireTableDataChanged();
	}

	/**
	 * Adds the list.
	 *
	 * @param list
	 *            the list of rows to add.
	 */
	public void addList(final List<T> list)
	{
		data.addAll(list);
		fireTableDataChanged();
	}

	/**
	 * Removes all data from this table model.
	 */
	public void clear()
	{
		if (null != data && !data.isEmpty())
		{
			data.clear();
			fireTableDataChanged();
		}
	}

	/**
	 * Gets the row from the given index.
	 *
	 * @param row
	 *            The index from the row to get.
	 *
	 * @return the row from the given index.
	 */
	public T get(final int row)
	{
		return data.get(row);
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<T> getData()
	{
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(final List<T> data)
	{
		this.data = data;
	}

	/**
	 * Gets the row count.
	 *
	 * @return the row count {@inheritDoc}
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount()
	{
		return data.size();
	}

	/**
	 * Removes the given Object.
	 *
	 * @param row
	 *            the row
	 *
	 * @return the removed Object or null if the object is not in the tablemodel.
	 */
	public T remove(final T row)
	{

		final int index = data.indexOf(row);
		if (index != -1)
		{
			try
			{
				return data.remove(index);
			}
			finally
			{
				fireTableDataChanged();
			}
		}
		return null;
	}

	/**
	 * Removes the all.
	 *
	 * @param selectedRows
	 *            the selected rows
	 * @return the list
	 */
	public List<T> removeAll(final int[] selectedRows)
	{
		final List<T> removedList = new ArrayList<>();
		final int lastIndex = selectedRows.length - 1;
		for (int i = lastIndex; -1 < i; i--)
		{
			final int selectedRow = selectedRows[i];
			final T row = removeAt(selectedRow);
			removedList.add(row);
		}
		fireTableDataChanged();
		return removedList;
	}

	/**
	 * Removes all
	 *
	 * @return the list that was removed
	 */
	public List<T> removeAll()
	{
		return removeAll(ListFactory.newArrayList(getData()));
	}

	/**
	 * Removes the all the given Object.
	 *
	 * @param toRemove
	 *            the to remove
	 * @return the list the removed Objects.
	 */
	public List<T> removeAll(final List<T> toRemove)
	{
		final List<T> removedList = new ArrayList<>();
		for (final T t : toRemove)
		{
			final int index = data.indexOf(t);
			if (index != -1)
			{
				removedList.add(data.remove(index));
			}
		}
		fireTableDataChanged();
		return removedList;
	}

	/**
	 * Removes the row at the given index.
	 *
	 * @param row
	 *            The index from the row to remove.
	 *
	 * @return the removed row at the given index.
	 */
	public T removeAt(final int row)
	{
		try
		{
			return data.remove(row);
		}
		finally
		{
			fireTableDataChanged();
		}
	}

	/**
	 * Update the row.
	 *
	 * @param row
	 *            the row
	 */
	public void update(final T row)
	{
		final int index = data.indexOf(row);
		if (index != -1)
		{
			data.set(index, row);
			fireTableDataChanged();
		}
	}

}
