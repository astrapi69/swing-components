package io.github.astrapi69.swing.combobox.model;

import java.util.List;
import java.util.Set;

/**
 * The class {@link GenericComboBoxModel} is an implementation of the abstract class
 * {@link AbstractComboBoxModel} for generic values.
 */
public class GenericComboBoxModel<T> extends AbstractComboBoxModel<T>
{

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link GenericComboBoxModel} with a new list.
	 */
	public GenericComboBoxModel()
	{
		super();
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given list
	 *
	 * @param comboList
	 *            the combo list
	 */
	public GenericComboBoxModel(final List<T> comboList)
	{
		super(comboList);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given list and set as selected item
	 * the given value
	 *
	 * @param comboList
	 *            the combo list
	 * @param selectedItem
	 *            the selected item
	 */
	public GenericComboBoxModel(final List<T> comboList, final T selectedItem)
	{
		super(comboList, selectedItem);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given {@link Set}.
	 *
	 * @param set
	 *            the combo set
	 */
	public GenericComboBoxModel(final Set<T> set)
	{
		super(set);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given array
	 *
	 * @param comboArray
	 *            the combo array
	 */
	public GenericComboBoxModel(final T[] comboArray)
	{
		super(comboArray);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given array and set as selected item
	 * the given value
	 *
	 * @param comboArray
	 *            the combo array
	 * @param selectedItem
	 *            the selected item
	 */
	public GenericComboBoxModel(final T[] comboArray, final T selectedItem)
	{
		super(comboArray, selectedItem);
	}

	/**
	 * Instantiates a new {@link GenericComboBoxModel} from the given array and set as selected item
	 * the given value
	 *
	 * @param comboArray
	 *            the combo array
	 * @param selectedItem
	 *            the selected item
	 * @param excludeValues
	 *            the values to exclude
	 */
	public GenericComboBoxModel(final T[] comboArray, final T selectedItem,
		final Set<T> excludeValues)
	{
		super(comboArray, selectedItem, excludeValues);
	}

}
