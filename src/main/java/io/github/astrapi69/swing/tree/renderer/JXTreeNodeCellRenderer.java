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
package io.github.astrapi69.swing.tree.renderer;

import javax.swing.*;

import io.github.astrapi69.swing.icon.StringIcon;
import io.github.astrapi69.swing.img.ImageExtensions;
import org.apache.commons.lang3.StringUtils;

import io.github.astrapi69.swing.icon.ImageIconFactory;
import io.github.astrapi69.swing.panels.tree.JXTreeElement;
import io.github.astrapi69.tree.TreeNode;

public class JXTreeNodeCellRenderer extends TreeNodeCellRenderer<JXTreeElement>
{
	protected JLabel initialize(TreeNode<JXTreeElement> userObject)
	{
		TreeNode<JXTreeElement> treeNode = userObject;
		String displayValue = treeNode.getDisplayValue();
		JXTreeElement value = treeNode.getValue();
		String iconPath = value.getIconPath();
		if (StringUtils.isNotEmpty(iconPath))
		{
			Icon customTreeIcon;
			try{
				customTreeIcon = ImageIconFactory.newImageIcon(iconPath, 100, 20);
			} catch (Exception e){
				customTreeIcon = new StringIcon(treeLabel, iconPath);
			}
			treeLabel.setToolTipText(displayValue);
			treeLabel.setText("");
			treeLabel.setIcon(customTreeIcon);
			return treeLabel;
		} else {
			return super.initialize(userObject);
		}
	}
}