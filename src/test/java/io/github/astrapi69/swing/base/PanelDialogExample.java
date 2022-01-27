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

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.button.ButtonFactory;
import io.github.astrapi69.swing.layout.ScreenSizeExtensions;
import io.github.astrapi69.swing.panel.login.pw.ChangePasswordModelBean;
import io.github.astrapi69.swing.panel.login.pw.NewPasswordPanel;
import io.github.astrapi69.window.adapter.CloseWindow;

public class PanelDialogExample extends PanelDialog<ChangePasswordModelBean>
{

	private static final long serialVersionUID = 1L;
	/** The button close. */
	private JButton buttonClose;

	public PanelDialogExample(final Frame owner, final String title, final boolean modal,
		final IModel<ChangePasswordModelBean> model)
	{
		super(owner, title, modal, model);
	}

	public static void main(final String[] a)
	{
		final PanelDialogExample dialog = new PanelDialogExample(null, "Password title", true,
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

	@Override
	protected JPanel newButtons(IModel<ChangePasswordModelBean> model)
	{
		JPanel buttons = super.newButtons(model);
		return buttons;
	}

	@Override
	protected JPanel newContent(IModel<ChangePasswordModelBean> model)
	{
		return new NewPasswordPanel(BaseModel.of());
	}

	private void onClose(final ActionEvent e)
	{
		this.dispose();
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		buttonClose = newButtonClose();
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		getButtons().add(buttonClose, BorderLayout.EAST);
	}


}
