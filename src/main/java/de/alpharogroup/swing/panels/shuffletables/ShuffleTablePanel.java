/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
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
package de.alpharogroup.swing.panels.shuffletables;

import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXPanel;

import de.alpharogroup.swing.x.GenericJXTable;
import de.alpharogroup.swing.x.GenericShuffleJXTable;

public class ShuffleTablePanel<T> extends JXPanel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	protected JXButton btnAddAll;

	protected JXButton btnAdd;

	protected JXButton btnRemoveAll;

	protected JXButton btnRemove;

	protected JXLabel lblAvailableElements;

	protected JXLabel lblSelectedElements;

	protected JScrollPane scrPnTblAvailableElements;

	protected JScrollPane scrPnTblSelectedElements;

	protected GenericJXTable<T> tblAvailableElements;

	protected GenericJXTable<T> tblSelectedElements;

	protected GenericShuffleJXTable<T> shuffleTable;

	public ShuffleTablePanel()
	{
		super();
	}

	public JXButton getBtnAdd()
	{
		return btnAdd;
	}

	public JXButton getBtnAddAll()
	{
		return btnAddAll;
	}

	public JXButton getBtnRemove()
	{
		return btnRemove;
	}

	public JXButton getBtnRemoveAll()
	{
		return btnRemoveAll;
	}

	public JXLabel getLblAvailableElements()
	{
		return lblAvailableElements;
	}

	public JXLabel getLblSelectedElements()
	{
		return lblSelectedElements;
	}


	public JScrollPane getScrPnTblAvailableElements()
	{
		return scrPnTblAvailableElements;
	}

	public JScrollPane getScrPnTblSelectedElements()
	{
		return scrPnTblSelectedElements;
	}

	public GenericJXTable<T> getTblAvailableElements()
	{
		return tblAvailableElements;
	}

	public GenericJXTable<T> getTblSelectedElements()
	{
		return tblSelectedElements;
	}

	public void setBtnAdd(final JXButton btnAdd)
	{
		this.btnAdd = btnAdd;
	}

	public void setBtnAddAll(final JXButton btnAddAll)
	{
		this.btnAddAll = btnAddAll;
	}

	public void setBtnRemove(final JXButton btnRemove)
	{
		this.btnRemove = btnRemove;
	}

	public void setBtnRemoveAll(final JXButton btnRemoveAll)
	{
		this.btnRemoveAll = btnRemoveAll;
	}

	public void setLblAvailableElements(final JXLabel lblAvailableElements)
	{
		this.lblAvailableElements = lblAvailableElements;
	}

	public void setLblSelectedElements(final JXLabel lblSelectedElements)
	{
		this.lblSelectedElements = lblSelectedElements;
	}

	public void setScrPnTblAvailableElements(final JScrollPane scrPnTblAvailableElements)
	{
		this.scrPnTblAvailableElements = scrPnTblAvailableElements;
	}

	public void setScrPnTblSelectedElements(final JScrollPane scrPnTblSelectedElements)
	{
		this.scrPnTblSelectedElements = scrPnTblSelectedElements;
	}

	public void setTblAvailableElements(final GenericJXTable<T> tblAvailableElements)
	{
		this.tblAvailableElements = tblAvailableElements;
	}

	public void setTblSelectedElements(final GenericJXTable<T> tblSelectedElements)
	{
		this.tblSelectedElements = tblSelectedElements;
	}
}
