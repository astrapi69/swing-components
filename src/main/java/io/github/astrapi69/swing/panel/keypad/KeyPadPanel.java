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
package io.github.astrapi69.swing.panel.keypad;

import java.awt.*;

import lombok.Getter;
import io.github.astrapi69.layout.LayoutExtensions;

/**
 * Panel for a number keypad.
 *
 * @author Asterios Raptis
 */
public class KeyPadPanel extends Panel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1L;
	@Getter
	private Button button0;
	@Getter
	private Button button1;
	@Getter
	private Button button2;
	@Getter
	private Button button3;
	@Getter
	private Button button4;
	@Getter
	private Button button5;
	@Getter
	private Button button6;
	@Getter
	private Button button7;
	@Getter
	private Button button8;
	@Getter
	private Button button9;
	@Getter
	private Button buttonCancel;
	@Getter
	private Button buttonEnter;
	@Getter
	private Button buttonMinus;
	@Getter
	private Button buttonPlus;
	@Getter
	private Button buttonStorno;
	@Getter
	private Button buttonTable;
	@Getter
	private TextArea textAreaDisplay;

	public KeyPadPanel()
	{
		initialize();
	}

	private void initialize()
	{
		textAreaDisplay = new TextArea("", 2, 5, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textAreaDisplay.setBounds(0, 0, 200, 40);
		textAreaDisplay.setEditable(false);

		initializeButtons();

		initializeLayout();
	}

	/**
	 * Initialize a button.
	 *
	 * @param button
	 *            the button
	 * @param foreground
	 *            the foreground
	 * @param background
	 *            the background
	 */
	protected void initializeButton(final Button button, final Color foreground,
		final Color background)
	{
		button.setForeground(foreground);
		button.setBackground(background);
	}

	/**
	 * Initialize the buttons.
	 */
	private void initializeButtons()
	{
		initializeButton(button1 = new Button("1"), Color.black, Color.lightGray);
		initializeButton(button2 = new Button("2"), Color.black, Color.lightGray);
		initializeButton(button3 = new Button("3"), Color.black, Color.lightGray);
		initializeButton(button4 = new Button("4"), Color.black, Color.lightGray);
		initializeButton(button5 = new Button("5"), Color.black, Color.lightGray);
		initializeButton(button6 = new Button("6"), Color.black, Color.lightGray);
		initializeButton(button7 = new Button("7"), Color.black, Color.lightGray);
		initializeButton(button8 = new Button("8"), Color.black, Color.lightGray);
		initializeButton(button9 = new Button("9"), Color.black, Color.lightGray);
		initializeButton(button0 = new Button("0"), Color.black, Color.lightGray);
		initializeButton(buttonCancel = new Button("A"), Color.black, Color.lightGray);
		initializeButton(buttonTable = new Button("T"), Color.black, Color.lightGray);
		initializeButton(buttonEnter = new Button("E"), Color.black, Color.lightGray);
		initializeButton(buttonMinus = new Button("-"), Color.black, Color.lightGray);
		initializeButton(buttonPlus = new Button("+"), Color.black, Color.lightGray);
		initializeButton(buttonStorno = new Button("ST"), Color.black, Color.lightGray);
	}

	/**
	 * Initialize layout.
	 */
	private void initializeLayout()
	{
		final GridBagLayout gbl = new GridBagLayout();
		final GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 0, 0, GridBagConstraints.REMAINDER, 1, 0, 0, 1, 1,
			textAreaDisplay, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 1, 1, 1, 100, 100, button1, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 1, 1, 1, 1, 100, 100, button2, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 2, 1, 1, 1, 100, 100, button3, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 3, 1, 1, 1, 100, 100, buttonTable,
			this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 2, 1, 1, 100, 100, button4, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 1, 2, 1, 1, 100, 100, button5, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 2, 2, 1, 1, 100, 100, button6, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 3, 2, 1, 1, 100, 100, buttonCancel,
			this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 3, 1, 1, 100, 100, button7, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 1, 3, 1, 1, 100, 100, button8, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 2, 3, 1, 1, 100, 100, button9, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 3, 3, 1, 1, 100, 100, buttonStorno,
			this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 4, 1, 1, 100, 100, buttonPlus,
			this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 1, 4, 1, 1, 100, 100, button0, this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 2, 4, 1, 1, 100, 100, buttonMinus,
			this);

		LayoutExtensions.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST,
			GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 3, 4, 1, 1, 100, 100, buttonEnter,
			this);

	}

}
