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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.alpharogroup.actions.DisposeWindowAction;
import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.panels.login.pw.ChangePasswordModelBean;
import de.alpharogroup.swing.panels.login.pw.NewPasswordPanel;

public class BaseDialogTest extends BaseDialog<ChangePasswordModelBean>
{

	private static final long serialVersionUID = 1L;

	NewPasswordPanel newPasswordPanel;


	/** The button close. */
	private JButton buttonClose;

	/** The label placeholder. */
	private JLabel labelPlaceholder;

	Panel buttons;

	Container container;

	public BaseDialogTest(final Frame frame, final JComponent content,
		final Model<ChangePasswordModelBean> model)
	{
		super(frame, content, model);
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		setModal(true);
		newPasswordPanel = new NewPasswordPanel(BaseModel.<ChangePasswordModelBean> of());
		buttonClose = new JButton("Close");
		buttonClose.addActionListener(new DisposeWindowAction(this));
		labelPlaceholder = new JLabel("Password");
		buttons = new Panel();

	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		buttons.add(buttonClose, BorderLayout.EAST);
		buttons.add(labelPlaceholder, BorderLayout.CENTER);

		container = getContentPane();
		container.add(newPasswordPanel, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
		final int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		final int y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setLocation((x / 3), (y / 3));
		setSize((x / 3), (y / 3));
	}


	public static void main(final String[] a)
	{

		final Frame frame = new Frame("FieldPanel");
		frame.addWindowListener(new CloseWindow());
		final BaseDialogTest dialog = new BaseDialogTest(frame, new JPanel(),
			BaseModel.<ChangePasswordModelBean> of());

		dialog.setSize(300, 150);

		frame.pack();
		frame.setVisible(true);
	}


}
