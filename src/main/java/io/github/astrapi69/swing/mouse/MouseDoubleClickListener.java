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
package io.github.astrapi69.swing.mouse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * The class {@link MouseDoubleClickListener} can handle single and double click events on any
 * {@link JComponent} object and prevents that an event will be executed twice.
 *
 * @deprecated use instead the same named class in project menu-actions<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public abstract class MouseDoubleClickListener extends MouseAdapter implements ActionListener
{
	/** The key for the multi click interval */
	private static final String AWT_MULTI_CLICK_INTERVAL_KEY = "awt.multiClickInterval";

	/**
	 * The {@link Timer} object
	 */
	private final Timer timer;

	/**
	 * The last {@link MouseEvent} object
	 */
	private MouseEvent lastEvent;

	/**
	 * The default constructor
	 */
	public MouseDoubleClickListener()
	{
		this((Integer)Toolkit.getDefaultToolkit().getDesktopProperty(AWT_MULTI_CLICK_INTERVAL_KEY));
	}

	/**
	 * The constructor with a delay argument for the {@link Timer} object
	 */
	public MouseDoubleClickListener(int delay)
	{
		this.timer = new Timer(delay, this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseClicked(MouseEvent mouseEvent)
	{
		if (mouseEvent.getClickCount() > 2)
		{
			return;
		}
		lastEvent = mouseEvent;

		if (timer.isRunning())
		{
			timer.stop();
			onDoubleClick(lastEvent);
		}
		else
		{
			timer.restart();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void actionPerformed(ActionEvent e)
	{
		timer.stop();
		onSingleClick(lastEvent);
	}

	/**
	 * Callback method that have to be implemented to provide specific action on single click events
	 *
	 * @param mouseEvent
	 *            the mouse event
	 */
	public abstract void onSingleClick(MouseEvent mouseEvent);


	/**
	 * Callback method that have to be implemented to provide specific action on double click events
	 *
	 * @param mouseEvent
	 *            the mouse event
	 */
	public abstract void onDoubleClick(MouseEvent mouseEvent);

}