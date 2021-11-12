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
package io.github.astrapi69.swing.panels.tree;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import lombok.Getter;

import org.jdesktop.swingx.JXTree;

import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.components.factories.DimensionFactory;


/**
 * The abstract class {@link JXTreePanel} provides a {@link JTree} that is already embedded in a
 * {@link JScrollPane}. Additionally it provides factory methods that can be overwritten to provide
 * specific behavior.
 *
 * @param <T>
 *            the generic type of the model object
 */
@Getter
public abstract class JXTreePanel<T> extends BasePanel<T>
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The {@link JScrollPane} for the decorated {@link JTree}. */
	protected JScrollPane scrTree;

	/** The decorated {@link JTree}. */
	protected JTree tree;

	/**
	 * Instantiates a new {@link JXTreePanel} object.
	 */
	public JXTreePanel()
	{
	}

	/**
	 * Instantiates a new new {@link JXTreePanel} object.
	 *
	 * @param model
	 *            the model
	 */
	public JXTreePanel(final Model<T> model)
	{
		super(model);
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

	/**
	 * New tree.
	 *
	 * @return the j tree
	 */
	protected JXTree newTree()
	{
		JXTree tree = new JXTree();

		tree.setModel(newTreeModel(getModel()));
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		tree.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				int selRow = tree.getRowForLocation(e.getX(), e.getY());
				int clickCount = e.getClickCount();

				if (selRow != -1)
				{
					// handle right clicks
					if (e.isPopupTrigger())
					{
						if (clickCount == 1)
						{
							onSingleRightClick(e);
						}
					}
					// handle left clicks
					if (!e.isPopupTrigger())
					{
						if (clickCount == 1)
						{
							onSingleLeftClick(e);
						}
						else if (clickCount == 2)
						{
							onDoubleLeftClick(e);
						}

					}
				}
			}
		});

		return tree;
	}

	/**
	 * Abstract factory callback method that have to be overwritten to provide the specific
	 * {@link TreeModel} for the {@link JTree}
	 *
	 * @param model
	 *            the model
	 * @return the tree model
	 */
	protected abstract TreeModel newTreeModel(final Model<T> model);

	/**
	 * Factory method for creating the new {@link JScrollPane}. This method is invoked in the
	 * constructor from the derived classes and can be overridden so users can provide their own
	 * version of a {@link JScrollPane}
	 *
	 * @return the new {@link JScrollPane}
	 */
	protected JScrollPane newTreeScrollPane()
	{
		JScrollPane scrDbTree = new JScrollPane();
		return scrDbTree;
	}

	/**
	 * The callback method on double left click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onDoubleLeftClick(MouseEvent event)
	{
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();

		scrTree = newTreeScrollPane();
		tree = newTree();

		setPreferredSize(newPreferredSize(420, 560));
		scrTree.setViewportView(tree);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
	}

	/**
	 * The callback method on single left click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onSingleLeftClick(MouseEvent event)
	{
	}

	/**
	 * The callback method on single right click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onSingleRightClick(MouseEvent event)
	{
	}

}
