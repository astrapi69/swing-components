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
package de.alpharogroup.swing.table.model.dynamic;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import de.alpharogroup.collections.array.ArrayFactory;
import de.alpharogroup.test.objects.Person;
import de.alpharogroup.test.objects.enums.Gender;

/**
 * The unit test class for the class {@link DynamicTableColumnsModel}
 */
public class DynamicTableColumnsModelTest
{

	/**
	 * Test method for the constructor with class argument
	 */
	@Test
	public void testNewGenericTableColumnsModel()
	{
		DynamicTableColumnsModel<Person> columnsModel = new DynamicTableColumnsModel<>(
			Person.class);
		boolean[] expectedCanEdit = ArrayFactory.newBooleanArray(false, false, false, false, false);
		boolean[] canEdit = columnsModel.getCanEdit();
		for (int i = 0; i < canEdit.length; i++)
		{
			assertEquals(canEdit[i], expectedCanEdit[i]);
		}
		Class<?>[] expectedColumnClasses = ArrayFactory.newArray(String.class, Gender.class,
			Boolean.class, String.class, String.class);
		Class<?>[] columnClasses = columnsModel.getColumnClasses();
		for (int i = 0; i < columnClasses.length; i++)
		{
			assertEquals(columnClasses[i], expectedColumnClasses[i]);
		}
		String[] expectedColumnNames = ArrayFactory.newArray("About", "Gender", "Married", "Name",
			"Nickname");
		String[] columnNames = columnsModel.getColumnNames();
		for (int i = 0; i < columnNames.length; i++)
		{
			assertEquals(columnNames[i], expectedColumnNames[i]);
		}
	}
}
