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
package de.alpharogroup.swing.wizard;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXPanel;

import de.alpharogroup.swing.panels.ComponentInitialization;
import lombok.Getter;

/**
 * The class {@link WizardContentPanel}.
 */
public class WizardContentPanel extends JXPanel implements ComponentInitialization
{
	@Getter
	private CardLayout cardLayout;

	/**
	 * Initializer block.
	 */
	{
		initialize();
	}

	/**
	 * Instantiates a new wizard content panel.
	 */
	public WizardContentPanel()
	{
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initializeComponents()
	{
		add(new FirstStepPanel(), CustomState.FIRST.getName());
		add(new SecondStepPanel(), CustomState.SECOND.getName());
		add(new ThirdStepPanel(), CustomState.THIRD.getName());

	}

	/**
	 * The layout have to initialize before the components!
	 * {@inheritDoc}
	 */
	@Override
	public void onBeforeInitializeComponents()
	{
		cardLayout = newCardLayout();
		setLayout(cardLayout);
	}

	protected CardLayout newCardLayout() {
		final CardLayout cardLayout = new CardLayout();
		return cardLayout;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initializeLayout()
	{
		setBorder(new LineBorder(Color.BLACK));
	}
}