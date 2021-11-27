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
import java.util.stream.Stream;

import javax.swing.*;

import lombok.experimental.UtilityClass;
import io.github.astrapi69.throwable.ExceptionExtensions;

/**
 * The class {@link DialogExtensions} provides methods for show dialogs.
 */
@UtilityClass
public class DialogExtensions
{

	/**
	 * Show exception dialog.
	 *
	 * @param exception
	 *            the exception
	 * @param parentComponent
	 *            determines the <code>Frame</code> in which the dialog is displayed; if
	 *            <code>null</code>, or if the <code>parentComponent</code> has no
	 *            <code>Frame</code>, a default <code>Frame</code> is used
	 * @param additionalMessages
	 *            the additional messages
	 */
	public static void showExceptionDialog(Exception exception, Component parentComponent,
		String... additionalMessages)
	{
		String title = exception.getLocalizedMessage();
		final StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body width='650'>");
		sb.append("<h2>");
		sb.append(exception.getLocalizedMessage());
		sb.append("</h2>");
		sb.append("<p>");
		sb.append(ExceptionExtensions.getStackTraceElements(exception));
		Stream.of(additionalMessages).forEach(am -> sb.append("<p>" + am));
		String htmlMessage = sb.toString();
		JOptionPane.showMessageDialog(parentComponent, htmlMessage, title,
			JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Show an information message.
	 *
	 * @param parentComponent
	 *            determines the <code>Frame</code> in which the dialog is displayed; if
	 *            <code>null</code>, or if the <code>parentComponent</code> has no
	 *            <code>Frame</code>, a default <code>Frame</code> is used
	 * @param title
	 *            the title
	 * @param message
	 *            the information message
	 */
	public static void showInformationDialog(Component parentComponent, String title,
		String message)
	{
		showMessageDialog(parentComponent, title, message, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Show an information message.
	 *
	 * @param parentComponent
	 *            determines the <code>Frame</code> in which the dialog is displayed; if
	 *            <code>null</code>, or if the <code>parentComponent</code> has no
	 *            <code>Frame</code>, a default <code>Frame</code> is used
	 * @param title
	 *            the title
	 * @param message
	 *            the information message
	 */
	public static void showMessageDialog(Component parentComponent, String title, String message,
		int messageType)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<html>").append("<body>").append(message).append("</body>").append("</html>");
		String htmlMessage = sb.toString();
		JOptionPane.showMessageDialog(parentComponent, htmlMessage, title, messageType);
	}

	/**
	 * Show an information message.
	 *
	 * @param title
	 *            the title
	 * @param message
	 *            the information message
	 */
	public static void info(String title, String message)
	{
		showInformationDialog(null, title, message);
	}

}
