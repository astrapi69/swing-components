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
package io.github.astrapi69.swing.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link RequestFocusListener} can take a {@link JComponent} which will gain focus when
 * the window/frame/dialog will show.<br>
 * <br>
 * The listener interface for receiving requestFocus events. The class that is interested in
 * processing a requestFocus event implements this interface, and the object created with that class
 * is registered with a component using the component's <code>addRequestFocusListener</code> method.
 * When the requestFocus event occurs, that object's appropriate method is invoked.
 */
@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestFocusListener implements WindowFocusListener
{

	/**
	 * The component that will gain focus when the window/frame/dialog will show.<br>
	 */
	@NonNull
	JComponent component;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void windowGainedFocus(WindowEvent e)
	{
		component.setFocusable(true);
		component.setRequestFocusEnabled(true);
		component.requestFocus();
		component.requestFocusInWindow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void windowLostFocus(WindowEvent e)
	{
	}

}
