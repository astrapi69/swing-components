package de.alpharogroup.swing.table.model;

import java.util.Arrays;

import org.testng.annotations.Test;

import de.alpharogroup.test.objects.Person;

public class GenericTableColumnsModelTest
{
	@Test
	public void testNewGenericTableColumnsModel() {
		GenericTableColumnsModel<Person> columnsModel = new GenericTableColumnsModel<>(Person.class);
		boolean[] canEdit = columnsModel.getCanEdit();
		Class<?>[] columnClasses = columnsModel.getColumnClasses();
		String[] columnNames = columnsModel.getColumnNames();
		// TODO make asserts...
		System.out.println(Arrays.toString(canEdit));
		System.out.println(Arrays.deepToString(columnClasses));
		System.out.println(Arrays.deepToString(columnNames));
	}
}
