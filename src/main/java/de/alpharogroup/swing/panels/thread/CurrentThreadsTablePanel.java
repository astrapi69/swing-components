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
package de.alpharogroup.swing.panels.thread;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;

import de.alpharogroup.lang.thread.ThreadDataBean;
import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.base.BasePanel;
import de.alpharogroup.swing.table.model.thread.ThreadsTableModel;
import de.alpharogroup.swing.x.GenericJXTable;

/**
 * The class {@link CurrentThreadsTablePanel} shows all running threads in an application.
 */
public class CurrentThreadsTablePanel extends BasePanel<ThreadsTableModel>
{

	private static final long serialVersionUID = 1L;

	private JScrollPane scrThreadTable;

	private GenericJXTable<ThreadDataBean> threadTable;

	public CurrentThreadsTablePanel()
	{
		this(BaseModel.of(new ThreadsTableModel()));
	}

	public CurrentThreadsTablePanel(final Model<ThreadsTableModel> model)
	{
		super(model);
	}

	@Override
	protected void finalize() throws Throwable
	{
		super.finalize();
		interrupt();
	}

	public void interrupt()
	{
		getModelObject().interrupt();
	}

	protected ThreadsTableModel newThreadsTableModel()
	{
		final ThreadsTableModel tableModel = new ThreadsTableModel();
		return tableModel;
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		threadTable = new GenericJXTable<>(getModelObject());
		scrThreadTable = new JScrollPane(threadTable);
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeComponents();
		setLayout(new BorderLayout());
		add(scrThreadTable, BorderLayout.CENTER);
	}

}
