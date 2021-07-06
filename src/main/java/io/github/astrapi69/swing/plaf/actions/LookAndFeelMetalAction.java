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
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import io.github.astrapi69.swing.plaf.LookAndFeels;

/**
 * The class {@link LookAndFeelMetalAction} can change the look and feel to Metal
 *
 * @deprecated use instead the same name class in the menu-actions repository.<br>
 *             <br>
 *             Note: will be removed in next minor version
 */
@Deprecated
public class LookAndFeelMetalAction extends LookAndFeelAction
{

	private static final String OCEAN_THEME_NAME = "Ocean";
	private static final long serialVersionUID = 1L;

	public LookAndFeelMetalAction(final String name, final Component component)
	{
		super(name, component, LookAndFeels.METAL);
	}

	@Override
	public void actionPerformed(final ActionEvent e)
	{
		try
		{
			UIManager.setLookAndFeel(LookAndFeels.METAL.getLookAndFeelName());
			SwingUtilities.updateComponentTreeUI(getComponent());

			if (NAME.equals(OCEAN_THEME_NAME))
			{
				MetalLookAndFeel.setCurrentTheme(new OceanTheme());
			}
			else
			{
				MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
			}
			UIManager.setLookAndFeel(new MetalLookAndFeel());

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
}
