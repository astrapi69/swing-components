package de.alpharogroup.swing.wizard;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import de.alpharogroup.design.pattern.state.StateMachine;
import de.alpharogroup.design.pattern.state.WizardStep;

public class WizardPanel extends JFrame
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new WizardPanel();
			}
		});
	}

	private StateMachine stateMachine;
	private WizardContentPanel wizardContentPanel;

	private NavigationPanel navigationPanel;

	public WizardPanel()
	{
		setTitle("Simple Wizard");

		stateMachine = StateMachine.builder().currentState(WizardStep.FIRST).build();
		wizardContentPanel = newWizardContentPanel();
		navigationPanel = newNavigationPanel();
		updateButtonState();
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(wizardContentPanel, BorderLayout.CENTER);
		add(navigationPanel, BorderLayout.SOUTH);
	}


	protected NavigationPanel newNavigationPanel()
	{
		final NavigationPanel navigationPanel = new NavigationPanel()
		{
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
		WizardContentPanel cardsPanel = new WizardContentPanel();
		return cardsPanel;
	}

	protected void onNext()
	{
		stateMachine.next();
		updateButtonState();
		String name = stateMachine.getCurrentState().getName();
		CardLayout cardLayout = ((CardLayout)wizardContentPanel.getLayout());
		cardLayout.show(wizardContentPanel, name);
	}

	protected void onPrevious()
	{
		stateMachine.previous();
		updateButtonState();
		String name = stateMachine.getCurrentState().getName();
		CardLayout cardLayout = ((CardLayout)wizardContentPanel.getLayout());
		cardLayout.show(wizardContentPanel, name);
	}

	protected void updateButtonState()
	{
		navigationPanel.getPreviousButton()
			.setEnabled(stateMachine.getCurrentState().hasPrevious());
		navigationPanel.getNextButton().setEnabled(stateMachine.getCurrentState().hasNext());
	}

}