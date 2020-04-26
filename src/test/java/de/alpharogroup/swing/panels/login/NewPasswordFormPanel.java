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

import lombok.Getter;

/**
 *
 * @author astrapi69
 */
@Getter
public class NewPasswordFormPanel extends javax.swing.JPanel
{

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel lblPassword;

	private javax.swing.JLabel lblRepeatPassword;

	private javax.swing.JLabel lblSetPwHeader;


	private javax.swing.JLabel lblUsername;
	private javax.swing.JPasswordField txtPassword;
	private javax.swing.JPasswordField txtRepeatPassword;
	private javax.swing.JTextField txtUsername;

	// End of variables declaration//GEN-END:variables
	/**
	 * Creates new form NewPasswordFormPanel
	 */
	public NewPasswordFormPanel()
	{
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT
	 * modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	// @SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		lblSetPwHeader = new javax.swing.JLabel();
		lblUsername = new javax.swing.JLabel();
		txtUsername = new javax.swing.JTextField();
		lblPassword = new javax.swing.JLabel();
		txtPassword = new javax.swing.JPasswordField();
		lblRepeatPassword = new javax.swing.JLabel();
		txtRepeatPassword = new javax.swing.JPasswordField();

		lblSetPwHeader.setText("Set new password");

		lblUsername.setText("Username");

		txtUsername.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				txtUsernameActionPerformed(evt);
			}
		});

		lblPassword.setText("Password");

		txtPassword.setText("jPasswordField1");

		lblRepeatPassword.setText("Repeat password");

		txtRepeatPassword.setText("jPasswordField2");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblSetPwHeader, javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
							.addComponent(lblRepeatPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
								200, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18).addComponent(txtRepeatPassword))
						.addGroup(layout.createSequentialGroup()
							.addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
								javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18).addComponent(txtUsername,
								javax.swing.GroupLayout.PREFERRED_SIZE, 260,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
								javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18).addComponent(txtPassword,
								javax.swing.GroupLayout.PREFERRED_SIZE, 260,
								javax.swing.GroupLayout.PREFERRED_SIZE)))
					.addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout
			.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(26, 26, 26)
					.addComponent(lblSetPwHeader).addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblUsername).addComponent(txtUsername,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblPassword).addComponent(txtPassword,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblRepeatPassword).addComponent(txtRepeatPassword,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_txtUsernameActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtUsernameActionPerformed
}
