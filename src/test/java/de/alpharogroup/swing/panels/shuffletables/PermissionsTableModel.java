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
package de.alpharogroup.swing.panels.shuffletables;

import de.alpharogroup.swing.tablemodel.GenericTableModel;
import de.alpharogroup.test.objects.Permission;

/**
 * The Class PermissionsTableModel.
 */
public class PermissionsTableModel extends GenericTableModel<Permission>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant NAME. */
	public static final String NAME = "Name";

	/** The Constant SHORTCUT. */
	public static final String SHORTCUT = "Shortcut";

	/** The Constant DESCRIPTION. */
	public static final String DESCRIPTION = "Description";

	/** The column names. */
	private final String[] columnNames = { NAME, SHORTCUT, DESCRIPTION };

	/** The can edit. */
	boolean[] canEdit = new boolean[] { false, false, false };

	/**
	 * (non-Javadoc).
	 *
	 * @param c
	 *            the c
	 *
	 * @return the column class
	 *
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(final int c)
	{
		switch (c)
		{
			case 0 :
				return String.class;
			case 1 :
				return String.class;
			case 2 :
				return String.class;
			default :
				return null;
		}

	}

	/**
	 * (non-Javadoc).
	 *
	 * @return the column count
	 *
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param col
	 *            the col
	 *
	 * @return the column name
	 *
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(final int col)
	{
		return columnNames[col];
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 *
	 * @return the value at
	 *
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(final int row, final int col)
	{
		final Permission permission = getData().get(row);
		switch (col)
		{
			case 0 :
				return permission.getName();
			case 1 :
				return permission.getShortcut();
			case 2 :
				return permission.getDescription();
			default :
				return null;
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex)
	{
		return canEdit[columnIndex];
	}

}
