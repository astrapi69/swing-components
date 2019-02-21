package de.alpharogroup.swing.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.SwingXUtilities;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ActionFactory
{

	@SuppressWarnings("serial")
	public static Action newPageAction(final String name, final JComponent container,
		final JComponent content)
	{
		Action action = new AbstractAction(name)
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				container.removeAll();
				container.add(new JScrollPane(content));
				container.revalidate();

			}
		};
		return action;
	}

	@SuppressWarnings("serial")
	public static Action newTextAction(final String name, final JComponent container,
		final JComponent content)
	{
		Action action = new AbstractAction(name)
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				container.removeAll();
				container.add(new JScrollPane(content));
				JXMultiSplitPane pane = SwingXUtilities.getAncestor(JXMultiSplitPane.class,
					container);
				if (pane != null)
				{
					pane.revalidate();
				}
				else
				{
					container.revalidate();
				}

			}
		};
		return action;
	}
}
