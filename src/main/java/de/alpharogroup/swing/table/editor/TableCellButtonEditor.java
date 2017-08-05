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