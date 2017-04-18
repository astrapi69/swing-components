package de.alpharogroup.swing.wizard;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import lombok.Getter;

@Getter
public class NavigationPanel extends JPanel
{
	private JButton nextButton;
	private JButton previousButton;

	public NavigationPanel()
	{
		setBorder(new LineBorder(Color.BLACK));
		nextButton = newNextButton("Next");
		previousButton = newPreviousButton("Previous");
		add(previousButton);
		add(nextButton);
	}

	protected JButton newNextButton(String label)
	{
		JButton button = new JButton(label);
		button.addActionListener(e -> onNext());
		return button;
	}

	protected JButton newPreviousButton(String label)
	{
		JButton button = new JButton(label);
		button.addActionListener(e -> onPrevious());
		return button;
	}

	protected void onNext()
	{
	}

	protected void onPrevious()
	{
	}

}