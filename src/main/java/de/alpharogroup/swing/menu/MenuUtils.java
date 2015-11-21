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
package de.alpharogroup.swing.menu;

import java.awt.Event;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * The Class MenuUtils.
 */
public final class MenuUtils
{

	/**
	 * Sets the accelerator from the given menuitem and the given character with the CTRL. The
	 * accelerator are combined with the given character and the CTRL.
	 *
	 * @param jmi
	 *            The JMenuItem.
	 * @param accelerator
	 *            The character that have to push together with the CTRL.
	 */
	public static void setCtrlAccelerator(final JMenuItem jmi, final char accelerator)
	{
		final KeyStroke ks = KeyStroke.getKeyStroke(accelerator, Event.CTRL_MASK);
		jmi.setAccelerator(ks);
	}

}
