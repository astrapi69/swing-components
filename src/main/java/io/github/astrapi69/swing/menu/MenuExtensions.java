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
package io.github.astrapi69.swing.menu;

import java.awt.*;

import javax.swing.*;

/**
 * The class {@link MenuExtensions}.
 */
public final class MenuExtensions
{

	/**
	 * Sets the accelerator for the given menuitem and the given key char.
	 *
	 * @param jmi
	 *            The JMenuItem.
	 * @param keyChar
	 *            the key char
	 */
	public static void setAccelerator(final JMenuItem jmi, final char keyChar)
	{
		jmi.setAccelerator(KeyStroke.getKeyStroke(keyChar));
	}

	/**
	 * Sets the accelerator for the given menuitem and the given key char and the given modifiers.
	 *
	 * @param jmi
	 *            The JMenuItem.
	 * @param keyChar
	 *            the key char
	 * @param modifiers
	 *            the modifiers
	 */
	public static void setAccelerator(final JMenuItem jmi, final Character keyChar,
		final int modifiers)
	{
		jmi.setAccelerator(KeyStroke.getKeyStroke(keyChar, modifiers));
	}

	/**
	 * Sets the accelerator for the given menuitem and the given key code and the given modifiers.
	 *
	 * @param jmi
	 *            The JMenuItem.
	 * @param keyCode
	 *            the key code
	 * @param modifiers
	 *            the modifiers
	 */
	public static void setAccelerator(final JMenuItem jmi, final int keyCode, final int modifiers)
	{
		jmi.setAccelerator(KeyStroke.getKeyStroke(keyCode, modifiers));
	}

	/**
	 * Sets the accelerator for the given menuitem and the given keyCode and the given modifiers.
	 *
	 * @param jmi
	 *            The JMenuItem.
	 * @param keyCode
	 *            the key code
	 * @param modifiers
	 *            the modifiers
	 * @param onKeyRelease
	 *            true if the KeyStroke should represent a key release, false otherwise.
	 */
	public static void setAccelerator(final JMenuItem jmi, final int keyCode, final int modifiers,
		final boolean onKeyRelease)
	{
		jmi.setAccelerator(KeyStroke.getKeyStroke(keyCode, modifiers, onKeyRelease));
	}

	/**
	 * Sets the accelerator for the given menuitem and the given parsable keystroke string.
	 *
	 * @param jmi
	 *            The JMenuItem.
	 * @param parsableKeystrokeString
	 *            the parsable keystroke string
	 */
	public static void setAccelerator(final JMenuItem jmi, final String parsableKeystrokeString)
	{
		jmi.setAccelerator(KeyStroke.getKeyStroke(parsableKeystrokeString));
	}

	/**
	 * Sets the accelerator for the given menuitem and the given character with the ALT. The
	 * accelerator are combined with the given character and the ALT.
	 *
	 * @param jmi
	 *            The JMenuItem.
	 * @param accelerator
	 *            The character that have to push together with the ALT.
	 */
	public static void setAltAccelerator(final JMenuItem jmi, final char accelerator)
	{
		setAccelerator(jmi, accelerator, Event.ALT_MASK);
	}

	/**
	 * Sets the accelerator for the given menuitem and the given character with the CTRL. The
	 * accelerator are combined with the given character and the CTRL.
	 *
	 * @param jmi
	 *            The JMenuItem.
	 * @param accelerator
	 *            The character that have to push together with the CTRL.
	 */
	public static void setCtrlAccelerator(final JMenuItem jmi, final char accelerator)
	{
		setAccelerator(jmi, accelerator, Event.CTRL_MASK);
	}

}
