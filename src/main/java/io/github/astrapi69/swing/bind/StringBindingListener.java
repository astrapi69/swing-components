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

import java.util.logging.Level;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.java.Log;
import io.github.astrapi69.model.api.Model;

/**
 * The class {@link StringBindingListener} acts as listener of the input of a text component and
 * updates the given {@link Model}.
 *
 */
@Log
@Getter
public class StringBindingListener implements DocumentListener
{

	/** The model. */
	private final Model<String> model;

	/**
	 * Instantiates a new {@link StringBindingListener}.
	 *
	 * @param model
	 *            the model
	 */
	public StringBindingListener(@NonNull Model<String> model)
	{
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changedUpdate(DocumentEvent event)
	{
		update(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUpdate(DocumentEvent event)
	{
		update(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeUpdate(DocumentEvent event)
	{
		update(event);
	}

	/**
	 * Update the underlying model object.
	 *
	 * @param event
	 *            the event
	 */
	protected void update(DocumentEvent event)
	{
		String text;
		try
		{
			text = event.getDocument().getText(event.getDocument().getStartPosition().getOffset(),
				event.getDocument().getEndPosition().getOffset() - 1);
			model.setObject(text);
		}
		catch (BadLocationException e1)
		{
			log.log(Level.SEVERE,
				"some portion of the given range was not a valid part of the document. "
					+ "The location in the exception is the first bad position encountered.",
				e1);
		}
	}

}
