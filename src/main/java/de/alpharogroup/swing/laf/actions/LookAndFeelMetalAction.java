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

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import de.alpharogroup.swing.laf.LookAndFeels;

public class LookAndFeelMetalAction extends LookAndFeelAction
{

	/**
	 *
	 */
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

			if (NAME.equals("Ocean"))
			{
				MetalLookAndFeel.setCurrentTheme(new OceanTheme());
			}
			else
			{
				MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
			}
			UIManager.setLookAndFeel(new MetalLookAndFeel());

		}
		catch (final ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (final InstantiationException e1)
		{
			e1.printStackTrace();
		}
		catch (final IllegalAccessException e1)
		{
			e1.printStackTrace();
		}
		catch (final UnsupportedLookAndFeelException e1)
		{
			e1.printStackTrace();
		}

	}
}
