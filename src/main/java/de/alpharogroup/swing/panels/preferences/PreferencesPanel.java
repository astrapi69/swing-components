package de.alpharogroup.swing.panels.preferences;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.base.BasePanel;

public abstract class PreferencesPanel<T> extends BasePanel<T>
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The {@link JSplitPane} for the tree in the left side and the corresponding value at teh right
	 * side.
	 */
	protected JSplitPane splitPane;

	/** The {@link JScrollPane} for the {@link JTree}. */
	protected JScrollPane scrTree;

	/** The {@link JTree}. */
	protected JTree tree;

	protected TreeModel treeModel;

	/**
	 * Instantiates a new {@link PreferencesPanel} object panel
	 *
	 * @param model the model
	 */
	public PreferencesPanel(final Model<T> model)
	{
		super(model);
	}

	protected void addTreeComponent(final String title, final Component c)
	{
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)treeModel.getRoot();
		root.add(new ComponentTreeNode(title, c));
	}

	protected JSplitPane newJSplitPane() {
		JSplitPane splitPane = new JSplitPane();
		splitPane.setLeftComponent(scrTree);
		splitPane.setRightComponent(null);
		return splitPane;
	}

	/**
	 *
	 * Factory method for creating the new {@link Dimension}. This method is invoked in the
	 * constructor from the derived classes and can be overridden so users can provide their own
	 * version of a {@link Dimension}
	 *
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 *
	 * @return the new {@link Dimension}
	 */
	protected Dimension newPreferredSize(int width, int height)
	{
		return new Dimension(width, height);
	}

	protected Component getSelectedComponent()
	{
		Object o = tree.getLastSelectedPathComponent();
		if (o instanceof ComponentTreeNode)
		{
			return ((ComponentTreeNode)o).getComponent();
		}
		else
		{
			return null;
		}

	}

	protected JTree newTree()
	{
		treeModel = newTreeModel(getModel());

		DefaultMutableTreeNode root = (DefaultMutableTreeNode)treeModel.getRoot();
		JTree tree = new JTree(root);
		tree.setEditable(false);

		tree.addTreeSelectionListener(new TreeSelectionListener()
		{
			@Override
			public void valueChanged(TreeSelectionEvent e)
			{
				splitPane.setRightComponent(PreferencesPanel.this.getSelectedComponent());
			}
		});

		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);


		tree.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				int selRow = tree.getRowForLocation(e.getX(), e.getY());
				if (selRow != -1)
				{
					if (e.getClickCount() == 1)
					{
						onSingleClick(e);
					}
					else if (e.getClickCount() == 2)
					{
						onDoubleClick(e);
					}
				}
			}
		});

		return tree;
	}

	/**
	 * Abstract factory callback method that have to be overwritten to provide the specific
	 * {@link TreeModel} for the {@link JTree}
	 *
	 * @param model
	 *            the model
	 * @return the tree model
	 */
	protected abstract TreeModel newTreeModel(final Model<T> model);

	/**
	 * Factory method for creating the new {@link JScrollPane}. This method is invoked in the
	 * constructor from the derived classes and can be overridden so users can provide their own
	 * version of a {@link JScrollPane}
	 *
	 * @return the new {@link JScrollPane}
	 */
	protected JScrollPane newTreeScrollPane()
	{
		JScrollPane scrDbTree = new JScrollPane();
		return scrDbTree;
	}

	/**
	 * The callback method on double click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onDoubleClick(MouseEvent event)
	{
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();

		scrTree = newTreeScrollPane();
		tree = newTree();

		setPreferredSize(newPreferredSize(420, 560));
		scrTree.setViewportView(tree);

		splitPane = newJSplitPane();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
	}

	/**
	 * The callback method on single click.
	 *
	 * @param event
	 *            the mouse event
	 */
	protected void onSingleClick(MouseEvent event)
	{
	}


}
