package de.alpharogroup.swing.radiomodel;

import java.util.EnumMap;
import java.util.Map;
import javax.swing.JRadioButton;

/**
 * The class {@link RadioButtonGroupEnumModel} can be used with {@link JRadioButton}.
 *
 * @param <E>
 *            the generic enum type
 */
public class RadioButtonGroupEnumModel<E extends Enum<E>>
{

	/** The button map. */
	private final Map<E, JRadioButton> buttonMap;

	/**
	 * Instantiates a new {@link RadioButtonGroupEnumModel}.
	 *
	 * @param enumClass
	 *            the enum class
	 */
	public RadioButtonGroupEnumModel(Class<E> enumClass)
	{
		this.buttonMap = new EnumMap<>(enumClass);
	}

	/**
	 * Import map.
	 *
	 * @param map
	 *            the map
	 */
	public void importMap(Map<E, JRadioButton> map)
	{
		for (E e : map.keySet())
		{
			this.buttonMap.put(e, map.get(e));
		}
	}

	/**
	 * Associate the given enum value with the given {@link JRadioButton}.
	 *
	 * @param enumValue
	 *            the enum value
	 * @param radioButton
	 *            the radio button
	 */
	public void associate(E enumValue, JRadioButton radioButton)
	{
		this.buttonMap.put(enumValue, radioButton);
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public E getValue()
	{
		for (E e : this.buttonMap.keySet())
		{
			JRadioButton btn = this.buttonMap.get(e);
			if (btn.isSelected())
			{
				return e;
			}
		}
		return null;
	}

	/**
	 * Sets the value.
	 *
	 * @param e
	 *            the new value
	 */
	public void setValue(E e)
	{
		JRadioButton btn = (e == null) ? null : this.buttonMap.get(e);
		if (btn == null)
		{
			// the following doesn't seem efficient...
			// but since when do we have more than say 10 radiobuttons?
			for (JRadioButton b : this.buttonMap.values())
			{
				b.setSelected(false);
			}

		}
		else
		{
			btn.setSelected(true);
		}
	}

}
