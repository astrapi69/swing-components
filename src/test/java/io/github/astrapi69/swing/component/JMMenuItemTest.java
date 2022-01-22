package io.github.astrapi69.swing.component;

import io.github.astrapi69.model.api.Model;

public class JMMenuItemTest
{
	public static void main(String[] args)
	{
		final JMMenuItem menuItem;
		menuItem = new JMMenuItem("Check me");
		Model beanModel = menuItem.getBeanModel();

		boolean selected = menuItem.isSelected();

		menuItem.setSelected(true);

		selected = menuItem.isSelected();
	}
}
