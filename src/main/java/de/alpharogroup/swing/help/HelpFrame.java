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
package de.alpharogroup.swing.help;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import de.alpharogroup.actions.DisposeWindowAction;
import de.alpharogroup.layout.DisposeWindow;

/**
 * The class {@link HelpFrame}
 */
public class HelpFrame extends JFrame
{

	private static final String DEFAULT_BUTTONLABEL_CLOSE = "Close";

	private static final String DEFAULT_LABEL_HELP = "License";

	private JButton buttonClose;

	private DisposeWindow disposeWindow;

	private String helptext;

	private JLabel jlabelTitle;

	private JScrollPane jscrollPanejtaHelp;

	private JTextArea jtaHelp;

	private JTextPane jtpHelp;

	/**
	 * Instantiates a new {@link HelpFrame}
	 *
	 * @param title
	 *            the title
	 * @param helptext
	 *            the help text
	 */
	public HelpFrame(final String title, final String helptext)
	{
		super(title);
		this.helptext = helptext;
		disposeWindow = new DisposeWindow();
		addWindowListener(disposeWindow);
		final Point parloc = new Point(0, 0);
		setLocation(parloc.x + 30, parloc.y + 30);
		setSize(580, 600);
		createLayout();

	}

	/**
	 * Creates the layout.
	 */
	private void createLayout()
	{
		jlabelTitle = new JLabel(newLabelHelpText());
		getContentPane().add(jlabelTitle, BorderLayout.NORTH);
		// JTextArea Help:
		jtaHelp = new JTextArea(10, 10);
		jtpHelp = new JTextPane();
		jtpHelp.replaceSelection(helptext);
		jtaHelp.setText(helptext);
		jtaHelp.setCaretPosition(0);
		jtaHelp.setLineWrap(true);
		jtaHelp.setWrapStyleWord(true);
		jtaHelp.setEditable(false);
		jscrollPanejtaHelp = new JScrollPane(jtpHelp);
		getContentPane().add(jscrollPanejtaHelp, BorderLayout.CENTER);
		buttonClose = new JButton(newLabelCloseText());
		buttonClose.addActionListener(new DisposeWindowAction(this));
		final Panel unten = new Panel();
		unten.add(buttonClose, BorderLayout.WEST);
		getContentPane().add(unten, BorderLayout.SOUTH);

	}


	protected String newLabelCloseText()
	{
		return DEFAULT_BUTTONLABEL_CLOSE;
	}

	protected String newLabelHelpText()
	{
		return DEFAULT_LABEL_HELP;
	}

}
