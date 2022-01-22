package io.github.astrapi69.swing.component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ButtonModelBean implements Serializable
{
	/**
	 * Flag that indicates partial commitment towards triggering the button
	 */
	boolean armed;

	/**
	 * Flag that indicates if the button has been selected. Only needed for
	 * certain types of buttons - such as radio buttons and check boxes
	 */
	boolean selected;

	/**
	 * Flag that indicates if the button can be selected or triggered by
	 * an input device, such as a mouse pointer
	 */
	boolean enabled;

	/**
	 * Flag that indicates if the button is pressed
	 */
	boolean pressed;

	/**
	 * Flag that indicates that the mouse is over the button
	 */
	boolean rollover;
}
