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

import javax.swing.JComponent;
import javax.swing.JLabel;

public class JLabelOutputStream extends AbstractComponentOutputStream<JLabel>
{

	private final StringBuilder sb = new StringBuilder();

	public JLabelOutputStream(JLabel component)
	{
		super(component);
	}

	public JLabelOutputStream(JLabel component, int maxLines)
	{
		super(component, maxLines);
	}

	@Override
	protected void append(JComponent swingComponent, String text)
	{
		sb.append(text);
		redrawTextOf(swingComponent);
	}

	protected void redrawTextOf(JComponent swingComponent)
	{
		((JLabel)swingComponent).setText(sb.toString());
	}

	@Override
	protected void replaceRange(JComponent swingComponent, String text, int start, int end)
	{
		sb.replace(start, end, text);
		redrawTextOf(swingComponent);
	}

	@Override
	protected void setText(JComponent swingComponent, String text)
	{
		sb.delete(0, sb.length());
		append(swingComponent, text);
	}

}
