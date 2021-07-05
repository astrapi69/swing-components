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

import java.awt.*;
import java.util.List;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.tree.TreeElement;
import io.github.astrapi69.tree.TreeNode;
import io.github.astrapi69.window.adapter.CloseWindow;

/**
 * The test class for {@link JTreePanel}
 */
public class JTreePanelTest
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		final Frame frame = new Frame("JTreePanel");
		frame.addWindowListener(new CloseWindow());
		Model<TreeNode<TreeElement>> parentModel = BaseModel.of(initializeTestTreeNodeElement());
		frame.add(new TestTreeElementPanel(parentModel));
		frame.pack();
		frame.setVisible(true);
	}

	public static TreeNode<TreeElement> initializeTestTreeNodeElement()
	{
		TreeElement firstChild;
		TreeNode<TreeElement> firstChildTreeNode;
		TreeElement firstGrandChild;
		TreeNode<TreeElement> firstGrandChildTreeNode;
		TreeElement firstGrandGrandChild;
		TreeNode<TreeElement> firstGrandGrandChildTreeNode;
		List<TreeNode<TreeElement>> list;
		TreeElement parent;
		TreeNode<TreeElement> parentTreeNode;
		TreeElement secondChild;
		TreeNode<TreeElement> secondChildTreeNode;
		parent = TreeElement.builder().name("parent").parent(null).node(false).build();
		firstChild = TreeElement.builder().name("firstChild").parent(parent).node(false).build();
		firstGrandChild = TreeElement.builder().name("firstGrandChild").parent(firstChild)
			.node(true).build();
		firstGrandGrandChild = TreeElement.builder().name("firstGrandGrandChild")
			.parent(firstGrandChild).node(true).build();
		secondChild = TreeElement.builder().name("secondChild").parent(parent).node(true).build();

		parentTreeNode = initializeTreeNodeWithTreeElement(parent, null);

		firstChildTreeNode = initializeTreeNodeWithTreeElement(firstChild, parentTreeNode);

		secondChildTreeNode = initializeTreeNodeWithTreeElement(secondChild, parentTreeNode);

		firstGrandChildTreeNode = initializeTreeNodeWithTreeElement(firstGrandChild,
			firstChildTreeNode);

		firstGrandGrandChildTreeNode = initializeTreeNodeWithTreeElement(firstGrandGrandChild,
			firstChildTreeNode);
		return parentTreeNode;
	}

	private static TreeNode<TreeElement> initializeTreeNodeWithTreeElement(TreeElement treeElement,
		TreeNode<TreeElement> parentTreeNode)
	{
		TreeNode<TreeElement> treeNode;
		treeNode = new TreeNode<>(treeElement);
		treeNode.setDisplayValue(treeElement.getName());
		if (parentTreeNode != null)
		{
			treeNode.setParent(parentTreeNode);
			parentTreeNode.addChild(treeNode);
		}
		return treeNode;
	}

}
