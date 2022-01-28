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

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.text.DefaultFormatter;

import lombok.NonNull;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;

public class JMSpinner<T> extends JSpinner
{
	IModel<T> propertyModel = BaseModel.of();
	{
		JComponent comp = this.getEditor();
		JFormattedTextField field = (JFormattedTextField)comp.getComponent(0);
		DefaultFormatter formatter = (DefaultFormatter)field.getFormatter();
		formatter.setCommitsOnValidEdit(true);
		addChangeListener(e -> {
			JSpinner s = (JSpinner)e.getSource();
			T value = (T)s.getValue();
			propertyModel.setObject(value);
		});
	}

	/**
	 * Constructs a spinner for the given model. The spinner has a set of previous/next buttons, and
	 * an editor appropriate for the model.
	 *
	 * @param model
	 * @throws NullPointerException
	 *             if the model is {@code null}
	 */
	public JMSpinner(SpinnerModel model)
	{
		super(model);
	}

	/**
	 * Constructs a spinner with an <code>Integer SpinnerNumberModel</code> with initial value 0 and
	 * no minimum or maximum limits.
	 */
	public JMSpinner()
	{
	}

	public JMSpinner setPropertyModel(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
		getModel().setValue(this.propertyModel.getObject());
		return this;
	}
}
