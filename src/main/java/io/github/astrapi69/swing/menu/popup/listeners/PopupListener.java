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
package io.github.astrapi69.swing.menu.popup.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * The listener interface for receiving popup events. The class that is interested in processing a
 * popup event implements this interface, and the object created with that class is registered with
 * a component using the component's addPopupListener method. When the popup event occurs, that
 * object's appropriate method is invoked.
 */
public class PopupListener extends MouseAdapter
{

	/** The popup menu. */
	private final JPopupMenu popupMenu;

	/**
	 * Instantiates a new popup listener.
	 *
	 * @param menu
	 *            the menu
	 */
	public PopupListener(final JPopupMenu menu)
	{
		super();
		popupMenu = menu;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mousePressed(final MouseEvent e)
	{
		onShowPopup(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseReleased(final MouseEvent e)
	{
		onShowPopup(e);
	}

	/**
	 * Callback method that is called on show popup.
	 *
	 * @param e
	 *            the mouse event
	 */
	protected void onShowPopup(final MouseEvent e)
	{
		if (e.isPopupTrigger())
		{
			System.out.println(e.getSource());
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}