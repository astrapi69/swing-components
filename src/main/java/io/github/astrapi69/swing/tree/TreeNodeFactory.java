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
package io.github.astrapi69.swing.tree;

import javax.swing.tree.DefaultMutableTreeNode;

import lombok.NonNull;
import io.github.astrapi69.swing.panels.tree.JXTreeElement;
import io.github.astrapi69.tree.TreeElement;
import io.github.astrapi69.tree.TreeNode;
import io.github.astrapi69.tree.api.ITreeNode;

/**
 * Factory class for generate {@link DefaultMutableTreeNode} from {@link TreeNode}
 *
 * @deprecated use instead the same named class in project swing-tree-component<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public class TreeNodeFactory
{

	/**
	 * Creates a new {@link DefaultMutableTreeNode} object from the given {@link TreeNode} object
	 * 
	 * @param treeNode
	 *            the {@link TreeNode} object
	 * @param <T>
	 *            the generic type of the given {@link TreeNode} object
	 * @return the new {@link DefaultMutableTreeNode} object generated from the given
	 *         {@link TreeNode} object
	 */
	public static <T> DefaultMutableTreeNode newDefaultMutableTreeNode(
		@NonNull TreeNode<T> treeNode)
	{
		TreeNode<T> rootNode = treeNode;
		if (!treeNode.isRoot())
		{
			rootNode = (TreeNode<T>)treeNode.getRoot();
		}
		DefaultMutableTreeNode rootDefaultMutableTreeNode = traverseAndAdd(null, rootNode);

		return rootDefaultMutableTreeNode;
	}

	/**
	 * Traverses through the given {@link TreeNode} object and return the root
	 * {@link DefaultMutableTreeNode} object
	 *
	 * @param rootDefaultMutableTreeNode
	 *            the {@link DefaultMutableTreeNode} object
	 * @param treeNode
	 *            the {@link TreeNode} object
	 * @param <T>
	 *            the generic type of the given {@link TreeNode} object
	 * @return the root {@link DefaultMutableTreeNode} object
	 */
	public static <T> DefaultMutableTreeNode traverseAndAdd(
		DefaultMutableTreeNode rootDefaultMutableTreeNode, @NonNull TreeNode<T> treeNode)
	{
		DefaultMutableTreeNode parent = rootDefaultMutableTreeNode;
		if (rootDefaultMutableTreeNode == null)
		{
			parent = newDefaultMutableTreeNode(null, treeNode);
		}
		for (final ITreeNode<T> data : treeNode.getChildren())
		{
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(data);
			parent.add(node);
			traverseAndAdd(node, (TreeNode<TreeElement>)data);
		}
		return parent;
	}

	/**
	 * Factory method that creates a new {@link DefaultMutableTreeNode} object
	 *
	 * @param parent
	 *            the parent {@link DefaultMutableTreeNode} object
	 * @param userObject
	 *            the user object
	 * @param <T>
	 *            the generic type of the given user object
	 * @return the new {@link DefaultMutableTreeNode} object
	 */
	public static <T> DefaultMutableTreeNode newDefaultMutableTreeNode(
		DefaultMutableTreeNode parent, T userObject)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(userObject);
		if (parent != null)
		{
			parent.add(node);
		}
		return node;
	}

	/**
	 * Factory method that creates a new {@link TreeNode} object from the given {@link TreeElement}
	 * object
	 *
	 * @param treeElement
	 *            the {@link TreeElement} object
	 * @param parentTreeNode
	 *            the parent object
	 * @return the new {@link TreeNode} object
	 */
	public static TreeNode<TreeElement> initializeTreeNodeWithTreeElement(
		final TreeElement treeElement, TreeNode<TreeElement> parentTreeNode)
	{
		TreeNode<TreeElement> treeNode;
		treeNode = new TreeNode<TreeElement>(treeElement)
		{
			@Override
			public boolean isNode()
			{
				return treeElement.isNode();
			}
		};
		treeNode.setDisplayValue(treeElement.getName());
		if (parentTreeNode != null)
		{
			parentTreeNode.addChild(treeNode);
		}
		return treeNode;
	}

	/**
	 * Factory method that creates a new {@link TreeNode} object from the given {@link TreeElement}
	 * object
	 *
	 * @param treeElement
	 *            the {@link TreeElement} object
	 * @param parentTreeNode
	 *            the parent object
	 * @return the new {@link TreeNode} object
	 */
	public static TreeNode<JXTreeElement> initializeTreeNodeWithTreeElement(
		final JXTreeElement treeElement, TreeNode<JXTreeElement> parentTreeNode)
	{
		TreeNode<JXTreeElement> treeNode;
		treeNode = new TreeNode<JXTreeElement>(treeElement)
		{
			@Override
			public boolean isNode()
			{
				return treeElement.isNode();
			}
		};
		treeNode.setDisplayValue(treeElement.getName());
		if (parentTreeNode != null)
		{
			parentTreeNode.addChild(treeNode);
		}
		return treeNode;
	}

}
