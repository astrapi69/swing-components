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
package de.alpharogroup.swing.panels.splitpane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.MultiSplitLayout;

import de.alpharogroup.layout.ScreenSizeExtensions;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.base.BasePanel;
import de.alpharogroup.swing.components.factories.DimensionFactory;
import lombok.Getter;

public class JXMultiSplitPanePanel<T> extends BasePanel<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The {@link JXMultiSplitPane} */
	@Getter
	JXMultiSplitPane multiSplitPane;

	/**
	 * Instantiates a new new {@link JXMultiSplitPanePanel} object
	 */
	public JXMultiSplitPanePanel()
	{
	}

	/**
	 * Instantiates a new new {@link JXMultiSplitPanePanel} object
	 *
	 * @param model
	 *            the model
	 */
	public JXMultiSplitPanePanel(final Model<T> model)
	{
		super(model);
	}

	/**
	 * Factory method for creating the new {@link JXMultiSplitPane}. This method is invoked in the
	 * constructor from the derived classes and can be overridden so users can provide their own
	 * version of a {@link JXMultiSplitPane}
	 *
	 * @param layoutDefinition
	 *            the layout definition
	 * @return the new {@link JXMultiSplitPane}
	 */
	protected JXMultiSplitPane newJXMultiSplitPane(String layoutDefinition)
	{
		JXMultiSplitPane msp = new JXMultiSplitPane();
		MultiSplitLayout.Node modelRoot = newRootNode(layoutDefinition);
		msp.getMultiSplitLayout().setModel(modelRoot);
		msp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		return msp;
	}

	/**
	 *
	 * Factory method for creating the new layout definition as {@link String}. This method is
	 * invoked in the constructor from the derived classes and can be overridden so users can
	 * provide their own version of a layout definition as {@link String}
	 *
	 * @return the new layout definition as {@link String}
	 */
	protected String newLayoutDefinition()
	{
		String layoutDefinition = "(COLUMN " + "(ROW weight=0.8 " + "(COLUMN weight=0.25 "
			+ "(LEAF name=left.top weight=0.5) " + "(LEAF name=left.middle weight=0.5)" + ")"
			+ "(LEAF name=editor weight=0.75)" + ") " + "(LEAF name=bottom weight=0.2)" + ")";
		return layoutDefinition;
	}


	/**
	 *
	 * Factory method for creating the new {@link Dimension}. This method is invoked in the
	 * constructor from the derived classes and can be overridden so users can provide their own
	 * version of a {@link Dimension}
	 *
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 *
	 * @return the new {@link Dimension}
	 */
	protected Dimension newPreferredSize(int width, int height)
	{
		return DimensionFactory.newDimension(width, height);
	}

	protected MultiSplitLayout.Node newRootNode(String layoutDefinition)
	{
		return MultiSplitLayout.parseModel(layoutDefinition);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();

		multiSplitPane = newJXMultiSplitPane(newLayoutDefinition());
		int screenHeight = (int)(ScreenSizeExtensions.getScreenHeight() / 1.1d);
		int screenWidth = (int)(ScreenSizeExtensions.getScreenWidth() / 1.1d);
		setPreferredSize(newPreferredSize(screenWidth, screenHeight));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		setLayout(new BorderLayout());
		add(multiSplitPane, BorderLayout.CENTER);
	}

}
