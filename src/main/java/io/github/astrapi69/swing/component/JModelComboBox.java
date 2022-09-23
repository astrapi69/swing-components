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

import javax.swing.ComboBoxModel;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import org.jdesktop.swingx.JXComboBox;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;

@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JModelComboBox<T, CMB extends ComboBoxModel<T>> extends JXComboBox
{
	IModel<T> propertyModel = BaseModel.of();

	{
		addItemListener(event -> {
			T item = (T)event.getItem();
			propertyModel.setObject(item);
		});
	}

	public JModelComboBox(CMB comboBoxModel)
	{
		super(comboBoxModel);
	}

	public JModelComboBox(T selectedModelObject, CMB comboBoxModel)
	{
		super(comboBoxModel);
		propertyModel.setObject(selectedModelObject);
		getModel().setSelectedItem(this.propertyModel.getObject());
	}

	public JModelComboBox(CMB comboBoxModel, IModel<T> propertyModel)
	{
		super(comboBoxModel);
		this.propertyModel = propertyModel;
		getModel().setSelectedItem(this.propertyModel.getObject());
	}

	public JModelComboBox<T, CMB> setPropertyModel(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
		getModel().setSelectedItem(this.propertyModel.getObject());
		return this;
	}
}
