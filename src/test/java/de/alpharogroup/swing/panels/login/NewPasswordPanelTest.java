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
package de.alpharogroup.swing.panels.login;

import static de.alpharogroup.model.typesafe.TypeSafeModel.from;
import static de.alpharogroup.model.typesafe.TypeSafeModel.model;

import java.awt.Frame;

import javax.swing.event.DocumentEvent;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.bind.StringBindingListener;
import de.alpharogroup.swing.panels.login.pw.NewPasswordPanel;

public class NewPasswordPanelTest
{



	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{

		final Frame frame = new Frame();
		frame.addWindowListener(new CloseWindow());
		frame.setTitle("Set pw Frame");
		final NewPasswordPanel newPasswordPanel = new NewPasswordPanel();
		// example of binding model with a textfield with the class StringBindingListener...
		Model<String> model = model(from(newPasswordPanel.getModel()).getCurrentPassword());
			BaseModel.of(newPasswordPanel.getTxtUsername().getText());
		newPasswordPanel.getTxtPassword().getDocument().addDocumentListener(new StringBindingListener(model) {
			@Override
			protected void update(DocumentEvent event)
			{
				super.update(event);
				System.out.println(model.getObject() + "::" + newPasswordPanel.getModelObject().getCurrentPassword());
			}
		});
		frame.add(newPasswordPanel);
		frame.pack();
		frame.setSize(500, 300);
		frame.setVisible(true);
	}

}
