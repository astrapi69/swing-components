package de.alpharogroup.swing.menu;

import java.awt.event.ActionListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItemBean {
	private String label;
	private String command;
	private ActionListener actionListener;
}
