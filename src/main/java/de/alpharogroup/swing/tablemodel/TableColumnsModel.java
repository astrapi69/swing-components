package de.alpharogroup.swing.tablemodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link TableColumnsModel} encapsulates the column data for a table
 * model like the column names if they are editable and the column classes.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TableColumnsModel {
	
	/** The column names. */
	private String[] columnNames;
	
	/** The flag for the column if they can be edited. */
	private boolean[] canEdit;
	
	/** The column classes. */
	private Class<?>[] columnClasses;
}
