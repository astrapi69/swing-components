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
package io.github.astrapi69.swing.base;

import java.awt.*;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.model.api.Model;

/**
 * The class {@link BaseWindow}.
 *
 * @param <T>
 *            the generic type
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseWindow<T> extends JWindow
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	Model<T> model;

	/**
	 * Instantiates a new {@link BaseWindow} object
	 *
	 * @param owner
	 *            the owner
	 * @param model
	 *            the model
	 */
	public BaseWindow(final Frame owner, final Model<T> model)
	{
		super(owner);
		this.model = model;
		initialize();
	}

	/**
	 * Instantiates a new {@link BaseWindow} object
	 *
	 * @param gc
	 *            the <code>GraphicsConfiguration</code> that is used * to construct the new window
	 *            with; if gc is <code>null</code>, * the system default
	 *            <code>GraphicsConfiguration</code> * is assumed
	 * @param model
	 *            the model
	 */
	public BaseWindow(final GraphicsConfiguration gc, final Model<T> model)
	{
		super(gc);
		this.model = model;
		initialize();
	}

	/**
	 * Instantiates a new {@link BaseWindow} object
	 *
	 * @param model
	 *            the model
	 */
	public BaseWindow(final Model<T> model)
	{
		super();
		this.model = model;
		initialize();
	}

	/**
	 * Instantiates a new {@link BaseWindow} object
	 *
	 * @param owner
	 *            the owner
	 * @param gc
	 *            the <code>GraphicsConfiguration</code> that is used * to construct the new window
	 *            with; if gc is <code>null</code>, * the system default
	 *            <code>GraphicsConfiguration</code> * is assumed
	 * @param model
	 *            the model
	 */
	public BaseWindow(final Window owner, final GraphicsConfiguration gc, final Model<T> model)
	{
		super(owner, gc);
		this.model = model;
		initialize();
	}

	/**
	 * Instantiates a new {@link BaseWindow} object
	 *
	 * @param owner
	 *            the owner
	 * @param model
	 *            the model
	 */
	public BaseWindow(final Window owner, final Model<T> model)
	{
		super(owner);
		this.model = model;
		initialize();
	}

	/**
	 * Getter for the model's object
	 *
	 * @return the model object
	 */
	public final T getModelObject()
	{
		return getModel().getObject();
	}

	/**
	 * Setter for the model object.
	 *
	 * @param modelObject
	 *            the new model object
	 * @return this for chaining
	 */
	public final BaseWindow<T> setModelObject(final T modelObject)
	{
		getModel().setObject(modelObject);
		return this;
	}

	/**
	 * Initialize the component.
	 */
	private final void initialize()
	{
		onInitialize();
	}

	/**
	 * Initialize components from the component.
	 */
	private final void initializeComponents()
	{
		onInitializeComponents();
	}

	/**
	 * Initialize layout from the component.
	 */
	private final void initializeLayout()
	{
		onInitializeLayout();
	}

	/**
	 * Callback method to interact when the initialization of the component is finished.
	 */
	protected void onAfterInitialize()
	{
	}

	/**
	 * Callback method to interact when the initialization is finished of the components from the
	 * component.
	 */
	protected void onAfterInitializeComponents()
	{
	}

	/**
	 * Callback method to interact when the initialization of the layout is finished.
	 */
	protected void onAfterInitializeLayout()
	{
	}

	/**
	 * Callback method to interact on before initialization of the component.
	 */
	protected void onBeforeInitialize()
	{
	}

	/**
	 * Callback method to interact on before initialization of the components from the component.
	 */
	protected void onBeforeInitializeComponents()
	{
	}

	/**
	 * Callback method to interact on before initialization of the layout.
	 */
	protected void onBeforeInitializeLayout()
	{
	}

	/**
	 * Callback method to initialize the component.
	 */
	protected void onInitialize()
	{
		onBeforeInitialize();
		onBeforeInitializeComponents();
		initializeComponents();
		onAfterInitializeComponents();
		onBeforeInitializeLayout();
		initializeLayout();
		onAfterInitializeLayout();
		onAfterInitialize();
	}

	/**
	 * Callback method to initialize components from the component.
	 */
	protected void onInitializeComponents()
	{
	}

	/**
	 * Callback method to initialize layout from the component.
	 */
	protected void onInitializeLayout()
	{
	}
}
