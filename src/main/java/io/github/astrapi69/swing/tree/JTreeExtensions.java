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

import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import lombok.NonNull;

/**
 * The class {@link JTreeExtensions}.
 */
public class JTreeExtensions
{

	/**
	 * Gets the selected tree node as {@link DefaultMutableTreeNode} object
	 * 
	 * @param mouseEvent
	 *            the mouse event
	 * @param tree
	 *            the tree
	 * @return the selected tree node
	 */
	public static DefaultMutableTreeNode getSelectedDefaultMutableTreeNode(
		@NonNull MouseEvent mouseEvent, @NonNull JTree tree)
	{
		TreePath selectionPath = tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
		assert selectionPath != null;
		Object lastPathComponent = selectionPath.getLastPathComponent();
		return (DefaultMutableTreeNode)lastPathComponent;
	}

	/**
	 * Expand all nodes recursive
	 *
	 * @param tree
	 *            the tree
	 * @param path
	 *            the path
	 * @param expand
	 *            the flag to expand or collapse
	 */
	public static void expandAll(@NonNull JTree tree, @NonNull TreePath path, boolean expand)
	{
		TreeNode node = (TreeNode)path.getLastPathComponent();

		if (node.getChildCount() >= 0)
		{
			Enumeration<?> enumeration = node.children();
			while (enumeration.hasMoreElements())
			{
				TreeNode n = (TreeNode)enumeration.nextElement();
				TreePath p = path.pathByAddingChild(n);

				expandAll(tree, p, expand);
			}
		}

		if (expand)
		{
			tree.expandPath(path);
		}
		else
		{
			tree.collapsePath(path);
		}
	}

	/**
	 * Expand all nodes but non-recursive
	 *
	 * @param tree
	 *            the tree
	 */
	public static void expandNodes(@NonNull JTree tree)
	{
		for (int i = 0; i < tree.getRowCount(); i++)
		{
			tree.expandRow(i);
		}
	}

}
