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
package de.alpharogroup.swing.dialog.info;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import de.alpharogroup.actions.DisposeWindowAction;

/**
 * The abstract class {@link InfoDialog} for display a simple info message. Provides abstract
 * callback methods for the text values.
 */
public abstract class InfoDialog extends JDialog
{

	/** The Constant BUTTONLABEL_CLOSE. */
	private static final String DEFAULT_BUTTONLABEL_CLOSE = "Close";

	/** The generaded serialVersionUID. */
	private static final long serialVersionUID = 5646178025613269032L;

	/** The button close. */
	private final JButton buttonClose;

	/** The label placeholder. */
	private final JLabel labelPlaceholder;

	/** The panel. */
	private final InfoPanel panel;

	/**
	 * Instantiates a new {@link InfoDialog}
	 *
	 * @param owner
	 *            the owner
	 * @param title
	 *            the title
	 * @throws HeadlessException
	 *             the headless exception
	 */
	public InfoDialog(final Frame owner, final String title) throws HeadlessException
	{
		setTitle(title);
		setModal(true);
		buttonClose = new JButton(newLabelCloseText());
		buttonClose.addActionListener(new DisposeWindowAction(this));
		labelPlaceholder = new JLabel(newLabelTextPlaceholder());
		final Panel buttons = new Panel();
		buttons.add(buttonClose, BorderLayout.EAST);
		buttons.add(labelPlaceholder, BorderLayout.CENTER);
		panel = newInfoPanel();
		final Container container = getContentPane();
		container.add(panel, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
		final int x = (int)owner.getWidth();
		final int y = (int)owner.getHeight();
		setLocation((x / 3), (y / 3));
		setSize((x / 3), (y / 3));
	}

	protected abstract InfoPanel newInfoPanel();

	protected String newLabelCloseText()
	{
		return DEFAULT_BUTTONLABEL_CLOSE;
	}

	protected abstract String newLabelTextPlaceholder();


}