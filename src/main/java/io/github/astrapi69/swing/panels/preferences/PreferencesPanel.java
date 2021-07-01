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
package io.github.astrapi69.swing.panels.preferences;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.components.factories.JComponentFactory;

public abstract class PreferencesPanel<T> extends BasePanel<T>
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The {@link JScrollPane} for the {@link JTree}. */
	protected JScrollPane scrTree;

	/**
	 * The {@link JSplitPane} for the tree in the left side and the corresponding value at teh right
	 * side.
	 */
	protected JSplitPane splitPane;

	/** The {@link JTree}. */
	protected JTree tree;

	protected TreeModel treeModel;

	/**
	 * Instantiates a new {@link PreferencesPanel} object panel
	 *
	 * @param model
	 *            the model
	 */
	public PreferencesPanel(final Model<T> model)
	{
		super(model);
	}

	protected void addTreeComponent(final String title, final Component c)
	{
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)treeModel.getRoot();
		root.add(new ComponentTreeNode(title, c));
	}

	protected Component getSelectedComponent()
	{
		Object o = tree.getLastSelectedPathComponent();
		if (o instanceof ComponentTreeNode)
		{
			return ((ComponentTreeNode)o).getComponent();
		}
		else
		{
			return null;
		}

	}

	protected JSplitPane newJSplitPane()
	{
		return JComponentFactory.newJSplitPane(scrTree, null);
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
		return new Dimension(width, height);
	}

	protected JTree newTree()
	{
		treeModel = newTreeModel(getModel());

		DefaultMutableTreeNode root = (DefaultMutableTreeNode)treeModel.getRoot();
		JTree tree = new JTree(root);
		tree.setEditable(false);

		tree.addTreeSelectionListener(new TreeSelectionListener()
		{
			@Override
			public void valueChanged(TreeSelectionEvent e)
			{
				splitPane.setRightComponent(PreferencesPanel.this.getSelectedComponent());
			}
		});

		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);


		tree.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				int selRow = tree.getRowForLocation(e.getX(), e.getY());
				if (selRow != -1)
				{
					if (e.getClickCount() == 1)
					{
						onSingleClick(e);
					}
					else if (e.getClickCount() == 2)
					{
						onDoubleClick(e);
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
	 * The callback method on double click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onDoubleClick(MouseEvent event)
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

		splitPane = newJSplitPane();
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
	 * The callback method on single click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onSingleClick(MouseEvent event)
	{
	}


}
