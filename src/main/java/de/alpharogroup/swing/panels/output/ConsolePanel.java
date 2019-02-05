package de.alpharogroup.swing.panels.output;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTextArea;

/**
 * The class {@link ConsolePanel} provides a {@link JXTextArea} that prints the output from system
 * out and error output stream
 */
public class ConsolePanel extends JXPanel
{
	private static final long serialVersionUID = 1L;

	JXTextArea textArea;
	JScrollPane jScrollPane;

	public ConsolePanel()
	{
		super(new BorderLayout());
		textArea = newJXTextArea();
		jScrollPane = new JScrollPane(textArea);
		add(jScrollPane);
	}

	/**
	 * Factory method that creates a new {@link JXTextArea} that prints the output from system out
	 * and error output stream. For custom
	 * 
	 * @return the JX text area
	 */
	protected JXTextArea newJXTextArea()
	{
		JXTextArea textArea = new JXTextArea();
		JTextAreaOutputStream taout = new JTextAreaOutputStream(textArea, 60);
		PrintStream ps = new PrintStream(taout);
		System.setOut(ps);
		System.setErr(ps);
		return textArea;
	}
}
