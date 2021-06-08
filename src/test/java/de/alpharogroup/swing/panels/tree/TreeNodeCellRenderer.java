package de.alpharogroup.swing.panels.tree;

import de.alpharogroup.file.system.SystemFileExtensions;
import io.github.astrapi69.tree.TreeNode;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class TreeNodeCellRenderer<T> extends DefaultTreeCellRenderer
{
	JLabel c = new JLabel("init-renderer");
	private final DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
	@Override public Component getTreeCellRendererComponent(JTree tree, Object value,
		boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		if (value instanceof TreeNode) {
			TreeNode<T> treeNode = (TreeNode<T>)value;
			c.setText(treeNode.getDisplayValue());
			if(leaf) {
				c.setIcon(renderer.getLeafIcon());
			} else {
				c.setIcon(renderer.getOpenIcon());
			}
			return c;
		}
		return renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
	}
}
