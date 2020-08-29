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
package de.alpharogroup.swing;

import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

import de.alpharogroup.check.Check;
import de.alpharogroup.swing.table.model.GenericTableModel;
import lombok.Getter;

/**
 * The class GenericJTable.
 *
 * @param <T>
 *            the generic type of the model
 */
public class GenericJTable<T> extends JTable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The generic table model. */
	@Getter
	private final GenericTableModel<T> genericTableModel;

	/** The sorter. */
	@Getter
	private final TableRowSorter<GenericTableModel<T>> sorter;

	/**
	 * Instantiates a new generic j table.
	 *
	 * @param genericTableModel
	 *            the generic table model
	 */
	public GenericJTable(final GenericTableModel<T> genericTableModel)
	{
		super(genericTableModel);
		Check.get().notNull(genericTableModel, "genericTableModel");
		this.genericTableModel = genericTableModel;

		this.setModel(this.genericTableModel);

		this.sorter = new TableRowSorter<>(this.genericTableModel);

		this.setRowSorter(this.sorter);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSelectedRow()
	{
		int selectedRow = super.getSelectedRow();
		if (-1 < selectedRow)
		{
			// find the real selected row. If the rows was sorted the index from
			// the
			// model does not fit to the table.
			selectedRow = this.convertRowIndexToModel(selectedRow);
		}
		return selectedRow;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int[] getSelectedRows()
	{
		// find the real selected rows. If the rows was sorted the index from
		// the
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
	 * Checks if any row in this table is selected.
	 *
	 * @return true, if any row in this table is selected
	 */
	public boolean isAnyRowSelected()
	{
		return (-1 < super.getSelectedRow());
	}

}
