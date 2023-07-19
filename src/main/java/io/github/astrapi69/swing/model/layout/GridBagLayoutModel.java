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
package io.github.astrapi69.swing.model.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link GridBagLayoutModel} holds data for layout a component with the
 * {@link GridBagLayout}.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder(toBuilder = true)
public class GridBagLayoutModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The anchor. */
	private final int anchor;

	/** The fill. */
	private final int fill;

	/** The gbc. */
	private final GridBagConstraints gridBagConstraints;

	/** The gbl. */
	private final GridBagLayout gridBagLayout;

	/** The gridheight. */
	private final int gridheight;

	/** The gridwidth. */
	private final int gridwidth;

	/** The gridx. */
	private final int gridx;

	/** The gridy. */
	private final int gridy;

	/** The horizontal strut. */
	private final int horizontalStrut;

	/** The insets. */
	private final InsetsModel insets;

	/** The ipadx. */
	private final int ipadx;

	/** The ipady. */
	private final int ipady;

	/** The layout component. */
	private final Component layoutComponent;

	/** The panel to add. */
	private final Container parent;

	/** The vertical strut. */
	private final int verticalStrut;

	/** The weightx. */
	private final double weightx;

	/** The weighty. */
	private final double weighty;
}
