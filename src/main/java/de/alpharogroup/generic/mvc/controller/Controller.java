/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
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
package de.alpharogroup.generic.mvc.controller;

import java.awt.event.ActionEvent;
import java.util.Map;

/**
 * The Interface Controller.
 *
 * @param <M>
 *            the generic type of the model
 * @param <V>
 *            the generic type of the view
 */
public interface Controller<M, V>
{

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public V getView();

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the new view
	 */
	public void setView(final V view);

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public M getModel();

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the new model
	 */
	public void setModel(final M model);

	/**
	 * Gets the parent from this controller.
	 *
	 * @return the parent or null.
	 */
	public Controller<M, V> getParent();

	/**
	 * Sets the parent.
	 *
	 * @param controller
	 *            the new parent
	 */
	public void setParent(final Controller<M, V> controller);


	/**
	 * Gets the child from this controller.
	 *
	 * @param key
	 *            the key
	 *
	 * @return the child or null.
	 */
	public Controller<M, V> getChild(final String key);


	/**
	 * Sets a child from this controller.
	 *
	 * @param key
	 *            the key
	 * @param controller
	 *            the controller
	 *
	 * @return the object
	 */
	public Object setChild(final String key, final Controller<M, V> controller);

	/**
	 * Removes the child.
	 *
	 * @param controller
	 *            the controller
	 *
	 * @return the controller
	 */
	public Controller<M, V> removeChild(final Controller<M, V> controller);

	/**
	 * Removes the child.
	 *
	 * @param key
	 *            the key from the controller
	 *
	 * @return the controller
	 */
	public Controller<M, V> removeChild(final String key);

	/**
	 * Gets the children from this controller.
	 *
	 * @return the children
	 */
	public Map<String, Controller<M, V>> getChildren();

	/**
	 * Process.
	 *
	 * @param event
	 *            the event
	 */
	public void process(final ActionEvent event);

	/**
	 * Gets the name from the Controller.
	 *
	 * @return the name from the Controller.
	 */
	public String getName();

	/**
	 * Checks for child.
	 *
	 * @param key
	 *            the key
	 *
	 * @return true, if successful
	 */
	public boolean hasChild(final String key);

	/**
	 * Checks for child.
	 *
	 * @param controller
	 *            the controller
	 *
	 * @return true, if successful
	 */
	public boolean hasChild(final Controller<M, V> controller);

}
