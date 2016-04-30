package de.alpharogroup.swing.components.factories;

import java.awt.Component;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import de.alpharogroup.swing.menu.popup.listeners.PopupListener;

/**
 * A factory class for create swing Component objects.
 */
public final class JComponentFactory {

	/**
	 * Factory method for create a <code>JPopupMenu</code>.
	 *
	 * @return the new {@link JPopupMenu}.
	 */
	public static JPopupMenu newJPopupMenu() {
		return newJPopupMenu("");
	}

	/**
	 * Factory method for create a <code>JPopupMenu</code> with the specified
	 * title.
	 *
	 * @param label
	 *            the string that a UI may use to display as a title for the
	 *            popup menu.
	 * @return the new {@link JPopupMenu}.
	 */
	public static JPopupMenu newJPopupMenu(String label) {
		final JPopupMenu popup = new JPopupMenu(label);
		return popup;
	}

	/**
	 * Factory method for create a <code>JPopupMenu</code> that will be add a
	 * <code>MouseListener</code> to the given <code>Component</code> and an array of <code>JMenuItem</code> that will be added to the popup.
	 *
	 * @param component
	 *            the component
	 * @param items
	 *            the <code>JMenuItem</code>s
	 * @return the new {@link JPopupMenu}.
	 */
	public static JPopupMenu newJPopupMenu(Component component, JMenuItem... items) {
		return newJPopupMenu("", component, items);
	}

	/**
	 * Factory method for create a <code>JPopupMenu</code> that will be add a
	 * <code>MouseListener</code> to the given <code>Component</code> and an array of <code>JMenuItem</code> that will be added to the popup.
	 *
	 * @param component
	 *            the component
	 * @param items
	 *            the <code>JMenuItem</code>s
	 * @return the new {@link JPopupMenu}.
	 */
	public static JPopupMenu newJPopupMenu(String label, Component component, JMenuItem... items) {
		// Create the popup menu.
		JPopupMenu popup = newJPopupMenu(label);
		for (JMenuItem jMenuItem : items) {
			popup.add(jMenuItem);
		}
		// Add listener to the component so the popup menu can come up.
		MouseListener popupListener = new PopupListener(popup);
		component.addMouseListener(popupListener);
		return popup;
	}
}
