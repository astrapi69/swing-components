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
package io.github.astrapi69.swing.utils;

import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * The class {@link ClipboardExtensions}
 */
public class ClipboardExtensions
{

	/**
	 * Copy the content with the html entitys of the second given {@link JTextArea} object to the
	 * clipboard. If the flag withComment is true a a html comment with the content of the first
	 * given {@link JTextArea} object will be added.
	 *
	 * @param textArea            the text area input
	 * @param textAreaHtmlEntitys the text area with the html entitys
	 * @param withComment         flag if a html comment will be added
	 */
	public static void copy2Clipboard(JTextArea textArea, JTextArea textAreaHtmlEntitys,
		boolean withComment)
	{
		Clipboard clipboard = AwtExtensions.getSystemClipboard();
		StringBuffer sb = new StringBuffer();
		if (withComment)
		{
			sb.append("<!-- ");
			sb.append(textArea.getText());
			sb.append(" -->\n");
		}
		sb.append(textAreaHtmlEntitys.getText());
		StringSelection content = new StringSelection(sb.toString());
		clipboard.setContents(content, null);
	}

	/**
	 * Copy the content of the given {@link JTextArea} object to the clipboard
	 *
	 * @param textArea {@link JTextArea} object
	 */
	public static void copyToClipboard(JTextArea textArea)
	{
		Clipboard clipboard = AwtExtensions.getSystemClipboard();
		StringBuffer sb = new StringBuffer();
		sb.append(textArea.getText());
		StringSelection content = new StringSelection(sb.toString());
		clipboard.setContents(content, null);
	}

}
