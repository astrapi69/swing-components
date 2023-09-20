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

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;

import javax.swing.JTextField;

@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class JMGenericTextField<T> extends JTextField
{

	/** The model. */
	IModel<T> propertyModel = BaseModel.of();

	/**
	 * init block
	 */
	{
		onInitialize();
	}


	/**
	 * Constructs a new <code>TextField</code>.
	 *
	 * @param propertyModel
	 *            the text model to be displayed
	 */
	public JMGenericTextField(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
	}

	/**
	 * Constructs a new <code>TextField</code>. A default model is created, the initial string is
	 * <code>null</code>, and the number of columns is set to 0.
	 */
	public JMGenericTextField()
	{
	}

	/**
	 * Constructs a new <code>TextField</code> initialized with the specified text. A default model
	 * is created and the number of columns is 0.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 */
	public JMGenericTextField(String text)
	{
		super(text);
		this.propertyModel.setObject(toGenericObject(text));
	}

	public JMGenericTextField(String text, int columns)
	{
		super(text);
		setColumns(columns);
		this.propertyModel.setObject(toGenericObject(text));
	}

	public JMGenericTextField setPropertyModel(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
		setText(toText(this.propertyModel.getObject()));
		return this;
	}

	protected abstract <T> void onInitialize();

	public abstract T toGenericObject(String text);

	public abstract String toText(T propertyModelObject);

}
