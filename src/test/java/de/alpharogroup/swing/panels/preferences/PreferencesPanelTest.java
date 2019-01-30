package de.alpharogroup.swing.panels.preferences;

import java.awt.Frame;

import de.alpharogroup.layout.CloseWindow;

public class PreferencesPanelTest
{


	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		final Frame frame = new Frame("ApplicationPreferencesPanel");
		frame.addWindowListener(new CloseWindow());
		frame.add(new ApplicationPreferencesPanel());

		frame.setBounds(100, 100, 730, 350);
		frame.setVisible(true);
	}

}
