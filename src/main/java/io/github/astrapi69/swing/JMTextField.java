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
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.adapters.DocumentListenerAdapter;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMTextField extends JTextField
{

	/** The model. */
	Model<String> propertyModel;

	{
		getDocument().addDocumentListener(new DocumentListenerAdapter()
		{
			@Override
			public void onDocumentChanged(final DocumentEvent documentEvent)
			{
				int currentLength = documentEvent.getDocument().getLength();
				final String text = RuntimeExceptionDecorator
					.decorate(() -> documentEvent.getDocument().getText(0, currentLength));
				if (JMTextField.this.propertyModel != null)
				{
					JMTextField.this.propertyModel.setObject(text);
				}
			}
		});
	}

	/**
	 * Constructs a new <code>TextField</code>. A default model is created, the initial string is
	 * <code>null</code>, and the number of columns is set to 0.
	 */
	public JMTextField()
	{
	}

	/**
	 * Constructs a new <code>TextField</code> initialized with the specified text. A default model
	 * is created and the number of columns is 0.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 */
	public JMTextField(String text)
	{
		super(text);
	}

	/**
	 * Constructs a new empty <code>TextField</code> with the specified number of columns. A default
	 * model is created and the initial string is set to <code>null</code>.
	 *
	 * @param columns
	 *            the number of columns to use to calculate the preferred width; if columns is set
	 *            to zero, the preferred width will be whatever naturally results from the component
	 *            implementation
	 */
	public JMTextField(int columns)
	{
		super(columns);
	}

	/**
	 * Constructs a new <code>TextField</code> initialized with the specified text and columns. A
	 * default model is created.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 * @param columns
	 *            the number of columns to use to calculate the preferred width; if columns is set
	 *            to zero, the preferred width will be whatever naturally results from
	 */
	public JMTextField(String text, int columns)
	{
		super(text, columns);
	}

	/**
	 * Constructs a new <code>JTextField</code> that uses the given text storage model and the given
	 * number of columns. This is the constructor through which the other constructors feed. If the
	 * document is <code>null</code>, a default model is created.
	 *
	 * @param doc
	 *            the text storage to use; if this is <code>null</code>, a default will be provided
	 *            by calling the <code>createDefaultModel</code> method
	 * @param text
	 *            the initial string to display, or <code>null</code>
	 * @param columns
	 *            the number of columns to use to calculate the preferred width &gt;= 0; if
	 *            <code>columns</code> is set to zero, the preferred width will be whatever
	 *            naturally results from the component implementation
	 * @throws IllegalArgumentException
	 *             if <code>columns</code> &lt; 0
	 */
	public JMTextField(Document doc, String text, int columns)
	{
		super(doc, text, columns);
	}

	public void setPropertyModel(final @NonNull Model<String> propertyModel)
	{
		this.propertyModel = propertyModel;
		setText(this.propertyModel.getObject());
	}
}
