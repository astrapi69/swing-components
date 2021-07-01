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

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import io.github.astrapi69.tree.TreeNode;
import io.github.astrapi69.tree.api.ITreeNode;

public class TreeNodeModel<T> implements TreeModel
{
	protected TreeNode<T> root;
	/** Listeners. */
	protected EventListenerList listenerList = new EventListenerList();

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

	public void reload()
	{
		reload(root);
	}

	public void reload(TreeNode node)
	{
		if (node != null)
		{
			fireTreeStructureChanged(this, node.toList().toArray(new ITreeNode[0]), null, null);
		}
	}

	protected void fireTreeStructureChanged(Object source, Object[] path, int[] childIndices,
		Object[] children)
	{
		// Guaranteed to return a non-null array
		Object[] listeners = listenerList.getListenerList();
		TreeModelEvent e = null;
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length - 2; i >= 0; i -= 2)
		{
			if (listeners[i] == TreeModelListener.class)
			{
				// Lazily create the event:
				if (e == null)
					e = new TreeModelEvent(source, path, childIndices, children);
				((TreeModelListener)listeners[i + 1]).treeStructureChanged(e);
			}
		}
	}
}
