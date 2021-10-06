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

import javax.swing.tree.TreeModel;

import org.jdesktop.swingx.JXTree;

import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.tree.TreeElement;
import io.github.astrapi69.tree.TreeNode;

/**
 * The abstract class {@link GenericTreeNodePanel} a given {@link TreeNode} parameterized with
 * {@link TreeElement}
 */
public abstract class GenericTreeNodePanel<T> extends JXTreePanel<TreeNode<T>>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link GenericTreeNodePanel}
	 */
	public GenericTreeNodePanel()
	{
	}

	/**
	 * Instantiates a new t{@link GenericTreeNodePanel}
	 *
	 * @param model
	 *            the model
	 */
	public GenericTreeNodePanel(final Model<TreeNode<T>> model)
	{
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected JXTree newTree()
	{
		JXTree tree = super.newTree();
		return tree;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected abstract TreeModel newTreeModel(final Model<TreeNode<T>> model);

	/**
	 * On initialize group layout.
	 */
	protected void onInitializeGroupLayout()
	{
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
					.addComponent(scrTree, javax.swing.GroupLayout.PREFERRED_SIZE, 384,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addContainerGap()
				.addComponent(scrTree, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
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
