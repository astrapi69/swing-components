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
package io.github.astrapi69.swing.action;

import java.awt.event.ActionEvent;

import javax.swing.*;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ActionFactory
{

	public static Action newPageAction(final String name, final JComponent container,
		final JComponent content)
	{
		return newReplaceContentAction(name, container, content, true);
	}

	public static Action newReplaceContentAction(final String name, final JComponent container,
		final JComponent content, boolean scrollable)
	{
		return new ReplaceContentAction(name, container, content, scrollable);
	}


	@SuppressWarnings("serial")
	public static Action newTextAction(final String name, final JComponent container,
		final JComponent content)
	{
		Action action = new AbstractAction(name)
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				ReplaceContentExtensions.replaceContentInMultiSplitPane(container, content, true);
			}

		};
		return action;
	}

}
