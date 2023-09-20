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
package io.github.astrapi69.swing.panel.output;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The class {@link ConsolePanel} provides a {@link JTextArea} that prints the output from system
 * out and error output stream
 */
public class ConsolePanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	final JScrollPane jScrollPane;
	final JTextArea textArea;

	public ConsolePanel()
	{
		super(new BorderLayout());
		textArea = newJTextArea();
		jScrollPane = new JScrollPane(textArea);
		add(jScrollPane);
	}

	/**
	 * Factory method that creates a new {@link JTextArea} that prints the output from system out
	 * and error output stream. For custom
	 * 
	 * @return the JX text area
	 */
	protected JTextArea newJTextArea()
	{
		JTextArea textArea = new JTextArea();
		JTextAreaOutputStream taout = new JTextAreaOutputStream(textArea, 60);
		PrintStream ps = new PrintStream(taout);
		System.setOut(ps);
		System.setErr(ps);
		return textArea;
	}
}
