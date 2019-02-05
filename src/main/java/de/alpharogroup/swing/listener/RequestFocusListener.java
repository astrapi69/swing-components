package de.alpharogroup.swing.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JComponent;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link RequestFocusListener} can take a {@link JComponent} which will gain focus when
 * the window/frame/dialog will show.<br>
 * <br>
 * The listener interface for receiving requestFocus events. The class that is interested in
 * processing a requestFocus event implements this interface, and the object created with that class
 * is registered with a component using the component's <code>addRequestFocusListener<code> method.
 * When the requestFocus event occurs, that object's appropriate method is invoked.
 *
 * @see RequestFocusEvent
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestFocusListener implements WindowFocusListener
{

	/**
	 * The component that will gain focus when the window/frame/dialog will show.<br>
	 */
	@NonNull
	JComponent component;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void windowGainedFocus(WindowEvent e)
	{
		component.setFocusable(true);
		component.setRequestFocusEnabled(true);
		component.requestFocus();
		component.requestFocusInWindow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void windowLostFocus(WindowEvent e)
	{
	}

}
