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

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;

import de.alpharogroup.design.pattern.state.wizard.WizardStateMachine;
import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.base.BasePanel;

public class WizardPanel extends BasePanel<WizardStateMachine>
{

	private static final long serialVersionUID = 1L;

	public static void main(final String[] args)
	{
		final JFrame f = new JFrame();
		final WizardPanel viewer = new WizardPanel();

		f.setTitle("Simple Wizard");
		f.setContentPane(viewer);
		f.setSize(600, 600);
		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private WizardContentPanel wizardContentPanel;

	private NavigationPanel<Void> navigationPanel;

	public WizardPanel()
	{
		this(BaseModel.of(WizardStateMachine.builder().currentState(CustomState.FIRST).build()));
	}

	public WizardPanel(final Model<WizardStateMachine> model)
	{
		super(model);
	}

	protected NavigationPanel<Void> newNavigationPanel()
	{
		final NavigationPanel<Void> navigationPanel = new NavigationPanel<Void>()
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void onCancel()
			{
				WizardPanel.this.onCancel();
			}

			@Override
			protected void onFinish()
			{
				WizardPanel.this.onFinish();
			}

			@Override
			protected void onNext()
			{
				WizardPanel.this.onNext();
			}

			@Override
			protected void onPrevious()
			{
				WizardPanel.this.onPrevious();
			}
		};
		return navigationPanel;
	}

	protected WizardContentPanel newWizardContentPanel()
	{
		final WizardContentPanel cardsPanel = new WizardContentPanel();
		return cardsPanel;
	}

	@Override
	protected void onAfterInitializeComponents()
	{
		super.onAfterInitializeComponents();
		updateButtonState();
	}


	protected void onCancel()
	{
		getModelObject().cancel();
		// from here application specific behavior...
		System.exit(0);
	}

	protected void onFinish()
	{
		getModelObject().finish();
		// from here application specific behavior...
		System.exit(0);
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		wizardContentPanel = newWizardContentPanel();
		navigationPanel = newNavigationPanel();
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		setLayout(new BorderLayout());
		add(wizardContentPanel, BorderLayout.CENTER);
		add(navigationPanel, BorderLayout.SOUTH);
	}

	protected void onNext()
	{
		getModelObject().next();
		updateButtonState();
		final String name = getModelObject().getCurrentState().getName();
		final CardLayout cardLayout = wizardContentPanel.getCardLayout();
		cardLayout.show(wizardContentPanel, name);
	}

	protected void onPrevious()
	{
		getModelObject().previous();
		updateButtonState();
		final String name = getModelObject().getCurrentState().getName();
		final CardLayout cardLayout = wizardContentPanel.getCardLayout();
		cardLayout.show(wizardContentPanel, name);
	}

	protected void updateButtonState()
	{
		navigationPanel.getBtnPrevious()
			.setEnabled(getModelObject().getCurrentState().hasPrevious());
		navigationPanel.getBtnNext().setEnabled(getModelObject().getCurrentState().hasNext());
	}

}