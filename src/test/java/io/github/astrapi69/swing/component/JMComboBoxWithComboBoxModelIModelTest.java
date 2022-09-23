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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Frame;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.github.astrapi69.collection.array.ArrayFactory;
import io.github.astrapi69.collection.pair.ValueBox;
import io.github.astrapi69.junit.jupiter.callback.before.test.IgnoreHeadlessExceptionExtension;
import io.github.astrapi69.model.LambdaModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.combobox.model.GenericComboBoxModel;
import io.github.astrapi69.window.adapter.CloseWindow;

/**
 * GUI unit test for component {@link JMComboBox} with assertj-swing module
 */
public class JMComboBoxWithComboBoxModelIModelTest
{

	private FrameFixture underTest;
	private JMComboBox<Integer, GenericComboBoxModel<Integer>> componentToTest;

	/**
	 * Test method for component constructor {@link JMComboBox#JMComboBox(ComboBoxModel, IModel)}
	 * and the binding with {@link IModel}
	 */
	@ExtendWith(IgnoreHeadlessExceptionExtension.class)
	@Test
	public void testComboBoxModelIModel()
	{
		String comboBoxName;
		String buttonName;
		Integer propertyModelObject;
		GenericComboBoxModel<Integer> comboBoxModel;
		ValueBox<Integer> valueBox;
		IModel<Integer> selectedItemModel;
		valueBox = ValueBox.<Integer> builder().value(1).build();
		Integer[] cmbArray = ArrayFactory.newArray(1, 2, 3, 4);
		comboBoxModel = new GenericComboBoxModel<>(cmbArray);
		selectedItemModel = LambdaModel.of(valueBox::getValue, valueBox::setValue);

		comboBoxName = "BoundCombobox";
		componentToTest = new JMComboBox<>(comboBoxModel, selectedItemModel);
		componentToTest.setName(comboBoxName);

		buttonName = "PushMe";
		JButton button = new JButton("push it");
		button.setName(buttonName);

		final Frame frame = new Frame("TestFrame");

		frame.setLayout(new MigLayout());
		frame.add(button);
		frame.add(componentToTest);
		frame.addWindowListener(new CloseWindow());
		frame.setSize(400, 400);
		frame.setVisible(true);
		underTest = new FrameFixture(frame);
		// check model value is set
		propertyModelObject = componentToTest.getPropertyModel().getObject();
		assertNotNull(propertyModelObject);
		assertEquals(propertyModelObject, 1);
		assertEquals(propertyModelObject, valueBox.getValue());
		assertEquals(propertyModelObject, componentToTest.getModel().getSelectedItem());
		// change the value
		underTest.comboBox(comboBoxName).selectItem(1);
		underTest.button(buttonName).click();
		// check model value is set
		propertyModelObject = componentToTest.getPropertyModel().getObject();
		assertNotNull(propertyModelObject);
		assertEquals(propertyModelObject, 2);
		assertEquals(propertyModelObject, valueBox.getValue());
		assertEquals(propertyModelObject, componentToTest.getModel().getSelectedItem());
		frame.setVisible(false);
		frame.dispose();
		underTest = null;
	}

}
