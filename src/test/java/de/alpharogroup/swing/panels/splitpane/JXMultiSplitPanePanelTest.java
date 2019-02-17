package de.alpharogroup.swing.panels.splitpane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
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
	private static String htmlURL = "MultiSplitPaneDemo.html";

	private static String dummyText = "<html>" + " <head>"
		+ "  <title>JXMultiSplitPane Demo</title>" + "</head>" + "<body>"
		+ "JXMultiSplitPane is a container that can be split into multiple resizeable"
		+ "areas. The layout is configured using MultiSplitLayout layout manager." + "<p>"
		+ "The MultiSplitLayout layout manager recursively arranges its components in"
		+ "row and column groups called Splits. Elements of the layout are"
		+ "separated by gaps called Dividers. The overall layout is defined with a"
		+ "simple tree model whose nodes are instances of MultiSplitLayout.Split,"
		+ "MultiSplitLayout. Divider, and MultiSplitLayout.Leaf. Named Leaf nodes"
		+ "represent the space allocated to a component that was added with a"
		+ "constraint that matches the Leaf's name. Extra space is distributed among"
		+ "row/column siblings according to their 0.0 to 1.0 weight. If no weights"
		+ "are specified then the last sibling always gets all of the extra space,"
		+ "or space reduction." + "<p>"
		+ "Although MultiSplitLayout can be used with any Container, it's the default"
		+ "layout manager for JXMultiSplitPane. JXMultiSplitPane supports"
		+ "interactively dragging the Dividers, accessibility, and other features"
		+ "associated with split panes." + "</body>" + "</html>";

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
		JXMultiSplitPanePanel<ApplicationTestModel<String>> multiSplitPanePanel = newJXMultiSplitPanePanelDefault();
		// newJXMultiSplitPanePanelCustomLayout();

		frame.add(multiSplitPanePanel);
		frame.pack();
		frame.setVisible(true);
	}

	public static JXMultiSplitPanePanel<ApplicationTestModel<String>> newJXMultiSplitPanePanelDefault()
	{
		JXMultiSplitPanePanel<ApplicationTestModel<String>> multiSplitPanePanel = new JXMultiSplitPanePanel<>();

		multiSplitPanePanel.getMultiSplitPane().add(new JButton("Left Top"), "left.top");
		multiSplitPanePanel.getMultiSplitPane().add(new JButton("Editor"), "editor");
		multiSplitPanePanel.getMultiSplitPane().add(new JButton("Bottom"), "bottom");
		return multiSplitPanePanel;
	}

	public static JXMultiSplitPanePanel<ApplicationTestModel<String>> newJXMultiSplitPanePanelCustomLayout()
	{
		JXMultiSplitPanePanel<ApplicationTestModel<String>> multiSplitPanePanel = new JXMultiSplitPanePanel<ApplicationTestModel<String>>()
		{

			@Override
			protected String newLayoutDefinition()
			{
				String layoutDefinition = "(ROW " + "(LEAF name=selector weight=0.3)"
					+ "(COLUMN weight=0.7 " + "(LEAF name= demo weight=0.7)"
					+ "(LEAF name=source weight=0.3)" + ")" + ")";
				return layoutDefinition;
			}
		};
		final JComponent demoContainer = new JXPanel();
		demoContainer.setLayout(new BorderLayout()); // BoxLayout(demoContainer,
														// BoxLayout.LINE_AXIS));
		demoContainer.setBorder(BorderFactory.createLineBorder(Color.RED));
		multiSplitPanePanel.getMultiSplitPane().add("selector", createButtonStack(demoContainer));
		multiSplitPanePanel.getMultiSplitPane().add("demo", demoContainer);
		return multiSplitPanePanel;
	}


	public static JComponent createButtonStack(JComponent demoContainer)
	{
		JComponent buttonStack = new JXTaskPaneContainer();
		JXTaskPane taskPane = new JXTaskPane();
		taskPane.setTitle("demo");
		taskPane.add(createTextAction(demoContainer));
		taskPane.add(createPageAction(demoContainer));
		buttonStack.add(taskPane);
		return buttonStack;
	}

	/**
	 * @param demoContainer
	 * @return
	 */
	public static Action createTextAction(final JComponent demoContainer)
	{
		Action action = new AbstractAction("add editor - setText")
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				demoContainer.removeAll();
				demoContainer.add(new JScrollPane(createEditorSetText()));
				JXMultiSplitPane pane = SwingXUtilities.getAncestor(JXMultiSplitPane.class,
					demoContainer);
				if (pane != null)
				{
					pane.revalidate();
				}
				else
				{
					demoContainer.revalidate();
				}

			}
		};
		return action;
	}

	/**
	 * @param demoContainer
	 * @return
	 */
	public static Action createPageAction(final JComponent demoContainer)
	{
		Action page = new AbstractAction("add editor - setPage")
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				demoContainer.removeAll();
				demoContainer.add(new JScrollPane(createEditorSetPage()));
				demoContainer.revalidate();

			}
		};
		return page;
	}

	public static JComponent createEditorSetText()
	{
		final JEditorPane editor = createEditor();
		editor.setText(dummyText);
		return editor;
	}

	public static JComponent createEditorSetPage()
	{
		final JEditorPane editor = createEditor();
		URL descriptionURL = getHTMLDescription();
		try
		{
			editor.setPage(descriptionURL);
		}
		catch (IOException e)
		{
			System.err.println("couldn't load description from URL:" + descriptionURL);
		}
		PropertyChangeListener l = new PropertyChangeListener()
		{

			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				JXMultiSplitPane pane = SwingXUtilities.getAncestor(JXMultiSplitPane.class, editor);
				if (pane != null)
				{
					MultiSplitLayout layout = pane.getMultiSplitLayout();
					layout.layoutByWeight(pane.getParent());
				}

			}
		};
		editor.addPropertyChangeListener("page", l);
		return editor;
	}

	public static JEditorPane createEditor()
	{
		final JEditorPane editor = new JEditorPane();
		editor.setContentType("text/html");
		editor.setEditable(false);
		editor.setOpaque(true);
		return editor;
	}

	public static URL getHTMLDescription()
	{
		// by default look for an html file with the same name as the demo class
		return JXMultiSplitPanePanel.class.getResource(htmlURL);
	}

	public static Split newSplit()
	{
		Split col1 = new Split();
		col1.setRowLayout(false);
		col1.setWeight(0.75);
		Leaf source = new Leaf("source");
		source.setWeight(0.75);
		Leaf info = new Leaf("info");
		info.setWeight(0.25);
		col1.setChildren(source, new Divider(), info);
		Split row1 = new Split();
		row1.setRowLayout(true);
		Leaf conf = new Leaf("conf");
		conf.setWeight(0.25);
		row1.setChildren(conf, new Divider(), col1);
		return row1;
	}

	private MultiSplitLayout newMultiSplitLayout(Split row1)
	{

		MultiSplitLayout layout = new MultiSplitLayout(row1);
		return layout;

	}

}
