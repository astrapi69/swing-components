package de.alpharogroup.swing.list;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

import de.alpharogroup.swing.check.model.CheckableItem;
import de.alpharogroup.swing.check.model.CheckableValue;
import de.alpharogroup.swing.tree.renderer.CheckBoxTreeCellRenderer;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckBoxListRenderer extends CheckBoxTreeCellRenderer implements ListCellRenderer<CheckableItem<CheckableValue>>
{
	Icon defaultIcon;
	Color textBackground;
	Color textForeground;

	public CheckBoxListRenderer()
	{
		defaultIcon = UIManager.getIcon("Tree.leafIcon");
		textBackground = UIManager.getColor("List.textBackground");
		textForeground = UIManager.getColor("List.textForeground");
		getCheckBox().setBackground(textBackground);
		getLabel().setForeground(textForeground);
	}

	@Override
	public Component getListCellRendererComponent(
		JList<? extends CheckableItem<CheckableValue>> list, CheckableItem<CheckableValue> value,
		int index, boolean isSelected, boolean cellHasFocus)
	{
		setEnabled(list.isEnabled());
		getCheckBox().setSelected(value.isSelected());
		getLabel().setFont(list.getFont());
		getLabel().setText(value.getCheckableValue().getItemText());
		getLabel().setSelected(isSelected);
		getLabel().setFocused(cellHasFocus);
		Icon icon = value.getCheckableValue().getIcon();
		if (icon == null)
		{
			icon = defaultIcon;
		}
		getLabel().setIcon(icon);
		return this;
	}
}