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
package de.alpharogroup.layout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The Class DisposeWindow.
 */
/**
 * The Class DisposeWindow is an Adapter class for the WindowAdapter to dispose the window and
 * setVisible to false.
 * 
 * @version 1.0
 * @author Asterios Raptis
 */
public class DisposeWindow extends WindowAdapter
{

	/**
	 * Window closed.
	 *
	 * @param we
	 *            the we {@inheritDoc}
	 * @see java.awt.event.WindowAdapter#windowClosed(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosed(final WindowEvent we)
	{
		we.getWindow().setVisible(false);
		we.getWindow().dispose();
	}

	/**
	 * Window closing.
	 *
	 * @param we
	 *            the we {@inheritDoc}
	 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(final WindowEvent we)
	{
		we.getWindow().setVisible(false);
		we.getWindow().dispose();
	}

}
