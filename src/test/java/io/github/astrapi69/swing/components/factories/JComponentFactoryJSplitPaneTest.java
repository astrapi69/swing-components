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
package io.github.astrapi69.swing.components.factories;

import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.MultiSplitLayout;

import io.github.astrapi69.layout.CloseWindow;
import io.github.astrapi69.swing.panels.preferences.ApplicationPreferencesPanel;

public class JComponentFactoryJSplitPaneTest
{


	public static JXMultiSplitPane createMultiSplitPaneDemo()
	{
		JXMultiSplitPane msp = new JXMultiSplitPane();
		String layoutDef = "(COLUMN (ROW weight=0.8 (COLUMN weight=0.25 "
			+ "(LEAF name=left.top weight=0.5) (LEAF name=left.middle weight=0.5))"
			+ "(LEAF name=editor weight=0.75)) (LEAF name=bottom weight=0.2))";

		MultiSplitLayout.Node modelRoot = MultiSplitLayout.parseModel(layoutDef);
		msp.getMultiSplitLayout().setModel(modelRoot);

		msp.add(new JButton("Left Top"), "left.top");
		msp.add(new JButton("Left Middle"), "left.middle");
		msp.add(new JButton("Editor"), "editor");
		msp.add(new JButton("Bottom"), "bottom");

		// ADDING A BORDER TO THE MULTISPLITPANE CAUSES ALL SORTS OF ISSUES
		msp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		return msp;
	}

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
