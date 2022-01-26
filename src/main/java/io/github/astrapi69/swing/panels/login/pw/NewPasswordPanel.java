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
package io.github.astrapi69.swing.panels.login.pw;

import javax.swing.*;

import lombok.Getter;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.base.BasePanel;

/**
 * The class {@link NewPasswordPanel}.
 */
@Getter
public class NewPasswordPanel extends BasePanel<ChangePasswordModelBean>
{


	private static final long serialVersionUID = 1L;
	private JLabel lblPassword;
	private JLabel lblRepeatPassword;
	private JLabel lblSetPwHeader;
	private JLabel lblUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtRepeatPassword;
	private JTextField txtUsername;

	public NewPasswordPanel()
	{
		this(BaseModel.of(ChangePasswordModelBean.builder().build()));
	}

	public NewPasswordPanel(final IModel<ChangePasswordModelBean> model)
	{
		super(model);
	}

	@Override
	protected void onInitializeComponents()
	{
		lblSetPwHeader = new JLabel();
		lblUsername = new JLabel();
		txtUsername = new JTextField();
		lblPassword = new JLabel();
		txtPassword = new JPasswordField();
		lblRepeatPassword = new JLabel();
		txtRepeatPassword = new JPasswordField();

		lblSetPwHeader.setText("Set new password");

		lblUsername.setText("Username");


		lblPassword.setText("Password");

		txtPassword.setText("");

		lblRepeatPassword.setText("Repeat password");

		txtRepeatPassword.setText("");
	}

	@Override
	protected void onInitializeLayout()
	{
		final GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(lblSetPwHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
					Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addGroup(layout
					.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addGroup(layout.createSequentialGroup()
						.addComponent(lblRepeatPassword, GroupLayout.PREFERRED_SIZE, 200,
							GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(txtRepeatPassword))
					.addGroup(layout.createSequentialGroup()
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 200,
							GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(txtUsername, GroupLayout.PREFERRED_SIZE,
							260, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createSequentialGroup()
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 200,
							GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(txtPassword, GroupLayout.PREFERRED_SIZE,
							260, GroupLayout.PREFERRED_SIZE)))
					.addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(lblSetPwHeader)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblUsername).addComponent(txtUsername, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblPassword).addComponent(txtPassword, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblRepeatPassword).addComponent(txtRepeatPassword,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addContainerGap(35, Short.MAX_VALUE)));
	}

}
