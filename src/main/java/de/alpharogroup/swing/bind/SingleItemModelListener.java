/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.swing.bind;

import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import de.alpharogroup.model.api.Model;
import lombok.Getter;

/**
 * The listener interface for receiving itemBind events. The class that is interested in processing
 * a itemBind event implements this interface, and the object created with that class is registered
 * with a component using the component's <code>addItemListener<code> method. When the itemBind
 * event occurs, that object's appropriate method is invoked.
 *
 * @param <T>
 *            the generic type
 * @see ItemBindEvent
 */
@Getter
public class SingleItemModelListener<T> implements ItemListener
{

	/** The model. */
	private final Model<T> model;

	/**
	 * Instantiates a new {@link SingleItemModelListener}.
	 *
	 * @param model
	 *            the model
	 */
	public SingleItemModelListener(Model<T> model)
	{
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		final ItemSelectable is = e.getItemSelectable();
		final Object selected[] = is.getSelectedObjects();
		final T selectedItem = (selected.length == 0) ? null : (T)selected[0];
		System.out.println(selectedItem);

		model.setObject(selectedItem);
	}

}
