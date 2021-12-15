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
package io.github.astrapi69.swing.dialog.info;

import java.awt.*;

import javax.swing.*;

/**
 * The abstract class {@link InfoPanel} for display a simple info message. Provides abstract
 * callback methods for the text values.
 *
 * @deprecated use instead the same named class in project swing-base-components<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public abstract class InfoPanel extends JPanel
{

	private static final long serialVersionUID = 1L;

	/** The application name. */
	private JLabel applicationName;

	/** The copyright. */
	private JLabel copyright;

	/** The jta warning. */
	private JTextArea jtaWarning;

	/** The label application name. */
	private JLabel labelApplicationName;

	/** The label copyright. */
	private JLabel labelCopyright;

	/** The labelversion number. */
	private JLabel labelversionNumber;

	/** The version number. */
	private JLabel versionNumber;

	/** The warning. */
	private String warning;

	/**
	 * Instantiates a new {@link InfoPanel}
	 */
	public InfoPanel()
	{
		newLayout();
	}

	protected abstract String newLabelTextApplicationName();

	protected abstract String newLabelTextCopyright();

	protected abstract String newLabelTextLabelApplicationName();

	protected abstract String newLabelTextLabelCopyright();

	protected abstract String newLabelTextLabelVersion();

	protected abstract String newLabelTextVersion();

	/**
	 * Creates the layout.
	 */
	private void newLayout()
	{
		final Insets oneInsent = new Insets(1, 1, 1, 1);
		final GridBagLayout gbl = new GridBagLayout();
		final GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		warning = newTextWarning();
		labelApplicationName = new JLabel(newLabelTextLabelApplicationName());
		applicationName = new JLabel(newLabelTextApplicationName());
		labelversionNumber = new JLabel(newLabelTextLabelVersion());
		versionNumber = new JLabel(newLabelTextVersion());
		labelCopyright = new JLabel(newLabelTextLabelCopyright());
		copyright = new JLabel(newLabelTextCopyright());
		jtaWarning = new JTextArea(warning);
		jtaWarning.setLineWrap(true);
		jtaWarning.setWrapStyleWord(true);
		jtaWarning.setEditable(false);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(labelApplicationName, gbc);
		add(labelApplicationName);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(applicationName, gbc);
		add(applicationName);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(labelversionNumber, gbc);
		add(labelversionNumber);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(versionNumber, gbc);
		add(versionNumber);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(labelCopyright, gbc);
		add(labelCopyright);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(copyright, gbc);
		add(copyright);

	}

	protected abstract String newTextWarning();
}