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
package io.github.astrapi69.swing.dialog;

import javax.swing.*;

import lombok.NonNull;

/**
 * The class {@link JOptionPaneExtensions} provides extension methods for the {@link JOptionPane}
 */
public class JOptionPaneExtensions
{

	/**
	 * Gets the selected option from the {@link JOptionPane}
	 *
	 * @param optionPane
	 *            the option pane
	 * @return the selected option
	 */
	public static int getSelectedOption(final @NonNull JOptionPane optionPane)
	{
		Object selectedOption = optionPane.getValue();
		if (selectedOption == null)
			return -1;
		Object[] options = optionPane.getOptions();
		if (options == null)
		{
			if (selectedOption instanceof Integer)
				return ((Integer)selectedOption).intValue();
			return -1;
		}
		for (int counter = 0, maxCounter = options.length; counter < maxCounter; counter++)
		{
			if (options[counter].equals(selectedOption))
				return counter;
		}
		return -1;
	}
}
