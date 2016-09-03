package de.alpharogroup.swing.menu.popup.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

/**
 * The listener interface for receiving popup events. The class that is
 * interested in processing a popup event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's addPopupListener method. When the popup event occurs, that
 * object's appropriate method is invoked.
 */
public class PopupListener extends MouseAdapter {

	/** The popup menu. */
	private final JPopupMenu popupMenu;

	/**
	 * Instantiates a new popup listener.
	 *
	 * @param menu
	 *            the menu
	 */
	public PopupListener(final JPopupMenu menu) {
		super();
		popupMenu = menu;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mousePressed(final MouseEvent e) {
		onShowPopup(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseReleased(final MouseEvent e) {
		onShowPopup(e);
	}

	/**
	 * Callback method that is called on show popup.
	 *
	 * @param e
	 *            the mouse event
	 */
	protected void onShowPopup(final MouseEvent e) {
		if (e.isPopupTrigger()) {
			System.out.println(e.getSource());
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}