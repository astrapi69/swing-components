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
package de.alpharogroup.swing.treemodel.ifaces;

import java.util.List;

import javax.swing.tree.TreeModel;

/**
 * The Interface ITreeNode.
 *
 * @param <T>
 *            the generic type
 */
public interface ITreeNode<T> extends TreeModel
{
	/**
	 * Adds the child.
	 *
	 * @param child
	 *            the child
	 */
	void addChild(final ITreeNode<T> child);

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
	void addChildAt(final int index, final ITreeNode<T> child) throws IndexOutOfBoundsException;

	/**
	 * Equals.
	 *
	 * @param treeNode
	 *            the tree node
	 * @return true, if successful
	 */
	boolean equals(final ITreeNode<T> treeNode);

	/**
	 * Gets the child count.
	 *
	 * @return the child count
	 */
	int getChildCount();

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	List<ITreeNode<T>> getChildren();

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	T getValue();

	/**
	 * Checks for children.
	 *
	 * @return true, if successful
	 */
	boolean hasChildren();

	/**
	 * Checks if is leaf.
	 *
	 * @return true, if is leaf
	 */
	boolean isLeaf();

	/**
	 * Checks if is node.
	 *
	 * @return true, if is node
	 */
	boolean isNode();

	/**
	 * Removes the child.
	 *
	 * @param child
	 *            the child
	 */
	void removeChild(final ITreeNode<T> child);

	/**
	 * Removes the child.
	 *
	 * @param index
	 *            the index
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	void removeChildAt(final int index) throws IndexOutOfBoundsException;

	/**
	 * Sets the children.
	 *
	 * @param children
	 *            the new children
	 */
	void setChildren(final List<ITreeNode<T>> children);

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	void setValue(final T value);

	/**
	 * To list.
	 *
	 * @return the list
	 */
	List<ITreeNode<T>> toList();

	/**
	 * Traverse.
	 *
	 * @param node
	 *            the node
	 * @param list
	 *            the list
	 */
	void traverse(final ITreeNode<T> node, final List<ITreeNode<T>> list);

}
