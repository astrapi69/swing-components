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

import static io.github.astrapi69.swing.tree.TreeNodeFactory.initializeTreeNodeWithTreeElement;

import java.util.List;

import io.github.astrapi69.tree.TreeElement;
import io.github.astrapi69.tree.TreeNode;

public class TestTreeNodeFactory
{

	public static TreeNode<TreeElement> initializeTestTreeNodeElement()
	{
		TreeNode<TreeElement> firstChildTreeNode;
		TreeNode<TreeElement> firstGrandChildTreeNodeLeaf;
		TreeNode<TreeElement> secondGrandChildTreeNodeLeaf;
		TreeElement firstGrandGrandChild;
		TreeNode<TreeElement> firstGrandGrandChildTreeNode;
		TreeNode<TreeElement> parentTreeNode;
		TreeNode<TreeElement> secondChildTreeNode;
		List<TreeNode<TreeElement>> list;
		TreeElement parent;
		TreeElement firstChild;
		TreeElement firstGrandChild;
		TreeElement secondChild;
		TreeElement secondGrandChild;
		parent = TreeElement.builder().name("parent").parent(null).node(true).build();
		firstChild = TreeElement.builder().name("firstChild").parent(parent).node(true).build();
		firstGrandChild = TreeElement.builder().name("firstGrandChild").parent(firstChild)
			.node(true).build();
		firstGrandGrandChild = TreeElement.builder().name("firstGrandGrandChild")
			.parent(firstGrandChild).node(false).build();
		secondChild = TreeElement.builder().name("secondChild").parent(parent).node(true).build();
		secondGrandChild = TreeElement.builder().name("secondGrandChild").parent(firstChild)
			.node(false).build();
		parentTreeNode = initializeTreeNodeWithTreeElement(parent, null);

		firstChildTreeNode = initializeTreeNodeWithTreeElement(firstChild, parentTreeNode);

		secondChildTreeNode = initializeTreeNodeWithTreeElement(secondChild, parentTreeNode);

		firstGrandChildTreeNodeLeaf = initializeTreeNodeWithTreeElement(firstGrandChild,
			firstChildTreeNode);
		secondGrandChildTreeNodeLeaf = initializeTreeNodeWithTreeElement(secondGrandChild,
			secondChildTreeNode);

		firstGrandGrandChildTreeNode = initializeTreeNodeWithTreeElement(firstGrandGrandChild,
			firstChildTreeNode);
		return parentTreeNode;
	}

}
