package de.alpharogroup.swing.panels.preferences;

import java.awt.Component;

import javax.swing.tree.DefaultMutableTreeNode;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComponentTreeNode extends DefaultMutableTreeNode
{

	Component component;
	String label;

	public ComponentTreeNode(final String label, final Component c)
	{
		super(c);
		this.component = c;
		this.label = label;
	}

	@Override
	public String toString()
	{
		return label;
	}

}
