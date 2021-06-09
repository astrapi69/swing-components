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
package de.alpharogroup.swing.base;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.swing.panels.splitpane.ApplicationTestModel;
import de.alpharogroup.swing.panels.splitpane.JXMultiSplitPanePanel;
import de.alpharogroup.swing.panels.splitpane.SplitFactory;
import org.jdesktop.swingx.MultiSplitLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ApplicationPanelFrameExample
	extends
	ApplicationPanelFrame<ApplicationTestModel<String>>
{


	private static final long serialVersionUID = 1L;

	/**
	 * Test init layout.
	 * @param args the arguments
	 */
	public static void main(final String[] args)
	{
		final Frame frame = new ApplicationPanelFrameExample(
			"ApplicationSplitPaneFrameExample");
		frame.addWindowListener(new CloseWindow());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Instantiates a new {@link ApplicationSplitPaneFrame}
	 *
	 * @param title
	 *            the title
	 */
	public ApplicationPanelFrameExample(String title)
	{
		super(title);
	}

	protected JComponent newBottomComponent()
	{
		JLabel label = new JLabel("Bottom Component");
		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		label.setBorder(border);
		return label;
	}


	@Override
	protected String newIconPath()
	{
		return "img/xmas/bell.png";
	}

	protected JComponent newLeftComponent()
	{
		JLabel label = new JLabel("Left Component");
		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		label.setBorder(border);
		return label;
	}

	@SuppressWarnings("serial")
	@Override
	protected JXMultiSplitPanePanel<ApplicationTestModel<String>> newMainComponent()
	{
		final JXMultiSplitPanePanel<ApplicationTestModel<String>> multiSplitPanePanel = new JXMultiSplitPanePanel<ApplicationTestModel<String>>()
		{
			@Override
			protected MultiSplitLayout.Node newRootNode(String layoutDefinition)
			{
				return ApplicationPanelFrameExample.this.newRootNode();
			}
		};
		multiSplitPanePanel.getMultiSplitPane().add(newTopComponent(), "content");
		multiSplitPanePanel.getMultiSplitPane().add(newBottomComponent(), "bottom");
		multiSplitPanePanel.getMultiSplitPane().add(newLeftComponent(), "left");
		return multiSplitPanePanel;
	}

	protected MultiSplitLayout.Split newRootNode()
	{

		MultiSplitLayout.Split col1 = SplitFactory.newSplit(false, 0.75);
		MultiSplitLayout.Leaf content = SplitFactory.newLeaf("content", 0.75);
		MultiSplitLayout.Leaf bottom = SplitFactory.newLeaf("bottom", 0.25);
		col1.setChildren(content, new MultiSplitLayout.Divider(), bottom);
		MultiSplitLayout.Split root = new MultiSplitLayout.Split();
		root.setRowLayout(true);
		MultiSplitLayout.Leaf left = SplitFactory.newLeaf("left", 0.25);
		SplitFactory.setChildren(root, left, new MultiSplitLayout.Divider(), col1);
		return root;
	}

	protected JComponent newTopComponent()
	{
		JLabel label = new JLabel("Top Component");
		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		label.setBorder(border);
		return label;
	}
}