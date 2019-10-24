package de.alpharogroup.swing.check.model;

import java.awt.Frame;

import de.alpharogroup.layout.CloseWindow;

public class CheckListPanelTest
{
	public static void main(String args[])
	{
		final Frame frame = new Frame("CheckListPanel");
		String[] strs = { "root", "home", "kde", "mint", "ubuntu" };
		frame.add(new CheckListPanel(strs));
		frame.addWindowListener(new CloseWindow());
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}

