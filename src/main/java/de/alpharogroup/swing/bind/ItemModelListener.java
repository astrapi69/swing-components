package de.alpharogroup.swing.bind;

import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import de.alpharogroup.model.api.Model;
import lombok.Getter;

/**
 * The listener interface for receiving itemBind events.
 * The class that is interested in processing a itemBind
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addItemListener<code> method. When
 * the itemBind event occurs, that object's appropriate
 * method is invoked.
 *
 * @param <T> the generic type
 * @see ItemBindEvent
 */
@Getter
public class ItemModelListener<T> implements ItemListener {

	/** The model. */
	private final Model<T[]> model;

	/**
	 * Instantiates a new {@link ItemModelListener}.
	 *
	 * @param model the model
	 */
	public ItemModelListener(Model<T[]> model) {
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void itemStateChanged(ItemEvent e) {
		final ItemSelectable is = e.getItemSelectable();
		final T selected[] = (T[])is.getSelectedObjects();
		model.setObject(selected);
	}

}
