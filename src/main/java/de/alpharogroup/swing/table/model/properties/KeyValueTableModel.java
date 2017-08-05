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
package de.alpharogroup.swing.table.model.properties;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.swing.table.model.BaseTableModel;
import de.alpharogroup.swing.table.model.TableColumnsModel;

/**
 * The class {@link KeyValueTableModel} that lists key value pairs.
 */
public class KeyValueTableModel<K, V> extends BaseTableModel<KeyValuePair<K, V>>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link KeyValueTableModel} object.
	 */
	public KeyValueTableModel()
	{
		this(TableColumnsModel.builder().columnNames(new String[] { "Key", "Value" })
			.canEdit(new boolean[] { false, false })
			.columnClasses(new Class<?>[] { Object.class, Object.class }).build());
	}

	/**
	 * Instantiates a new {@link KeyValueTableModel} object.
	 *
	 * @param columnsModel
	 *            the columns model
	 */
	public KeyValueTableModel(final TableColumnsModel columnsModel)
	{
		super(columnsModel);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex)
	{
		final KeyValuePair<K, V> row = getData().get(rowIndex);
		switch (columnIndex)
		{
			case 0 :
				return row.getKey();
			case 1 :
				return row.getValue();
			default :
				return null;
		}
	}

}
