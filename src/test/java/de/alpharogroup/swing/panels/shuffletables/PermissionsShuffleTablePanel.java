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
import de.alpharogroup.model.GenericModel;
import de.alpharogroup.model.api.Model;
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

		permissions
			.add(Permission.builder().name("read").description("Permission to read.").build());
		permissions
			.add(Permission.builder().name("write").description("Permission to write.").build());
		permissions
			.add(Permission.builder().name("delete").description("Permission to delete.").build());
		permissions.add(
			Permission.builder().name("execute").description("Permission to execute.").build());
		permissions.add(Permission.builder().name("buy").description("Permission to buy.").build());
		permissions
			.add(Permission.builder().name("sale").description("Permission to sale.").build());

		final Frame frame = new Frame();
		frame.addWindowListener(new CloseWindow());
		frame.setTitle("Shuffle table panel");
		final PermissionsShuffleTablePanel panel = new PermissionsShuffleTablePanel(
			GenericModel.of(permissions));
		frame.add(panel);
		frame.setSize(700, 500);
		frame.setVisible(true);
	}

	public PermissionsShuffleTablePanel(final Model<List<Permission>> model)
	{
		super(model);
	}

	@Override
	public void actionPerformed(final ActionEvent event)
	{

		if (event.getSource() == this.btnAdd)
		{
			if (0 < this.tblAvailableElements.getSelectedRowCount())
			{
				this.shuffleTable.shuffleSelectedLeftRowToRightTable();
			}

		}
		else if (event.getSource() == this.btnAddAll)
		{

			this.shuffleTable.addAllLeftRowsToRightTable();

		}
		else if (event.getSource() == this.btnRemoveAll)
		{

			this.shuffleTable.addAllRightRowsToLeftTable();

		}
		else if (event.getSource() == this.btnRemove)
		{
			if (0 < this.tblSelectedElements.getSelectedRowCount())
			{
				this.shuffleTable.shuffleSelectedRightRowsToLeftTable();
			}
		}
	}

	@Override
	protected void initializeComponents()
	{
		this.btnAddAll = new JXButton("Add all >>");
		this.btnAddAll.addActionListener(this);
		this.btnAdd = new JXButton("Add >");
		this.btnAdd.addActionListener(this);
		this.btnRemoveAll = new JXButton("<< Remove all");
		this.btnRemoveAll.addActionListener(this);
		this.btnRemove = new JXButton("< Remove");
		this.btnRemove.addActionListener(this);
		this.lblAvailableElements = new JXLabel("Available permissions:");
		this.lblSelectedElements = new JXLabel("Selected permissions:");
		this.scrPnTblAvailableElements = new JScrollPane();
		this.scrPnTblSelectedElements = new JScrollPane();
		// 2. Create a generic table model for the class Permission.
		final PermissionsTableModel permissionsTableModel = new PermissionsTableModel();
		// 3. Add the data to the model.
		permissionsTableModel.addList(getModelObject());
		// 4. Create the generic table and associate with the generic table
		// model.
		this.tblAvailableElements = new GenericJXTable<>(permissionsTableModel);
		this.tblSelectedElements = new GenericJXTable<>(new PermissionsTableModel());
		this.shuffleTable = new GenericShuffleJXTable<>(this.tblAvailableElements,
			this.tblSelectedElements);
		this.scrPnTblAvailableElements.setViewportView(this.tblAvailableElements);
		this.scrPnTblSelectedElements.setViewportView(this.tblSelectedElements);
	}

	@Override
	protected void initializeLayout()
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
		add(this.scrPnTblAvailableElements, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(this.btnAdd, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(this.btnAddAll, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(this.btnRemoveAll, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(this.btnRemove, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 10;
		gbc.weighty = 0;
		gbc.weightx = 0;
		add(this.scrPnTblSelectedElements, gbc);

	}

}
