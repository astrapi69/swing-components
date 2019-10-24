package de.alpharogroup.swing.check.model;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalIconFactory;

import org.jdesktop.swingx.JXPanel;

import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.swing.list.CheckBoxListRenderer;

public class CheckListPanel extends JXPanel
{
	public CheckListPanel(String[] strs)
	{
		setLayout(new BorderLayout());
		final JList<CheckableItem<CheckableValue>> list = newJList(strs);

		JScrollPane checklistPane = new JScrollPane(list);

		final JTextArea textArea = new JTextArea(3, 10);
		JScrollPane textPane = new JScrollPane(textArea);
		JButton printButton = new JButton("Print entries");
		printButton.addActionListener(e ->
			{
				ListModel<CheckableItem<CheckableValue>> model = list.getModel();
				int n = model.getSize();
				for (int i = 0; i < n; i++)
				{
					CheckableItem<CheckableValue> item = model.getElementAt(i);
					if (item.isSelected())
					{
						textArea.append(item.getCheckableValue().getItemText());
						textArea.append(System.getProperty("line.separator"));
					}
				}
			}
		);
		JButton uncheckButton = new JButton("Uncheck entries");
		uncheckButton.addActionListener(e ->
			{
				ListModel<CheckableItem<CheckableValue>> model = list.getModel();
				int n = model.getSize();
				for (int i = 0; i < n; i++)
				{
					CheckableItem<CheckableValue> item = model.getElementAt(i);
					item.setSelected(false);
				}
				list.repaint();
			}
		);
		JButton clearTextButton = new JButton("Clear Text");
		clearTextButton.addActionListener(e -> textArea.setText(""));
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		buttonPanel.add(printButton);
		buttonPanel.add(uncheckButton);
		buttonPanel.add(clearTextButton);

		add(checklistPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.WEST);
		add(textPane, BorderLayout.SOUTH);
	}

	protected JList<CheckableItem<CheckableValue>> newJList(String[] strs){
		final JList<CheckableItem<CheckableValue>> list = new JList<>(newCheckableItems(strs));

		Icon icon = MetalIconFactory.getFileChooserHomeFolderIcon();
		list.getModel().getElementAt(1).getCheckableValue()
			.setIcon(icon);

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

	private CheckableItem<CheckableValue>[] newCheckableItems(String[] strs)
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

}

