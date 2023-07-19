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

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.label.model.LabelModel;
import lombok.NonNull;

import javax.swing.*;

public class JMLabel<T> extends JLabel
{
	IModel<LabelModel> propertyModel = BaseModel.of();

	public JMLabel(String text, IModel<LabelModel> propertyModel)
	{
		super(text);
		propertyModel.getObject().setText(text);
		this.propertyModel = propertyModel;
	}

	public JMLabel setPropertyModel(final @NonNull IModel<LabelModel> propertyModel)
	{
		this.propertyModel = propertyModel;
		LabelModel labelModel = this.propertyModel.getObject();
		if (labelModel.getText() != null)
		{
			setText(labelModel.getText());
		}
		if (labelModel.getIcon() != null)
		{
			setIcon(labelModel.getIcon());
		}
		if (labelModel.getHorizontalAlignment() != null
			&& labelModel.getHorizontalAlignment() != getHorizontalAlignment())
		{
			setHorizontalAlignment(labelModel.getHorizontalAlignment());
		}
		return this;
	}
}
