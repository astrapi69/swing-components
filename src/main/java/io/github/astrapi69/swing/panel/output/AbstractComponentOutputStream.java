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

import java.awt.EventQueue;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

/**
 * The class {@link AbstractComponentOutputStream} is inspired from <a href=
 * "https://stackoverflow.com/questions/342990/create-java-console-inside-a-gui-panel">stackoverflow
 * question</a> and the accepted answer.
 *
 * @param <T>
 *            the generic type of the component
 */
public abstract class AbstractComponentOutputStream<T extends JComponent> extends OutputStream
{

	private final Lock jcosLock = new ReentrantLock();
	private final byte[] oneByte;
	private Appender appender;

	public AbstractComponentOutputStream(T component)
	{
		this(component, 100);
	}

	public AbstractComponentOutputStream(T component, int maxLines)
	{
		if (maxLines < 1)
		{
			throw new IllegalArgumentException(
				"JComponentOutputStream maximum lines must be positive (value=" + maxLines + ")");
		}
		oneByte = new byte[1];
		appender = new Appender(component, maxLines);
	}

	protected abstract void append(JComponent swingComponent, String text);

	private String bytesToString(byte[] ba, int str, int len)
	{
		try
		{
			return new String(ba, str, len, StandardCharsets.UTF_8.name());
		}
		catch (UnsupportedEncodingException thr)
		{
			return new String(ba, str, len);
		}
	}

	/** Clear the current console text area. */
	public void clear()
	{
		jcosLock.lock();
		try
		{
			if (appender != null)
			{
				appender.clear();
			}
		}
		finally
		{
			jcosLock.unlock();
		}
	}

	@Override
	public void close()
	{
		jcosLock.lock();
		try
		{
			appender = null;
		}
		finally
		{
			jcosLock.unlock();
		}
	}

	@Override
	public void flush()
	{
	}

	protected abstract void replaceRange(JComponent swingComponent, String text, int start,
		int end);

	/**
	 * Sets the text.
	 *
	 * @param swingComponent
	 *            the swing component
	 * @param text
	 *            the text
	 */
	protected abstract void setText(JComponent swingComponent, String text);

	@Override
	public void write(byte[] ba)
	{
		jcosLock.lock();
		try
		{
			write(ba, 0, ba.length);
		}
		finally
		{
			jcosLock.unlock();
		}
	}

	@Override
	public void write(byte[] ba, int str, int len)
	{
		jcosLock.lock();
		try
		{
			if (appender != null)
			{
				appender.append(bytesToString(ba, str, len));
			}
		}
		finally
		{
			jcosLock.unlock();
		}
	}

	@Override
	public void write(int val)
	{
		jcosLock.lock();
		try
		{
			oneByte[0] = (byte)val;
			write(oneByte, 0, 1);
		}
		finally
		{
			jcosLock.unlock();
		}
	}

	class Appender implements Runnable
	{
		private final String EOL1 = "\n";
		private final String EOL2 = System.getProperty("line.separator", EOL1);
		private final LinkedList<Integer> lengths; // length of lines within
		private final int maxLines; // maximum lines allowed in text area
		private final JComponent swingComponent;
		// text area
		private final List<String> values; // values waiting to be appended
		private final Lock appenderLock;
		private boolean clear;
		private int curLength; // length of current line
		private boolean queue;

		Appender(JComponent cpt, int maxLines)
		{
			appenderLock = new ReentrantLock();

			swingComponent = cpt;
			this.maxLines = maxLines;
			lengths = new LinkedList<Integer>();
			values = new ArrayList<String>();

			curLength = 0;
			clear = false;
			queue = true;
		}

		void append(String val)
		{
			appenderLock.lock();
			try
			{
				values.add(val);
				if (queue)
				{
					queue = false;
					EventQueue.invokeLater(this);
				}
			}
			finally
			{
				appenderLock.unlock();
			}
		}

		void clear()
		{
			appenderLock.lock();
			try
			{

				clear = true;
				curLength = 0;
				lengths.clear();
				values.clear();
				if (queue)
				{
					queue = false;
					EventQueue.invokeLater(this);
				}
			}
			finally
			{
				appenderLock.unlock();
			}
		}

		// MUST BE THE ONLY METHOD THAT TOUCHES the JComponent!
		@Override
		public void run()
		{
			appenderLock.lock();
			try
			{
				if (clear)
				{
					AbstractComponentOutputStream.this.setText(swingComponent, "");
				}
				for (String val : values)
				{
					curLength += val.length();
					if (val.endsWith(EOL1) || val.endsWith(EOL2))
					{
						if (lengths.size() >= maxLines)
						{
							AbstractComponentOutputStream.this.replaceRange(swingComponent, "", 0,
								lengths.removeFirst());
						}
						lengths.addLast(curLength);
						curLength = 0;
					}
					AbstractComponentOutputStream.this.append(swingComponent, val);
				}

				values.clear();
				clear = false;
				queue = true;
			}
			finally
			{
				appenderLock.unlock();
			}
		}
	}

}