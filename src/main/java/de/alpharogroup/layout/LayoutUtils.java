/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
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
package de.alpharogroup.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;

/**
 * The Class LayoutUtils helps with method for simplify the live with Layouts.
 */
public final class LayoutUtils
{


	/**
	 * Adds the component.
	 * 
	 * @param gbl
	 *            the gbl
	 * @param gbc
	 *            the gbc
	 * @param gridx
	 *            the gridx
	 * @param gridy
	 *            the gridy
	 * @param component
	 *            the component
	 * @param panelToAdd
	 *            the panel to add
	 */
	public static void addComponent(final GridBagLayout gbl, final GridBagConstraints gbc,
		final int gridx, final int gridy, final Component component, final Container panelToAdd)
	{
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbl.setConstraints(component, gbc);
		panelToAdd.add(component);
	}

	/**
	 * Adds the component.
	 * 
	 * @param gbl
	 *            the gbl
	 * @param gbc
	 *            the gbc
	 * @param anchor
	 *            the anchor
	 * @param fill
	 *            the fill
	 * @param insets
	 *            the insets
	 * @param gridx
	 *            the gridx
	 * @param gridy
	 *            the gridy
	 * @param gridwidth
	 *            the gridwidth
	 * @param gridheight
	 *            the gridheight
	 * @param weightx
	 *            the weightx
	 * @param weighty
	 *            the weighty
	 * @param addComponentToPanel
	 *            the add component to panel
	 * @param panelToAdd
	 *            the panel to add
	 */
	public static void addComponent(final GridBagLayout gbl, final GridBagConstraints gbc,
		final int anchor, final int fill, final Insets insets, final int gridx, final int gridy,
		final int gridwidth, final int gridheight, final double weightx, final double weighty,
		final Component addComponentToPanel, final Container panelToAdd)
	{
		gbc.anchor = anchor;
		gbc.fill = fill;
		gbc.insets = insets;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(addComponentToPanel, gbc);
		panelToAdd.add(addComponentToPanel);
	}

	/**
	 * Adds the component.
	 * 
	 * @param gbl
	 *            the gbl
	 * @param gbc
	 *            the gbc
	 * @param anchor
	 *            the anchor
	 * @param fill
	 *            the fill
	 * @param insets
	 *            the insets
	 * @param gridx
	 *            the gridx
	 * @param gridy
	 *            the gridy
	 * @param gridwidth
	 *            the gridwidth
	 * @param gridheight
	 *            the gridheight
	 * @param weightx
	 *            the weightx
	 * @param weighty
	 *            the weighty
	 * @param ipadx
	 *            the ipadx
	 * @param ipady
	 *            the ipady
	 * @param addComponentToPanel
	 *            the add component to panel
	 * @param panelToAdd
	 *            the panel to add
	 */
	public static void addComponent(final GridBagLayout gbl, final GridBagConstraints gbc,
		final int anchor, final int fill, final Insets insets, final int gridx, final int gridy,
		final int gridwidth, final int gridheight, final double weightx, final double weighty,
		final int ipadx, final int ipady, final Component addComponentToPanel,
		final Container panelToAdd)
	{
		gbc.anchor = anchor;
		gbc.fill = fill;
		gbc.insets = insets;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.ipadx = ipadx;
		gbc.ipady = ipady;
		gbl.setConstraints(addComponentToPanel, gbc);
		panelToAdd.add(addComponentToPanel);
	}

	/**
	 * Adds the component with horizontal strut in box.
	 * 
	 * @param gbl
	 *            the gbl
	 * @param gbc
	 *            the gbc
	 * @param anchor
	 *            the anchor
	 * @param fill
	 *            the fill
	 * @param insets
	 *            the insets
	 * @param gridx
	 *            the gridx
	 * @param gridy
	 *            the gridy
	 * @param gridwidth
	 *            the gridwidth
	 * @param gridheight
	 *            the gridheight
	 * @param weightx
	 *            the weightx
	 * @param weighty
	 *            the weighty
	 * @param horizontalStrut
	 *            the horizontal strut
	 * @param addComponentToPanel
	 *            the add component to panel
	 * @param panelToAdd
	 *            the panel to add
	 */
	public static void addComponentWithHorizontalStrutInBox(final GridBagLayout gbl,
		final GridBagConstraints gbc, final int anchor, final int fill, final Insets insets,
		final int gridx, final int gridy, final int gridwidth, final int gridheight,
		final double weightx, final double weighty, final int horizontalStrut,
		final Component addComponentToPanel, final Container panelToAdd)
	{
		gbc.anchor = anchor;
		gbc.fill = fill;
		gbc.insets = insets;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(addComponentToPanel, gbc);
		panelToAdd.add(addComponentToPanel);
		panelToAdd.add(Box.createHorizontalStrut(horizontalStrut), gbc);
	}

	/**
	 * Adds the component with vertical strut in box.
	 * 
	 * @param gbl
	 *            the gbl
	 * @param gbc
	 *            the gbc
	 * @param anchor
	 *            the anchor
	 * @param fill
	 *            the fill
	 * @param insets
	 *            the insets
	 * @param gridx
	 *            the gridx
	 * @param gridy
	 *            the gridy
	 * @param gridwidth
	 *            the gridwidth
	 * @param gridheight
	 *            the gridheight
	 * @param weightx
	 *            the weightx
	 * @param weighty
	 *            the weighty
	 * @param verticalStrut
	 *            the vertical strut
	 * @param addComponentToPanel
	 *            the add component to panel
	 * @param panelToAdd
	 *            the panel to add
	 */
	public static void addComponentWithVerticalStrutInBox(final GridBagLayout gbl,
		final GridBagConstraints gbc, final int anchor, final int fill, final Insets insets,
		final int gridx, final int gridy, final int gridwidth, final int gridheight,
		final double weightx, final double weighty, final int verticalStrut,
		final Component addComponentToPanel, final Container panelToAdd)
	{
		gbc.anchor = anchor;
		gbc.fill = fill;
		gbc.insets = insets;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(addComponentToPanel, gbc);
		panelToAdd.add(addComponentToPanel);
		panelToAdd.add(Box.createVerticalStrut(verticalStrut), gbc);
	}

}
