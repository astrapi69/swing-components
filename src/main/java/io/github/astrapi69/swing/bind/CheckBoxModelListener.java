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
package io.github.astrapi69.swing.bind;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.swing.check.model.CheckBoxModel;

/**
 * The listener interface {@link CheckBoxModelListener} receives events from a checkbox
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckBoxModelListener implements ItemListener
{

	/** The model. */
	CheckBoxModel model;

	/**
	 * Instantiates a new {@link CheckBoxModelListener}
	 *
	 * @param model
	 *            the model
	 */
	public CheckBoxModelListener(final @NonNull CheckBoxModel model)
	{
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		this.model.setChecked(((JCheckBox)e.getSource()).isSelected());
	}
}
