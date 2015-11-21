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

import de.alpharogroup.layout.CloseWindow;

/**
 * The Class GenericShuffleTableModelTest.
 */
public class GenericShuffleTableModelTest
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		// 1. Create a list with data.
		final List<Permission> permissions = new ArrayList<>();
		permissions.add(new Permission("read", "Permission to read."));
		permissions.add(new Permission("write", "Permission to write."));
		permissions.add(new Permission("delete", "Permission to delete."));
		permissions.add(new Permission("execute", "Permission to execute."));
		permissions.add(new Permission("buy", "Permission to buy."));
		permissions.add(new Permission("sale", "Permission to sale."));
		// 2. Create a panel with that encapsulates the two tables and buttons.
		final SimpleShuffleTablePanel panel = new SimpleShuffleTablePanel();
		// 3. Get the TableModel from the available permissions table...
		final PermissionsTableModel permissionsTableModel = (PermissionsTableModel)panel
			.getTblAvailablePermissions().getModel();
		// 4. Add the created data as list to the TableModel
		permissionsTableModel.addList(permissions);

		// 5. Create a Frame for displaying the shuffle table.
		final JFrame frame = new JFrame();
		frame.addWindowListener(new CloseWindow());
		// 6. Add the Panel to the Frame.
		frame.add(panel);
		frame.pack();
		// 7. Show the Frame.
		frame.setVisible(true);
		if (!frame.isActive())
		{
			frame.toFront();
		}
	}

}
