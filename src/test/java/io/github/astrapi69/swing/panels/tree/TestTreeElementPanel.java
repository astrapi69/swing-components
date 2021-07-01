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

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.tree.TreeElement;
import io.github.astrapi69.tree.TreeNode;
import io.github.astrapi69.tree.api.ITreeNode;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;

public class TestTreeElementPanel extends JTreePanel<TreeNode<TreeElement>>
{

	private static final long serialVersionUID = 1L;

	public TestTreeElementPanel()
	{
		this(BaseModel.<TreeNode<TreeElement>>of(new TreeNode<>()));
	}

	public TestTreeElementPanel(final Model<TreeNode<TreeElement>> model)
	{
		super(model);
	}

	@Override protected JTree newTree()
	{
		JTree tree = super.newTree();
		tree.setCellRenderer(new TreeNodeCellRenderer<TreeElement>());
		return tree;
	}

	@Override protected TreeModel newTreeModel(final Model<TreeNode<TreeElement>> model)
	{
		TreeNode<TreeElement> parentTreeNode = model.getObject();

		TreeModel treeModel = new TreeNodeModel(parentTreeNode);

		treeModel.addTreeModelListener(new TreeModelListener()
		{
			@Override public void treeNodesChanged(TreeModelEvent e)
			{
				Object lastPathComponent = e.getTreePath().getLastPathComponent();
				DefaultMutableTreeNode node;
				node = (DefaultMutableTreeNode)lastPathComponent;
				int index = e.getChildIndices()[0];
				node = (DefaultMutableTreeNode)(node.getChildAt(index));
			}

			@Override public void treeNodesInserted(TreeModelEvent e)
			{
			}

			@Override public void treeNodesRemoved(TreeModelEvent e)
			{
			}

			@Override public void treeStructureChanged(TreeModelEvent e)
			{
			}
		});
		return treeModel;
	}

	protected void onInitializeGroupLayout()
	{
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap()
					.addComponent(scrTree, javax.swing.GroupLayout.PREFERRED_SIZE, 384,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap()
					.addComponent(scrTree, javax.swing.GroupLayout.DEFAULT_SIZE, 536,
						Short.MAX_VALUE).addContainerGap()));
	}

	@Override protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		onInitializeGroupLayout();
	}

	@Override protected void onSingleClick(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());

		JPopupMenu popup = new JPopupMenu();
		JMenuItem addChild = new JMenuItem("add node...");
		addChild.addActionListener(le -> {
			JTextField textField1 = new JTextField();
			final JCheckBox checkBox = new JCheckBox();

			checkBox.addChangeListener(new ChangeListener()
			{
				@Override public void stateChanged(ChangeEvent e)
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
			Object[] inputFields = { "Enter name for node", textField1, "Is leaf", checkBox };

			int option = JOptionPane.showConfirmDialog(this, inputFields, "Multiple Inputs",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

			if (option == JOptionPane.OK_OPTION)
			{
				Object lastPathComponent = selectionPath.getLastPathComponent();
				TreeNode<TreeElement> selectedTreeNode = (TreeNode<TreeElement>)lastPathComponent;

				boolean allowsChildren = !checkBox.isSelected();
				String userObject = textField1.getText();

				TreeElement treeElement = TreeElement.builder().name(userObject)
					.node(allowsChildren).build();
				TreeNode<TreeElement> newEl = new TreeNode<>(treeElement);
				selectedTreeNode.addChild(newEl);
				tree.treeDidChange();
			}

		});
		popup.add(addChild);
		DefaultTreeModel model;
		JMenuItem deleteNode = new JMenuItem("delete");
		deleteNode.addActionListener(le -> {

			Object lastPathComponent = selectionPath.getLastPathComponent();
			TreeNode<TreeElement> selectedTreeNode = (TreeNode<TreeElement>)lastPathComponent;
			if(!selectedTreeNode.isRoot()) {
				ITreeNode<TreeElement> parent = selectedTreeNode.getParent();
				boolean remove = parent.getChildren().remove(selectedTreeNode);
				System.out.println(remove);
				TreeNode<TreeElement> root = (TreeNode<TreeElement>)parent.getRoot();
				TreeNodeModel<TreeElement> ntnm = new TreeNodeModel<TreeElement>(root);
				getTree().setModel(ntnm);

			} else {
				TestTreeElementPanel.this.setModelObject(null);
			}
			tree.treeDidChange();
			this.repaint();

		});
		popup.add(deleteNode);
		popup.show(tree, x, y);
	}
}
