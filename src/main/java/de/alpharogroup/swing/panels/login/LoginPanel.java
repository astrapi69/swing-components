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
package de.alpharogroup.swing.panels.login;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author admin
 */
public class LoginPanel extends JXPanel
{

	/**
	 *
	 */
	private static final long serialVersionUID = -1773660900716220066L;
	private JButton btnCancel;
	private JButton btnLogin;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JTextField txtInfo;
	private JPasswordField txtPassword;
	private JTextField txtUsername;

	/** Creates new form LoginPanel */
	public LoginPanel()
	{
		initComponents();
		initLayout();
	}

	/**
	 * Returns the field <code>btnCancel</code>.
	 *
	 * @return The field <code>btnCancel</code>.
	 */
	public JButton getBtnCancel()
	{
		return btnCancel;
	}

	/**
	 * Returns the field <code>btnLogin</code>.
	 *
	 * @return The field <code>btnLogin</code>.
	 */
	public JButton getBtnLogin()
	{
		return btnLogin;
	}

	/**
	 * Returns the field <code>lblPassword</code>.
	 *
	 * @return The field <code>lblPassword</code>.
	 */
	public JLabel getLblPassword()
	{
		return lblPassword;
	}

	/**
	 * Returns the field <code>lblUsername</code>.
	 *
	 * @return The field <code>lblUsername</code>.
	 */
	public JLabel getLblUsername()
	{
		return lblUsername;
	}

	/**
	 * Returns the field <code>txtInfo</code>.
	 *
	 * @return The field <code>txtInfo</code>.
	 */
	public JTextField getTxtInfo()
	{
		return txtInfo;
	}

	/**
	 * Returns the field <code>txtPassword</code>.
	 *
	 * @return The field <code>txtPassword</code>.
	 */
	public JPasswordField getTxtPassword()
	{
		return txtPassword;
	}

	/**
	 * Returns the field <code>txtUsername</code>.
	 *
	 * @return The field <code>txtUsername</code>.
	 */
	public JTextField getTxtUsername()
	{
		return txtUsername;
	}

	private void initComponents()
	{

		lblUsername = new JLabel();
		txtUsername = new JTextField();
		lblPassword = new JLabel();
		txtPassword = new JPasswordField();
		btnLogin = new JButton();
		btnCancel = new JButton();
		txtInfo = new JTextField();

		lblUsername.setText("Username:");

		lblPassword.setText("Password:");

		btnLogin.setText("Login");

		btnCancel.setText("Cancel");

		txtInfo.setEditable(false);

	}

	private void initLayout()
	{
		final GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
			GroupLayout.Alignment.LEADING).addGroup(
			GroupLayout.Alignment.TRAILING,
			layout
				.createSequentialGroup()
				.addGap(23, 23, 23)
				.addGroup(
					layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 107,
							GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 89,
							GroupLayout.PREFERRED_SIZE))
				.addGap(32, 32, 32)
				.addGroup(
					layout
						.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(txtPassword, GroupLayout.Alignment.LEADING,
							GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(txtUsername, GroupLayout.Alignment.LEADING,
							GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addGroup(
							layout
								.createSequentialGroup()
								.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 92,
									Short.MAX_VALUE)
								.addPreferredGap(
									LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 87,
									GroupLayout.PREFERRED_SIZE))
						.addComponent(txtInfo, GroupLayout.DEFAULT_SIZE, 191,
							Short.MAX_VALUE)).addGap(28, 28, 28)));
		layout.setVerticalGroup(layout.createParallelGroup(
			GroupLayout.Alignment.LEADING).addGroup(
			layout
				.createSequentialGroup()
				.addGap(32, 32, 32)
				.addGroup(
					layout
						.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE).addComponent(lblUsername))
				.addGap(18, 18, 18)
				.addGroup(
					layout
						.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(txtInfo, GroupLayout.PREFERRED_SIZE,
					GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(9, 9, 9)
				.addGroup(
					layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnCancel).addComponent(btnLogin))
				.addContainerGap(27, Short.MAX_VALUE)));
	}

	/**
	 * Sets the field <code>btnCancel</code>.
	 *
	 * @param btnCancel
	 *            The <code>btnCancel</code> to set.
	 */
	public void setBtnCancel(final JButton btnCancel)
	{
		this.btnCancel = btnCancel;
	}

	/**
	 * Sets the field <code>btnLogin</code>.
	 *
	 * @param btnLogin
	 *            The <code>btnLogin</code> to set.
	 */
	public void setBtnLogin(final JButton btnLogin)
	{
		this.btnLogin = btnLogin;
	}

	/**
	 * Sets the field <code>lblPassword</code>.
	 *
	 * @param lblPassword
	 *            The <code>lblPassword</code> to set.
	 */
	public void setLblPassword(final JLabel lblPassword)
	{
		this.lblPassword = lblPassword;
	}

	/**
	 * Sets the field <code>lblUsername</code>.
	 *
	 * @param lblUsername
	 *            The <code>lblUsername</code> to set.
	 */
	public void setLblUsername(final JLabel lblUsername)
	{
		this.lblUsername = lblUsername;
	}

	/**
	 * Sets the field <code>txtInfo</code>.
	 *
	 * @param txtInfo
	 *            The <code>txtInfo</code> to set.
	 */
	public void setTxtInfo(final JTextField txtInfo)
	{
		this.txtInfo = txtInfo;
	}

	/**
	 * Sets the field <code>txtPassword</code>.
	 *
	 * @param txtPassword
	 *            The <code>txtPassword</code> to set.
	 */
	public void setTxtPassword(final JPasswordField txtPassword)
	{
		this.txtPassword = txtPassword;
	}

	/**
	 * Sets the field <code>txtUsername</code>.
	 *
	 * @param txtUsername
	 *            The <code>txtUsername</code> to set.
	 */
	public void setTxtUsername(final JTextField txtUsername)
	{
		this.txtUsername = txtUsername;
	}


}
