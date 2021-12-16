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
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import lombok.Getter;

import org.jdesktop.swingx.JXTree;

import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.components.factories.DimensionFactory;
import io.github.astrapi69.swing.components.factories.SwingContainerFactory;
import io.github.astrapi69.swing.mouse.MouseDoubleClickListener;
import io.github.astrapi69.swing.tree.JTreeExtensions;


/**
 * The abstract class {@link JXTreePanel} provides a {@link JTree} that is already embedded in a
 * {@link JScrollPane}. Additionally it provides factory methods that can be overwritten to provide
 * specific behavior.
 *
 * @param <T>
 *            the generic type of the model object
 *
 * @deprecated use instead the same named class in project swing-tree-component<br>
 *             <br>
 *             Note: will be deleted in next minor version
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
		// if setEditable is set to true, tree element names are editable with double click
		tree.setEditable(false);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		tree.addMouseListener(new MouseDoubleClickListener()
		{
			@Override
			public void onSingleClick(MouseEvent mouseEvent)
			{
				int selRow = tree.getRowForLocation(mouseEvent.getX(), mouseEvent.getY());
				if (selRow != -1)
				{
					if (mouseEvent.getButton() == MouseEvent.BUTTON1)
					{
						onSingleLeftClick(mouseEvent);
					}
					if (mouseEvent.getButton() == MouseEvent.BUTTON2)
					{
						onSingleMiddleClick(mouseEvent);
					}
					if (mouseEvent.getButton() == MouseEvent.BUTTON3)
					{
						onSingleRightClick(mouseEvent);
					}
				}
			}

			@Override
			public void onDoubleClick(MouseEvent mouseEvent)
			{
				int selRow = tree.getRowForLocation(mouseEvent.getX(), mouseEvent.getY());
				if (selRow != -1)
				{
					if (mouseEvent.getButton() == MouseEvent.BUTTON1)
					{
						onDoubleLeftClick(mouseEvent);
					}
					if (mouseEvent.getButton() == MouseEvent.BUTTON2)
					{
						onDoubleMiddleClick(mouseEvent);
					}
					if (mouseEvent.getButton() == MouseEvent.BUTTON3)
					{
						onDoubleRightClick(mouseEvent);
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
		return SwingContainerFactory.newScrollPane();
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
	 * The callback method on double middle click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onDoubleMiddleClick(MouseEvent event)
	{
	}

	/**
	 * The callback method on double right click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onDoubleRightClick(MouseEvent event)
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
	 * The callback method on single middle click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onSingleMiddleClick(MouseEvent event)
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

	/**
	 * The callback method on add a new child tree node
	 */
	protected void onAddNewChildTreeNode()
	{
	}

	/**
	 * The callback method on copy an existing tree node
	 */
	protected void onCopySelectedTreeNode()
	{
	}

	/**
	 * The callback method on editing the selected tree node
	 */
	protected void onEditSelectedTreeNode()
	{
	}

	/**
	 * The callback method on expand the selected tree node
	 */
	protected void onExpandSelectedTreeNode()
	{
		JTreeExtensions.expandAll(tree, JTreeExtensions.getTreePath(getSelectedTreeNode()), true);
	}

	/**
	 * The callback method on collapse the selected tree node
	 */
	protected void onCollapseSelectedTreeNode()
	{
		JTreeExtensions.expandAll(tree, JTreeExtensions.getTreePath(getSelectedTreeNode()), false);
	}

	/**
	 * The callback method on delete the selected tree node
	 */
	protected void onDeleteSelectedTreeNode()
	{
		DefaultMutableTreeNode selectedTreeNode = getSelectedTreeNode();
		int selectedNodeIndex = selectedTreeNode.getParent().getIndex(selectedTreeNode);
		selectedTreeNode.removeAllChildren();
		((DefaultMutableTreeNode)selectedTreeNode.getParent()).remove(selectedNodeIndex);
		((DefaultTreeModel)tree.getModel()).reload(selectedTreeNode);
		tree.treeDidChange();
		tree.treeDidChange();
		this.repaint();
	}

	/**
	 * Gets the selected tree node
	 * 
	 * @return the selected tree node
	 */
	protected DefaultMutableTreeNode getSelectedTreeNode()
	{
		return JTreeExtensions.getSelectedTreeNode(tree);
	}
}
