package de.alpharogroup.swing.tablemodel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * The abstract class {@link BaseTableModel} holds a {@link TableColumnsModel}
 * for layout the columns.
 *
 * @param <T>
 *            the generic type of the model
 */
public abstract class BaseTableModel<T> extends GenericTableModel<T> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The columns model. */
	@Getter
	@Setter
	private TableColumnsModel columnsModel;

	/**
	 * Instantiates a new {@link BaseTableModel}.
	 */
	public BaseTableModel() {
	}

	/**
	 * Instantiates a new {@link BaseTableModel}.
	 *
	 * @param list
	 *            the list
	 */
	public BaseTableModel(List<T> list) {
		super(list);
	}

	/**
	 * Instantiates a new base table model.
	 *
	 * @param columnsModel
	 *            the columns model
	 */
	public BaseTableModel(TableColumnsModel columnsModel) {
		this.columnsModel = columnsModel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<?> getColumnClass(final int c) {
		try {
			return columnsModel.getColumnClasses()[c];
		} catch (Exception e) {
			// ignore and return null...
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getColumnCount() {
		return columnsModel.getColumnNames().length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColumnName(final int col) {
		try {
			return columnsModel.getColumnNames()[col];
		} catch (Exception e) {
			// ignore and return null...
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		try {
			return columnsModel.getCanEdit()[columnIndex];
		} catch (Exception e) {
			// ignore and return the default value...
			return false;
		}
	}

}
