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
package de.alpharogroup.generic.mvc.view;

import java.awt.Component;


/**
 * The Class AbstractGenericView.
 *
 * @param <C>
 *            the generic type of the controller
 * @param <COMP>
 *            the generic type of the component
 */
public abstract class AbstractGenericView<C, COMP extends Component> implements View<C, COMP>
{

	/** The component. */
	private COMP component;

	/** The controller. */
	private C controller;

	/** The parent. */
	private View<C, COMP> parent;

	/**
	 * Instantiates a new abstract generic view.
	 *
	 * @param controller
	 *            the controller
	 */
	public AbstractGenericView(final C controller)
	{
		this.controller = controller;
		initialize();
	}

	/**
	 * Returns the field <code>component</code>.
	 *
	 * @return The field .
	 */
	@Override
	public COMP getComponent()
	{
		return component;
	}

	/**
	 * Returns the field <code>controller</code>.
	 *
	 * @return The field .
	 */
	@Override
	public C getController()
	{
		return controller;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	@Override
	public View<C, COMP> getParent()
	{
		return parent;
	}

	/**
	 * Gets the root parent view.
	 *
	 * @return the root parent view
	 */
	public View<?, ?> getRootParentView()
	{
		View<?, ?> currentView = this;
		while (currentView.hasParent())
		{
			currentView = currentView.getParent();
		}
		return currentView;
	}

	/**
	 * Checks for parent.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean hasParent()
	{
		return null != this.parent;
	}

	/**
	 * Initialize.
	 */
	protected abstract void initialize();

	/**
	 * Sets the field <code>component</code>.
	 *
	 * @param component
	 *            The <code>component</code> to set.
	 */
	@Override
	public void setComponent(final COMP component)
	{
		this.component = component;
	}

	/**
	 * Sets the field <code>controller</code>.
	 *
	 * @param controller
	 *            The <code>controller</code> to set.
	 */
	@Override
	public void setController(final C controller)
	{
		this.controller = controller;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent
	 *            the parent
	 */
	public void setParent(final View<C, COMP> parent)
	{
		this.parent = parent;
	}

}
