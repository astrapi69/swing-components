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
package io.github.astrapi69.swing.table.model.triple;

import io.github.astrapi69.collections.pairs.Triple;
import io.github.astrapi69.swing.table.model.BaseTableModel;
import io.github.astrapi69.swing.table.model.TableColumnsModel;

/**
 * The class {@link TripleTableModel} that lists three columns with generic content that can be
 * defined for every column.
 */
public class TripleTableModel<L, M, R> extends BaseTableModel<Triple<L, M, R>>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link TripleTableModel} object.
	 */
	public TripleTableModel()
	{
		this(TableColumnsModel.builder().columnNames(new String[] { "Left", "Middle", "Right" })
			.canEdit(new boolean[] { true, true, true })
			.columnClasses(new Class<?>[] { Object.class, Object.class, Object.class }).build());
	}

	/**
	 * Instantiates a new {@link TripleTableModel} object.
	 *
	 * @param columnsModel
	 *            the columns model
	 */
	public TripleTableModel(final TableColumnsModel columnsModel)
	{
		super(columnsModel);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex)
	{
		final Triple<L, M, R> row = getData().get(rowIndex);
		switch (columnIndex)
		{
			case 0 :
				return row.getLeft();
			case 1 :
				return row.getMiddle();
			case 2 :
				return row.getRight();
			default :
				return null;
		}
	}

}
