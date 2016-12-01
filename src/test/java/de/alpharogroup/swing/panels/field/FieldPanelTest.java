package de.alpharogroup.swing.panels.field;

import java.awt.Frame;

import javax.swing.DefaultComboBoxModel;

import de.alpharogroup.layout.CloseWindow;

/**
 * The test class for {@link FieldPanel}.
 */
public class FieldPanelTest
{

	/**
	 * Test init layout.
	 */

	public static void main(final String[] args)
	{
		final Frame frame = new Frame("FieldPanel");
		frame.addWindowListener(new CloseWindow());
		frame.add(new FieldPanel<String>()
		{

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			@Override
			protected DefaultComboBoxModel<String> newTypeModel()
			{
				return new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" });
			}
		});
		frame.pack();
		frame.setVisible(true);
	}

}
