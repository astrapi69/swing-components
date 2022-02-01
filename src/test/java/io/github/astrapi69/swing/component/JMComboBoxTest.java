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
import io.github.astrapi69.crypto.key.KeyType;
import io.github.astrapi69.swing.combobox.model.EnumComboBoxModel;
import io.github.astrapi69.window.adapter.CloseWindow;

public class JMComboBoxTest
{
	public static void main(String[] args)
	{
		JMComboBox<EnumComboBoxModel<KeyType>> comboBox = new JMComboBox<>(
			new EnumComboBoxModel<>(KeyType.class));

		final Frame frame = new Frame("JMComboBoxTest");
		JButton button = new JButton("push it");
		button.addActionListener(e -> {
			KeyType selectedItem = comboBox.getPropertyModel().getObject().getSelectedItem();
			Object selectedObject = comboBox.getModel().getSelectedItem();
			System.out.println(selectedItem + "::" + selectedObject);
		});
		frame.addWindowListener(new CloseWindow());

		frame.setLayout(new MigLayout());
		frame.add(button);
		frame.add(comboBox);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

}