package de.alpharogroup.swing.tablemodel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import de.alpharogroup.check.Check;
import de.alpharogroup.swing.GenericShuffleJTable;

public class AddAction<T> extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private final GenericShuffleJTable<T> shuffleJTable;

	public AddAction(final GenericShuffleJTable<T> shuffleJTable) {
		Check.get().notNull(shuffleJTable, "shuffleJTable");
		this.shuffleJTable = shuffleJTable;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final int[] selectedRows = shuffleJTable.getLeftTable().getSelectedRows();
		if (selectedRows.length == 0) {
			JOptionPane.showMessageDialog(null, "You have to selected at least one row.");
		} else {
			shuffleJTable.shuffleSelectedLeftRowsToRightTable();
		}
	}

}
