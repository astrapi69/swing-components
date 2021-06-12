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

import java.util.List;
import java.util.logging.Level;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 * The abstract class {@link BaseTableModel} holds a {@link TableColumnsModel} for layout the
 * columns.
 *
 * @param <T>
 *            the generic type of the model
 */
@NoArgsConstructor
@Log
public abstract class BaseTableModel<T> extends GenericTableModel<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The columns model. */
	@Getter
	@Setter
	private TableColumnsModel columnsModel;

	/**
	 * Instantiates a new {@link BaseTableModel}.
	 *
	 * @param list
	 *            the list
	 */
	public BaseTableModel(List<T> list)
	{
		super(list);
	}

	/**
	 * Instantiates a new {@link BaseTableModel}.
	 *
	 * @param list
	 *            the list
	 * @param columnsModel
	 *            the columns model
	 */
	public BaseTableModel(List<T> list, TableColumnsModel columnsModel)
	{
		super(list);
		this.columnsModel = columnsModel;
	}

	/**
	 * Instantiates a new {@link BaseTableModel}.
	 *
	 * @param columnsModel
	 *            the columns model
	 */
	public BaseTableModel(TableColumnsModel columnsModel)
	{
		this.columnsModel = columnsModel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<?> getColumnClass(final int c)
	{
		try
		{
			return columnsModel.getColumnClasses()[c];
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "Error occured on getting column class on index " + c + ".", e);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getColumnCount()
	{
		return columnsModel.getColumnNames().length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColumnName(final int col)
	{
		try
		{
			return columnsModel.getColumnNames()[col];
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "Error occured on getting column name on index " + col + ".", e);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex)
	{
		try
		{
			return columnsModel.getCanEdit()[columnIndex];
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE,
				"Error occured on getting flag if the cell is editable at position on row: "
					+ rowIndex + " and in column: " + columnIndex + ".",
				e);

		}
		return false;
	}

}
