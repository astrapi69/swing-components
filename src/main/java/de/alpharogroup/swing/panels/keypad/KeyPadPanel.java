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
package de.alpharogroup.swing.panels.keypad;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextArea;

import de.alpharogroup.layout.LayoutUtils;

/**
 * Panel for a number keypad.
 * 
 * @author Asterios Raptis
 */
public class KeyPadPanel extends Panel
{

	/**
	 *
	 */
	private static final long serialVersionUID = -3996634633232412144L;

	private Button button1 = null;
	private Button button2 = null;
	private Button button3 = null;
	private Button button4 = null;
	private Button button5 = null;
	private Button button6 = null;
	private Button button7 = null;
	private Button button8 = null;
	private Button button9 = null;
	private Button button0 = null;
	private Button buttonTable = null;
	private Button buttonCancel = null;
	private Button buttonStorno = null;

	private Button buttonEnter = null;
	private Button buttonPlus = null;
	private Button buttonMinus = null;
	private TextArea textAreaDisplay = null;

	public KeyPadPanel()
	{
		initialize();
	}

	/**
	 * @return Returns the button0.
	 */
	public Button getButton0()
	{
		if (null == button0)
		{
			button0 = new Button("0");
			button0.setForeground(Color.black);
			button0.setBackground(Color.lightGray);
		}
		return button0;
	}

	/**
	 * @return Returns the button1.
	 */
	public Button getButton1()
	{
		if (null == button1)
		{
			button1 = new Button("1");
			button1.setForeground(Color.black);
			button1.setBackground(Color.lightGray);
		}
		return button1;
	}

	/**
	 * @return Returns the button2.
	 */
	public Button getButton2()
	{
		if (null == button2)
		{
			button2 = new Button("2");
			button2.setForeground(Color.black);
			button2.setBackground(Color.lightGray);
		}
		return button2;
	}

	/**
	 * @return Returns the button3.
	 */
	public Button getButton3()
	{
		if (null == button3)
		{
			button3 = new Button("3");
			button3.setForeground(Color.black);
			button3.setBackground(Color.lightGray);
		}
		return button3;
	}

	/**
	 * @return Returns the button4.
	 */
	public Button getButton4()
	{
		if (null == button4)
		{
			button4 = new Button("4");
			button4.setForeground(Color.black);
			button4.setBackground(Color.lightGray);
		}
		return button4;
	}

	/**
	 * @return Returns the button5.
	 */
	public Button getButton5()
	{
		if (null == button5)
		{
			button5 = new Button("5");
			button5.setForeground(Color.black);
			button5.setBackground(Color.lightGray);
		}
		return button5;
	}

	/**
	 * @return Returns the button6.
	 */
	public Button getButton6()
	{
		if (null == button6)
		{
			button6 = new Button("6");
			button6.setForeground(Color.black);
			button6.setBackground(Color.lightGray);
		}
		return button6;
	}

	/**
	 * @return Returns the button7.
	 */
	public Button getButton7()
	{
		if (null == button7)
		{
			button7 = new Button("7");
			button7.setForeground(Color.black);
			button7.setBackground(Color.lightGray);
		}
		return button7;
	}

	/**
	 * @return Returns the button8.
	 */
	public Button getButton8()
	{
		if (null == button8)
		{
			button8 = new Button("8");
			button8.setForeground(Color.black);
			button8.setBackground(Color.lightGray);
		}
		return button8;
	}

	/**
	 * @return Returns the button9.
	 */
	public Button getButton9()
	{
		if (null == button9)
		{
			button9 = new Button("9");
			button9.setForeground(Color.black);
			button9.setBackground(Color.lightGray);
		}
		return button9;
	}

	/**
	 * @return Returns the buttonAbrechnen.
	 */
	public Button getButtonCancel()
	{
		if (null == buttonCancel)
		{
			buttonCancel = new Button("A");
			buttonCancel.setForeground(Color.black);
			buttonCancel.setBackground(Color.lightGray);
		}
		return buttonCancel;
	}

	/**
	 * @return Returns the buttonEnter.
	 */
	public Button getButtonEnter()
	{
		if (null == buttonEnter)
		{
			buttonEnter = new Button("E");
			buttonEnter.setForeground(Color.black);
			buttonEnter.setBackground(Color.lightGray);
		}
		return buttonEnter;
	}

	/**
	 * @return Returns the buttonMinus.
	 */
	public Button getButtonMinus()
	{
		if (null == buttonMinus)
		{
			buttonMinus = new Button("-");
			buttonMinus.setForeground(Color.black);
			buttonMinus.setBackground(Color.lightGray);
		}
		return buttonMinus;
	}

	/**
	 * @return Returns the buttonPlus.
	 */
	public Button getButtonPlus()
	{
		if (null == buttonPlus)
		{
			buttonPlus = new Button("+");
			buttonPlus.setForeground(Color.black);
			buttonPlus.setBackground(Color.lightGray);
		}
		return buttonPlus;
	}

	/**
	 * @return Returns the buttonStorno.
	 */
	public Button getButtonStorno()
	{
		if (null == buttonStorno)
		{
			buttonStorno = new Button("ST");
			buttonStorno.setForeground(Color.black);
			buttonStorno.setBackground(Color.lightGray);
		}
		return buttonStorno;
	}

	/**
	 * @return Returns the buttonTisch.
	 */
	public Button getButtonTable()
	{
		if (null == buttonTable)
		{
			buttonTable = new Button("T");
			buttonTable.setForeground(Color.black);
			buttonTable.setBackground(Color.lightGray);
		}
		return buttonTable;
	}

	/**
	 * @return Returns the textAreaBestellungAuflisten.
	 */
	public TextArea getTextAreaDisplay()
	{
		if (null == textAreaDisplay)
		{
			textAreaDisplay = new TextArea("", 2, 5, TextArea.SCROLLBARS_VERTICAL_ONLY);
			textAreaDisplay.setBounds(0, 0, 200, 40);
			textAreaDisplay.setEditable(false);
		}
		return textAreaDisplay;
	}

	private void initialize()
	{
		getTextAreaDisplay();
		initializeButtons();
		initializeLayout();
	}

	/**
	 * Method createButtons
	 */
	private void initializeButtons()
	{
		getButton1();
		getButton2();
		getButton3();
		getButton4();
		getButton5();
		getButton6();
		getButton7();
		getButton8();
		getButton9();
		getButton0();
		getButtonCancel();
		getButtonTable();
		getButtonEnter();
		getButtonMinus();
		getButtonPlus();
		getButtonStorno();

	}

	/**
	 * Method createLayout
	 */
	private void initializeLayout()
	{
		final GridBagLayout gbl = new GridBagLayout();
		final GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 0, 0, GridBagConstraints.REMAINDER, 1, 0, 0, 1, 1,
			textAreaDisplay, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 0, 1, 1, 1, 100, 100, button1, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 1, 1, 1, 1, 100, 100, button2, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 2, 1, 1, 1, 100, 100, button3, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 3, 1, 1, 1, 100, 100, buttonTable, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 0, 2, 1, 1, 100, 100, button4, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 1, 2, 1, 1, 100, 100, button5, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 2, 2, 1, 1, 100, 100, button6, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 3, 2, 1, 1, 100, 100, buttonCancel, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 0, 3, 1, 1, 100, 100, button7, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 1, 3, 1, 1, 100, 100, button8, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 2, 3, 1, 1, 100, 100, button9, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 3, 3, 1, 1, 100, 100, buttonStorno, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 0, 4, 1, 1, 100, 100, buttonPlus, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 1, 4, 1, 1, 100, 100, button0, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 2, 4, 1, 1, 100, 100, buttonMinus, this);

		LayoutUtils.addComponent(gbl, gbc, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
			new Insets(2, 2, 2, 2), 3, 4, 1, 1, 100, 100, buttonEnter, this);

	}

}
