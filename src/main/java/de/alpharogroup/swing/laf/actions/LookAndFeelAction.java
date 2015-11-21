/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
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
package de.alpharogroup.swing.laf.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.UnsupportedLookAndFeelException;

import de.alpharogroup.swing.laf.LookAndFeels;

public class LookAndFeelAction extends AbstractAction
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final Component component;
	private final LookAndFeels lookAndFeel;

	public LookAndFeelAction(final String name, final Component component,
		final LookAndFeels lookAndFeel)
	{
		super(name);
		this.component = component;
		this.lookAndFeel = lookAndFeel;
	}

	@Override
	public void actionPerformed(final ActionEvent event)
	{
		try
		{
			LookAndFeels.setLookAndFeel(this.lookAndFeel.getLookAndFeelName(), this.component);
		}
		catch (final ClassNotFoundException exception)
		{
			throw new RuntimeException(exception);
		}
		catch (final InstantiationException exception)
		{
			throw new RuntimeException(exception);
		}
		catch (final IllegalAccessException exception)
		{
			throw new RuntimeException(exception);
		}
		catch (final UnsupportedLookAndFeelException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	protected Component getComponent()
	{
		return component;
	}

}
