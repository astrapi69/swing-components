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
package de.alpharogroup.swing.base;

import java.awt.LayoutManager;

import org.jdesktop.swingx.JXPanel;

import de.alpharogroup.model.IModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link BasePanel} for swing panels to provide an initialization cycle where the user
 * can overwrite the callback methods for interaction.
 *
 * @param <T>
 *            the generic type
 */
@Getter
@Setter
public class BasePanel<T> extends JXPanel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	private IModel<T> model;

	/**
	 * Initializer block.
	 */
	{
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 */
	public BasePanel()
	{
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param isDoubleBuffered
	 *            the is double buffered
	 */
	public BasePanel(final boolean isDoubleBuffered)
	{
		super(isDoubleBuffered);
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param model
	 *            the model
	 */
	public BasePanel(final IModel<T> model)
	{
		this.model = model;
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param layout
	 *            the layout
	 */
	public BasePanel(final LayoutManager layout)
	{
		super(layout);
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param layout
	 *            the layout
	 * @param isDoubleBuffered
	 *            the is double buffered
	 */
	public BasePanel(final LayoutManager layout, final boolean isDoubleBuffered)
	{
		super(layout, isDoubleBuffered);
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
	};

	/**
	 * Initialize the component.
	 */
	protected void initialize()
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
	protected void initializeComponents()
	{
	}

	/**
	 * Callback method to initialize layout from the component.
	 */
	protected void initializeLayout()
	{
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
	 * Setter for the model object.
	 *
	 * @param modelObject
	 *            the new model object
	 * @return this for chaining
	 */
	public final BasePanel<T> setModelObject(final T modelObject)
	{
		getModel().setObject(modelObject);
		return this;
	}


}
