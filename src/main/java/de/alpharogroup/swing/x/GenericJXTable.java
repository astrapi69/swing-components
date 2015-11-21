/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
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
package de.alpharogroup.swing.x;

import javax.swing.table.TableRowSorter;

import org.jdesktop.swingx.JXTable;

import de.alpharogroup.swing.tablemodel.GenericTableModel;

/**
 * The Class GenericJXTable.
 *
 * @param <TYPE>
 *            the generic type of the model
 */
@SuppressWarnings("serial")
public class GenericJXTable<TYPE> extends JXTable
{

	/** The generic table model. */
	private final GenericTableModel<TYPE> genericTableModel;

	/** The sorter. */
	private final TableRowSorter<GenericTableModel<TYPE>> sorter;

	/**
	 * Instantiates a new GenericJXTable.
	 *
	 * @param genericTableModel
	 *            the generic table model
	 */
	public GenericJXTable(final GenericTableModel<TYPE> genericTableModel)
	{
		super();
		this.genericTableModel = genericTableModel;

		this.setModel(this.genericTableModel);

		this.sorter = new TableRowSorter<GenericTableModel<TYPE>>(this.genericTableModel);

		this.setRowSorter(this.sorter);
	}

	/**
	 * Gets the generic table model.
	 *
	 * @return the generic table model
	 */
	public GenericTableModel<TYPE> getGenericTableModel()
	{
		return genericTableModel;
	}

	/**
	 * Gets the selected row.
	 *
	 * @return the selected row
	 */
	@Override
	public int getSelectedRow()
	{
		int selectedRow = super.getSelectedRow();
		// find the real selected row. If the rows was sorted the index from the
		// model does not fit to the table.
		selectedRow = this.convertRowIndexToModel(selectedRow);
		return selectedRow;
	}

	/**
	 * Gets the selected rows.
	 *
	 * @return the selected rows
	 */
	@Override
	public int[] getSelectedRows()
	{
		// find the real selected rows. If the rows was sorted the index from the
		// model does not fit to the table.
		final int[] selectedRows = super.getSelectedRows();
		final int[] sr = new int[selectedRows.length];
		for (int i = 0; i < selectedRows.length; i++)
		{
			sr[i] = this.convertRowIndexToModel(selectedRows[i]);
		}
		return sr;
	}

	/**
	 * Gets the sorter.
	 *
	 * @return the sorter
	 */
	public TableRowSorter<GenericTableModel<TYPE>> getSorter()
	{
		return sorter;
	}

}
