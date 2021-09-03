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
package io.github.astrapi69.swing.dialog;

import java.awt.*;

import javax.swing.*;

import io.github.astrapi69.window.adapter.CloseWindow;

public class DialogExtensionsTest
{

	public static void main(final String[] arguments)
	{
		NullPointerException nullPointerException = null;
		try
		{
			String message = nullPointerException.getMessage();
		}
		catch (NullPointerException exception)
		{
			nullPointerException = exception;
		}
		final JFrame frame = new JFrame("DialogExtensionsTest");
		frame.addWindowListener(new CloseWindow());
		JButton exceptionMessage = new JButton("Exception message");
		final NullPointerException npe = nullPointerException;
		exceptionMessage.addActionListener(e -> DialogExtensions.showExceptionDialog(npe, frame));
		JButton informationMessage = new JButton("Information");
		informationMessage.addActionListener(e -> DialogExtensions.showInformationDialog(frame,
			"Help", "<div width='650'>Help content<br>foo<br>foo</div>"
				+ "<div>Help content<br>foo<br>foo</div>"));
		frame.getContentPane().add(BorderLayout.WEST, informationMessage);
		frame.getContentPane().add(BorderLayout.EAST, exceptionMessage);
		frame.pack();
		frame.setVisible(true);
	}

}