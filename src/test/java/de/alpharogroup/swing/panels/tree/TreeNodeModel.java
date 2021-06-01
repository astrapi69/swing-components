package de.alpharogroup.swing.panels.tree;

import de.alpharogroup.tree.TreeNode;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class TreeNodeModel<T> implements TreeModel
{
	protected TreeNode<T> root;

	public TreeNodeModel(TreeNode<T> root)
	{
		this.root = root;
	}

	public Object getRoot()
	{
		return root;
	}

	public boolean isLeaf(Object node)
	{
		return ((TreeNode)node).isLeaf();
	}

	public int getChildCount(Object parent)
	{
		return ((TreeNode)parent).getChildCount();
	}

	public Object getChild(Object parent, int index)
	{
		return ((TreeNode)parent).getChildren().get(index);
	}

	public int getIndexOfChild(Object parent, Object child)
	{
		return ((TreeNode)parent).getChildren().indexOf(child);
	}

	public void valueForPathChanged(TreePath path, Object newvalue)
	{
	}

	public void addTreeModelListener(TreeModelListener l)
	{
	}

	public void removeTreeModelListener(TreeModelListener l)
	{
	}
}
