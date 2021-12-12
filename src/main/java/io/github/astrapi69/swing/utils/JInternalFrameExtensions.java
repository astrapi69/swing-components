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

import java.awt.*;

import javax.swing.*;

import lombok.experimental.UtilityClass;
import io.github.astrapi69.mvc.view.View;

/**
 * The Class {@link JInternalFrameExtensions}.
 *
 * @deprecated use instead the same named class in project swing-base-components<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
@UtilityClass
public class JInternalFrameExtensions
{

	/**
	 * Adds the given {@link View} object to the given {@link JInternalFrame} object.
	 *
	 * @param internalFrame
	 *            the {@link JInternalFrame} object.
	 * @param view
	 *            the {@link View} object to add
	 */
	public static void addViewToFrame(final JInternalFrame internalFrame, final View<?, ?> view)
	{
		internalFrame.add(view.getComponent(), BorderLayout.CENTER);
		internalFrame.pack();
	}

	/**
	 * Adds the given {@link Component} object to the given {@link JInternalFrame} object.
	 *
	 * @param internalFrame
	 *            the {@link JInternalFrame} object.
	 * @param component
	 *            the {@link Component} object to add
	 */
	public static void addComponentToFrame(final JInternalFrame internalFrame,
		final Component component)
	{
		internalFrame.add(component, BorderLayout.CENTER);
		internalFrame.pack();
	}

	/**
	 * Adds the given {@link JInternalFrame} to the given {@link JDesktopPane} and bring it to the
	 * front.
	 *
	 * @param desktopPane
	 *            the desktop pane
	 * @param internalFrame
	 *            the internal frame
	 */
	public static void addJInternalFrame(final JDesktopPane desktopPane,
		final JInternalFrame internalFrame)
	{
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);
		internalFrame.toFront();
	}

}