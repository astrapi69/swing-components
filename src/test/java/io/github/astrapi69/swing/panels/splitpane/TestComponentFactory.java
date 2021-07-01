/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.panels.splitpane;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;

import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.MultiSplitLayout;
import org.jdesktop.swingx.SwingXUtilities;

import io.github.astrapi69.swing.actions.ActionFactory;
import io.github.astrapi69.swing.components.factories.JComponentFactory;

public class TestComponentFactory
{

	private static final String dummyText = "<html>" + " <head>"
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

	private static final String htmlURL = "MultiSplitPaneDemo.html";

	public static JComponent createButtonStack(JComponent demoContainer)
	{
		JComponent buttonStack = new JXTaskPaneContainer();
		JXTaskPane taskPane = new JXTaskPane();
		taskPane.setTitle("demo");
		taskPane.add(ActionFactory.newTextAction("add editor - setText", demoContainer,
			createEditorSetText()));
		taskPane.add(ActionFactory.newPageAction("add editor - setPage", demoContainer,
			createEditorSetPage()));
		buttonStack.add(taskPane);
		return buttonStack;
	}

	public static JComponent createEditorSetPage()
	{
		final JEditorPane editor = JComponentFactory.newJEditorPane("text/html", false);
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


	public static JComponent createEditorSetText()
	{
		final JEditorPane editor = JComponentFactory.newJEditorPane("text/html", false);
		editor.setText(dummyText);
		return editor;
	}

	public static URL getHTMLDescription()
	{
		// by default look for an html file with the same name as the demo class
		return JXMultiSplitPanePanel.class.getResource(htmlURL);
	}

	@SuppressWarnings("serial")
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
		demoContainer.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		multiSplitPanePanel.getMultiSplitPane().add("selector", createButtonStack(demoContainer));
		multiSplitPanePanel.getMultiSplitPane().add("demo", demoContainer);
		return multiSplitPanePanel;
	}

	@SuppressWarnings("serial")
	public static JXMultiSplitPanePanel<ApplicationTestModel<String>> newJXMultiSplitPanePanelCustomLayout2()
	{
		JXMultiSplitPanePanel<ApplicationTestModel<String>> multiSplitPanePanel = new JXMultiSplitPanePanel<ApplicationTestModel<String>>()
		{
			@Override
			protected MultiSplitLayout.Node newRootNode(String layoutDefinition)
			{
				return TestSplitFactory.newTestSplit();
			}
		};

		multiSplitPanePanel.getMultiSplitPane().add(new JButton("Content"), "content");
		multiSplitPanePanel.getMultiSplitPane().add(new JButton("Bottom"), "bottom");
		multiSplitPanePanel.getMultiSplitPane().add(new JButton("Left"), "left");
		return multiSplitPanePanel;
	}

	@SuppressWarnings("serial")
	public static JXMultiSplitPanePanel<ApplicationTestModel<String>> newJXMultiSplitPanePanelDefault()
	{
		JXMultiSplitPanePanel<ApplicationTestModel<String>> multiSplitPanePanel = new JXMultiSplitPanePanel<ApplicationTestModel<String>>()
		{
			@Override
			protected Dimension newPreferredSize(int width, int height)
			{
				return super.newPreferredSize(1000, 600);
			}
		};

		multiSplitPanePanel.getMultiSplitPane().add(new JButton("Left Top"), "left.top");
		multiSplitPanePanel.getMultiSplitPane().add(new JButton("Editor"), "editor");
		multiSplitPanePanel.getMultiSplitPane().add(new JButton("Bottom"), "bottom");
		return multiSplitPanePanel;
	}
}
