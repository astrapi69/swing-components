package de.alpharogroup.swing.panels.login;

import java.awt.Frame;

import de.alpharogroup.layout.CloseWindow;

public class NewPasswordPanelTest
{


	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{

		final Frame frame = new Frame();
		frame.addWindowListener(new CloseWindow());
		frame.setTitle("Set pw Frame");
		final NewPasswordPanel newPasswordPanel = new NewPasswordPanel();
		frame.add(newPasswordPanel);
		frame.pack();
		frame.setSize(500, 300);
		frame.setVisible(true);
	}

}
