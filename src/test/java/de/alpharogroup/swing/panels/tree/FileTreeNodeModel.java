package de.alpharogroup.swing.panels.tree;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.io.File;

public class FileTreeNodeModel implements TreeModel
{
	protected File root;

	public FileTreeNodeModel(File root)
	{
		this.root = root;
	}

	public Object getRoot()
	{
		return root;
	}

	public boolean isLeaf(Object node)
	{
		return ((File)node).isFile();
	}

	public int getChildCount(Object parent)
	{
		String[] list = ((File)parent).list();
		return list == null ? 0 : list.length;
	}

	public Object getChild(Object parent, int index)
	{
		String[] list = ((File)parent).list();
		if (list != null && index < list.length)
		{
			return new File((File)parent, list[index]);
		}
		return null;
	}

	public int getIndexOfChild(Object parent, Object child)
	{
		String[] list = ((File)parent).list();
		if (list != null)
		{
			String filename = ((File)child).getName();
			for (int i = 0; i < list.length; i++)
			{
				if (filename.equals(list[i]))
				{
					return i;
				}
			}
		}
		return -1;
	}

	public void valueForPathChanged(TreePath path, Object newvalue)
	{
	}

	public void addTreeModelListener(TreeModelListener l)
	{
	}

	public void removeTreeModelListener(TreeModelListener l)
	{
	}
}
