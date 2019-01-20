package de.alpharogroup.swing.tree;

import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import lombok.NonNull;

/**
 * The class {@link JTreeExtensions}.
 */
public class JTreeExtensions
{

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
	public static void expandAll(JTree tree, TreePath path, boolean expand)
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
}
