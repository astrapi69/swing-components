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
package de.alpharogroup.swing.table.model;

import java.lang.reflect.Field;

import de.alpharogroup.reflection.ReflectionExtensions;
import lombok.Data;
import lombok.NonNull;

/**
 * The class {@link GenericTableColumnsModel} encapsulates the column data for a table model like
 * the column names if they are editable and the column classes.
 */
@Data
public class GenericTableColumnsModel<T>
{

	/** The flag for the column if they can be edited. */
	private boolean[] canEdit;

	/** The column classes. */
	private Class<?>[] columnClasses;

	/** The column names. */
	private String[] columnNames;

	/** The class type. */
	@NonNull
	private final Class<T> type;

	/**
	 * Instantiates a new {@link GenericTableColumnsModel} object
	 *
	 * @param type
	 *            the class type
	 */
	public GenericTableColumnsModel(@NonNull Class<T> type)
	{
		this.type = type;
		onSetColumnNames();
		onSetColumnClasses();
		onSetCanEdit();
	}

	/**
	 * Callback method for set the column names array from the generic given type. This method is
	 * invoked in the constructor from the derived classes and can be overridden so users can
	 * provide their own version of a column names
	 */
	protected void onSetColumnNames()
	{
		columnNames = ReflectionExtensions.getDeclaredFieldNames(getType(), "serialVersionUID");
		for(int i = 0; i < columnNames.length; i++){
			columnNames[i] = StringUtils.capitalize(columnNames[i]);
		}
	}

	/**
	 * Callback method for set the column classes array from the generic given type. This method is
	 * invoked in the constructor from the derived classes and can be overridden so users can
	 * provide their own version of a column classes
	 */
	protected void onSetColumnClasses()
	{
		columnClasses = getTypeClasses(getType(), "serialVersionUID");
	}

	public static<T> Class<?>[] getTypeClasses(Class<T> cls, String... ignoreFieldNames) {
		Field[] fields = ReflectionExtensions.getDeclaredFields(cls, ignoreFieldNames);
		Class<?>[] typeClasses = new Class<?>[fields.length];
		for (int i = 0; i < fields.length; i++)
		{
			typeClasses[i] = fields[i].getType();
		}
		return typeClasses;
	}

	/**
	 * Callback method for set the canEdit array from the generic given type. This method is invoked
	 * in the constructor from the derived classes and can be overridden so users can provide their
	 * own version of a column classes
	 */
	protected void onSetCanEdit()
	{
		Field[] fields = ReflectionExtensions.getDeclaredFields(getType(), "serialVersionUID");
		canEdit = new boolean[fields.length];
		for (int i = 0; i < fields.length; i++)
		{
			canEdit[i] = false;
		}
	}

}
