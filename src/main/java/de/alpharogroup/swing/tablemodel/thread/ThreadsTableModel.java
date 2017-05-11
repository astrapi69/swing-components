/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Thread is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this Thread notice shall be
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
package de.alpharogroup.swing.tablemodel.thread;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;

import de.alpharogroup.swing.tablemodel.GenericTableModel;

/**
 * The class {@link ThreadsTableModel} that lists all threads.
 */
public class ThreadsTableModel extends GenericTableModel<ThreadDataBean> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private List<ThreadDataBean> currentThreadData;

	/** The Constant PRIORITY. */
	public static final String PRIORITY = "Priority";

	/** The Constant ALIVE. */
	public static final String ALIVE = "Alive";

	/** The Constant DAEMON. */
	public static final String DAEMON = "Daemon";

	/** The Constant INTERRUPTED. */
	public static final String INTERRUPTED = "Interrupted";

	/** The Constant NAME. */
	public static final String THREAD_GROUP = "Thread group";

	/** The Constant NAME. */
	public static final String NAME = "Name";

	/** The column names. */
	private final String[] columnNames = { PRIORITY, ALIVE, DAEMON, INTERRUPTED, THREAD_GROUP, NAME };

	/** The can edit. */
	private boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

	private Object lock;

	private Thread updateRunningThreads;

	private volatile boolean running;

	/**
	 * Instantiates a new {@link ThreadsTableModel} object.
	 */
	public ThreadsTableModel() {
		onInitialize();
	}
	
	protected void onInitialize() {
		lock = new Object();

		running = true;
		Runnable updater = new Runnable() {
			@Override
			public void run() {
				try {
					update();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		};
		updateRunningThreads = new Thread(updater, "RunningThreadUpdater");
		updateRunningThreads.setPriority(Thread.MAX_PRIORITY);
		updateRunningThreads.setDaemon(true);
		updateRunningThreads.start();
		
	}

	private void update() {
		Runnable updateCurrentRunningThreads = new Runnable() {
			@Override
			public void run() {
				updateCurrentThreadData();
				fireTableDataChanged();
			}
		};

		while (running) {
			try {
				newThreadData();
				SwingUtilities.invokeAndWait(updateCurrentRunningThreads);
				Thread.sleep(5000);
			} catch (InterruptedException exception) {
				Thread.currentThread().interrupt();
			} catch (InvocationTargetException exception) {
				exception.printStackTrace();
				interrupt();
			}
		}
	}

	private void newThreadData() {
		Thread[] thread = resolveRunningThreads();
		List<ThreadDataBean> newCellData = new ArrayList<>(thread.length);
		for (int i = 0; i < thread.length; i++) {
			Thread t = thread[i];
			newCellData.add(ThreadDataBean.of(t));
		}
		synchronized (lock) {
			currentThreadData = newCellData;
		}
	}

	public void interrupt() {
		running = false;
		updateRunningThreads.interrupt();
	}

	private void updateCurrentThreadData() {
		synchronized (lock) {
			setData(currentThreadData);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<?> getColumnClass(final int c) {
		switch (c) {
		case 0:
			return Integer.class;
		case 1:
			return Boolean.class;
		case 2:
			return Boolean.class;
		case 3:
			return Boolean.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		default:
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColumnName(final int col) {
		return columnNames[col];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueAt(final int row, final int col) {
		final ThreadDataBean threadData = getData().get(row);
		switch (col) {
		case 0:
			return threadData.getPriority();
		case 1:
			return threadData.isAlive();
		case 2:
			return threadData.isDaemon();
		case 3:
			return threadData.isInterrupted();
		case 4:
			return threadData.getThreadGroup();
		case 5:
			return threadData.getName();
		default:
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		return canEdit[columnIndex];
	}

	/**
	 * Finds all threads the are currently running.
	 *
	 * @return An array with all threads the are currently running.
	 */
	private Thread[] resolveRunningThreads() {
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
		return threadArray;
	}
}
