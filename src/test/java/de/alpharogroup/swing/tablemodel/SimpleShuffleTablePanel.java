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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.alpharogroup.swing.GenericJTable;
import de.alpharogroup.swing.GenericShuffleJTable;

/**
 * The Class SimpleShuffleTablePanel.
 */
public class SimpleShuffleTablePanel extends JPanel implements ActionListener
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The btn add permission. */
	private JButton btnAddPermission;

	/** The btn add all permissions. */
	private javax.swing.JButton btnAddAllPermissions;

	/** The btn remove all permissions. */
	private JButton btnRemoveAllPermissions;

	/** The btn remove permission. */
	private JButton btnRemovePermission;

	/** The scr pn tbl available permissions. */
	private javax.swing.JScrollPane scrPnTblAvailablePermissions;

	/** The scr pn tbl permissions from role. */
	private javax.swing.JScrollPane scrPnTblPermissionsFromRole;

	/** The tbl available permissions. */
	private GenericJTable<Permission> tblAvailablePermissions;

	/** The tbl permissions from role. */
	private GenericJTable<Permission> tblPermissionsFromRole;

	/** The permissions shuffle table. */
	private GenericShuffleJTable<Permission> permissionsShuffleTable;

	/**
	 * Instantiates a new simple shuffle table panel.
	 */
	public SimpleShuffleTablePanel()
	{
		super();
		initComponents();
		initializelayout();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(final ActionEvent event)
	{

		if (event.getSource() == getBtnAddPermission())
		{
			if (0 < getTblAvailablePermissions().getSelectedRowCount())
			{
				getPermissionsShuffleTable().shuffleSelectedLeftRowToRightTable();
			}

		}
		else if (event.getSource() == getBtnAddAllPermissions())
		{

			getPermissionsShuffleTable().addAllLeftRowsToRightTable();


		}
		else if (event.getSource() == getBtnRemoveAllPermissions())
		{

			getPermissionsShuffleTable().addAllRightRowsToLeftTable();


		}
		else if (event.getSource() == getBtnRemovePermission())
		{
			if (0 < getTblPermissionsFromRole().getSelectedRowCount())
			{
				getPermissionsShuffleTable().shuffleSelectedRightRowsToLeftTable();
			}
		}
	}

	/**
	 * Gets the btn add all permissions.
	 *
	 * @return the btn add all permissions
	 */
	public javax.swing.JButton getBtnAddAllPermissions()
	{
		return btnAddAllPermissions;
	}

	/**
	 * Gets the btn add permission.
	 *
	 * @return the btn add permission
	 */
	public JButton getBtnAddPermission()
	{
		return btnAddPermission;
	}

	/**
	 * Gets the btn remove all permissions.
	 *
	 * @return the btn remove all permissions
	 */
	public JButton getBtnRemoveAllPermissions()
	{
		return btnRemoveAllPermissions;
	}

	/**
	 * Gets the btn remove permission.
	 *
	 * @return the btn remove permission
	 */
	public JButton getBtnRemovePermission()
	{
		return btnRemovePermission;
	}

	/**
	 * Gets the permissions shuffle table.
	 *
	 * @return the permissions shuffle table
	 */
	public GenericShuffleJTable<Permission> getPermissionsShuffleTable()
	{
		return permissionsShuffleTable;
	}

	/**
	 * Gets the tbl available permissions.
	 *
	 * @return the tbl available permissions
	 */
	public GenericJTable<Permission> getTblAvailablePermissions()
	{
		return tblAvailablePermissions;
	}

	/**
	 * Gets the tbl permissions from role.
	 *
	 * @return the tbl permissions from role
	 */
	public GenericJTable<Permission> getTblPermissionsFromRole()
	{
		return tblPermissionsFromRole;
	}

	/**
	 * Inits the components.
	 */
	private void initComponents()
	{
		// Create the JButtons to move the data...
		btnAddPermission = new JButton();
		btnAddPermission.addActionListener(this);
		btnAddAllPermissions = new JButton();
		btnAddAllPermissions.addActionListener(this);
		btnRemovePermission = new JButton();
		btnRemovePermission.addActionListener(this);
		btnRemoveAllPermissions = new JButton();
		btnRemoveAllPermissions.addActionListener(this);
		btnAddPermission.setText("Add>");
		btnAddAllPermissions.setText("Add all>>");
		btnRemovePermission.setText("<Remove");
		btnRemoveAllPermissions.setText("<<Remove all");
		// Create the tables and scrollpanes for it...
		tblPermissionsFromRole = new GenericJTable<>(new PermissionsTableModel());
		tblAvailablePermissions = new GenericJTable<>(new PermissionsTableModel());

		permissionsShuffleTable = new GenericShuffleJTable<>(tblAvailablePermissions,
			tblPermissionsFromRole);

		scrPnTblPermissionsFromRole = new javax.swing.JScrollPane();
		scrPnTblAvailablePermissions = new javax.swing.JScrollPane();
		scrPnTblAvailablePermissions.setViewportView(tblAvailablePermissions);
		scrPnTblPermissionsFromRole.setViewportView(tblPermissionsFromRole);
	}

	/**
	 * Initializelayout.
	 */
	private void initializelayout()
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
