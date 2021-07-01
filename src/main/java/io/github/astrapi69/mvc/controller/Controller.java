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
package io.github.astrapi69.mvc.controller;

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
	 * Gets the child from this controller.
	 *
	 * @param key
	 *            the key
	 *
	 * @return the child or null.
	 */
	Controller<M, V> getChild(final String key);

	/**
	 * Gets the children from this controller.
	 *
	 * @return the children
	 */
	Map<String, Controller<M, V>> getChildren();

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	M getModel();

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the new model
	 */
	void setModel(final M model);

	/**
	 * Gets the name from the Controller.
	 *
	 * @return the name from the Controller.
	 */
	String getName();

	/**
	 * Gets the parent from this controller.
	 *
	 * @return the parent or null.
	 */
	Controller<M, V> getParent();

	/**
	 * Sets the parent.
	 *
	 * @param controller
	 *            the new parent
	 */
	void setParent(final Controller<M, V> controller);

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	V getView();

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the new view
	 */
	void setView(final V view);

	/**
	 * Checks for child.
	 *
	 * @param controller
	 *            the controller
	 *
	 * @return true, if successful
	 */
	boolean hasChild(final Controller<M, V> controller);

	/**
	 * Checks for child.
	 *
	 * @param key
	 *            the key
	 *
	 * @return true, if successful
	 */
	boolean hasChild(final String key);

	/**
	 * Process.
	 *
	 * @param event
	 *            the event
	 */
	void process(final ActionEvent event);

	/**
	 * Removes the child.
	 *
	 * @param controller
	 *            the controller
	 *
	 * @return the controller
	 */
	Controller<M, V> removeChild(final Controller<M, V> controller);

	/**
	 * Removes the child.
	 *
	 * @param key
	 *            the key from the controller
	 *
	 * @return the controller
	 */
	Controller<M, V> removeChild(final String key);

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
	Object setChild(final String key, final Controller<M, V> controller);

}
