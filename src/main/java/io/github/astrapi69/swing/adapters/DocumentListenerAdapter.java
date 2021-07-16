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
package io.github.astrapi69.swing.adapters;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * The abstract class {@link DocumentListenerAdapter} is an adapter for the DocumentListener
 * interface and provides one callback method that have to be implemented
 */
public abstract class DocumentListenerAdapter implements DocumentListener
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changedUpdate(DocumentEvent e)
	{
		onDocumentChanged(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUpdate(DocumentEvent e)
	{
		onDocumentChanged(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeUpdate(DocumentEvent e)
	{
		onDocumentChanged(e);
	}

	/**
	 * Callback method that have to be implemented to provide specific action on change of document
	 *
	 * @param e
	 *            - the DocumentEvent from the specific DocumentListener method
	 */
	public abstract void onDocumentChanged(final DocumentEvent e);

}