/**
 * The MIT License
 *
 * Copyright (C) 2026 Asterios Raptis
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
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import net.sds.mvvm.bindings.BindingBuilder;
import net.sds.mvvm.bindings.BindingException;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import net.sds.mvvm.triggers.DocumentTextChangedTrigger;

public class TestSwingMvvm
{


	@Test
	public void theSourceCanBeAComponent() throws BindingException
	{
		Property<Color> colorProperty = PropertyFactory.createProperty("Color", this, Color.class);
		JLabel label = new JLabel();
		new BindingBuilder<Color, Color>().withSourceSupplier(() -> label.getForeground())
			.withSourceTrigger(
				(b, d) -> label.addPropertyChangeListener("foreground", e -> b.apply(d)))
			.withTargetConsumer(colorProperty::set).build();

		label.setForeground(Color.RED);
		assertEquals(Color.RED, label.getForeground());
	}

	@Test
	public void testEncapsulatedAutoBindingWithJLabel() throws BindingException
	{
		String actual;
		String expected;
		String value;
		String text;
		Employee employee;
		JLabel lblValue;

		value = "foo";
		employee = Employee.builder().person(Person.builder().nickname(value).build()).build();
		lblValue = new JLabel();

		new BindingBuilder<String, String>().withSourceSupplier(() -> lblValue.getText())
			.withSourceTrigger(
				(b, d) -> lblValue.addPropertyChangeListener("text", e -> b.apply(d)))
			.withTargetConsumer(t -> employee.getPerson().setNickname(t)).build();

		text = "bar";
		lblValue.setText(text);
		actual = employee.getPerson().getNickname();
		expected = text;
		assertEquals(actual, expected);

	}

	@Test
	public void textChangesArePropagated() throws BindingException
	{
		final StringBuilder b = new StringBuilder();
		JTextField jTextField = new JTextField();
		new BindingBuilder<String, String>().withSourceSupplier(() -> jTextField.getText())
			.withSourceTrigger(new DocumentTextChangedTrigger(jTextField.getDocument()))
			.withTargetConsumer(t -> b.append(t)).build();

		jTextField.setText("New text");
		assertEquals("New text", b.toString());
	}
}
