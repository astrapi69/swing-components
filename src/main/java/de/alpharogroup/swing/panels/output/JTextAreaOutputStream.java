package de.alpharogroup.swing.panels.output;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class JTextAreaOutputStream extends AbstractComponentOutputStream<JTextArea>
{

	public JTextAreaOutputStream(JTextArea component, int maxLines)
	{
		super(component, maxLines);
	}

	public JTextAreaOutputStream(JTextArea component)
	{
		super(component);
	}
	private StringBuilder sb = new StringBuilder();

	@Override
	protected void setText(JComponent swingComponent, String text)
	{
		sb.delete(0, sb.length());
		append(swingComponent, text);
	}

	@Override
	protected void replaceRange(JComponent swingComponent, String text, int start, int end)
	{
		sb.replace(start, end, text);
		redrawTextOf(swingComponent);
	}

	@Override
	protected void append(JComponent swingComponent, String text)
	{
		sb.append(text);
		redrawTextOf(swingComponent);
	}

	protected void redrawTextOf(JComponent swingComponent)
	{
		((JTextArea)swingComponent).setText(sb.toString());
	}

}
