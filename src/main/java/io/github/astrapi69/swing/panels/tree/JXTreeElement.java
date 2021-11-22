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
package io.github.astrapi69.swing.panels.tree;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JXTreeElement implements Serializable
{
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_CONTENT_KEY = "default_content";

	/** The name of this tree element. */
	String name;

	/** The flag that indicates if this tree element is a node. */
	boolean node;

	/** The flag that indicates if a text label should shown if an icon exists */
	boolean withText;

	/** The icon path for a custom tree icon, if not set default icon will be set */
	String iconPath;

	/** The parent of this tree element. */
	JXTreeElement parent;

	/** The map with optional properties */
	@Builder.Default
	final Map<String, Object> properties = new LinkedHashMap<>();

	/**
	 * Gets the default content object from the map
	 * 
	 * @return the default content object from the map
	 */
	public Object getDefaultContent()
	{
		return properties.get(DEFAULT_CONTENT_KEY);
	}

	/**
	 * Sets the default content object from the map to the given object
	 * 
	 * @param defaultContent
	 *            the default content object to set
	 * @return this object
	 */
	public JXTreeElement setDefaultContent(Object defaultContent)
	{
		properties.put(DEFAULT_CONTENT_KEY, defaultContent);
		return this;
	}
}