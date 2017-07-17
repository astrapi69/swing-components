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
package de.alpharogroup.swing.panels;

/**
 * The interface {@link ComponentInitialization} contains methods for the initialization for the
 * components.
 */
public interface ComponentInitialization
{

	/**
	 * Initialize the component.
	 */
	default void initialize()
	{
		onBeforeInitialize();
		onBeforeInitializeComponents();
		initializeComponents();
		onAfterInitializeComponents();
		onBeforeInitializeLayout();
		initializeLayout();
		onAfterInitializeLayout();
		onAfterInitialize();
	};

	/**
	 * Initialize components from the component.
	 */
	void initializeComponents();

	/**
	 * Initialize layout from the component.
	 */
	void initializeLayout();

	/**
	 * Callback method to interact when the initialization of the component is finished.
	 */
	default void onAfterInitialize()
	{
	}


	/**
	 * Callback method to interact when the initialization is finished of the components from the
	 * component.
	 */
	default void onAfterInitializeComponents()
	{
	}

	/**
	 * Callback method to interact when the initialization of the layout is finished.
	 */
	default void onAfterInitializeLayout()
	{
	}

	/**
	 * Callback method to interact on before initialization of the component.
	 */
	default void onBeforeInitialize()
	{
	}


	/**
	 * Callback method to interact on before initialization of the components from the component.
	 */
	default void onBeforeInitializeComponents()
	{
	}

	/**
	 * Callback method to interact on before initialization of the layout.
	 */
	default void onBeforeInitializeLayout()
	{
	}

}
