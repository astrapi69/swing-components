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
package de.alpharogroup.swing.tablemodel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.GenericJTable;
import de.alpharogroup.swing.GenericShuffleJTable;
import de.alpharogroup.swing.base.BasePanel;
import de.alpharogroup.swing.components.factories.JComponentFactory;
import de.alpharogroup.swing.table.model.suffle.actions.AddAction;
import de.alpharogroup.swing.table.model.suffle.actions.AddAllAction;
import de.alpharogroup.swing.table.model.suffle.actions.RemoveAction;
import de.alpharogroup.swing.table.model.suffle.actions.RemoveAllAction;
import lombok.Getter;

/**
 * The class SimpleShuffleTablePanel.
 */
@Getter
public class SimpleShuffleTablePanel extends BasePanel<List<Permission>>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The btn add permission. */
	private JButton btnAddPermission;

	/** The btn add all permissions. */
	private JButton btnAddAllPermissions;

	/** The btn remove all permissions. */
	private JButton btnRemoveAllPermissions;

	/** The btn remove permission. */
	private JButton btnRemovePermission;

	/** The scr pn tbl available permissions. */
	private JScrollPane scrPnTblAvailablePermissions;

	/** The scr pn tbl permissions from role. */
	private JScrollPane scrPnTblPermissionsFromRole;

	/** The tbl available permissions. */
	private GenericJTable<Permission> tblAvailablePermissions;

	/** The tbl permissions from role. */
	private GenericJTable<Permission> tblPermissionsFromRole;

	/** The permissions shuffle table. */
	private GenericShuffleJTable<Permission> permissionsShuffleTable;

	private AddAction<Permission> addAction;

	private AddAllAction<Permission> addAllAction;

	private RemoveAction<Permission> removeAction;

	private RemoveAllAction<Permission> removeAllAction;


	public SimpleShuffleTablePanel()
	{
		this(BaseModel.ofList(new ArrayList<>()));
	}

	public SimpleShuffleTablePanel(Model<List<Permission>> model)
	{
		super(model);
		final PermissionsTableModel permissionsTableModel =
			(PermissionsTableModel)tblAvailablePermissions
			.getModel();
		permissionsTableModel.addList(getModelObject());
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();

		// Create the tables and scrollpanes for it...
		tblPermissionsFromRole = new GenericJTable<>(new PermissionsTableModel());
		tblAvailablePermissions = new GenericJTable<>(new PermissionsTableModel());

		permissionsShuffleTable = new GenericShuffleJTable<>(tblAvailablePermissions,
			tblPermissionsFromRole);

		addAction = new AddAction<>(permissionsShuffleTable);
		removeAction = new RemoveAction<>(permissionsShuffleTable);
		addAllAction = new AddAllAction<>(permissionsShuffleTable);
		removeAllAction = new RemoveAllAction<>(permissionsShuffleTable);

		final JMenuItem addMenuItem = new JMenuItem("Selected row to right >");
		addMenuItem.addActionListener(addAction);
		final JMenuItem addAllMenuItem = new JMenuItem("All selected rows to right >>");
		addAllMenuItem.addActionListener(addAllAction);
		final JPopupMenu leftTablePopupMenu = JComponentFactory
			.newJPopupMenu(permissionsShuffleTable.getLeftTable(), addMenuItem, addAllMenuItem);
		permissionsShuffleTable.getLeftTable().add(leftTablePopupMenu);

		final JMenuItem removeMenuItem = new JMenuItem("< Selected row to left");
		removeMenuItem.addActionListener(removeAction);
		final JMenuItem removeAllMenuItem = new JMenuItem("<< All selected rows to left");
		removeAllMenuItem.addActionListener(removeAllAction);
		final JPopupMenu rightTablePopupMenu = JComponentFactory.newJPopupMenu(
			permissionsShuffleTable.getRightTable(), removeMenuItem, removeAllMenuItem);
		permissionsShuffleTable.getRightTable().add(rightTablePopupMenu);

		permissionsShuffleTable.getLeftTable().add(leftTablePopupMenu);
		// Create the JButtons to move the data...
		btnAddPermission = new JButton(addAction);
		btnAddAllPermissions = new JButton(addAllAction);
		btnRemovePermission = new JButton(removeAction);
		btnRemoveAllPermissions = new JButton(removeAllAction);

		btnAddPermission.setText("Add>");
		btnAddAllPermissions.setText("Add all>>");
		btnRemovePermission.setText("<Remove");
		btnRemoveAllPermissions.setText("<<Remove all");

		scrPnTblPermissionsFromRole = new javax.swing.JScrollPane();
		scrPnTblAvailablePermissions = new javax.swing.JScrollPane();
		scrPnTblAvailablePermissions.setViewportView(tblAvailablePermissions);
		scrPnTblPermissionsFromRole.setViewportView(tblPermissionsFromRole);
	}

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
		add(scrPnTblAvailablePermissions, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnAddPermission, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnAddAllPermissions, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnRemoveAllPermissions, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnRemovePermission, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 6;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(scrPnTblPermissionsFromRole, gbc);

	}

}
