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
package io.github.astrapi69.swing.check.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JCheckBoxDecorator extends JCheckBox
{

	/** The model. */
	Model<Boolean> bindModel;

	public JCheckBoxDecorator()
	{
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(Icon icon)
	{
		super(icon);
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(Icon icon, boolean selected)
	{
		super(icon, selected);
		initializeBindModel(selected);
	}

	public JCheckBoxDecorator(String text)
	{
		super(text);
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(Action a)
	{
		super(a);
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(String text, boolean selected)
	{
		super(text, selected);
		initializeBindModel(selected);
	}

	public JCheckBoxDecorator(String text, Icon icon)
	{
		super(text, icon);
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
		initializeBindModel(selected);
	}

	@Override
	public void setModel(ButtonModel newModel)
	{
		super.setModel(newModel);
		if (newModel != null)
		{
			if (bindModel == null)
			{
				bindModel = BaseModel.of(newModel.isSelected());
			}
			else
			{
				bindModel.setObject(newModel.isSelected());
			}
			newModel.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					bindModel.setObject(newModel.isSelected());
				}
			});
		}
	}

	public void setBindModel(final @NonNull Model<Boolean> bindModel)
	{
		ButtonModel buttonModel = getModel();
		if (buttonModel == null)
		{
			buttonModel = new DefaultButtonModel();
		}
		buttonModel.setSelected(bindModel.getObject());
	}

	public void setBindModelObject(final boolean modelObject)
	{
		bindModel.setObject(modelObject);
		setBindModel(bindModel);
	}

	protected void initializeBindModel(boolean selected)
	{
		bindModel.setObject(selected);
	}
}
