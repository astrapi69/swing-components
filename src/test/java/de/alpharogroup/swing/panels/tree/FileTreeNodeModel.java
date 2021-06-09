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
