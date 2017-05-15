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

import de.alpharogroup.swing.tablemodel.BaseTableModel;
import de.alpharogroup.swing.tablemodel.TableColumnsModel;

/**
 * The class {@link ThreadsTableModel} that lists all threads.
 */
public class ThreadsTableModel extends BaseTableModel<ThreadDataBean> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private List<ThreadDataBean> currentThreadData;
	
	private Object lock;

	private Thread updateRunningThreads;

	private volatile boolean running;

	/**
	 * Instantiates a new {@link ThreadsTableModel} object.
	 */
	public ThreadsTableModel() {
		this(TableColumnsModel.builder().columnNames(new String[] { "Priority", "Alive", "Daemon", "Interrupted", "Thread group", "Name" })
				.canEdit(new boolean[] { false, false, false, false, false, false })
				.columnClasses(new Class<?>[]{Integer.class, Boolean.class, Boolean.class, Boolean.class, String.class, String.class})
				.build());
	}

	/**
	 * Instantiates a new {@link ThreadsTableModel} object.
	 */
	public ThreadsTableModel(TableColumnsModel columnsModel) {
		super(columnsModel);
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
				Thread.sleep(1000);
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
