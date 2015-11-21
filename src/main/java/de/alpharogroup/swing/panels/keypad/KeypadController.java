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

import java.awt.event.ActionEvent;

import de.alpharogroup.generic.mvc.controller.AbstractGenericController;

public class KeypadController extends AbstractGenericController<KeypadModel, KeypadView>
{

	KeyPadPanel keyPadPanel = null;

	public KeypadController()
	{
		super();
	}

	public KeyPadPanel getKeyPadPanel()
	{
		return getKeypadView().getComponent();
	}

	public KeypadView getKeypadView()
	{
		return getView();
	}

	@Override
	public void process(final ActionEvent actionEvent)
	{
		if (null == keyPadPanel)
		{
			keyPadPanel = getKeyPadPanel();
		}
		if (actionEvent.getSource() == keyPadPanel.getButton1())
		{
			keyPadPanel.getTextAreaDisplay().append("1");
			System.out.println("1");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButton2())
		{
			keyPadPanel.getTextAreaDisplay().append("2");
			System.out.println("2");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButton3())
		{
			keyPadPanel.getTextAreaDisplay().append("3");
			System.out.println("3");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButton4())
		{
			keyPadPanel.getTextAreaDisplay().append("4");
			System.out.println("4");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButton5())
		{
			keyPadPanel.getTextAreaDisplay().append("5");
			System.out.println("5");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButton6())
		{
			keyPadPanel.getTextAreaDisplay().append("6");
			System.out.println("6");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButton7())
		{
			keyPadPanel.getTextAreaDisplay().append("7");
			System.out.println("7");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButton8())
		{
			keyPadPanel.getTextAreaDisplay().append("8");
			System.out.println("8");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButton9())
		{
			keyPadPanel.getTextAreaDisplay().append("9");
			System.out.println("9");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButton0())
		{
			keyPadPanel.getTextAreaDisplay().append("0");
			System.out.println("0");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButtonTable())
		{
			System.out.println("Table");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButtonCancel())
		{
			System.out.println("Cancel");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButtonStorno())
		{
			System.out.println("Storno");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButtonEnter())
		{
			System.out.println("Enter");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButtonPlus())
		{
			System.out.println("plus");
		}
		else if (actionEvent.getSource() == keyPadPanel.getButtonMinus())
		{
			System.out.println("minus");
		}
	}

}
