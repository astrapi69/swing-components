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
package de.alpharogroup.swing.tree.model;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckableTreeNode extends DefaultMutableTreeNode
{

	boolean selected;

	public CheckableTreeNode()
	{
		this(null);
	}

	public CheckableTreeNode(Object userObject)
	{
		this(userObject, true, false);
	}

	public CheckableTreeNode(Object userObject, boolean allowsChildren, boolean isSelected)
	{
		super(userObject, allowsChildren);
		this.selected = isSelected;
	}

	@SuppressWarnings("unchecked")
	public void setSelected(boolean selected)
	{
		this.selected = selected;
		Enumeration<CheckableTreeNode> e = children.elements();
		while (e.hasMoreElements())
		{
			CheckableTreeNode node = e.nextElement();
			node.setSelected(selected);
		}
	}

	@Override
	public void setUserObject(Object obj)
	{
		if (obj instanceof Boolean)
		{
			setSelected(((Boolean)obj).booleanValue());
		}
		else
		{
			super.setUserObject(obj);
		}
	}

}