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
package io.github.astrapi69.swing.check.model;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.model.check.CheckableItem;
import io.github.astrapi69.model.check.CheckableListModel;
import io.github.astrapi69.model.check.CheckableValue;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.list.JListExtensions;

public class CheckListPanel extends BasePanel<CheckableListModel>
{
	JList<CheckableItem<CheckableValue>> list;
	JScrollPane checklistPane;
	JTextArea textArea;
	JButton printButton;
	JScrollPane textPane;
	JButton uncheckButton;
	JButton clearTextButton;
	JPanel buttonPanel;

	public CheckListPanel()
	{
		this(BaseModel.of(CheckableListModel.builder().build()));
	}

	public CheckListPanel(IModel<CheckableListModel> model)
	{
		super(model);
	}

	/**
	 * Initialize components.
	 */
	@Override
	protected void onInitializeComponents()
	{
		list = JListExtensions.newJList(getModelObject().getValues());
		list.setName("list");

		checklistPane = new JScrollPane(list);

		textArea = new JTextArea(3, 10);
		textArea.setName("textArea");
		textPane = new JScrollPane(textArea);
		printButton = new JButton("Print entries");
		printButton.setName("printButton");
		uncheckButton = new JButton("Uncheck entries");
		clearTextButton = new JButton("Clear Text");
		buttonPanel = new JPanel(new GridLayout(3, 1));
		buttonPanel.add(printButton);
		buttonPanel.add(uncheckButton);
		buttonPanel.add(clearTextButton);
		// add action listeners
		printButton.addActionListener(e -> {
			ListModel<CheckableItem<CheckableValue>> model = list.getModel();
			int n = model.getSize();
			for (int i = 0; i < n; i++)
			{
				CheckableItem<CheckableValue> item = model.getElementAt(i);
				if (item.isSelected())
				{
					textArea.append(item.getCheckableValue().getItemText());
					textArea.append(System.getProperty("line.separator"));
				}
			}
		});

		uncheckButton.addActionListener(e -> {
			ListModel<CheckableItem<CheckableValue>> model = list.getModel();
			int n = model.getSize();
			for (int i = 0; i < n; i++)
			{
				CheckableItem<CheckableValue> item = model.getElementAt(i);
				item.setSelected(false);
			}
			list.repaint();
		});

		clearTextButton.addActionListener(e -> textArea.setText(""));
	}


	/**
	 * Initialize layout.
	 */
	@Override
	protected void onInitializeLayout()
	{
		setLayout(new BorderLayout());

		add(checklistPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.WEST);
		add(textPane, BorderLayout.SOUTH);
	}

}

