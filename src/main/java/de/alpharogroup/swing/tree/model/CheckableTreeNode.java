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