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

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalIconFactory;

import io.github.astrapi69.collection.list.ListExtensions;
import io.github.astrapi69.collection.list.ListFactory;
import io.github.astrapi69.model.check.CheckableItem;
import io.github.astrapi69.model.check.CheckableValue;
import io.github.astrapi69.swing.tree.renderer.list.CheckBoxListRenderer;

public class JListExtensions
{

	public static CheckableItem<CheckableValue>[] newCheckableItems(String[] strs)
	{
		int n = strs.length;
		List<CheckableItem<CheckableValue>> itemList = ListFactory.newArrayList();
		for (int i = 0; i < n; i++)
		{
			itemList.add(CheckableItem.<CheckableValue> builder()
				.checkableValue(CheckableValue.builder().itemText(strs[i]).build()).build());
		}
		return ListExtensions.toArray(itemList);
	}

	public static JList<CheckableItem<CheckableValue>> newJList(String[] strs)
	{
		CheckableItem<CheckableValue>[] checkableItems = newCheckableItems(strs);
		return newJList(checkableItems);
	}

	public static JList<CheckableItem<CheckableValue>> newJList(
		CheckableItem<CheckableValue>[] checkableItems)
	{
		final JList<CheckableItem<CheckableValue>> list = new JList<>(checkableItems);

		Icon icon = MetalIconFactory.getFileChooserHomeFolderIcon();
		list.getModel().getElementAt(1).getCheckableValue().setIcon(icon);

		list.setCellRenderer(new CheckBoxListRenderer());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new EmptyBorder(0, 4, 0, 0));
		list.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int index = list.locationToIndex(e.getPoint());
				CheckableItem<CheckableValue> item = list.getModel().getElementAt(index);
				item.setSelected(!item.isSelected());
				Rectangle rect = list.getCellBounds(index, index);
				list.repaint(rect);
			}
		});
		return list;
	}

}
