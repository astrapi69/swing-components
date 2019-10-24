package de.alpharogroup.swing.tree.labels;

import javax.swing.JLabel;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckBoxTreeLabel extends JLabel
{
	@SuppressWarnings("unused")
	boolean selected;

	@SuppressWarnings("unused")
	boolean focused;

}