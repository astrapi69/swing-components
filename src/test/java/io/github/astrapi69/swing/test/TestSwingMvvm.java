package io.github.astrapi69.swing.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import org.junit.jupiter.api.Test;

import net.sds.mvvm.bindings.BindingBuilder;
import net.sds.mvvm.bindings.BindingException;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

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
}
