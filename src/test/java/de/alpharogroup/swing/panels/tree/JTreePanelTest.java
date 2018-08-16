package de.alpharogroup.swing.panels.tree;

import java.awt.Frame;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.swing.panels.tree.JTreePanel;

/**
 * The test class for {@link JTreePanel}
 */
public class JTreePanelTest
{


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args)
	{
		final Frame frame = new Frame("JTreePanel");
		frame.addWindowListener(new CloseWindow());
		frame.add(new TestTreePanel());
		frame.pack();
		frame.setVisible(true);
	}

}
