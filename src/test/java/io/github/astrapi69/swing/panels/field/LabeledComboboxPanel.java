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

import io.github.astrapi69.collections.list.ListFactory;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.bind.ItemBindListener;
import io.github.astrapi69.swing.combobox.model.StringComboBoxModel;

/**
 *
 * @author astrapi69
 */
public class LabeledComboboxPanel extends BasePanel<ComboListBean>
{

	private static final long serialVersionUID = 1L;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JLabel jLabel1;


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

		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();

		jLabel1.setText("Combo label");

		jComboBox1.setModel(new StringComboBoxModel(getModelObject().getComboList(),
			getModelObject().getSelectedItem()));
		jComboBox1.addItemListener(new ItemBindListener<>(jComboBox1.getModel()));
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(23, 23, 23)
					.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout
			.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(53, 53, 53)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE)));
	}

}