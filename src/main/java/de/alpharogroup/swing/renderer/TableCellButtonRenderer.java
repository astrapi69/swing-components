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
	public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column)
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

	protected Color newSelectionBackround(JTable table) {
		return table.getSelectionBackground();
	}

	protected Color newSelectionForeground(JTable table) {
		return table.getSelectionForeground();
	}

	protected Color newBackround(JTable table) {
		if(this.backround == null) {
			this.backround = UIManager.getColor(BUTTON_BACKGROUND_COLOR);
		}
		return this.backround;
	}

	protected Color newForeground(JTable table) {
		if(this.foreground == null) {
			this.foreground = table.getForeground();
		}
		return this.foreground;
	}

}