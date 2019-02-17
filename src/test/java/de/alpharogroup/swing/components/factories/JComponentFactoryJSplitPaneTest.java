package de.alpharogroup.swing.components.factories;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.MultiSplitLayout;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.swing.panels.preferences.ApplicationPreferencesPanel;

public class JComponentFactoryJSplitPaneTest
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

	public static JXMultiSplitPane createMultiSplitPaneDemo() {
		  JXMultiSplitPane msp = new JXMultiSplitPane();
		  String layoutDef = "(COLUMN (ROW weight=0.8 (COLUMN weight=0.25 " +
		      "(LEAF name=left.top weight=0.5) (LEAF name=left.middle weight=0.5))" +
		      "(LEAF name=editor weight=0.75)) (LEAF name=bottom weight=0.2))";

		  MultiSplitLayout.Node modelRoot = MultiSplitLayout.parseModel( layoutDef );
		  msp.getMultiSplitLayout().setModel( modelRoot );

		  msp.add( new JButton( "Left Top" ), "left.top" );
		  msp.add( new JButton( "Left Middle" ), "left.middle" );
		  msp.add( new JButton( "Editor" ), "editor" );
		  msp.add( new JButton( "Bottom" ), "bottom" );

		  // ADDING A BORDER TO THE MULTISPLITPANE CAUSES ALL SORTS OF ISSUES
		  msp.setBorder( BorderFactory.createEmptyBorder( 4, 4, 4, 4 ) );
		  return msp;
		}
}
