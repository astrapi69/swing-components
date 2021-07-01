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
package io.github.astrapi69.swing.components.factories;

import java.awt.*;
import java.net.URL;

import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.*;

import lombok.experimental.UtilityClass;
import io.github.astrapi69.lang.ClassExtensions;

/**
 * The class {@link JComponentFactory} provides factory methods for create swing Component objects
 */
@UtilityClass
public class JComponentFactory
{

	public static Frame newFrame(String title)
	{
		final Frame frame = new Frame(title);
		return frame;
	}

	public static JEditorPane newJEditorPane(String contentType, boolean editable)
	{
		final JEditorPane editor = new JEditorPane();
		editor.setContentType(contentType);
		editor.setEditable(editable);
		editor.setOpaque(true);
		return editor;
	}

	/**
	 * Factory method for create new {@link JSplitPane} object
	 *
	 * @param newLeftComponent
	 *            the <code>Component</code> that will appear on the left of a horizontally-split
	 *            pane, or at the top of a vertically-split pane
	 * @param newRightComponent
	 *            the <code>Component</code> that will appear on the right of a horizontally-split
	 *            pane, or at the bottom of a vertically-split pane
	 * @return the new {@link JSplitPane} object
	 */
	public static JSplitPane newJSplitPane(Component newLeftComponent, Component newRightComponent)
	{
		return newJSplitPane(JSplitPane.HORIZONTAL_SPLIT, newLeftComponent, newRightComponent);
	}

	/**
	 * Factory method for create new {@link JSplitPane} object
	 *
	 * @param newOrientation
	 *            <code>JSplitPane.HORIZONTAL_SPLIT</code> or <code>JSplitPane.VERTICAL_SPLIT</code>
	 * @param newLeftComponent
	 *            the <code>Component</code> that will appear on the left of a horizontally-split
	 *            pane, or at the top of a vertically-split pane
	 * @param newRightComponent
	 *            the <code>Component</code> that will appear on the right of a horizontally-split
	 *            pane, or at the bottom of a vertically-split pane
	 * @return the new {@link JSplitPane} object
	 */
	public static JSplitPane newJSplitPane(int newOrientation, Component newLeftComponent,
		Component newRightComponent)
	{
		return newJSplitPane(newOrientation, true, newLeftComponent, newRightComponent);
	}

	/**
	 * Factory method for create new {@link JSplitPane} object
	 *
	 * @param newOrientation
	 *            <code>JSplitPane.HORIZONTAL_SPLIT</code> or <code>JSplitPane.VERTICAL_SPLIT</code>
	 * @param newContinuousLayout
	 *            a boolean, true for the components to redraw continuously as the divider changes
	 *            position, false to wait until the divider position stops changing to redraw
	 * @param newLeftComponent
	 *            the <code>Component</code> that will appear on the left of a horizontally-split
	 *            pane, or at the top of a vertically-split pane
	 * @param newRightComponent
	 *            the <code>Component</code> that will appear on the right of a horizontally-split
	 *            pane, or at the bottom of a vertically-split pane
	 * @return the new {@link JSplitPane} object
	 */
	public static JSplitPane newJSplitPane(int newOrientation, boolean newContinuousLayout,
		Component newLeftComponent, Component newRightComponent)
	{
		return new JSplitPane(newOrientation, newContinuousLayout, newLeftComponent,
			newRightComponent);
	}

	/**
	 * Factory method for create new {@link HelpSet} object.
	 *
	 * @param directoryPath
	 *            the directory path
	 * @param filename
	 *            the filename
	 * @return the new {@link HelpSet} object
	 * @throws HelpSetException
	 *             is thrown if there are problems parsing the {@link HelpSet} object.
	 */
	public static HelpSet newHelpSet(final String directoryPath, final String filename)
		throws HelpSetException
	{
		String absolutePath = directoryPath + filename;
		URL hsURL = ClassExtensions.getResource(absolutePath);
		HelpSet hs = new HelpSet(ClassExtensions.getClassLoader(), hsURL);
		return hs;
	}

	/**
	 * Factory method for create a {@link JInternalFrame} object.
	 *
	 * @param title
	 *            the title
	 * @param resizable
	 *            the resizable
	 * @param closable
	 *            the closable
	 * @param maximizable
	 *            the maximizable
	 * @param iconifiable
	 *            the iconifiable
	 * @return the new {@link JInternalFrame}.
	 */
	public static JInternalFrame newInternalFrame(final String title, final boolean resizable,
		final boolean closable, final boolean maximizable, final boolean iconifiable)
	{
		final JInternalFrame internalFrame = new JInternalFrame(title, resizable, closable,
			maximizable, iconifiable);
		return internalFrame;
	}

}
