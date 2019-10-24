package de.alpharogroup.swing.tree.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.TreeCellRenderer;

import de.alpharogroup.swing.components.factories.DimensionFactory;
import de.alpharogroup.swing.tree.labels.CheckBoxTreeLabel;
import de.alpharogroup.swing.tree.model.CheckableTreeNode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckBoxTreeCellRenderer extends JPanel implements TreeCellRenderer
{

	JCheckBox checkBox;

	CheckBoxTreeLabel label;

	Icon leafIcon;
	Icon openIcon;
	Icon closedIcon;
	Color textBackground;
	Color textForeground;

	public CheckBoxTreeCellRenderer()
	{
		setLayout(null);
		leafIcon = UIManager.getIcon("Tree.leafIcon");
		openIcon = UIManager.getIcon("Tree.openIcon");
		closedIcon = UIManager.getIcon("Tree.closedIcon");
		textBackground = UIManager.getColor("Tree.textBackground");
		textForeground = UIManager.getColor("Tree.textForeground");
		add(checkBox = newCheckBox());
		add(label = newTreeLabel());
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected,
		boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		String stringValue = tree.convertValueToText(value, isSelected, expanded, leaf, row,
			hasFocus);
		setEnabled(tree.isEnabled());
		checkBox.setSelected(((CheckableTreeNode)value).isSelected());
		label.setFont(tree.getFont());
		label.setText(stringValue);
		label.setSelected(isSelected);
		label.setFocused(hasFocus);
		if (leaf)
		{
			label.setIcon(leafIcon);
		}
		else if (expanded)
		{
			label.setIcon(openIcon);
		}
		else
		{
			label.setIcon(closedIcon);
		}
		return this;
	}

	protected JCheckBox newCheckBox()
	{
		JCheckBox jCheckBox = new JCheckBox();
		jCheckBox.setBackground(textBackground);
		return jCheckBox;
	}

	protected CheckBoxTreeLabel newTreeLabel()
	{
		CheckBoxTreeLabel treeLabel = new CheckBoxTreeLabel();
		treeLabel.setForeground(textForeground);
		return treeLabel;
	}

	@Override
	public Dimension getPreferredSize()
	{
		return DimensionFactory.getPreferredSize(checkBox, label);
	}

	@Override
	public void doLayout()
	{
		Dimension checkboxDimension = checkBox.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		int yAxisCheckbox = 0;
		int yAxisLabel = 0;
		if (checkboxDimension.height < labelDimension.height)
		{
			yAxisCheckbox = (labelDimension.height - checkboxDimension.height) / 2;
		}
		else
		{
			yAxisLabel = (checkboxDimension.height - labelDimension.height) / 2;
		}
		checkBox.setLocation(0, yAxisCheckbox);
		checkBox.setBounds(0, yAxisCheckbox, checkboxDimension.width, checkboxDimension.height);
		label.setLocation(checkboxDimension.width, yAxisLabel);
		label.setBounds(checkboxDimension.width, yAxisLabel, labelDimension.width, labelDimension.height);
	}

	@Override
	public void setBackground(Color color)
	{
		if (color instanceof ColorUIResource)
		{
			color = null;
		}
		super.setBackground(color);
	}

}