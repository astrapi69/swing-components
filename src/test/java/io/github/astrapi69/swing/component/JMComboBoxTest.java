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

import java.awt.Frame;

import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;
import io.github.astrapi69.collection.array.ArrayFactory;
import io.github.astrapi69.collection.pair.ValueBox;
import io.github.astrapi69.model.LambdaModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.combobox.model.GenericComboBoxModel;
import io.github.astrapi69.window.adapter.CloseWindow;

public class JMComboBoxTest
{
	public static void main(String[] args)
	{
		JMComboBox<Integer, GenericComboBoxModel<Integer>> comboBox;
		GenericComboBoxModel<Integer> comboBoxModel;
		ValueBox<Integer> valueBox;
		IModel<Integer> selectedItemModel;
		valueBox = ValueBox.<Integer> builder().value(1).build();
		Integer[] cmbArray = ArrayFactory.newArray(1, 2, 3, 4);
		comboBoxModel = new GenericComboBoxModel<>(cmbArray);
		selectedItemModel = LambdaModel.of(valueBox::getValue, valueBox::setValue);

		comboBox = new JMComboBox<>(comboBoxModel, selectedItemModel);

		final Frame frame = new Frame("JMComboBoxTest");
		JButton button = new JButton("push it");
		button.addActionListener(e -> {
			Integer selectedItem = comboBox.getPropertyModel().getObject();
			Object selectedObject = comboBox.getModel().getSelectedItem();
			Integer value = valueBox.getValue();
			System.out.println(selectedItem + "::" + selectedObject + "::" + value);
		});
		frame.addWindowListener(new CloseWindow());

		frame.setLayout(new MigLayout());
		frame.add(button);
		frame.add(comboBox);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

}
