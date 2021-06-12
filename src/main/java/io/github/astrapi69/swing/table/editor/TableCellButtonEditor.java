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
package io.github.astrapi69.swing.table.editor;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link TableCellButtonEditor}
 */
@Getter
@Setter
public class TableCellButtonEditor extends DefaultCellEditor
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The button. */
	private JButton button;

	/** The flag if the button was clicked. */
	private boolean clicked;

	/** The column index. */
	private int column;

	/** The row index. */
	private int row;

	/** The value. */
	private Object value;

	/**
	 * Instantiates a new {@link TableCellButtonEditor} object
	 */
	public TableCellButtonEditor()
	{
		this(new JCheckBox());
	}

	/**
	 * Instantiates a new {@link TableCellButtonEditor} object.
	 *
	 * @param checkBox
	 *            the check box
	 */
	public TableCellButtonEditor(final JCheckBox checkBox)
	{
		super(checkBox);
		setButton(new JButton());
		getButton().setOpaque(true);
		getButton().addActionListener(e -> {
			onClick();
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getCellEditorValue()
	{
		setClicked(false);
		onGetCellEditorValue();
		return onSetText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Component getTableCellEditorComponent(final JTable table, final Object value,
		final boolean isSelected, final int row, final int column)
	{
		setRow(row);
		setColumn(column);
		setValue(value);
		if (isSelected)
		{
			getButton().setForeground(table.getSelectionForeground());
			getButton().setBackground(table.getSelectionBackground());
		}
		else
		{
			getButton().setForeground(table.getForeground());
			getButton().setBackground(table.getBackground());
		}
		getButton().setText(onSetText());
		setClicked(true);
		return getButton();
	}


	/**
	 * Callback method to interact when the button is clicked.
	 */
	protected void onClick()
	{
		fireEditingStopped();
	}

	/**
	 * Callback method to interact in the method getCellEditorValue
	 */
	protected void onGetCellEditorValue()
	{
	}

	/**
	 * Callback method to interact when the text is set.
	 *
	 * @return the string
	 */
	protected String onSetText()
	{
		String text = "";
		if (getValue() != null)
		{
			text = getValue().toString();
		}
		return text;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean stopCellEditing()
	{
		boolean stopCellEditing = super.stopCellEditing();
		setClicked(false);
		return stopCellEditing;
	}
}