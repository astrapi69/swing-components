package io.github.astrapi69.swing.components.factories;

import javax.swing.*;

import lombok.experimental.UtilityClass;

/**
 * The class {@link SwingContainerFactory} provides factory methods for create swing container
 * component objects
 */
@UtilityClass
public class SwingContainerFactory
{

	/**
	 * Factory method for create new {@link JScrollPane} object
	 *
	 * @return the new {@link JScrollPane}
	 */
	public static JScrollPane newScrollPane()
	{
		final JScrollPane scrDbTree = new JScrollPane();
		return scrDbTree;
	}

}
