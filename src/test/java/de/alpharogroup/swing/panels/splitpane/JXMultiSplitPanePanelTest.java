package de.alpharogroup.swing.panels.splitpane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.MultiSplitLayout;
import org.jdesktop.swingx.MultiSplitLayout.Split;
import org.jdesktop.swingx.MultiSplitLayout.Leaf;
import org.jdesktop.swingx.MultiSplitLayout.Divider;
import org.jdesktop.swingx.SwingXUtilities;

import de.alpharogroup.layout.CloseWindow;

public class JXMultiSplitPanePanelTest
{
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		final Frame frame = new Frame("JXMultiSplitPanePanel");
		frame.addWindowListener(new CloseWindow());
		JXMultiSplitPanePanel<ApplicationTestModel<String>> multiSplitPanePanel =
				// TestComponentFactory.newJXMultiSplitPanePanelDefault();
//				TestComponentFactory.newJXMultiSplitPanePanelCustomLayout();
				TestComponentFactory.newJXMultiSplitPanePanelCustomLayout2();

		frame.add(multiSplitPanePanel);
		frame.pack();
		frame.setVisible(true);
	}

}
