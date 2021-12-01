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

import io.github.astrapi69.swing.tree.JTreeExtensions;
import org.jdesktop.swingx.JXTree;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.dialog.JOptionPaneExtensions;
import io.github.astrapi69.swing.listener.RequestFocusListener;
import io.github.astrapi69.swing.tree.TreeNodeFactory;
import io.github.astrapi69.swing.tree.renderer.JXTreeNodeCellRenderer;
import io.github.astrapi69.tree.TreeNode;

public class TreeNodeJXTreeElementPanelTest extends TreeNodeJXTreeElementPanel
{

	private static final long serialVersionUID = 1L;

	public TreeNodeJXTreeElementPanelTest()
	{
		this(BaseModel.of(new TreeNode<>()));
	}

	public TreeNodeJXTreeElementPanelTest(final Model<TreeNode<JXTreeElement>> model)
	{
		super(model);
	}

	@Override
	protected JXTree newTree()
	{
		JXTree tree = super.newTree();
		tree.setCellRenderer(new JXTreeNodeCellRenderer());
		return tree;
	}

	@Override
	protected TreeModel newTreeModel(final Model<TreeNode<JXTreeElement>> model)
	{
		TreeNode<JXTreeElement> parentTreeNode = model.getObject();
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
				Object lastPathComponent = e.getTreePath().getLastPathComponent();
				DefaultMutableTreeNode node;
				node = (DefaultMutableTreeNode)lastPathComponent;
				System.err.println(node);
			}

			@Override
			public void treeNodesRemoved(TreeModelEvent e)
			{
				Object lastPathComponent = e.getTreePath().getLastPathComponent();
				DefaultMutableTreeNode node;
				node = (DefaultMutableTreeNode)lastPathComponent;
				System.err.println(node);
			}

			@Override
			public void treeStructureChanged(TreeModelEvent e)
			{
				Object lastPathComponent = e.getTreePath().getLastPathComponent();
				DefaultMutableTreeNode node;
				node = (DefaultMutableTreeNode)lastPathComponent;
				System.err.println(node);
			}
		});
		return treeModel;
	}

	@Override
	protected void onSingleRightClick(MouseEvent mouseEvent)
	{
		int x = mouseEvent.getX();
		int y = mouseEvent.getY();
		TreePath selectionPath = tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
		tree.getSelectionModel().setSelectionPath(selectionPath);

		Object lastPathComponent = selectionPath.getLastPathComponent();
		DefaultMutableTreeNode selectedTreeNode = (DefaultMutableTreeNode)lastPathComponent;
		TreeNode<JXTreeElement> parentTreeNode = (TreeNode<JXTreeElement>)selectedTreeNode
			.getUserObject();

		JPopupMenu popup = new JPopupMenu();
		if (parentTreeNode.isNode())
		{
			JMenuItem menuItemAddChild = new JMenuItem("add node...");
			menuItemAddChild.addActionListener(
				actionEvent -> this.onAddNewChildTreeNode());
			popup.add(menuItemAddChild);
		}

		if (!parentTreeNode.isRoot())
		{
			JMenuItem deleteNode = new JMenuItem("delete");
			deleteNode.addActionListener(
				actionEvent -> this.onDeleteSelectedTreeNode());
			popup.add(deleteNode);
		}

		JMenuItem menuItemEdit = new JMenuItem("Edit node...");
		menuItemEdit.addActionListener(
			actionEvent -> this.onEditSelectedTreeNode());
		popup.add(menuItemEdit);

		JMenuItem menuItemCopy = new JMenuItem("Copy node");
		menuItemCopy.addActionListener(
			actionEvent -> this.onCopySelectedTreeNode());
		popup.add(menuItemCopy);

		JMenuItem menuItemCollapse = new JMenuItem("Collapse node");
		menuItemCollapse.addActionListener(
			actionEvent -> this.onCollapseSelectedTreeNode());
		popup.add(menuItemCollapse);

		JMenuItem menuItemExpand = new JMenuItem("Expand node");
		menuItemExpand.addActionListener(
			actionEvent -> this.onExpandSelectedTreeNode());
		popup.add(menuItemExpand);

		popup.show(tree, x, y);
	}

	protected void onAddNewChildTreeNode()
	{
		DefaultMutableTreeNode selectedTreeNode = getSelectedTreeNode();
		TreeNode<JXTreeElement> parentTreeNode = (TreeNode<JXTreeElement>)selectedTreeNode
			.getUserObject();
		JTextField textField1 = new JTextField();
		final JCheckBox checkBox = new JCheckBox();

		checkBox.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent changeEvent)
			{
				if (changeEvent.getSource() == checkBox)
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
			boolean allowsChildren = !checkBox.isSelected();
			String userObject = textField1.getText();
			JXTreeElement treeElement = JXTreeElement.builder().name(userObject)
				.parent(parentTreeNode.getValue()).node(allowsChildren).build();
			TreeNode<JXTreeElement> newTreeNode = TreeNode.<JXTreeElement> builder()
				.value(treeElement).parent(parentTreeNode).displayValue(userObject)
				.node(allowsChildren).build();

			DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(newTreeNode,
				allowsChildren);
			selectedTreeNode.add(newChild);
			((DefaultTreeModel)tree.getModel()).reload(selectedTreeNode);
			tree.treeDidChange();
		}
	}

	protected void onCopySelectedTreeNode()
	{
		System.out.println("onCopySelectedTreeNode");
	}

	protected void onEditSelectedTreeNode()
	{
		System.out.println("onEditSelectedTreeNode");
	}

}
