package de.alpharogroup.swing.bind;

import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ComboBoxModel;

/**
 * The listener interface for receiving itemBind events.
 * The class that is interested in processing a itemBind
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addItemBindListener<code> method. When
 * the itemBind event occurs, that object's appropriate
 * method is invoked.
 *
 * @param <T> the generic type
 * @see ItemBindEvent
 */
public class ItemBindListener<T> implements ItemListener {
	
	/** The model. */
	private ComboBoxModel<T> model;

	/**
	 * Instantiates a new {@link ItemBindListener}.
	 *
	 * @param model the model
	 */
	public ItemBindListener(ComboBoxModel<T> model) {
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void itemStateChanged(ItemEvent e) {
		ItemSelectable is = e.getItemSelectable();	
		Object selected[] = is.getSelectedObjects();
		T sel = (selected.length == 0) ? null : (T) selected[0];
		model.setSelectedItem(sel);
	}

}
