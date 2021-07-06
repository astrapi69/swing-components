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
package io.github.astrapi69.swing.actions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import io.github.astrapi69.swing.plaf.LookAndFeels;

/**
 * The class {@link ShowHelpDialogAction} shows the help window of an application
 *
 * @deprecated use instead the same name class in the menu-actions repository.<br>
 *             <br>
 *             Note: will be removed in next minor version
 */
@Log
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@Deprecated
public class ShowHelpDialogAction extends AbstractAction
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	Window helpWindow;
	LookAndFeels lookAndFeels;

	/**
	 * Instantiates a new {@link ShowHelpDialogAction}
	 *
	 * @param name
	 *            the name
	 * @param helpWindow
	 *            the help window
	 * @param lookAndFeels
	 *            the look and feels
	 */
	public ShowHelpDialogAction(final String name, final @NonNull Window helpWindow,
		final @NonNull LookAndFeels lookAndFeels)
	{
		super(name);
		this.helpWindow = helpWindow;
		this.lookAndFeels = lookAndFeels;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent e)
	{
		helpWindow.setLocationRelativeTo(null);
		try
		{
			UIManager.setLookAndFeel(this.lookAndFeels.getLookAndFeelName());
		}
		catch (final Exception ex)
		{
			log.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
		}
		SwingUtilities.updateComponentTreeUI(helpWindow);
	}
}