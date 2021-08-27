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
package io.github.astrapi69.swing.help;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BaseDialog;
import io.github.astrapi69.swing.button.ButtonFactory;
import io.github.astrapi69.swing.panels.help.HelpModelBean;
import io.github.astrapi69.swing.panels.help.HelpPanel;

/**
 * The class {@link HelpDialog} for a simple help dialog with title and content.
 */
public class HelpDialog extends BaseDialog<HelpModelBean>
{

	private static final long serialVersionUID = 1L;
	JPanel buttons;
	Container container;
	HelpPanel helpPanel;
	/** The button close. */
	private JButton buttonClose;

	public HelpDialog(final Frame owner, final String title, final boolean modal,
		final Model<HelpModelBean> model)
	{
		super(owner, title, modal, model);
	}

	protected JButton newButtonClose()
	{
		JButton button = ButtonFactory.newJButton("Close");
		button.addActionListener(e -> onClose(e));
		return button;
	}

	protected JPanel newButtons(Model<HelpModelBean> model)
	{
		JPanel buttons = new JPanel();
		return buttons;
	}


	protected HelpPanel newHelpPanel(Model<HelpModelBean> model)
	{
		return new HelpPanel(model);
	}

	protected void onClose(final ActionEvent e)
	{
		this.setVisible(false);
		this.dispose();
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		setModal(isModal());

		helpPanel = newHelpPanel(getModel());
		buttonClose = newButtonClose();
		buttons = newButtons(getModel());
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		buttons.add(buttonClose, BorderLayout.EAST);

		container = getContentPane();
		container.add(helpPanel, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
	}

}
