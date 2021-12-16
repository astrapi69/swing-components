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
package io.github.astrapi69.swing.panels.field;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.*;

import io.github.astrapi69.collections.list.ListFactory;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.combobox.model.StringMutableComboBoxModel;
import io.github.astrapi69.swing.listener.document.EnableButtonBehavior;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

/**
 *
 * @author astrapi69
 */
public class LabeledComboboxPanel extends BasePanel<ComboListBean>
{

	private static final long serialVersionUID = 1L;
	StringMutableComboBoxModel mutableComboBoxModel;
	private JButton btnAddNewValue;
	private JButton btnRemoveSelected;
	private JComboBox<String> cmbStringValues;
	private JLabel lblAddNewValue;
	private JLabel lblStringValues;
	private JTextField txtAddNewValue;


	public LabeledComboboxPanel()
	{
		this(BaseModel.of(ComboListBean.builder()
			.comboList(ListFactory.newArrayList("foo", "bar", "bla")).selectedItem("foo").build()));
	}

	public LabeledComboboxPanel(final Model<ComboListBean> model)
	{
		super(model);
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();

		lblStringValues = new JLabel();
		cmbStringValues = new JComboBox<>();
		btnRemoveSelected = new JButton();
		lblAddNewValue = new JLabel();
		txtAddNewValue = new JTextField();
		btnAddNewValue = new JButton();

		lblStringValues.setText("Combo label");

		btnRemoveSelected.setText("Remove selected value");

		lblAddNewValue.setText("Add new Value to combobox");

		btnAddNewValue.setText("Add combobox value");
		// ===
		mutableComboBoxModel = new StringMutableComboBoxModel(getModelObject().getComboList(),
			getModelObject().getSelectedItem());
		cmbStringValues.setModel(mutableComboBoxModel);
		cmbStringValues.addActionListener(this::onStringValuesChange);
		btnRemoveSelected.addActionListener(this::onRemoveSelected);
		btnAddNewValue.addActionListener(this::onAddNewValue);

		EnableButtonBehavior.builder().buttonModel(btnAddNewValue.getModel())
			.document(txtAddNewValue.getDocument()).build();
	}

	protected void onStringValuesChange(final ActionEvent actionEvent)
	{
		Object item = cmbStringValues.getSelectedItem();
		String value = (String)item;
		txtAddNewValue.setText(value);
	}

	protected void onRemoveSelected(final ActionEvent actionEvent)
	{
		Object item = cmbStringValues.getSelectedItem();
		String value = (String)item;
		mutableComboBoxModel.removeElement(value);
	}

	protected void onAddNewValue(final ActionEvent actionEvent)
	{
		String text = txtAddNewValue.getText();
		mutableComboBoxModel.addElement(text);
		mutableComboBoxModel.setSelectedItem(text);
		int length = txtAddNewValue.getDocument().getLength();
		RuntimeExceptionDecorator.decorate(() -> txtAddNewValue.getDocument().remove(0, length));
		List<String> comboList = getModelObject().getComboList();
		System.out.println(comboList);
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout
			.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(23, 23, 23)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(lblAddNewValue, GroupLayout.DEFAULT_SIZE, 226,
							Short.MAX_VALUE)
						.addComponent(lblStringValues, GroupLayout.DEFAULT_SIZE,
							GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(cmbStringValues, 0, 200, Short.MAX_VALUE)
						.addComponent(txtAddNewValue))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(btnRemoveSelected, GroupLayout.DEFAULT_SIZE,
							GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddNewValue, GroupLayout.DEFAULT_SIZE,
							GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(27, 27, 27)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(53, 53, 53)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblStringValues, GroupLayout.PREFERRED_SIZE, 30,
						GroupLayout.PREFERRED_SIZE)
					.addComponent(cmbStringValues, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnRemoveSelected))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(txtAddNewValue, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblAddNewValue, GroupLayout.PREFERRED_SIZE, 35,
						GroupLayout.PREFERRED_SIZE)
					.addComponent(btnAddNewValue))
				.addContainerGap(41, Short.MAX_VALUE)));
	}

}
