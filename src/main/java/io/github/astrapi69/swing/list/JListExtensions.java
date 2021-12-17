package io.github.astrapi69.swing.list;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalIconFactory;

import io.github.astrapi69.collections.list.ListExtensions;
import io.github.astrapi69.collections.list.ListFactory;
import io.github.astrapi69.swing.check.model.CheckableItem;
import io.github.astrapi69.swing.check.model.CheckableValue;

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
