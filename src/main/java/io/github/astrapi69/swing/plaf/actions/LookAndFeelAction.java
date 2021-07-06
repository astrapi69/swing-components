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
package io.github.astrapi69.swing.plaf.actions;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.swing.plaf.LookAndFeels;

/**
 * The base class {@link LookAndFeelAction} for change a look and feel from the application
 *
 * @deprecated use instead the same name class in the menu-actions repository.<br>
 *             <br>
 *             Note: will be removed in next minor version
 */
@Getter(AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LookAndFeelAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;
	Component component;
	LookAndFeels lookAndFeel;

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
			LookAndFeels.setLookAndFeel(this.lookAndFeel, this.component);
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
