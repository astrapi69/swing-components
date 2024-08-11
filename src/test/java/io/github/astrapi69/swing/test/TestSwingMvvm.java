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
