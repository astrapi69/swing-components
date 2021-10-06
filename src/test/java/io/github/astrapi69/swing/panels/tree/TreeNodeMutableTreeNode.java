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

import java.io.Serializable;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.MutableTreeNode;

import io.github.astrapi69.tree.TreeNode;
import io.github.astrapi69.tree.api.ITreeNode;

public class TreeNodeMutableTreeNode<T> implements Cloneable, MutableTreeNode, Serializable
{
	protected TreeNode<T> userObject;

	protected MutableTreeNode parent;

	protected Vector children;

	/** Listeners. */
	protected EventListenerList listenerList = new EventListenerList();

	public TreeNodeMutableTreeNode(TreeNode<T> root)
	{
		this.userObject = root;
	}

	public Object getRoot()
	{
		return userObject.getRoot();
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

	public void reload()
	{
		reload(userObject);
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

	/**
	 * Adds <code>child</code> to the receiver at <code>index</code>. <code>child</code> will be
	 * messaged with <code>setParent</code>.
	 *
	 * @param child
	 * @param index
	 */
	@Override
	public void insert(MutableTreeNode child, int index)
	{
		if (child == null)
		{
			throw new IllegalArgumentException("given node is null");
		}
		else if (isNodeAncestor(child))
		{
			throw new IllegalArgumentException("given node is an ancestor");
		}

		MutableTreeNode oldParent = (MutableTreeNode)child.getParent();

		if (oldParent != null)
		{
			oldParent.remove(child);
		}
		child.setParent(this);
		if (children == null)
		{
			children = new Vector();
		}
		children.insertElementAt(child, index);
	}


	public boolean isNodeAncestor(javax.swing.tree.TreeNode anotherNode)
	{
		if (anotherNode == null)
		{
			return false;
		}

		javax.swing.tree.TreeNode ancestor = this;

		do
		{
			if (ancestor == anotherNode)
			{
				return true;
			}
		}
		while ((ancestor = ancestor.getParent()) != null);

		return false;
	}

	/**
	 * Removes the child at <code>index</code> from the receiver.
	 *
	 * @param index
	 */
	@Override
	public void remove(int index)
	{
		MutableTreeNode child = (MutableTreeNode)getChildAt(index);
		children.removeElementAt(index);
		child.setParent(null);
	}

	/**
	 * Removes <code>node</code> from the receiver. <code>setParent</code> will be messaged on
	 * <code>node</code>.
	 *
	 * @param node
	 */
	@Override
	public void remove(MutableTreeNode node)
	{
		if (node == null)
		{
			throw new IllegalArgumentException("given node is null");
		}

		if (!isNodeChild(node))
		{
			throw new IllegalArgumentException("given node is not a child");
		}
		remove(getIndex(node));
	}

	public boolean isNodeChild(javax.swing.tree.TreeNode node)
	{
		boolean nodeChild;

		if (node == null)
		{
			nodeChild = false;
		}
		else
		{
			if (getChildCount() == 0)
			{
				nodeChild = false;
			}
			else
			{
				nodeChild = (node.getParent() == this);
			}
		}

		return nodeChild;
	}

	/**
	 * Resets the user object of the receiver to <code>object</code>.
	 *
	 * @param object
	 */
	@Override
	public void setUserObject(Object object)
	{
		this.userObject = userObject;
	}

	/**
	 * Removes the receiver from its parent.
	 */
	@Override
	public void removeFromParent()
	{
		MutableTreeNode parent = (MutableTreeNode)getParent();
		if (parent != null)
		{
			parent.remove(this);
		}
	}

	/**
	 * Returns the child <code>TreeNode</code> at index <code>childIndex</code>.
	 *
	 * @param childIndex
	 */
	@Override
	public javax.swing.tree.TreeNode getChildAt(int childIndex)
	{
		if (children == null)
		{
			throw new ArrayIndexOutOfBoundsException("children list is null");
		}
		return (javax.swing.tree.TreeNode)children.elementAt(childIndex);
	}

	/**
	 * Returns the number of children <code>TreeNode</code>s the receiver contains.
	 */
	@Override
	public int getChildCount()
	{
		return children == null ? 0 : children.size();
	}

	/**
	 * Returns the parent <code>TreeNode</code> of the receiver.
	 */
	@Override
	public javax.swing.tree.TreeNode getParent()
	{
		return parent;
	}

	/**
	 * Sets the parent of the receiver to <code>newParent</code>.
	 *
	 * @param newParent
	 */
	@Override
	public void setParent(MutableTreeNode newParent)
	{
		this.parent = newParent;
	}

	/**
	 * Returns the index of <code>node</code> in the receivers children. If the receiver does not
	 * contain <code>node</code>, -1 will be returned.
	 *
	 * @param node
	 */
	@Override
	public int getIndex(javax.swing.tree.TreeNode node)
	{
		if (node == null)
		{
			throw new IllegalArgumentException("given node is null");
		}

		if (!isNodeChild(node))
		{
			return -1;
		}
		return children.indexOf(node);
	}

	/**
	 * Returns true if the receiver allows children.
	 */
	@Override
	public boolean getAllowsChildren()
	{
		return true;
	}

	/**
	 * Returns true if the receiver is a leaf.
	 */
	@Override
	public boolean isLeaf()
	{
		return (getChildCount() == 0);
	}

	/**
	 * Returns the children of the receiver as an <code>Enumeration</code>.
	 */
	@Override
	public Enumeration children()
	{
		if (children == null)
		{
			return Collections.emptyEnumeration();
		}
		else
		{
			return children.elements();
		}
	}
}
