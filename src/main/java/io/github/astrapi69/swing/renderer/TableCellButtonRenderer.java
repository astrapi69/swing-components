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
package io.github.astrapi69.swing.renderer;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

/**
 * The class {@link TableCellButtonRenderer}.
 *
 * @deprecated use instead the same named class in project swing-table-components<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public class TableCellButtonRenderer extends JButton implements TableCellRenderer
{

	private static final String BUTTON_BACKGROUND_COLOR = "Button.background";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Color backround;
	private Color foreground;

	public TableCellButtonRenderer()
	{
		this(null, null);
	}

	public TableCellButtonRenderer(final Color foreground, final Color backround)
	{
		setOpaque(true);
		this.foreground = foreground;
		this.backround = backround;
	}

	@Override
	public Component getTableCellRendererComponent(final JTable table, final Object value,
		final boolean isSelected, final boolean hasFocus, final int row, final int column)
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
		setText(onSetText(value));
		return this;
	}

	protected Color newBackround(final JTable table)
	{
		if (this.backround == null)
		{
			this.backround = UIManager.getColor(BUTTON_BACKGROUND_COLOR);
		}
		return this.backround;
	}

	protected Color newForeground(final JTable table)
	{
		if (this.foreground == null)
		{
			this.foreground = table.getForeground();
		}
		return this.foreground;
	}

	protected Color newSelectionBackround(final JTable table)
	{
		return table.getSelectionBackground();
	}

	protected Color newSelectionForeground(final JTable table)
	{
		return table.getSelectionForeground();
	}

	/**
	 * Callback method to interact when the text is set.
	 *
	 * @param value
	 *            the value of the table cell
	 * @return the string
	 */
	protected String onSetText(final Object value)
	{
		String text = "";
		if (value != null)
		{
			text = value.toString();
		}
		return text;
	}

}