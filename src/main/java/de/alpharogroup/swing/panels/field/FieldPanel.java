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
package de.alpharogroup.swing.panels.field;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import lombok.Getter;

/**
 * The class {@link FieldPanel} for create a new field.
 */
public abstract class FieldPanel<T> extends JPanel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The {@link JLabel} type. */
	@Getter
	private JLabel lblType;

	/** The {@link JComboBox} type. */
	@Getter
	private JComboBox<T> dropDownType;

	/** The {@link JLabel} field name. */
	@Getter
	private JLabel lblFieldName;

	/** The {@link JTextField} field name. */
	@Getter
	private JTextField txtFieldName;


	/**
	 * Instantiates a new {@link FieldPanel}.
	 */
	public FieldPanel()
	{
		initComponents();
		initLayout();
	}

	protected void initComponents()
	{
		txtFieldName = new JTextField();
		lblFieldName = new JLabel();
		lblType = new JLabel();
		dropDownType = new JComboBox<>();

		txtFieldName.setToolTipText("Enter a name");

		lblFieldName.setText("Field Name");

		lblType.setText("Type");

		dropDownType.setModel(newTypeModel());
	}

	protected void initLayout()
	{
		final GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(txtFieldName)
					.addComponent(lblFieldName, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(dropDownType, 0, 168, Short.MAX_VALUE).addComponent(lblType,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap(19, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(17, 17, 17)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblFieldName).addComponent(lblType))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(txtFieldName, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(dropDownType, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(23, Short.MAX_VALUE)));
	}

	protected abstract DefaultComboBoxModel<T> newTypeModel();

}
