package de.alpharogroup.actions;

import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import de.alpharogroup.check.Check;

/**
 * The Class {@link DisposeWindowAction}.
 */
public class DisposeWindowAction extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The window. */
	private final Window window;

	/**
	 * Instantiates a new {@link DisposeWindowAction}.
	 *
	 * @param window
	 *            the window
	 */
	public DisposeWindowAction(final Window window) {
		super("DisposeWindowAction");
		Check.get().notNull(window, "window");
		this.window = window;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {
		window.setVisible(false);
		window.dispose();
	}
}