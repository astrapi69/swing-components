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
package io.github.astrapi69.swing.table.model.suffle;

import lombok.Getter;
import io.github.astrapi69.check.Check;
import io.github.astrapi69.swing.table.model.GenericTableModel;

/**
 * The class GenericShuffleTableModel is a helper class to shuffle between the two given
 * GenericTableModel.
 *
 * @param <T>
 *            the generic type of the given model
 */
public class GenericShuffleTableModel<T>
{

	/** The left table model. */
	@Getter
	private final GenericTableModel<T> leftTableModel;

	/** The right table model. */
	@Getter
	private final GenericTableModel<T> rightTableModel;

	/**
	 * Instantiates a new generic shuffle table model.
	 *
	 * @param leftTableModel
	 *            the left table model
	 * @param rightTableModel
	 *            the right table model
	 */
	public GenericShuffleTableModel(final GenericTableModel<T> leftTableModel,
		final GenericTableModel<T> rightTableModel)
	{
		Check.get().notNull(leftTableModel, "leftTableModel").notNull(rightTableModel,
			"rightTableModel");
		this.leftTableModel = leftTableModel;
		this.rightTableModel = rightTableModel;
	}

	/**
	 * Adds the all left rows to right table model.
	 */
	public void addAllLeftRowsToRightTableModel()
	{
		rightTableModel.addList(leftTableModel.getData());
		leftTableModel.clear();
	}

	/**
	 * Adds the all right rows to left table model.
	 */
	public void addAllRightRowsToLeftTableModel()
	{
		leftTableModel.addList(rightTableModel.getData());
		rightTableModel.clear();
	}

	/**
	 * Shuffle selected left rows to right table model.
	 *
	 * @param selectedRows
	 *            the selected rows
	 */
	public void shuffleSelectedLeftRowsToRightTableModel(final int[] selectedRows)
	{
		final int lastIndex = selectedRows.length - 1;
		for (int i = lastIndex; -1 < i; i--)
		{
			final int selectedRow = selectedRows[i];
			final T row = leftTableModel.removeAt(selectedRow);
			rightTableModel.add(row);
		}
	}

	/**
	 * Shuffle selected left row to right table model.
	 *
	 * @param selectedRow
	 *            the selected row
	 */
	public void shuffleSelectedLeftRowToRightTableModel(final int selectedRow)
	{
		if (-1 < selectedRow)
		{
			final T row = leftTableModel.removeAt(selectedRow);
			rightTableModel.add(row);
		}
	}

	/**
	 * Shuffle selected right rows to left table model.
	 *
	 * @param selectedRows
	 *            the selected rows
	 */
	public void shuffleSelectedRightRowsToLeftTableModel(final int[] selectedRows)
	{
		final int lastIndex = selectedRows.length - 1;
		for (int i = lastIndex; -1 < i; i--)
		{
			final int selectedRow = selectedRows[i];
			final T row = rightTableModel.removeAt(selectedRow);
			leftTableModel.add(row);
		}
	}

	/**
	 * Shuffle selected right row to left table model.
	 *
	 * @param selectedRow
	 *            the selected row
	 */
	public void shuffleSelectedRightRowToLeftTableModel(final int selectedRow)
	{
		if (-1 < selectedRow)
		{
			final T row = rightTableModel.removeAt(selectedRow);
			leftTableModel.add(row);
		}
	}

}
