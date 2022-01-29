package io.github.astrapi69.swing.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotSame;

import javax.swing.JLabel;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.testng.annotations.Test;

import io.github.astrapi69.collections.pairs.ValueBox;
import io.github.astrapi69.test.objects.Employee;
import io.github.astrapi69.test.objects.Person;

public class TestAutoBinding
{
	@Test
	public void testEncapsulatedAutoBinding()
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
