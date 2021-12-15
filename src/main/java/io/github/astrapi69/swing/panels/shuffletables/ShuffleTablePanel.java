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
package io.github.astrapi69.swing.panels.shuffletables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import lombok.Getter;
import lombok.Setter;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXLabel;

import io.github.astrapi69.model.GenericModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.x.GenericJXTable;
import io.github.astrapi69.swing.x.GenericShuffleJXTable;

/**
 * The class {@link ShuffleTablePanel}.
 *
 * @param <T>
 *            the generic type of the model
 *
 * @deprecated use instead the same named class in project swing-table-components<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
@Getter
@Setter
public class ShuffleTablePanel<T> extends BasePanel<List<T>>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	protected JXButton btnAdd;

	protected JXButton btnAddAll;

	protected JXButton btnRemove;

	protected JXButton btnRemoveAll;

	protected JXLabel lblAvailableElements;

	protected JXLabel lblSelectedElements;

	protected JScrollPane scrPnTblAvailableElements;

	protected JScrollPane scrPnTblSelectedElements;

	protected GenericShuffleJXTable<T> shuffleTable;

	protected GenericJXTable<T> tblAvailableElements;

	protected GenericJXTable<T> tblSelectedElements;

	public ShuffleTablePanel()
	{
		this(GenericModel.ofList(new ArrayList<>()));
	}

	public ShuffleTablePanel(final Model<List<T>> model)
	{
		super(model);
	}

}
