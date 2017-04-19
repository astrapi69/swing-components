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

import java.io.Serializable;

import de.alpharogroup.check.Check;
import de.alpharogroup.swing.tablemodel.GenericShuffleTableModel;
import lombok.Getter;

/**
 * The class {@link GenericShuffleJTable}.
 *
 * @param <T>
 *            the generic type of the model
 */
public class GenericShuffleJTable<T> implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The left table. */
	@Getter
	private final GenericJTable<T> leftTable;

	/** The right table. */
	@Getter
	private final GenericJTable<T> rightTable;

	/** The model. */
	@Getter
	private final GenericShuffleTableModel<T> model;

	/**
	 * Instantiates a new {@link GenericShuffleJTable}.
	 *
	 * @param leftTable
	 *            the left table
	 * @param rightTable
	 *            the right table
	 */
	public GenericShuffleJTable(final GenericJTable<T> leftTable, final GenericJTable<T> rightTable)
	{
		Check.get().notNull(leftTable, "leftTable").notNull(rightTable, "rightTable");
		this.leftTable = leftTable;
		this.rightTable = rightTable;
		this.model = new GenericShuffleTableModel<>(leftTable.getGenericTableModel(),
			rightTable.getGenericTableModel());

	}

	/**
	 * Adds all the left rows to right table.
	 */
	public void addAllLeftRowsToRightTable()
	{
		model.addAllLeftRowsToRightTableModel();
	}

	/**
	 * Adds all the right rows to left table.
	 */
	public void addAllRightRowsToLeftTable()
	{
		model.addAllRightRowsToLeftTableModel();
	}

	/**
	 * Shuffle selected left rows to right table.
	 */
	public void shuffleSelectedLeftRowsToRightTable()
	{
		model.shuffleSelectedLeftRowsToRightTableModel(leftTable.getSelectedRows());
	}

	/**
	 * Shuffle selected left row to right table.
	 */
	public void shuffleSelectedLeftRowToRightTable()
	{
		model.shuffleSelectedLeftRowToRightTableModel(leftTable.getSelectedRow());
	}

	/**
	 * Shuffle selected right rows to left table.
	 */
	public void shuffleSelectedRightRowsToLeftTable()
	{
		model.shuffleSelectedRightRowsToLeftTableModel(rightTable.getSelectedRows());
	}

	/**
	 * Shuffle selected right row to left table.
	 */
	public void shuffleSelectedRightRowToLeftTable()
	{
		model.shuffleSelectedRightRowToLeftTableModel(rightTable.getSelectedRow());
	}

}
