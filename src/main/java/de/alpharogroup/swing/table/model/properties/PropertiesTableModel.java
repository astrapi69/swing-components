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

import java.util.Properties;

import javax.swing.table.AbstractTableModel;

import org.apache.commons.lang.NotImplementedException;

/**
 * The class {@link PropertiesTableModel}.
 */
public class PropertiesTableModel extends AbstractTableModel
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The data. */
	private Properties data;

	/**
	 * Instantiates a new generic table model.
	 */
	public PropertiesTableModel()
	{
	}

	/**
	 * Instantiates a new generic table model.
	 *
	 * @param list
	 *            The list with the data to set.
	 */
	public PropertiesTableModel(final Properties properties)
	{
		data = properties;
	}

	/**
	 * Adds the row.
	 *
	 * @param row
	 *            the row to add.
	 */
	public void add(final String key, final String value)
	{
		data.setProperty(key, value);
		fireTableDataChanged();
	}

	/**
	 * Adds the list.
	 *
	 * @param list
	 *            the list of rows to add.
	 */
	public void addList(final Properties properties)
	{
		data.putAll(properties);
		fireTableDataChanged();
	}

	/**
	 * Removes all data from this table model.
	 */
	public void clear()
	{
		if (null != data && !data.isEmpty())
		{
			data.clear();
			fireTableDataChanged();
		}
	}

	/**
	 * Gets the Object from the given key.
	 *
	 * @param key
	 *            the key
	 *
	 * @return the Object from the given key.
	 */
	public String get(final String key)
	{
		return data.getProperty(key);
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Properties getData()
	{
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getRowCount()
	{
		return data.size();
	}

	/**
	 * Removes the Object from the given key.
	 *
	 * @param key
	 *            the key
	 *
	 * @return the removed Object or null if the object is not in the tablemodel.
	 */
	public String remove(final String key)
	{
		return (String)data.remove(key);
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(final Properties data)
	{
		this.data = data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getColumnCount()
	{
		return 2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex)
	{
		throw new NotImplementedException();
	}

}

