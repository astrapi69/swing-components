/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
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
package de.alpharogroup.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.StringTokenizer;

/**
 * The Class InfomationDialog.
 * 
 * @version 1.0
 * @author Asterios Raptis
 */
public class InfomationDialog extends Dialog implements ActionListener
{
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Statische Methode um ein Dialogfenster mit der angegebener Nachricht zu erzeugen.
	 *
	 * @param owner
	 *            the owner
	 * @param message
	 *            the message
	 * @return das ergebnis
	 */
	public static String showInfoDialog(final Frame owner, final String message)
	{
		InfomationDialog mdialog;
		final String ok = "OK";
		mdialog = new InfomationDialog(owner, "Information message", message, ok);
		final int index = mdialog.getVButtons().indexOf(ok);
		final Button button = mdialog.getVButtons().get(index);
		button.addActionListener(mdialog);
		mdialog.setVisible(true);
		return mdialog.getResult();
	}

	/**
	 * The result.
	 */
	String result;

	/** The vector with the buttons. */
	List<Button> vButtons;

	/**
	 * Instantiates a new infomation dialog.
	 * 
	 * @param owner
	 *            the owner
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param buttons
	 *            the buttons
	 */
	public InfomationDialog(final Frame owner, final String title, final String message,
		final String buttons)
	{
		super(owner, title, true);

		// the dialog to set
		this.setBackground(Color.lightGray);
		this.setLayout(new BorderLayout());
		this.setResizable(false);

		final Point parloc = owner.getLocation();
		this.setLocation(parloc.x + 30, parloc.y + 30);

		// Set the message.
		this.add("Center", new Label(message));
		this.addWindowListener(new DisposeWindow());
		// Add the Buttons.
		final Panel panel = new Panel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		final StringTokenizer stringZerleger = new StringTokenizer(buttons, ",");

		while (stringZerleger.hasMoreTokens())
		{
			final Button button = new Button(stringZerleger.nextToken());
			this.vButtons.add(button);
			panel.add(button);
		}

		this.add("South", panel);
		this.pack();
	}

	/**
	 * Handle actions.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void actionPerformed(final ActionEvent e)
	{
		this.setVisible(false);
		this.dispose();
	}

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * Returns the field <code>vButtons</code>.
	 *
	 * @return The field .
	 */
	public List<Button> getVButtons()
	{
		return this.vButtons;
	}
}
