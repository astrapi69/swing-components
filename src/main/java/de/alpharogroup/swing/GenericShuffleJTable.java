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
package de.alpharogroup.swing;

/**
 * The Class GenericShuffleJXTable.
 *
 * @param <T>
 *            the generic type of the model
 */
public class GenericShuffleJTable<T>
{

	/** The left table. */
	private final GenericJTable<T> leftTable;

	/** The right table. */
	private final GenericJTable<T> rightTable;

	/**
	 * Instantiates a new generic shuffle jx table.
	 *
	 * @param leftTable
	 *            the left table
	 * @param rightTable
	 *            the right table
	 */
	public GenericShuffleJTable(final GenericJTable<T> leftTable, final GenericJTable<T> rightTable)
	{
		super();
		this.leftTable = leftTable;
		this.rightTable = rightTable;
	}

	/**
	 * Adds the all left rows to right table.
	 */
	public void addAllLeftRowsToRightTable()
	{
		rightTable.getGenericTableModel().addList(leftTable.getGenericTableModel().getData());
		leftTable.getGenericTableModel().clear();
	}

	/**
	 * Adds the all right rows to left table.
	 */
	public void addAllRightRowsToLeftTable()
	{
		leftTable.getGenericTableModel().addList(rightTable.getGenericTableModel().getData());
		rightTable.getGenericTableModel().clear();
	}

	/**
	 * Shuffle selected left rows to right table.
	 */
	public void shuffleSelectedLeftRowsToRightTable()
	{
		final int[] selectedRows = leftTable.getSelectedRows();
		final int lastIndex = selectedRows.length - 1;
		for (int i = lastIndex; -1 < i; i--)
		{
			final int selectedRow = selectedRows[i];
			final T row = leftTable.getGenericTableModel().removeAt(selectedRow);
			rightTable.getGenericTableModel().add(row);
		}
	}


	/**
	 * Shuffle selected left row to right table model.
	 */
	public void shuffleSelectedLeftRowToRightTable()
	{
		final int selectedRow = leftTable.getSelectedRow();
		final T row = leftTable.getGenericTableModel().removeAt(selectedRow);
		rightTable.getGenericTableModel().add(row);
	}


	/**
	 * Shuffle selected right rows to left table model.
	 */
	public void shuffleSelectedRightRowsToLeftTable()
	{
		final int[] selectedRows = rightTable.getSelectedRows();
		final int lastIndex = selectedRows.length - 1;
		for (int i = lastIndex; -1 < i; i--)
		{
			final int selectedRow = selectedRows[i];
			final T row = rightTable.getGenericTableModel().removeAt(selectedRow);
			leftTable.getGenericTableModel().add(row);
		}
	}

	/**
	 * Shuffle selected right row to left table model.
	 */
	public void shuffleSelectedRightRowToLeftTable()
	{
		final int selectedRow = rightTable.getSelectedRow();
		final T row = rightTable.getGenericTableModel().removeAt(selectedRow);
		leftTable.getGenericTableModel().add(row);
	}

}
