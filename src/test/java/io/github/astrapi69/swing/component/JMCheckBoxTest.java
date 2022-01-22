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
package io.github.astrapi69.swing.component;

import java.awt.*;

import javax.swing.*;

import io.github.astrapi69.model.LambdaModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.check.model.CheckedModelBean;
import io.github.astrapi69.swing.component.JMCheckBox;
import io.github.astrapi69.window.adapter.CloseWindow;

public class JMCheckBoxTest
{
	public static void main(String[] args)
	{
		// Bind with JMCheckBox that encapsulate a property model
		final JMCheckBox checkBox;
		final CheckedModelBean checkedModelBean;
		checkedModelBean = CheckedModelBean.builder().build();
		checkBox = new JMCheckBox("Check me");

		// SerializableSupplier<Boolean> getter = () -> {
		// Boolean checked = checkBox.isSelected();
		// checkedModelBean.setChecked(checked);
		// return checked;
		// };
		// SerializableConsumer<Boolean> setter = (checked) -> {
		// checkBox.setSelected(checked);
		// checkedModelBean.setChecked(checked);
		// };
		final Model<Boolean> booleanModel =
			// PropertyModel.of(checkedModelBean, "checked");
			// LambdaModel.of(getter, setter);
			LambdaModel.of(checkedModelBean::isChecked, checkedModelBean::setChecked);
		checkBox.setPropertyModel(booleanModel);

		final Frame frame = new Frame("JMCheckBoxTest");
		JButton buttonCheck = new JButton("check it");
		buttonCheck.addActionListener(e -> {
			Boolean selected = checkBox.getPropertyModel().getObject();
			Boolean checked = checkedModelBean.isChecked();
			Boolean booleanModelObject = booleanModel.getObject();
			Boolean toggledSelected = !checkBox.isSelected();
			checkBox.setSelected(toggledSelected);
			selected = checkBox.getPropertyModel().getObject();
			booleanModelObject = booleanModel.getObject();
			checked = checkedModelBean.isChecked();
			System.out.println(selected);
		});
		frame.addWindowListener(new CloseWindow());

		frame.setLayout(new GridBagLayout());
		frame.add(buttonCheck);
		frame.add(checkBox);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}