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
package io.github.astrapi69.swing.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.junit.jupiter.api.Test;

import io.github.astrapi69.collections.pairs.ValueBox;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;

public class TestAutoBinding
{
	@Test
	public void testEncapsulatedAutoBindingWithJLabel()
	{
		String actual;
		String expected;
		String value;
		String text;
		Employee employee;
		AutoBinding<Employee, String, JLabel, String> autoBinding;
		AutoBinding.UpdateStrategy updateStrategy;
		BeanProperty<Employee, String> employeeStringBeanProperty;
		BeanProperty<JLabel, String> jLabelBeanProperty;
		JLabel lblValue;

		// new scenario with AutoBinding.UpdateStrategy.READ
		value = "foo";
		updateStrategy = AutoBinding.UpdateStrategy.READ;
		employee = Employee.builder().person(Person.builder().nickname(value).build()).build();
		employeeStringBeanProperty = BeanProperty.create("person.nickname");
		lblValue = new JLabel();
		jLabelBeanProperty = BeanProperty.create("text");
		autoBinding = Bindings.createAutoBinding(updateStrategy, employee,
			employeeStringBeanProperty, lblValue, jLabelBeanProperty);
		autoBinding.bind();

		actual = lblValue.getText();
		expected = value;
		assertEquals(actual, expected);
		// set text from JLabel will not update source, because of strategy only READ
		text = "bar";
		lblValue.setText(text);
		actual = employee.getPerson().getNickname();
		expected = text;
		assertNotSame(actual, expected); // Not equal!!!
		// set value from Employee
		employee.getPerson().setNickname(text);
		actual = lblValue.getText();
		expected = employee.getPerson().getNickname();
		assertEquals(actual, expected);
	}

	@Test
	public void testEncapsulatedAutoBindingWithJButton()
	{
		Boolean actual;
		Boolean expected;
		Boolean value;
		Boolean enabled;
		Employee employee;
		AutoBinding<Employee, Boolean, JButton, Boolean> autoBinding;
		AutoBinding.UpdateStrategy updateStrategy;
		BeanProperty<Employee, Boolean> employeeStringBeanProperty;
		BeanProperty<JButton, Boolean> jButtonBeanProperty;
		JButton btnValue;

		// new scenario with AutoBinding.UpdateStrategy.READ
		value = false;
		updateStrategy = AutoBinding.UpdateStrategy.READ;
		employee = Employee.builder().person(Person.builder().married(value).build()).build();
		employeeStringBeanProperty = BeanProperty.create("person.married");
		btnValue = new JButton();
		jButtonBeanProperty = BeanProperty.create("model.enabled");
		autoBinding = Bindings.createAutoBinding(updateStrategy, employee,
			employeeStringBeanProperty, btnValue, jButtonBeanProperty);
		autoBinding.bind();

		actual = btnValue.isEnabled();
		expected = value;
		assertEquals(actual, expected);
		// set enabled from JButton will not update source, because of strategy only READ
		enabled = true;
		btnValue.setEnabled(enabled);
		actual = employee.getPerson().getMarried();
		expected = enabled;
		assertNotSame(actual, expected); // Not equal!!!

		enabled = false;
		btnValue.setEnabled(enabled);
		actual = employee.getPerson().getMarried();
		expected = enabled;
		assertEquals(actual, expected);
		// set value from Employee
		enabled = true;
		employee.getPerson().setMarried(enabled);
		actual = btnValue.isEnabled();
		expected = employee.getPerson().getMarried();
		assertNotSame(actual, expected); // Not equal!!!
	}

	@Test
	public void testSimpleAutoBinding()
	{
		String actual;
		String expected;
		String value;
		String text;
		AutoBinding<ValueBox, String, JLabel, String> autoBinding;
		AutoBinding.UpdateStrategy updateStrategy;
		BeanProperty<ValueBox, String> valueBoxStringBeanProperty;
		BeanProperty<JLabel, String> jLabelBeanProperty;
		JLabel lblValue;
		ValueBox<String> stringValueBox;
		// new scenario with AutoBinding.UpdateStrategy.READ
		lblValue = new JLabel();
		value = "foo";
		updateStrategy = AutoBinding.UpdateStrategy.READ;
		stringValueBox = ValueBox.<String> builder().value(value).build();
		valueBoxStringBeanProperty = BeanProperty.create("value");
		jLabelBeanProperty = BeanProperty.create("text");
		autoBinding = Bindings.createAutoBinding(updateStrategy, stringValueBox,
			valueBoxStringBeanProperty, lblValue, jLabelBeanProperty);
		autoBinding.bind();
		actual = lblValue.getText();
		expected = value;
		assertEquals(actual, expected);
		// set text from JLabel will not update source, because of strategy only READ
		text = "bar";
		lblValue.setText(text);
		actual = stringValueBox.getValue();
		expected = text;
		assertNotSame(actual, expected); // Not equal!!!
		// set value from ValueBox
		stringValueBox.setValue(text);
		actual = lblValue.getText();
		expected = stringValueBox.getValue();
		assertEquals(actual, expected);
		// new scenario with AutoBinding.UpdateStrategy.READ_WRITE
		lblValue = new JLabel();
		value = "foo";
		updateStrategy = AutoBinding.UpdateStrategy.READ_WRITE;
		stringValueBox = ValueBox.<String> builder().value(value).build();
		valueBoxStringBeanProperty = BeanProperty.create("value");
		jLabelBeanProperty = BeanProperty.create("text");
		autoBinding = Bindings.createAutoBinding(updateStrategy, stringValueBox,
			valueBoxStringBeanProperty, lblValue, jLabelBeanProperty);
		autoBinding.bind();
		actual = lblValue.getText();
		expected = value;
		assertEquals(actual, expected);
		// set text from JLabel will update source, because of strategy is READ_WRITE
		text = "bar";
		lblValue.setText(text);
		actual = stringValueBox.getValue();
		expected = text;
		assertEquals(actual, expected);
		// set value from ValueBox
		stringValueBox.setValue(text);
		actual = lblValue.getText();
		expected = stringValueBox.getValue();
		assertEquals(actual, expected);
	}
}
