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
package io.github.astrapi69.swing.wizard;

import java.awt.*;

import lombok.Getter;
import lombok.Setter;
import io.github.astrapi69.design.pattern.state.wizard.model.BaseWizardStateMachineModel;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BasePanel;

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

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The navigation panel. */
	private NavigationPanel<BaseWizardStateMachineModel<T>> navigationPanel;

	/** The state machine. */
	private BaseWizardStateMachineModel<T> stateMachine;

	/** The wizard content panel. */
	private BaseWizardContentPanel<T> wizardContentPanel;

	/**
	 * Instantiates a new {@link AbstractWizardPanel}.
	 */
	public AbstractWizardPanel()
	{
		this(BaseModel.of());
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
	protected NavigationPanel<BaseWizardStateMachineModel<T>> newNavigationPanel(
		Model<BaseWizardStateMachineModel<T>> model)
	{
		final NavigationPanel<BaseWizardStateMachineModel<T>> navigationPanel = new NavigationPanel<BaseWizardStateMachineModel<T>>()
		{

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected void onCancel()
			{
				AbstractWizardPanel.this.onCancel();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected void onFinish()
			{
				AbstractWizardPanel.this.onFinish();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected void onNext()
			{
				AbstractWizardPanel.this.onNext();
			}

			/**
			 * {@inheritDoc}
			 */
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
		Model<BaseWizardStateMachineModel<T>> model);

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
		wizardContentPanel = newWizardContentPanel(BaseModel.of(getStateMachine()));
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
		updateButtonState();
		final String name = getStateMachine().getCurrentState().getName();
		final CardLayout cardLayout = getWizardContentPanel().getCardLayout();
		cardLayout.show(getWizardContentPanel(), name);
	}

	/**
	 * Callback method for the previous action.
	 */
	protected void onPrevious()
	{
		stateMachine.previous();
		updateButtonState();
		final String name = getStateMachine().getCurrentState().getName();
		final CardLayout cardLayout = getWizardContentPanel().getCardLayout();
		cardLayout.show(getWizardContentPanel(), name);
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
