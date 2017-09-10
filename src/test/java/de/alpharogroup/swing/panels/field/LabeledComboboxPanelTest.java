package de.alpharogroup.swing.panels.field;

import java.awt.Frame;

import de.alpharogroup.layout.CloseWindow;

public class LabeledComboboxPanelTest
{


	/**
	 * Test init layout.
	 */

	public static void main(final String[] args)
	{
		final Frame frame = new Frame("ComboboxPanel");
		frame.addWindowListener(new CloseWindow());
		frame.add(new LabeledComboboxPanel());
		frame.pack();
		frame.setVisible(true);
	}

}
