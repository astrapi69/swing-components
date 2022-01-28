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
package io.github.astrapi69.swing.base;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.button.ButtonFactory;
import io.github.astrapi69.swing.layout.ScreenSizeExtensions;
import io.github.astrapi69.swing.panel.login.pw.ChangePasswordModelBean;
import io.github.astrapi69.swing.panel.login.pw.NewPasswordPanel;
import io.github.astrapi69.window.adapter.CloseWindow;

public class BaseDialogExample extends BaseDialog<ChangePasswordModelBean>
{

	private static final long serialVersionUID = 1L;
	JPanel buttons;
	Container container;
	NewPasswordPanel newPasswordPanel;
	/** The button close. */
	private JButton buttonClose;

	public BaseDialogExample(final Frame owner, final String title, final boolean modal,
		final IModel<ChangePasswordModelBean> model)
	{
		super(owner, title, modal, model);
	}

	public static void main(final String[] a)
	{
		final BaseDialogExample dialog = new BaseDialogExample(null, "Password title", true,
			BaseModel.of());
		dialog.addWindowListener(new CloseWindow());
		ScreenSizeExtensions.centralize(dialog, 3, 3);
		dialog.setSize(500, 250);

		dialog.setVisible(true);
	}

	protected JButton newButtonClose()
	{
		JButton button = ButtonFactory.newJButton("Close");
		button.addActionListener(e -> onClose(e));
		return button;
	}

	protected JPanel newButtons(IModel<ChangePasswordModelBean> model)
	{
		JPanel buttons = new JPanel();
		return buttons;
	}


	protected NewPasswordPanel newNewPasswordPanel(IModel<ChangePasswordModelBean> model)
	{
		return new NewPasswordPanel(model);
	}

	private void onClose(final ActionEvent e)
	{
		this.setVisible(false);
		System.exit(0);
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		setModal(isModal());

		newPasswordPanel = newNewPasswordPanel(getModel());
		buttonClose = newButtonClose();
		buttons = newButtons(getModel());
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		buttons.add(buttonClose, BorderLayout.EAST);

		container = getContentPane();
		container.add(newPasswordPanel, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
	}

}
