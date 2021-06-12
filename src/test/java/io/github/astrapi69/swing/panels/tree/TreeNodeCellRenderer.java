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

import io.github.astrapi69.tree.TreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
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
