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

import de.alpharogroup.design.pattern.state.wizard.model.WizardModelStateMachine;
import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.base.BasePanel;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link AbstractWizardPanel} serves as the base class for wizard panels.
 *
 * @param <T>
 *            the generic type of the model object
 */
@Getter
@Setter
public abstract class AbstractWizardPanel<T> extends BasePanel<T>
{

	/** The state machine. */
	private WizardModelStateMachine<T> stateMachine;

	/** The wizard content panel. */
	private BaseWizardContentPanel<T> wizardContentPanel;

	/** The navigation panel. */
	private NavigationPanel<WizardModelStateMachine<T>> navigationPanel;

	/**
	 * Instantiates a new {@link AbstractWizardPanel}.
	 */
	public AbstractWizardPanel()
	{
		this(BaseModel.<T> of());
	}

	/**
	 * Instantiates a new {@link AbstractWizardPanel}.
	 *
	 * @param model
	 *            the model
	 */
	public AbstractWizardPanel(Model<T> model)
	{
		super(model);
	}

	/**
	 * Factory method for create new {@link NavigationPanel} object.
	 *
	 * @param model
	 *            the model
	 * @return the new {@link NavigationPanel} object.
	 */
	protected NavigationPanel<WizardModelStateMachine<T>> newNavigationPanel(
		Model<WizardModelStateMachine<T>> model)
	{
		final NavigationPanel<WizardModelStateMachine<T>> navigationPanel = new NavigationPanel<WizardModelStateMachine<T>>()
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void onCancel()
			{
				AbstractWizardPanel.this.onCancel();
			}

			@Override
			protected void onFinish()
			{
				AbstractWizardPanel.this.onFinish();
			}

			@Override
			protected void onNext()
			{
				AbstractWizardPanel.this.onNext();
			}

			@Override
			protected void onPrevious()
			{
				AbstractWizardPanel.this.onPrevious();
			}
		};
		return navigationPanel;
	}

	/**
	 * Abstract factory method for create new {@link BaseWizardContentPanel} object that have to be
	 * implemented to provide specific content for the wizard.
	 *
	 * @param model
	 *            the model
	 * @return the new {@link BaseWizardContentPanel} object
	 */
	protected abstract BaseWizardContentPanel<T> newWizardContentPanel(
		Model<WizardModelStateMachine<T>> model);

	/**
	 * Callback method for the cancel action.
	 */
	protected void onCancel()
	{
		stateMachine.cancel();
	}

	/**
	 * Callback method for the finish action.
	 */
	protected void onFinish()
	{
		stateMachine.finish();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		wizardContentPanel = newWizardContentPanel(
			BaseModel.<WizardModelStateMachine<T>> of(getStateMachine()));
		navigationPanel = newNavigationPanel(BaseModel.of(getStateMachine()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		setLayout(new BorderLayout());
		add(wizardContentPanel, BorderLayout.CENTER);
		add(navigationPanel, BorderLayout.SOUTH);
	}

	/**
	 * Callback method for the next action.
	 */
	protected void onNext()
	{
		stateMachine.next();
	}


	/**
	 * Callback method for the previous action.
	 */
	protected void onPrevious()
	{
		stateMachine.previous();
	}

	/**
	 * Update the button states. Overwrite this method for activate or disable the navigation
	 * buttons.
	 */
	protected void updateButtonState()
	{
		getNavigationPanel().getBtnPrevious()
			.setEnabled(getStateMachine().getCurrentState().hasPrevious());
		getNavigationPanel().getBtnNext().setEnabled(getStateMachine().getCurrentState().hasNext());
	}

}
