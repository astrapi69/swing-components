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
package io.github.astrapi69.swing.table.model.thread;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.swing.*;

import io.github.astrapi69.lang.thread.ThreadDataBean;
import io.github.astrapi69.lang.thread.ThreadExtensions;
import io.github.astrapi69.swing.table.model.BaseTableModel;
import io.github.astrapi69.swing.table.model.TableColumnsModel;

/**
 * The class {@link ThreadsTableModel} that lists all threads.
 *
 * @deprecated use instead the same named class in project swing-table-components<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public class ThreadsTableModel extends BaseTableModel<ThreadDataBean>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private List<ThreadDataBean> currentThreadData;

	private Object lock;

	private volatile boolean running;

	private Thread updateRunningThreads;

	/**
	 * Instantiates a new {@link ThreadsTableModel} object.
	 */
	public ThreadsTableModel()
	{
		this(TableColumnsModel.builder()
			.columnNames(new String[] { "Priority", "Alive", "Daemon", "Interrupted",
					"Thread group", "Name" })
			.canEdit(new boolean[] { false, false, false, false, false, false })
			.columnClasses(new Class<?>[] { Integer.class, Boolean.class, Boolean.class,
					Boolean.class, String.class, String.class })
			.build());
	}

	/**
	 * Instantiates a new {@link ThreadsTableModel} object.
	 *
	 * @param columnsModel
	 *            the columns model
	 */
	public ThreadsTableModel(final TableColumnsModel columnsModel)
	{
		super(columnsModel);
		onInitialize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueAt(final int row, final int col)
	{
		final ThreadDataBean threadData = getData().get(row);
		switch (col)
		{
			case 0 :
				return threadData.getPriority();
			case 1 :
				return threadData.isAlive();
			case 2 :
				return threadData.isDaemon();
			case 3 :
				return threadData.isInterrupted();
			case 4 :
				return threadData.getThreadGroup();
			case 5 :
				return threadData.getName();
			default :
				return null;
		}
	}

	public void interrupt()
	{
		running = false;
		updateRunningThreads.interrupt();
	}

	private void newThreadData()
	{
		synchronized (lock)
		{
			currentThreadData = ThreadExtensions.newThreadData();
		}
	}

	protected void onInitialize()
	{
		lock = new Object();

		running = true;
		final Runnable updater = new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					update();
				}
				catch (final Exception exception)
				{
					exception.printStackTrace();
				}
			}
		};
		updateRunningThreads = new Thread(updater, "RunningThreadUpdater");
		updateRunningThreads.setPriority(Thread.MAX_PRIORITY);
		updateRunningThreads.setDaemon(true);
		updateRunningThreads.start();

	}

	private void update()
	{
		final Runnable updateCurrentRunningThreads = new Runnable()
		{
			@Override
			public void run()
			{
				updateCurrentThreadData();
				fireTableDataChanged();
			}
		};

		while (running)
		{
			try
			{
				newThreadData();
				SwingUtilities.invokeAndWait(updateCurrentRunningThreads);
				Thread.sleep(1000);
			}
			catch (final InterruptedException exception)
			{
				Thread.currentThread().interrupt();
			}
			catch (final InvocationTargetException exception)
			{
				exception.printStackTrace();
				interrupt();
			}
		}
	}

	private void updateCurrentThreadData()
	{
		synchronized (lock)
		{
			setData(currentThreadData);
		}
	}

}
