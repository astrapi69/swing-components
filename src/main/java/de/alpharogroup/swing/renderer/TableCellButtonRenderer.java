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
package de.alpharogroup.swing.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 * The class {@link TableCellButtonRenderer}.
 */
public class TableCellButtonRenderer extends JButton implements TableCellRenderer
{

	private static final String BUTTON_BACKGROUND_COLOR = "Button.background";

	private Color foreground;
	private Color backround;

	public TableCellButtonRenderer()
	{
		this(null, null);
	}

	public TableCellButtonRenderer(Color foreground, Color backround)
	{
		setOpaque(true);
		this.foreground = foreground;
		this.backround = backround;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
		boolean hasFocus, int row, int column)
	{
		if (isSelected)
		{
			setForeground(newSelectionForeground(table));
			setBackground(newSelectionBackround(table));
		}
		else
		{
			setForeground(newForeground(table));
			setBackground(newBackround(table));
		}
		String text = "";
		if (value != null)
		{
			text = value.toString();
		}
		setText(text);
		return this;
	}

	protected Color newBackround(JTable table)
	{
		if (this.backround == null)
		{
			this.backround = UIManager.getColor(BUTTON_BACKGROUND_COLOR);
		}
		return this.backround;
	}

	protected Color newForeground(JTable table)
	{
		if (this.foreground == null)
		{
			this.foreground = table.getForeground();
		}
		return this.foreground;
	}

	protected Color newSelectionBackround(JTable table)
	{
		return table.getSelectionBackground();
	}

	protected Color newSelectionForeground(JTable table)
	{
		return table.getSelectionForeground();
	}

}