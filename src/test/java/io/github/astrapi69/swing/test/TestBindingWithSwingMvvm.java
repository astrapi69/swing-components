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

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.collection.pair.ValueBox;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import net.sds.mvvm.bindings.BindingBuilder;
import net.sds.mvvm.bindings.BindingException;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import net.sds.mvvm.triggers.PropertyTrigger;

public class TestBindingWithSwingMvvm
{
	@Test
	public void testOneWayBindingWithJLabel() throws BindingException
	{
		String actual;
		String expected;
		String value;
		String text;
		Employee employee;
		Property<String> employeePropertyBean;
		Property<String> jLabelPropertyBean;
		JLabel lblValue;

		value = "foo";
		employee = Employee.builder().person(Person.builder().nickname(value).build()).build();
		lblValue = new JLabel();
		employeePropertyBean = PropertyFactory.createProperty("employee.person.nickname", employee,
			String.class);
		jLabelPropertyBean = PropertyFactory.createProperty("text", lblValue, String.class);

		new BindingBuilder<String, String>().withSourceSupplier(() -> employeePropertyBean.get())
			.withSourceTrigger(
				(b, d) -> employeePropertyBean.addPropertyChangeListener(e -> b.apply(d)))
			.withTargetConsumer(c -> lblValue.setText(c)).build();

		employeePropertyBean.set(value);
		actual = lblValue.getText();
		expected = value;
		assertEquals(actual, expected);
	}

	@Test
	public void testBiDirectionalBindingWithJLabel() throws BindingException
	{
		String actual;
		String expected;
		String value;
		String text;
		Employee employee;
		Property<String> sourceProp;
		Property<String> targetProp;
		JLabel lblValue;

		value = "foo";
		employee = Employee.builder().person(Person.builder().nickname(value).build()).build();
		lblValue = new JLabel();
		sourceProp = PropertyFactory.createProperty("employee.person.nickname", employee,
			String.class);
		targetProp = PropertyFactory.createProperty("text", lblValue, String.class);

		new BindingBuilder<String, String>().withSourceSupplier(() -> sourceProp.get())
			.withSourceTrigger((b, d) -> sourceProp.addPropertyChangeListener(e -> b.apply(d)))
			.withTargetConsumer(b -> targetProp.set(b)).withTargetSupplier(targetProp::get)
			.withTargetTrigger((b, d) -> targetProp.addPropertyChangeListener(e -> b.apply(d)))
			.withSourceConsumer(sourceProp::set).build();
		String target = targetProp.get();
		String source = sourceProp.get();
		// sourceProp.set(value);
		// actual = lblValue.getText();
		// expected = value;
		// assertEquals(actual, expected);
		// set text from JLabel will not update source, because of strategy only READ
		text = "bar";

		employee.getPerson().setNickname(text);
		actual = employee.getPerson().getNickname();
		expected = text;
		assertEquals(actual, expected); // Not equal!!!
		// set value from Employee
		text = "foo";
		lblValue.setText(text);
		actual = lblValue.getText();
		expected = employee.getPerson().getNickname();
		assertNotSame(actual, expected);
	}
}
