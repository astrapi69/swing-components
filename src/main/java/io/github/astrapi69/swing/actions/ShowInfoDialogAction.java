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
package io.github.astrapi69.swing.actions;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import io.github.astrapi69.swing.dialog.info.InfoDialog;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The abstract class {@link ShowInfoDialogAction}
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class ShowInfoDialogAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;
	Frame owner;
	String title;

	/**
	 * Instantiates a new {@link ShowInfoDialogAction}.
	 *
	 * @param name
	 *            the name
	 * @param owner
	 *            the owner
	 * @param title
	 *            the title
	 */
	public ShowInfoDialogAction(final String name, final @NonNull Frame owner,
		final @NonNull String title)
	{
		super(name);
		this.owner = owner;
		this.title = title;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent e)
	{
		final InfoDialog info = newInfoDialog(owner, title);
		info.setVisible(true);
	}

	protected abstract InfoDialog newInfoDialog(final Frame owner, final String title);

}