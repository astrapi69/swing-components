package de.alpharogroup.swing.table.model.suffle.actions;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import de.alpharogroup.check.Check;
import de.alpharogroup.swing.GenericShuffleJTable;

public class AddAllAction<T> extends AbstractAction
{

	private static final long serialVersionUID = 1L;

	private final GenericShuffleJTable<T> shuffleJTable;

	public AddAllAction(final GenericShuffleJTable<T> shuffleJTable)
	{
		Check.get().notNull(shuffleJTable, "shuffleJTable");
		this.shuffleJTable = shuffleJTable;
	}

	@Override
	public void actionPerformed(final ActionEvent e)
	{
		shuffleJTable.addAllLeftRowsToRightTable();
	}

}