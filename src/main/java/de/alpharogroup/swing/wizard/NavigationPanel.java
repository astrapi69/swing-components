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

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import de.alpharogroup.swing.base.BasePanel;
import lombok.Getter;

/**
 * The class {@link NavigationPanel}.
 */
@Getter
public class NavigationPanel<T> extends BasePanel<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The next button. */
	private JButton btnNext;

	/** The previous button. */
	private JButton btnPrevious;

	/** The cancel button. */
	private JButton btnCancel;

	/** The finish button. */
	private JButton btnFinish;

	/**
	 * Instantiates a new navigation panel.
	 */
	public NavigationPanel()
	{
	}

	protected JButton newCancelButton(final String label)
	{
		final JButton button = new JButton(label);
		button.addActionListener(e -> onCancel());
		return button;
	}

	protected JButton newFinishButton(final String label)
	{
		final JButton button = new JButton(label);
		button.addActionListener(e -> onFinish());
		return button;
	}

	protected JButton newNextButton(final String label)
	{
		final JButton button = new JButton(label);
		button.addActionListener(e -> onNext());
		return button;
	}

	protected JButton newPreviousButton(final String label)
	{
		final JButton button = new JButton(label);
		button.addActionListener(e -> onPrevious());
		return button;
	}

	protected void onCancel()
	{
	}

	protected void onFinish()
	{
	}

	@Override
	protected void onInitializeComponents()
	{
		btnNext = newNextButton("Next");
		btnPrevious = newPreviousButton("Previous");
		btnCancel = newCancelButton("Cancel");
		btnFinish = newFinishButton("Finish");
		add(btnPrevious);
		add(btnNext);
		add(btnCancel);
		add(btnFinish);
	}

	@Override
	protected void onInitializeLayout()
	{
		setBorder(new LineBorder(Color.BLACK));
	}

	protected void onNext()
	{
	}

	protected void onPrevious()
	{
	}

}