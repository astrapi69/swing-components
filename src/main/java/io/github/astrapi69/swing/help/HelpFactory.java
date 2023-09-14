/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
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
package io.github.astrapi69.swing.help;

import java.awt.Window;
import java.net.URL;

import javax.help.CSH;
import javax.help.DefaultHelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.help.WindowPresentation;
import javax.swing.JMenuItem;

import io.github.astrapi69.lang.ClassExtensions;
import io.github.astrapi69.swing.menu.factory.JMenuItemFactory;
import lombok.NonNull;

/**
 * A factory {@link HelpFactory} provides factory methods for create all components for the help
 * window
 */
public class HelpFactory
{

	/**
	 * Factory method for create a <code>HelpSet</code> object
	 *
	 * @param directory
	 *            the directory where the helpset file is
	 * @param filename
	 *            the filename of the helpset file
	 * @return the new {@link HelpSet} object
	 * @throws HelpSetException
	 *             is thrown if there are problems parsing the help set
	 */
	public static HelpSet newHelpSet(String directory, String filename) throws HelpSetException
	{
		HelpSet hs;
		final String path = directory + "/" + filename;
		URL hsURL;
		hsURL = ClassExtensions.getResource(path);
		if (hsURL != null)
		{
			hs = new HelpSet(ClassExtensions.getClassLoader(), hsURL);
		}
		else
		{
			hs = new HelpSet();
		}
		return hs;
	}

	/**
	 * Factory method for create a <code>DefaultHelpBroker</code> object
	 *
	 * @param directory
	 *            the directory where the helpset file is
	 * @param filename
	 *            the filename of the helpset file
	 * @return the new {@link DefaultHelpBroker} object
	 * @throws HelpSetException
	 *             is thrown if there are problems parsing the help set
	 */
	public static DefaultHelpBroker newHelpBroker(String directory, String filename)
		throws HelpSetException
	{
		final HelpSet hs = newHelpSet(directory, filename);
		final DefaultHelpBroker helpBroker = (DefaultHelpBroker)hs.createHelpBroker();
		return helpBroker;
	}

	/**
	 * Factory method for create the help <code>Window</code> object
	 *
	 * @param helpBroker
	 *            the help broker
	 * @return the new {@link Window} object
	 */
	public static Window newHelpWindow(final DefaultHelpBroker helpBroker)
	{
		// found bug with the javax.help
		// Exception in thread "main" java.lang.SecurityException: no manifiest
		// section for signature file entry
		// com/sun/java/help/impl/TagProperties.class
		// Solution is to remove the rsa files from the jar
		final WindowPresentation pres = helpBroker.getWindowPresentation();
		pres.createHelpWindow();
		Window helpWindow = pres.getHelpWindow();
		return helpWindow;
	}

	/**
	 * Factory method for create a <code>JMenuItem</code> object that shows the help window
	 *
	 * @param helpBroker
	 *            the default help broker
	 * @param content
	 *            the text for the menu item
	 * @param overview
	 *            the title of the overview
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenuItem</code>
	 * @param accelerator
	 *            The character that have to push together with the CTRL.
	 * @return the new {@link JMenuItem} object
	 */
	public static JMenuItem newHelpContent(@NonNull DefaultHelpBroker helpBroker,
		@NonNull String content, @NonNull String overview, char mnemonic, char accelerator)
	{

		JMenuItem miHelpContent = JMenuItemFactory.newJMenuItem(content, mnemonic, accelerator);
		// 2. assign help to components
		CSH.setHelpIDString(miHelpContent, overview);
		// 3. handle events
		final CSH.DisplayHelpFromSource displayHelpFromSource = new CSH.DisplayHelpFromSource(
			helpBroker);
		miHelpContent.addActionListener(displayHelpFromSource);
		return miHelpContent;
	}
}
