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

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.swing.model.label.LabelModel;
import io.github.astrapi69.awt.window.adapter.CloseWindow;

public class JMLabelTest
{
	public static void main(String[] args)
	{
		// Bind with JMLabel that encapsulate a property model
		LabelModel labelModel;
		final JMLabel label;
		String initialText;
		String otherText;

		initialText = "Label text";
		otherText = "other Label text";
		Icon icon = MetalIconFactory.getFileChooserHomeFolderIcon();
		labelModel = LabelModel.builder().text(initialText)
			.horizontalAlignment(SwingConstants.TRAILING).icon(icon).build();

		label = new JMLabel(BaseModel.of(labelModel));

		final Frame frame = new Frame("JMLabelTest");
		JButton buttonCheck = new JButton("change text");
		buttonCheck.addActionListener(e -> {
			LabelModel modelObject = label.getPropertyModel().getObject();
			if (modelObject.getText().equals(initialText))
			{
				modelObject.setText(otherText);
			}
			else
			{
				modelObject.setText(initialText);
			}
			label.setPropertyModel(BaseModel.of(modelObject));
		});
		frame.addWindowListener(new CloseWindow());

		frame.setLayout(new GridBagLayout());
		frame.add(buttonCheck);
		frame.add(label);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

}
