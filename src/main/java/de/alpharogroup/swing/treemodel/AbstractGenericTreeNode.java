/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
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
package de.alpharogroup.swing.treemodel;

import java.util.ArrayList;
import java.util.List;

import de.alpharogroup.swing.treemodel.ifaces.ITreeNode;

public abstract class AbstractGenericTreeNode<T> implements ITreeNode<T>
{

	/**
	 * The serialVersionUID.
	 */

	/** The children. */
	private List<ITreeNode<T>> children;

	/** The value. */
	private T value;

	/**
	 * Instantiates a new tree node.
	 */
	public AbstractGenericTreeNode()
	{
		super();
	}

	/**
	 * Instantiates a new tree node.
	 *
	 * @param value
	 *            the value
	 */
	public AbstractGenericTreeNode(final T value)
	{
		this();
		setValue(value);
	}

	/**
	 * Adds the child.
	 *
	 * @param child
	 *            the child
	 */
	@Override
	public void addChild(final ITreeNode<T> child)
	{
		if (children != null)
		{
			children.add(child);
		}
		else
		{
			children = new ArrayList<>();
			children.add(child);
		}

	}

	/**
	 * Adds the child.
	 *
	 * @param index
	 *            the index
	 * @param child
	 *            the child
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	@Override
	public void addChildAt(final int index, final ITreeNode<T> child)
		throws IndexOutOfBoundsException
	{
		if (children != null && children.size() < index)
		{
			children.add(index, child);
		}
		else
		{
			addChild(child);
		}
	}

	/**
	 * Equals.
	 *
	 * @param treeNode
	 *            the tree node
	 * @return true, if successful
	 */
	@Override
	public boolean equals(final ITreeNode<T> treeNode)
	{
		return treeNode.getValue().equals(treeNode);
	}

	/**
	 * Gets the child count.
	 *
	 * @return the child count
	 */
	@Override
	public int getChildCount()
	{
		if (children == null)
		{
			return 0;
		}
		return children.size();

	}

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	@Override
	public List<ITreeNode<T>> getChildren()
	{
		if (this.children == null)
		{
			return new ArrayList<>();
		}
		return this.children;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public T getValue()
	{
		return value;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @return true, if successful
	 * @see de.alpharogroup.swing.treemodel.ifaces.ITreeNode#hasChildren()
	 */
	@Override
	public boolean hasChildren()
	{
		return getChildren() != null && !getChildren().isEmpty();
	}

	/**
	 * (non-Javadoc).
	 *
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (children == null ? 0 : children.hashCode());
		result = prime * result + (value == null ? 0 : value.hashCode());
		return result;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @return true, if is leaf
	 * @see de.alpharogroup.swing.treemodel.ifaces.ITreeNode#isLeaf()
	 */
	@Override
	public boolean isLeaf()
	{
		return !isNode();
	}

	/**
	 * (non-Javadoc).
	 *
	 * @return true, if is node
	 * @see de.alpharogroup.swing.treemodel.ifaces.ITreeNode#isNode()
	 */
	@Override
	public boolean isNode()
	{
		return true;
	}

	/**
	 * Removes the child.
	 *
	 * @param child
	 *            the child
	 */
	@Override
	public void removeChild(final ITreeNode<T> child)
	{
		if (children != null)
		{
			children.remove(child);
		}
		else
		{
			children = new ArrayList<>();
		}

	}

	/**
	 * Removes the child.
	 *
	 * @param index
	 *            the index
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	@Override
	public void removeChildAt(final int index) throws IndexOutOfBoundsException
	{
		children.remove(index);
	}

	/**
	 * Sets the children.
	 *
	 * @param children
	 *            the new children
	 */
	@Override
	public void setChildren(final List<ITreeNode<T>> children)
	{
		this.children = children;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	@Override
	public void setValue(final T value)
	{
		this.value = value;
	}

	/**
	 * To list.
	 *
	 * @return the list
	 */
	@Override
	public List<ITreeNode<T>> toList()
	{
		final List<ITreeNode<T>> list = new ArrayList<>();
		traverse(this, list);
		return list;
	}

	/**
	 * Traverse.
	 *
	 * @param node
	 *            the node
	 * @param list
	 *            the list
	 */
	@Override
	public void traverse(final ITreeNode<T> node, final List<ITreeNode<T>> list)
	{
		list.add(node);
		for (final ITreeNode<T> data : node.getChildren())
		{
			traverse(data, list);
		}
	}

}
