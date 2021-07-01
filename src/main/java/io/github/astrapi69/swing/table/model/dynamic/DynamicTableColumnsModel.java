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
package io.github.astrapi69.swing.table.model.dynamic;

import java.lang.reflect.Field;

import lombok.Data;
import lombok.NonNull;

import org.apache.commons.lang3.StringUtils;

import io.github.astrapi69.collections.list.ListFactory;
import io.github.astrapi69.reflection.ReflectionExtensions;

/**
 * The class {@link DynamicTableColumnsModel} encapsulates the column data for a table model that
 * can resolve the columns dynamically from the given class type
 */
@Data
public class DynamicTableColumnsModel<T>
{

	/** The class type. */
	@NonNull
	private final Class<T> type;
	/** The flag for the column if they can be edited. */
	private boolean[] canEdit;
	/** The column classes. */
	private Class<?>[] columnClasses;
	/** The column names. */
	private String[] columnNames;

	/**
	 * Instantiates a new {@link DynamicTableColumnsModel} object
	 *
	 * @param type
	 *            the class type
	 */
	public DynamicTableColumnsModel(@NonNull Class<T> type)
	{
		this.type = type;
		onSetColumnNames();
		onSetColumnClasses();
		onSetCanEdit();
	}

	private Field[] getFields()
	{
		return ReflectionExtensions.getAllDeclaredFields(getType(), "serialVersionUID",
			"$jacocoData");
	}

	/**
	 * Callback method for set the canEdit array from the generic given type. This method is invoked
	 * in the constructor from the derived classes and can be overridden so users can provide their
	 * own version of a column classes
	 */
	protected void onSetCanEdit()
	{
		Field[] fields = getFields();
		canEdit = new boolean[fields.length];
		for (int i = 0; i < fields.length; i++)
		{
			canEdit[i] = false;
		}
	}

	/**
	 * Callback method for set the column classes array from the generic given type. This method is
	 * invoked in the constructor from the derived classes and can be overridden so users can
	 * provide their own version of a column classes
	 */
	protected void onSetColumnClasses()
	{
		Field[] fields = getFields();
		columnClasses = new Class<?>[fields.length];
		for (int i = 0; i < fields.length; i++)
		{
			columnClasses[i] = fields[i].getType();
		}
	}

	/**
	 * Callback method for set the column names array from the generic given type. This method is
	 * invoked in the constructor from the derived classes and can be overridden so users can
	 * provide their own version of a column names
	 */
	protected void onSetColumnNames()
	{
		columnNames = ReflectionExtensions.getAllDeclaredFieldNames(getType(),
			ListFactory.newArrayList("serialVersionUID", "$jacocoData"));
		for (int i = 0; i < columnNames.length; i++)
		{
			columnNames[i] = StringUtils.capitalize(columnNames[i]);
		}
	}

}
