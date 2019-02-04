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
package de.alpharogroup.swing.dialog.factories;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import de.alpharogroup.swing.utils.AwtExtensions;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * The class {@link JDialogFactory} provides factory methods for create swing {@link JDialog}
 * objects
 */
@UtilityClass
public class JDialogFactory
{

	/**
	 * Factory method for create a {@link JDialog} object
	 *
	 * @param parentComponent
	 *            the parent component
	 * @param title
	 *            the title
	 * @param modal
	 *            the modal
	 * @return the new {@link JDialog}
	 */
	public static JDialog newJDialog(Component parentComponent, String title, boolean modal,
		GraphicsConfiguration gc)
	{
		final JDialog dialog;

		Window window = AwtExtensions.getWindowForComponent(parentComponent);
		if (window instanceof Frame)
		{
			dialog = new JDialog((Frame)window, title, modal, gc);
		}
		else if (window instanceof Dialog)
		{
			dialog = new JDialog((Dialog)window, title, modal, gc);
		}
		else
		{
			dialog = new JDialog((Frame)null, title, modal, gc);
		}
		return dialog;
	}

	/**
	 * Factory method for create a {@link JDialog} object.
	 *
	 * @param parentComponent
	 *            the parent component
	 * @param title
	 *            the title
	 * @param modalityType
	 *            the modality type
	 * @param gc
	 *            the {@code GraphicsConfiguration} of the target screen device; if {@code null},
	 *            the default system {@code GraphicsConfiguration} is assumed
	 * @return the new {@link JDialog}
	 */
	public static JDialog newJDialog(Component parentComponent, String title,
		Dialog.ModalityType modalityType, GraphicsConfiguration gc)
	{
		return new JDialog(AwtExtensions.getWindowForComponent(parentComponent), title,
			modalityType, gc);
	}

	/**
	 * Factory method for create a {@link JDialog} object over the given {@link JOptionPane}
	 *
	 * @param pane
	 *            the pane
	 * @param title
	 *            the title
	 * @return the new {@link JDialog}
	 */
	public static JDialog newJDialog(@NonNull JOptionPane pane, String title)
	{
		JDialog dialog = pane.createDialog(title);
		dialog.setResizable(true);
		dialog.setVisible(true);
		return dialog;
	}

}
