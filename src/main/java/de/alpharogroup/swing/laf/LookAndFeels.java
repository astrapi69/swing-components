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
package de.alpharogroup.swing.laf;

import java.awt.Component;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * The Enum LookAndFeels.
 */
public enum LookAndFeels
{

	/** The METAL. */
	METAL(LookAndFeels.LOOK_AND_FEEL_METAL),

	/** The MOTIF. */
	MOTIF(LookAndFeels.LOOK_AND_FEEL_MOTIF),

	/** The WINDOWS. */
	WINDOWS(LookAndFeels.LOOK_AND_FEEL_WINDOWS),

	/** The SYSTEM. */
	SYSTEM(UIManager.getSystemLookAndFeelClassName());

	private static final String LOOK_AND_FEEL_WINDOWS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	private static final String LOOK_AND_FEEL_MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	private static final String LOOK_AND_FEEL_METAL = "javax.swing.plaf.metal.MetalLookAndFeel";

	public static void setLookAndFeel(final String aLook, final Component component)
		throws ClassNotFoundException, InstantiationException, IllegalAccessException,
		UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(aLook);
		SwingUtilities.updateComponentTreeUI(component);
	}

	/** The look and feel name. */
	private final String lookAndFeelName;

	/**
	 * Instantiates a new look and feels.
	 *
	 * @param name
	 *            the name
	 */
	LookAndFeels(final String name)
	{
		lookAndFeelName = name;
	}

	/**
	 * Gets the look and feel name.
	 *
	 * @return the look and feel name
	 */
	public String getLookAndFeelName()
	{
		return lookAndFeelName;
	}

}