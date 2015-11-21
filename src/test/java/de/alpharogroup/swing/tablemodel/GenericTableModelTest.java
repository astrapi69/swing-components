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
package de.alpharogroup.swing.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.swing.GenericJTable;

/**
 * The Class GenericTableModelTest.
 */
public class GenericTableModelTest
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		newTableModelWithTableAndShow();
	}

	/**
	 * Creates the table model with table and show.
	 */
	private static void newTableModelWithTableAndShow()
	{
		// 1. Create a list with data.
		final List<Permission> permissions = new ArrayList<>();
		permissions.add(new Permission("read", "Permission to read."));
		permissions.add(new Permission("write", "Permission to write."));
		permissions.add(new Permission("delete", "Permission to delete."));
		// 2. Create a generic table model for the class Permission.
		final PermissionsTableModel permissionsTableModel = new PermissionsTableModel();
		// 3. Add the data to the model.
		permissionsTableModel.addList(permissions);
		// 4. Create the generic table and associate with the generic table model.
		final GenericJTable<Permission> permissionTable = new GenericJTable<>(permissionsTableModel);
		// 5. Add the table to a JScrollPane.
		final JScrollPane scrPnTblPermissions = new JScrollPane();
		scrPnTblPermissions.setViewportView(permissionTable);
		// 6. Create a Frame for displaying the table.
		final JFrame frame = new JFrame();
		frame.addWindowListener(new CloseWindow());
		// 7. Add the JScrollPane to the Frame.
		frame.add(scrPnTblPermissions);
		frame.setSize(600, 400);
		// 8. Show the Frame.
		frame.setVisible(true);
		if (!frame.isActive())
		{
			frame.toFront();
		}
	}

}
