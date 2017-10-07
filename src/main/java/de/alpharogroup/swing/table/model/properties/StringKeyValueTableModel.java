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

import de.alpharogroup.swing.table.model.TableColumnsModel;

/**
 * The class {@link StringKeyValueTableModel} that lists key value pairs.
 */
public class StringKeyValueTableModel extends KeyValueTableModel<String, String>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link StringKeyValueTableModel} object.
	 */
	public StringKeyValueTableModel()
	{
		this(TableColumnsModel.builder().columnNames(new String[] { "Key", "Value" })
			.canEdit(new boolean[] { false, false })
			.columnClasses(new Class<?>[] { String.class, String.class }).build());
	}

	/**
	 * Instantiates a new {@link StringKeyValueTableModel} object.
	 *
	 * @param columnsModel
	 *            the columns model
	 */
	public StringKeyValueTableModel(final TableColumnsModel columnsModel)
	{
		super(columnsModel);
	}

}
