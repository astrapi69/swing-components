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
package io.github.astrapi69.swing;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.model.PropertyModel;
import io.github.astrapi69.model.api.Model;

@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMCheckBox extends JCheckBox
{

	/** The model. */
	Model<Boolean> propertyModel = PropertyModel.<Boolean> of(this, "model.selected");

	{
		addItemListener(e -> {
			Object source = e.getSource();
			if (source instanceof JCheckBox)
			{
				propertyModel.setObject(JMCheckBox.this.isSelected());
			}
		});
	}

	public JMCheckBox()
	{
	}

	public JMCheckBox(Icon icon)
	{
		super(icon);
	}

	public JMCheckBox(Icon icon, boolean selected)
	{
		super(icon, selected);
	}

	public JMCheckBox(String text)
	{
		super(text);
	}

	public JMCheckBox(Action a)
	{
		super(a);
	}

	public JMCheckBox(String text, boolean selected)
	{
		super(text, selected);
	}

	public JMCheckBox(String text, Icon icon)
	{
		super(text, icon);
	}

	public JMCheckBox(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
	}

	public void setPropertyModel(final @NonNull Model<Boolean> propertyModel)
	{
		this.propertyModel = propertyModel;
		getModel().setSelected(this.propertyModel.getObject());
	}

}
