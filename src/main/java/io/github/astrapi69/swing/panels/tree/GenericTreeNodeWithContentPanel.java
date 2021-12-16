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

import javax.swing.*;

import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.tree.TreeElement;
import io.github.astrapi69.tree.TreeNode;

/**
 * The abstract class {@link GenericTreeNodeWithContentPanel}
 *
 * @deprecated use instead the same named class in project swing-tree-component<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public abstract class GenericTreeNodeWithContentPanel<T> extends JXTreeWithContentPanel<TreeNode<T>>
{

	/**
	 * Instantiates a new {@link GenericTreeNodeWithContentPanel}
	 */
	public GenericTreeNodeWithContentPanel()
	{
	}

	/**
	 * Instantiates a new t{@link GenericTreeNodeWithContentPanel}
	 *
	 * @param model
	 *            the model
	 */
	public GenericTreeNodeWithContentPanel(final Model<TreeNode<T>> model)
	{
		super(model);
	}

	/**
	 * On initialize group layout.
	 */
	protected void onInitializeGroupLayout()
	{
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addContainerGap()
				.addComponent(scrTree, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(scrTreeEntryTable, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
				.addContainerGap()));
		layout
			.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(
						layout.createSequentialGroup().addContainerGap()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scrTree, GroupLayout.DEFAULT_SIZE, 756,
									Short.MAX_VALUE)
								.addComponent(scrTreeEntryTable))
							.addContainerGap()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		onInitializeGroupLayout();
	}
}
