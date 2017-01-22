package de.alpharogroup.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * The class {@link GridBagLayoutModel} holds data for layout a component with the
 * {@link GridBagLayout}.
 */
@Data
@Builder
public class GridBagLayoutModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The gbl. */
	private final GridBagLayout gridBagLayout;

	/** The gbc. */
	private final GridBagConstraints gridBagConstraints;

	/** The anchor. */
	private final int anchor;

	/** The fill. */
	private final int fill;

	/** The insets. */
	private final InsetsModel insets;

	/** The gridx. */
	private final int gridx;

	/** The gridy. */
	private final int gridy;

	/** The gridwidth. */
	private final int gridwidth;

	/** The gridheight. */
	private final int gridheight;

	/** The weightx. */
	private final double weightx;

	/** The weighty. */
	private final double weighty;

	/** The ipadx. */
	private final int ipadx;

	/** The ipady. */
	private final int ipady;

	/** The horizontal strut. */
	private final int horizontalStrut;

	/** The vertical strut. */
	private final int verticalStrut;

	/** The layout component. */
	private final Component layoutComponent;

	/** The panel to add. */
	private final Container parent;
}
