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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import de.alpharogroup.swing.table.model.GenericTableModel;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link DeleteRowButtonEditor}
 */
public class DeleteRowButtonEditor extends DefaultCellEditor
{
	/**
	 * The listener interface for receiving deleteRowButton events. The class that is interested in
	 * processing a deleteRowButton event implements this interface, and the object created with
	 * that class is registered with a component using the component's
	 * <code>addDeleteRowButtonListener<code> method. When the deleteRowButton event occurs, that
	 * object's appropriate method is invoked.
	 *
	 * @see DeleteRowButtonEvent
	 */
	@FieldDefaults(level = AccessLevel.PRIVATE)
	@Setter
	class DeleteRowButtonListener implements ActionListener
	{

		int row;
		JTable table;

		@Override
		public void actionPerformed(ActionEvent event)
		{
			if (table.getRowCount() > 0)
			{
				TableModel tableModel = table.getModel();
				GenericTableModel<?> model = (GenericTableModel<?>)tableModel;
				model.removeAt(this.row);
				DeleteRowButtonEditor.this.cancelCellEditing();
			}
		}
	}

	private static final long serialVersionUID = 1L;

	/** The button. */
	protected JButton button;

	/** The delete row button listener. */
	private final DeleteRowButtonListener deleteRowButtonListener;

	/**
	 * Instantiates a new {@link DeleteRowButtonEditor}
	 *
	 * @param checkBox
	 *            the check box
	 */
	public DeleteRowButtonEditor(JCheckBox checkBox)
	{
		super(checkBox);
		deleteRowButtonListener = new DeleteRowButtonListener();
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(deleteRowButtonListener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
		int row, int column)
	{
		deleteRowButtonListener.setRow(row);
		deleteRowButtonListener.setTable(table);

		button.setText(value == null ? "" : "Delete");
		return button;
	}

}