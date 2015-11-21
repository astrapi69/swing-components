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
package de.alpharogroup.swing.panels.shuffletables;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXLabel;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.swing.x.GenericJXTable;
import de.alpharogroup.swing.x.GenericShuffleJXTable;
import de.alpharogroup.test.objects.Permission;

public class PermissionsShuffleTablePanel extends ShuffleTablePanel<Permission>
	implements
		ActionListener
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

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
		final Frame frame = new Frame();
		frame.addWindowListener(new CloseWindow());
		frame.setTitle("Shuffle table panel");
		final PermissionsShuffleTablePanel panel = new PermissionsShuffleTablePanel(permissions);
		frame.add(panel);
		frame.setSize(700, 500);
		frame.setVisible(true);
	}

	private final List<Permission> permissions;

	public PermissionsShuffleTablePanel(final List<Permission> permissions)
	{
		super();
		this.permissions = permissions;
		initComponents();
		initLayout();
	}

	@Override
	public void actionPerformed(final ActionEvent event)
	{

		if (event.getSource() == btnAdd)
		{
			if (0 < tblAvailableElements.getSelectedRowCount())
			{
				shuffleTable.shuffleSelectedLeftRowToRightTable();
			}

		}
		else if (event.getSource() == btnAddAll)
		{

			shuffleTable.addAllLeftRowsToRightTable();

		}
		else if (event.getSource() == btnRemoveAll)
		{

			shuffleTable.addAllRightRowsToLeftTable();

		}
		else if (event.getSource() == btnRemove)
		{
			if (0 < tblSelectedElements.getSelectedRowCount())
			{
				shuffleTable.shuffleSelectedRightRowsToLeftTable();
			}
		}
	}

	public List<Permission> getPermissions()
	{
		return permissions;
	}

	private void initComponents()
	{
		btnAddAll = new JXButton("Add all >>");
		btnAddAll.addActionListener(this);
		btnAdd = new JXButton("Add >");
		btnAdd.addActionListener(this);
		btnRemoveAll = new JXButton("<< Remove all");
		btnRemoveAll.addActionListener(this);
		btnRemove = new JXButton("< Remove");
		btnRemove.addActionListener(this);
		lblAvailableElements = new JXLabel("Available permissions:");
		lblSelectedElements = new JXLabel("Selected permissions:");
		scrPnTblAvailableElements = new JScrollPane();
		scrPnTblSelectedElements = new JScrollPane();
		// 2. Create a generic table model for the class Permission.
		final PermissionsTableModel permissionsTableModel = new PermissionsTableModel();
		// 3. Add the data to the model.
		permissionsTableModel.addList(permissions);
		// 4. Create the generic table and associate with the generic table
		// model.
		tblAvailableElements = new GenericJXTable<>(permissionsTableModel);
		tblSelectedElements = new GenericJXTable<>(new PermissionsTableModel());
		shuffleTable = new GenericShuffleJXTable<>(tblAvailableElements, tblSelectedElements);
		scrPnTblAvailableElements.setViewportView(tblAvailableElements);
		scrPnTblSelectedElements.setViewportView(tblSelectedElements);
	}

	private void initLayout()
	{
		final GridBagLayout gbl = new GridBagLayout();
		final GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 10;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(scrPnTblAvailableElements, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnAdd, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnAddAll, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(btnRemoveAll, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 6;
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
		gbc.gridheight = 10;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(scrPnTblSelectedElements, gbc);

	}

}
