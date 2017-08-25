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
package de.alpharogroup.swing.table.editor;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TableCellButtonEditor extends DefaultCellEditor
{
	private JButton button;

	private boolean clicked;

	private int row;

	private Object value;

	private int  column;

	public TableCellButtonEditor(JCheckBox checkBox)
	{
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(e -> {onClick(); fireEditingStopped();});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
		int row, int column)
	{
		this.row = row;
		this.column = column;
		this.value = value;
		if (isSelected)
		{
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		}
		else
		{
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		String text = "";
		if (value != null)
		{
			text = this.value.toString();
		}
		button.setText(text);
		clicked = true;
		return button;
	}

	@Override
	public Object getCellEditorValue()
	{
		if (clicked)
		{
			JOptionPane.showMessageDialog(button, "You clicked the button with the value "
				+ this.value + " in row index " + row + " and in colunm index " + column +".");
		}
		clicked = false;
		String text = "";
		if (value != null)
		{
			text = this.value.toString();
		}
		return text;
	}

	@Override
	public boolean stopCellEditing()
	{
		clicked = false;
		return super.stopCellEditing();
	}

	protected void onClick() {

	}
}