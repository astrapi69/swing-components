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
package io.github.astrapi69.swing.table.model.suffle.actions;

import java.awt.event.ActionEvent;

import javax.swing.*;

import io.github.astrapi69.check.Check;
import io.github.astrapi69.swing.x.GenericShuffleJXTable;

/**
 * The class {@link RemoveAction} can shuffle one row from a table to another table
 *
 * @deprecated use instead the same named class in project swing-table-components<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public class RemoveAction<T> extends AbstractAction
{

	private static final long serialVersionUID = 1L;

	private final GenericShuffleJXTable<T> shuffleJTable;

	public RemoveAction(final GenericShuffleJXTable<T> shuffleJTable)
	{
		Check.get().notNull(shuffleJTable, "shuffleJTable");
		this.shuffleJTable = shuffleJTable;
	}

	@Override
	public void actionPerformed(final ActionEvent e)
	{
		final int[] selectedRows = shuffleJTable.getRightTable().getSelectedRows();
		if (selectedRows.length == 0)
		{
			JOptionPane.showMessageDialog(null, "You have to selected at least one row.");
		}
		else
		{
			shuffleJTable.shuffleSelectedRightRowsToLeftTable();
		}
	}

}
