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

import de.alpharogroup.generic.mvc.view.AbstractGenericView;

public class KeypadView extends AbstractGenericView<KeypadController, KeyPadPanel>
{

	KeyPadPanel keyPadPanel = null;

	public KeypadView(final KeypadController controller)
	{
		super(controller);
		controller.setView(this);
		initialize();
	}

	public KeypadController getKeypadController()
	{
		return getController();
	}

	@Override
	protected void initialize()
	{
		keyPadPanel = new KeyPadPanel();
		setComponent(keyPadPanel);
		keyPadPanel.getButton0().addActionListener(getKeypadController());
		keyPadPanel.getButton1().addActionListener(getKeypadController());
		keyPadPanel.getButton2().addActionListener(getKeypadController());
		keyPadPanel.getButton3().addActionListener(getKeypadController());
		keyPadPanel.getButton4().addActionListener(getKeypadController());
		keyPadPanel.getButton5().addActionListener(getKeypadController());
		keyPadPanel.getButton6().addActionListener(getKeypadController());
		keyPadPanel.getButton7().addActionListener(getKeypadController());
		keyPadPanel.getButton8().addActionListener(getKeypadController());
		keyPadPanel.getButton9().addActionListener(getKeypadController());
		keyPadPanel.getButtonCancel().addActionListener(getKeypadController());
		keyPadPanel.getButtonEnter().addActionListener(getKeypadController());
		keyPadPanel.getButtonMinus().addActionListener(getKeypadController());
		keyPadPanel.getButtonPlus().addActionListener(getKeypadController());
		keyPadPanel.getButtonStorno().addActionListener(getKeypadController());
		keyPadPanel.getButtonTable().addActionListener(getKeypadController());
	}

}
