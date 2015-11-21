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
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * The Class AbstractGenericController.
 *
 * @param <M>
 *            the generic type of the model
 * @param <V>
 *            the generic type of the view
 */
public abstract class AbstractGenericController<M, V> implements Controller<M, V>, ActionListener
{

	/** The model. */
	private M model;

	/** The view. */
	private V view;

	/** The parent. */
	private Controller<M, V> parent;

	/** The children. */
	private Map<String, Controller<M, V>> children;

	/**
	 * Instantiates a new abstract generic controller.
	 */
	public AbstractGenericController()
	{
		super();
		initialize();
	}


	/**
	 * (non-Javadoc).
	 *
	 * @param event
	 *            the event
	 *
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(final ActionEvent event)
	{
		process(event);

	}

	/**
	 * (non-Javadoc).
	 *
	 * @param key
	 *            the key
	 *
	 * @return the child
	 */
	@Override
	public Controller<M, V> getChild(final String key)
	{
		return children.get(key);
	}

	/**
	 * (non-Javadoc).
	 *
	 * @return the children
	 */
	@Override
	public Map<String, Controller<M, V>> getChildren()
	{
		return children;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @return the model
	 */
	@Override
	public M getModel()
	{
		return this.model;
	}

	@Override
	public String getName()
	{
		return this.getClass().getName();
	}

	/**
	 * (non-Javadoc).
	 *
	 * @return the parent
	 */
	@Override
	public Controller<M, V> getParent()
	{
		return parent;
	}


	/**
	 * (non-Javadoc).
	 *
	 * @return the view
	 */
	@Override
	public V getView()
	{
		return this.view;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param controller
	 *            the controller
	 * @return true, if successful
	 */
	@Override
	public boolean hasChild(final Controller<M, V> controller)
	{
		return children.containsValue(controller);
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param key
	 *            the key
	 * @return true, if successful
	 */
	@Override
	public boolean hasChild(final String key)
	{

		return children.containsKey(key);

	}

	/**
	 * Initialize.
	 */
	protected void initialize()
	{
		preinitialize();
		postinitialize();
	}

	/**
	 * Postinitialize.
	 */
	protected void postinitialize()
	{
	}


	/**
	 * Preinitialize.
	 */
	protected void preinitialize()
	{
	}

	/**
	 * Process.
	 *
	 * @param event
	 *            the event
	 */
	@Override
	public abstract void process(final ActionEvent event);

	/**
	 * (non-Javadoc).
	 *
	 * @param controller
	 *            the controller
	 * @return the controller
	 */
	@Override
	public Controller<M, V> removeChild(final Controller<M, V> controller)
	{
		return removeChild(controller.getName());
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param key
	 *            the key
	 * @return the controller
	 */
	@Override
	public Controller<M, V> removeChild(final String key)
	{
		return children.remove(key);
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param key
	 *            the key
	 * @param controller
	 *            the controller
	 *
	 * @return the object
	 */
	@Override
	public Object setChild(final String key, final Controller<M, V> controller)
	{
		if (null != controller.getParent())
		{
			// controller.getParent().re
		}
		return children.put(key, controller);
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param model
	 *            the model
	 */
	@Override
	public void setModel(final M model)
	{
		this.model = model;

	}

	/**
	 * (non-Javadoc).
	 *
	 * @param controller
	 *            the controller
	 */
	@Override
	public void setParent(final Controller<M, V> controller)
	{
		this.parent = controller;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param view
	 *            the view
	 */
	@Override
	public void setView(final V view)
	{
		this.view = view;
	}


}
