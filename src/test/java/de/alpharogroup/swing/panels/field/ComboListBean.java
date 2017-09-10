package de.alpharogroup.swing.panels.field;

import java.io.Serializable;
import java.util.List;

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
@Builder(toBuilder=true)
public class ComboListBean implements Serializable
{

	private static final long serialVersionUID = 1L;

	String selectedItem;

	List<String> comboList;

}
