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
package io.github.astrapi69.swing.address;

/**
 *
 * @author astrapi69
 */
public class NewAddressFormPanel extends javax.swing.JPanel
{

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel lblCity;

	private javax.swing.JLabel lblCountry;

	private javax.swing.JLabel lblFirstname;


	private javax.swing.JLabel lblLastname;
	private javax.swing.JLabel lblNewAddressHeader;
	private javax.swing.JLabel lblStreet;
	private javax.swing.JLabel lblStreetnumber;
	private javax.swing.JLabel lblZipcode;
	private javax.swing.JTextField txtCity;
	private javax.swing.JTextField txtCountry;
	private javax.swing.JTextField txtFirstname;
	private javax.swing.JTextField txtLastname;
	private javax.swing.JTextField txtStreet;
	private javax.swing.JTextField txtStreetnumber;
	private javax.swing.JTextField txtZipcode;

	// End of variables declaration//GEN-END:variables
	/**
	 * Creates new form NewAddressFormPanel
	 */
	public NewAddressFormPanel()
	{
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT
	 * modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		lblNewAddressHeader = new javax.swing.JLabel();
		lblFirstname = new javax.swing.JLabel();
		lblLastname = new javax.swing.JLabel();
		lblStreet = new javax.swing.JLabel();
		lblStreetnumber = new javax.swing.JLabel();
		lblZipcode = new javax.swing.JLabel();
		lblCity = new javax.swing.JLabel();
		lblCountry = new javax.swing.JLabel();
		txtFirstname = new javax.swing.JTextField();
		txtLastname = new javax.swing.JTextField();
		txtStreet = new javax.swing.JTextField();
		txtStreetnumber = new javax.swing.JTextField();
		txtZipcode = new javax.swing.JTextField();
		txtCity = new javax.swing.JTextField();
		txtCountry = new javax.swing.JTextField();

		lblNewAddressHeader.setText("New address");

		lblFirstname.setText("First name");

		lblLastname.setText("Last name");

		lblStreet.setText("Street");

		lblStreetnumber.setText("Street number");

		lblZipcode.setText("Zipcode");

		lblCity.setText("City");

		lblCountry.setText("Country");

		txtFirstname.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				txtFirstnameActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							.addComponent(lblNewAddressHeader, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblFirstname, javax.swing.GroupLayout.DEFAULT_SIZE, 200,
								Short.MAX_VALUE)
							.addComponent(lblLastname, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblStreet, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblStreetnumber, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblZipcode, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblCity, javax.swing.GroupLayout.DEFAULT_SIZE, 220,
							Short.MAX_VALUE))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStreetnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCity, javax.swing.GroupLayout.Alignment.TRAILING,
							javax.swing.GroupLayout.PREFERRED_SIZE, 250,
							javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGroup(layout.createSequentialGroup()
					.addComponent(lblCountry, javax.swing.GroupLayout.DEFAULT_SIZE, 220,
						Short.MAX_VALUE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
						javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		layout
			.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
					.addComponent(lblNewAddressHeader).addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblFirstname).addComponent(txtFirstname,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblLastname).addComponent(txtLastname,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblStreet).addComponent(txtStreet,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblStreetnumber).addComponent(txtStreetnumber,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblZipcode).addComponent(txtZipcode,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblCity).addComponent(txtCity,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblCountry).addComponent(txtCountry,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	private void txtFirstnameActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_txtFirstnameActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtFirstnameActionPerformed
}