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
package de.alpharogroup.swing.utils;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public interface Keystrokes
{

	/** The Constant CTRL_ALT_A. */
	static final KeyStroke CTRL_ALT_A = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK
		+ KeyEvent.ALT_MASK);

	/** The Constant CTRL_ALT_B. */
	static final KeyStroke CTRL_ALT_B = KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK
		+ KeyEvent.ALT_MASK);

	/** The Constant CTRL_ALT_C. */
	static final KeyStroke CTRL_ALT_C = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK
		+ KeyEvent.ALT_MASK);

	/** The Constant CTRL_ALT_D. */
	static final KeyStroke CTRL_ALT_D = KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK
		+ KeyEvent.ALT_MASK);

	/** The Constant CTRL_ALT_E. */
	static final KeyStroke CTRL_ALT_E = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK
		+ KeyEvent.ALT_MASK);

	/** The Constant CTRL_ALT_F. */
	static final KeyStroke CTRL_ALT_F = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK
		+ KeyEvent.ALT_MASK);
}
