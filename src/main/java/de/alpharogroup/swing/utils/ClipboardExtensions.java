package de.alpharogroup.swing.utils;

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
