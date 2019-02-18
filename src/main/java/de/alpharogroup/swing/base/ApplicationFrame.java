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
package de.alpharogroup.swing.base;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import de.alpharogroup.swing.components.factories.JComponentFactory;
import de.alpharogroup.swing.desktoppane.SingletonDesktopPane;
import de.alpharogroup.swing.utils.JInternalFrameExtensions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link ApplicationFrame}
 *
 * @param <T>
 *            the generic type of the model object
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class ApplicationFrame<T> extends AbstractApplicationFrame<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The current visible internal frame. */
	@Getter
	@Setter
	JInternalFrame currentVisibleInternalFrame;

	/** The desktop pane. */
	@Getter
	JDesktopPane desktopPane;

	/**
	 * Instantiates a new {@link ApplicationFrame}
	 *
	 * @param title the title
	 */
	public ApplicationFrame(String title)
	{
		super(title);
	}

	/**
	 * Factory method for create a new {@link JDesktopPane} object
	 *
	 * @return the new {@link JDesktopPane} object
	 */
	protected JDesktopPane newJDesktopPane()
	{
		return SingletonDesktopPane.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected JComponent newMainComponent()
	{
		return newJDesktopPane();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();		
	}

	/**
	 * Replace the current internal frame with a new internal frame with the given {@link Component}
	 * as content.
	 *
	 * @param title
	 *            the title
	 * @param component
	 *            the component
	 */
	public void replaceInternalFrame(final String title, final Component component)
	{
		if (getCurrentVisibleInternalFrame() != null)
		{
			getCurrentVisibleInternalFrame().dispose();
		}
		// create internal frame
		final JInternalFrame internalFrame = JComponentFactory.newInternalFrame(title, true, true,
			true, true);
		JInternalFrameExtensions.addComponentToFrame(internalFrame, component);
		JInternalFrameExtensions.addJInternalFrame(desktopPane, internalFrame);
		setCurrentVisibleInternalFrame(internalFrame);
	}

}
