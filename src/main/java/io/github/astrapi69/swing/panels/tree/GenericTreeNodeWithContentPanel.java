package io.github.astrapi69.swing.panels.tree;

import javax.swing.*;

import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.tree.TreeNode;

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
