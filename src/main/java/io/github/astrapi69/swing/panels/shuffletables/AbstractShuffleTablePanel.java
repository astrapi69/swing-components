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
package io.github.astrapi69.swing.panels.shuffletables;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import io.github.astrapi69.swing.x.GenericJXTable;
import io.github.astrapi69.swing.x.GenericShuffleJXTable;
import lombok.Getter;
import io.github.astrapi69.model.GenericModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.menu.MenuFactory;
import io.github.astrapi69.swing.table.model.GenericTableModel;
import io.github.astrapi69.swing.table.model.suffle.actions.AddAction;
import io.github.astrapi69.swing.table.model.suffle.actions.AddAllAction;
import io.github.astrapi69.swing.table.model.suffle.actions.RemoveAction;
import io.github.astrapi69.swing.table.model.suffle.actions.RemoveAllAction;


/**
 * The class {@link AbstractShuffleTablePanel}.
 *
 * @param <T>
 *            the generic type of the model
 */
@Getter
public abstract class AbstractShuffleTablePanel<T> extends BasePanel<List<T>>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The add action. */
	private AddAction<T> addAction;

	/** The add all action. */
	private AddAllAction<T> addAllAction;

	/** The btn add. */
	private JButton btnAdd;

	/** The btn add all. */
	private JButton btnAddAll;

	/** The btn remove. */
	private JButton btnRemove;

	/** The btn remove all. */
	private JButton btnRemoveAll;

	/** The remove action. */
	private RemoveAction<T> removeAction;

	/** The remove all action. */
	private RemoveAllAction<T> removeAllAction;

	/** The {@link JScrollPane} for the left table. */
	private JScrollPane scrPnTblLeft;

	/** The {@link JScrollPane} for the right table. */
	private JScrollPane scrPnTblRight;

	/** The shuffle table. */
	private GenericShuffleJXTable<T> shuffleTable;

	/** The left table. */
	private GenericJXTable<T> tblLeft;

	/** The right table. */
	private GenericJXTable<T> tblRight;


	/**
	 * Instantiates a new {@link AbstractShuffleTablePanel} panel.
	 */
	public AbstractShuffleTablePanel()
	{
		this(GenericModel.ofList(new ArrayList<>()));
	}

	/**
	 * Instantiates a new {@link AbstractShuffleTablePanel} panel.
	 *
	 * @param model
	 *            the model
	 */
	public AbstractShuffleTablePanel(Model<List<T>> model)
	{
		super(model);
	}

	/**
	 * Abstract factory method to provide the left table model.
	 *
	 * @return the generic table model
	 */
	protected abstract GenericTableModel<T> newLeftTableModel();

	/**
	 * Abstract factory method to provide the right table model.
	 *
	 * @return the generic table model
	 */
	protected abstract GenericTableModel<T> newRightTableModel();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();

		// Create the tables and scrollpanes...
		tblRight = new GenericJXTable<>(newRightTableModel());
		tblLeft = new GenericJXTable<>(newLeftTableModel());
		@SuppressWarnings("unchecked")
		final GenericTableModel<T> tableModel = (GenericTableModel<T>)tblLeft.getModel();
		tableModel.addList(getModelObject());

		shuffleTable = new GenericShuffleJXTable<>(tblLeft, tblRight);

		addAction = new AddAction<>(shuffleTable);
		removeAction = new RemoveAction<>(shuffleTable);
		addAllAction = new AddAllAction<>(shuffleTable);
		removeAllAction = new RemoveAllAction<>(shuffleTable);

		final JMenuItem addMenuItem = new JMenuItem("Selected row to right >");
		addMenuItem.addActionListener(addAction);
		final JMenuItem addAllMenuItem = new JMenuItem("All selected rows to right >>");
		addAllMenuItem.addActionListener(addAllAction);
		final JPopupMenu leftTablePopupMenu = MenuFactory.newJPopupMenu(shuffleTable.getLeftTable(),
			addMenuItem, addAllMenuItem);
		shuffleTable.getLeftTable().add(leftTablePopupMenu);

		final JMenuItem removeMenuItem = new JMenuItem("< Selected row to left");
		removeMenuItem.addActionListener(removeAction);
		final JMenuItem removeAllMenuItem = new JMenuItem("<< All selected rows to left");
		removeAllMenuItem.addActionListener(removeAllAction);
		final JPopupMenu rightTablePopupMenu = MenuFactory
			.newJPopupMenu(shuffleTable.getRightTable(), removeMenuItem, removeAllMenuItem);
		shuffleTable.getRightTable().add(rightTablePopupMenu);

		shuffleTable.getLeftTable().add(leftTablePopupMenu);
		// Create the JButtons to move the data...
		btnAdd = new JButton(addAction);
		btnAddAll = new JButton(addAllAction);
		btnRemove = new JButton(removeAction);
		btnRemoveAll = new JButton(removeAllAction);

		btnAdd.setText("Add>");
		btnAddAll.setText("Add all>>");
		btnRemove.setText("<Remove");
		btnRemoveAll.setText("<<Remove all");

		scrPnTblRight = new JScrollPane();
		scrPnTblLeft = new JScrollPane();
		scrPnTblLeft.setViewportView(tblLeft);
		scrPnTblRight.setViewportView(tblRight);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		final GridBagLayout gbl = new GridBagLayout();
		final GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 6;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(scrPnTblLeft, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnAdd, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnAddAll, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnRemoveAll, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnRemove, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 6;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(scrPnTblRight, gbc);
	}

}
