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
package io.github.astrapi69.swing.button;

import javax.swing.*;

/**
 * A factory {@link IconButtonFactory} provides factory methods for create {@link JButton} objects
 * with {@link Icon} objects
 */
public class IconButtonFactory
{

	/**
	 * Factory method for create a <code>JButton</code> with the given <code>Icon</code>
	 *
	 * @param icon
	 *            the icon for the button
	 * @return the new {@link JButton} object with the given <code>Icon</code>
	 */
	public static JButton newIconButton(Icon icon)
	{
		JButton button = ButtonFactory.newJButton();
		button.setIcon(icon);
		return button;
	}

	/**
	 * Factory method for create a <code>JButton</code> with the given <code>Icon</code> and the
	 * given text
	 *
	 * @param icon
	 *            the icon for the button
	 * @param toolTipText
	 *            the tooltip text for the button
	 * @return the new {@link JButton} object with the given <code>Icon</code>
	 */
	public static JButton newIconButton(Icon icon, String toolTipText)
	{
		JButton button = newIconButton(icon);
		button.setToolTipText(toolTipText);
		return button;
	}

	/**
	 * Factory method for create a <code>JButton</code> with the given <code>Icon</code> and the
	 * given text
	 *
	 * @param relativeImagePath
	 *            the relative image path
	 * @param toolTipText
	 *            the tooltip text for the button
	 * @return the new {@link JButton} object with the given <code>Icon</code>
	 */
	public static JButton newIconButton(String relativeImagePath, String toolTipText)
	{
		JButton button = newIconButton(ImageIconFactory.newImageIcon(relativeImagePath),
			toolTipText);
		return button;
	}

	/**
	 * Factory method for create a <code>JButton</code> with the given <code>Icon</code> and the
	 * given text
	 *
	 * @param icon
	 *            the icon for the button
	 * @param toolTipText
	 *            the tooltip text for the button
	 * @param text
	 *            the text for the button
	 * @return the new {@link JButton} object with the given <code>Icon</code>
	 */
	public static JButton newIconButton(Icon icon, String toolTipText, String text)
	{
		JButton button = newIconButton(icon, toolTipText);
		button.setText(text);
		return button;
	}

	/**
	 * Factory method for create a <code>JButton</code> with the given <code>Icon</code> and the
	 * given text
	 *
	 * @param icon
	 *            the icon for the button
	 * @param text
	 *            the text for the button
	 * @return the new {@link JButton} object with the given <code>Icon</code>
	 */
	public static JButton newIconButtonWithText(Icon icon, String text)
	{
		JButton button = newIconButton(icon);
		button.setText(text);
		return button;
	}

	/**
	 * Factory method for create a <code>JButton</code> with the given <code>Icon</code> and the
	 * given text
	 *
	 * @param icon
	 *            the icon for the button
	 * @param toolTipText
	 *            the tooltip text for the button
	 * @param text
	 *            the text for the button
	 * @param actionCommand
	 *            the action command
	 * @return the new {@link JButton} object with the given <code>Icon</code>
	 */
	public static JButton newIconButton(Icon icon, String toolTipText, String text,
		String actionCommand)
	{
		JButton button = newIconButton(icon, toolTipText, text);
		button.setActionCommand(actionCommand);
		return button;
	}

}
