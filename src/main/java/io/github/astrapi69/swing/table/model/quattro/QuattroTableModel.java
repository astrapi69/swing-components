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
package io.github.astrapi69.swing.table.model.quattro;

import io.github.astrapi69.collections.pairs.Quattro;
import io.github.astrapi69.swing.table.model.BaseTableModel;
import io.github.astrapi69.swing.table.model.TableColumnsModel;

/**
 * The class {@link QuattroTableModel} that lists four columns with generic content that can be
 * defined for every column.
 */
public class QuattroTableModel<TL, TR, BL, BR> extends BaseTableModel<Quattro<TL, TR, BL, BR>>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link QuattroTableModel} object.
	 */
	public QuattroTableModel()
	{
		this(TableColumnsModel.builder()
			.columnNames(new String[] { "Top Left", "Top Right", "Bottom Left", "Bottom Right" })
			.canEdit(new boolean[] { true, true, true }).columnClasses(
				new Class<?>[] { Object.class, Object.class, Object.class, Object.class })
			.build());
	}

	/**
	 * Instantiates a new {@link QuattroTableModel} object.
	 *
	 * @param columnsModel
	 *            the columns model
	 */
	public QuattroTableModel(final TableColumnsModel columnsModel)
	{
		super(columnsModel);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex)
	{
		final Quattro<TL, TR, BL, BR> row = getData().get(rowIndex);
		switch (columnIndex)
		{
			case 0 :
				return row.getTopLeft();
			case 1 :
				return row.getTopRight();
			case 2 :
				return row.getBottomLeft();
			case 3 :
				return row.getBottomRight();
			default :
				return null;
		}
	}

}
