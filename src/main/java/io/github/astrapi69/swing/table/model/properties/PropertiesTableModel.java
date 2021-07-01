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
package io.github.astrapi69.swing.table.model.properties;

import java.util.Properties;

import javax.swing.table.AbstractTableModel;

import io.github.astrapi69.collections.properties.IndexSortedProperties;

/**
 * The class {@link PropertiesTableModel}.
 */
public class PropertiesTableModel extends AbstractTableModel
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The data. */
	private IndexSortedProperties data;

	/**
	 * Instantiates a new {@link PropertiesTableModel}.
	 */
	public PropertiesTableModel()
	{
		this(new IndexSortedProperties());
	}

	/**
	 * Instantiates a new {@link PropertiesTableModel}.
	 *
	 * @param properties
	 *            the properties to set.
	 */
	public PropertiesTableModel(final Properties properties)
	{
		setProperties(properties);
	}

	/**
	 * Adds the given Properties.
	 *
	 * @param properties
	 *            the properties to add.
	 */
	public void add(final Properties properties)
	{
		data.putAll(properties);
		fireTableDataChanged();
	}

	/**
	 * Adds the row from the given key and value.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void add(final String key, final String value)
	{
		data.setProperty(key, value);
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
	 * Gets the value from the given index.
	 *
	 * @param row
	 *            The index from the row to get.
	 *
	 * @return the row from the given index.
	 */
	public String get(final int row)
	{
		return data.getProperty(row);
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
	 * {@inheritDoc}
	 */
	@Override
	public Class<?> getColumnClass(final int columnIndex)
	{
		return String.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getColumnCount()
	{
		return PropertiesColumns.values().length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColumnName(final int columnIndex)
	{
		final PropertiesColumns column = PropertiesColumns.values()[columnIndex];
		switch (column)
		{
			case KEY :
				return "Key";
			case VALUE :
				return "Value";
		}
		return "";
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
	 * Sets the new properties.
	 *
	 * @param properties
	 *            the new properties
	 */
	public void setData(final Properties properties)
	{
		setProperties(properties);
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
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex)
	{
		final String key = (String)data.get(rowIndex);
		final PropertiesColumns column = PropertiesColumns.values()[columnIndex];
		switch (column)
		{
			case KEY :
				return key;
			case VALUE :
				return data.get(key);
		}
		return null;
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
	 * Sets the properties.
	 *
	 * @param properties
	 *            the new properties
	 */
	protected void setProperties(final Properties properties)
	{
		data = new IndexSortedProperties(properties);
	}

}

