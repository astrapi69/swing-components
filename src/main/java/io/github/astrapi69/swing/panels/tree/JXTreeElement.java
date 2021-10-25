package io.github.astrapi69.swing.panels.tree;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * The class {@link JXTreeElement} represents as the name already presume a tree element
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = { "parent" })
@ToString(exclude = { "parent" })
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JXTreeElement implements Serializable
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;

	/** The name of this tree element. */
	String name;

	/** The flag that indicates if this tree element is a node. */
	boolean node;

	/** The icon path for a custom tree icon, if not set default icon will be set */
	String iconPath;

	/** The parent of this tree element. */
	JXTreeElement parent;

	/** The map with optional properties */
	@Builder.Default
	Map<String, Object> properties = new LinkedHashMap<>();
}