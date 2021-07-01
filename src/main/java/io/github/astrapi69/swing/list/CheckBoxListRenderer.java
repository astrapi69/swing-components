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
package io.github.astrapi69.swing.list;

import java.awt.*;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.swing.check.model.CheckableItem;
import io.github.astrapi69.swing.check.model.CheckableValue;
import io.github.astrapi69.swing.tree.renderer.CheckBoxTreeCellRenderer;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckBoxListRenderer extends CheckBoxTreeCellRenderer
	implements
		ListCellRenderer<CheckableItem<CheckableValue>>
{
	private static final long serialVersionUID = 1L;
	final Icon defaultIcon;
	final Color textBackground;
	final Color textForeground;

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