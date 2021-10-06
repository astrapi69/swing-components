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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import io.github.astrapi69.swing.tree.TreeNodeFactory;
import org.jdesktop.swingx.JXTree;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.dialog.JOptionPaneExtensions;
import io.github.astrapi69.swing.listener.RequestFocusListener;
import io.github.astrapi69.swing.tree.renderer.TreeNodeCellRenderer;
import io.github.astrapi69.tree.TreeElement;
import io.github.astrapi69.tree.TreeNode;

public class TestTreeElementPanel extends TreeElementPanel
{

	private static final long serialVersionUID = 1L;

	public TestTreeElementPanel()
	{
		this(BaseModel.of(new TreeNode<>()));
	}

	public TestTreeElementPanel(final Model<TreeNode<TreeElement>> model)
	{
		super(model);
	}

	@Override
	protected JXTree newTree()
	{
		JXTree tree = super.newTree();
		tree.setCellRenderer(new TreeNodeCellRenderer<TreeElement>());
		return tree;
	}

	@Override
	protected TreeModel newTreeModel(final Model<TreeNode<TreeElement>> model)
	{
		TreeNode<TreeElement> parentTreeNode = model.getObject();
		TreeModel treeModel;

		// treeModel = new TreeNodeModel(parentTreeNode);

		DefaultMutableTreeNode rootNode = TreeNodeFactory.newDefaultMutableTreeNode(parentTreeNode);

		treeModel = new DefaultTreeModel(rootNode, true);

		treeModel.addTreeModelListener(new TreeModelListener()
		{
			@Override
			public void treeNodesChanged(TreeModelEvent e)
			{
				Object lastPathComponent = e.getTreePath().getLastPathComponent();
				DefaultMutableTreeNode node;
				node = (DefaultMutableTreeNode)lastPathComponent;
				int index = e.getChildIndices()[0];
				node = (DefaultMutableTreeNode)(node.getChildAt(index));


			}

			@Override
			public void treeNodesInserted(TreeModelEvent e)
			{
			}

			@Override
			public void treeNodesRemoved(TreeModelEvent e)
			{
			}

			@Override
			public void treeStructureChanged(TreeModelEvent e)
			{
			}
		});
		return treeModel;
	}

	@Override
	protected void onSingleClick(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());
		TreeSelectionModel selectionModel = tree.getSelectionModel();
		JPopupMenu popup = new JPopupMenu();
		JMenuItem addChild = new JMenuItem("add node...");
		addChild.addActionListener(le -> {
			JTextField textField1 = new JTextField();
			final JCheckBox checkBox = new JCheckBox();

			checkBox.addChangeListener(new ChangeListener()
			{
				@Override
				public void stateChanged(ChangeEvent e)
				{
					if (e.getSource() == checkBox)
					{
						if (checkBox.isSelected())
						{

						}
						else
						{

						}
					}
				}
			});
			// Object[] inputFields = { "Enter name for node", textField1, "Is leaf", checkBox };
			//
			// int option = JOptionPane.showConfirmDialog(this, inputFields, "Multiple Inputs",
			// JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

			JPanel panel = new JPanel(new GridLayout(2, 2));
			panel.add(new JLabel("Enter name for node:"));
			panel.add(textField1);
			panel.add(new JLabel("Is leaf:"));
			panel.add(checkBox);

			JOptionPane pane = new JOptionPane(panel, JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION);
			JDialog dialog = pane.createDialog(null, "New node");
			dialog.addWindowFocusListener(new RequestFocusListener(textField1));
			dialog.pack();
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
			int option = JOptionPaneExtensions.getSelectedOption(pane);

			if (option == JOptionPane.OK_OPTION)
			{
				Object lastPathComponent = selectionPath.getLastPathComponent();
				DefaultMutableTreeNode selectedTreeNode = (DefaultMutableTreeNode)lastPathComponent;

				boolean allowsChildren = !checkBox.isSelected();
				String userObject = textField1.getText();
				TreeNode<TreeElement> parentTreeNode = (TreeNode<TreeElement>)selectedTreeNode
					.getUserObject();
				TreeElement treeElement = TreeElement.builder().name(userObject)
					.parent(parentTreeNode.getValue())
					.node(allowsChildren).build();
				TreeNode<TreeElement> newTreeNode = TreeNode.<TreeElement> builder()
					.value(treeElement).parent(parentTreeNode).displayValue(userObject)
					.node(allowsChildren).build();
				new TreeNode<>(treeElement);
				DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(newTreeNode,
					allowsChildren);
				selectedTreeNode.add(newChild);
				((DefaultTreeModel)tree.getModel()).reload(selectedTreeNode);
				tree.treeDidChange();
			}

		});
		popup.add(addChild);
		DefaultTreeModel model;
		JMenuItem deleteNode = new JMenuItem("delete");
		deleteNode.addActionListener(le -> {

			DefaultMutableTreeNode selectedPathComponent = (DefaultMutableTreeNode)selectionPath
				.getLastPathComponent();

			if (!selectedPathComponent.isRoot())
			{
				int selectedNodeIndex = selectedPathComponent.getParent()
					.getIndex(selectedPathComponent);
				selectedPathComponent.removeAllChildren();
				((DefaultMutableTreeNode)selectedPathComponent.getParent())
					.remove(selectedNodeIndex);
				((DefaultTreeModel)tree.getModel()).reload(selectedPathComponent);
				tree.treeDidChange();
			}
			else
			{
				TestTreeElementPanel.this.setModelObject(null);
			}
			tree.treeDidChange();
			this.repaint();

		});
		popup.add(deleteNode);
		popup.show(tree, x, y);
	}
}
