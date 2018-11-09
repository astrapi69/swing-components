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
package de.alpharogroup.swing.base;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.help.CSH;
import javax.help.DefaultHelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.help.WindowPresentation;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import de.alpharogroup.lang.ClassExtensions;
import de.alpharogroup.swing.menu.MenuExtensions;
import de.alpharogroup.swing.plaf.actions.LookAndFeelGTKAction;
import de.alpharogroup.swing.plaf.actions.LookAndFeelMetalAction;
import de.alpharogroup.swing.plaf.actions.LookAndFeelMotifAction;
import de.alpharogroup.swing.plaf.actions.LookAndFeelNimbusAction;
import de.alpharogroup.swing.plaf.actions.LookAndFeelSystemAction;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class DesktopMenu.
 */
@Slf4j
@FieldDefaults(level=AccessLevel.PRIVATE, makeFinal=true)
public class BaseDesktopMenu extends JMenu
{

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(BaseDesktopMenu.class.getName());

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The application frame. */
	Component applicationFrame;

	/** The file menu. */
	@Getter
	JMenu fileMenu;

	@Getter
	DefaultHelpBroker helpBroker;

	/** The help menu. */
	@Getter
	JMenu helpMenu;

	/** The help window. */
	@Getter
	Window helpWindow;

	/** The look and feel menu. */
	@Getter
	JMenu lookAndFeelMenu;

	/** The JMenuBar from the DesktopMenu. */
	@Getter
	JMenuBar menubar;

	/**
	 * Instantiates a new desktop menu.
	 */
	public BaseDesktopMenu(@NonNull Component applicationFrame)
	{
		this.applicationFrame = applicationFrame;
		helpBroker = newHelpBroker();
		helpWindow = newHelpWindow(helpBroker);
		menubar = newJMenuBar();
		menubar.add(fileMenu = newFileMenu(e -> logger.debug("filemenu")));
		menubar.add(lookAndFeelMenu = newLookAndFeelMenu(e -> logger.debug("Look and Feel menu")));
		menubar.add(helpMenu = newHelpMenu(e -> logger.debug("Help menu")));
	}

	/**
	 * Gets the help set.
	 *
	 * @return the help set
	 */
	public HelpSet getHelpSet()
	{
		HelpSet hs = null;
		final String filename = "simple-hs.xml";
		final String path = "help/" + filename;
		URL hsURL;
		hsURL = ClassExtensions.getResource(path);
		try
		{
			hs = new HelpSet(ClassExtensions.getClassLoader(), hsURL);
		}
		catch (final HelpSetException e)
		{
			String title = e.getLocalizedMessage();
			String htmlMessage = "<html><body width='650'>" + "<h2>" + title + "</h2>" + "<p>"
				+ e.getMessage();
			JOptionPane.showMessageDialog(this.getParent(), htmlMessage, title,
				JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage(), e);
		}
		return hs;
	}

	/**
	 * Creates the file menu.
	 *
	 * @param listener
	 *            the listener
	 *
	 * @return the j menu
	 */
	protected JMenu newFileMenu(final ActionListener listener)
	{
		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		return fileMenu;
	}

	protected DefaultHelpBroker newHelpBroker()
	{
		final HelpSet hs = getHelpSet();
		final DefaultHelpBroker helpBroker = (DefaultHelpBroker)hs.createHelpBroker();
		return helpBroker;
	}

	/**
	 * Creates the help menu.
	 *
	 * @param listener
	 *            the listener
	 * @return the j menu
	 */
	protected JMenu newHelpMenu(final ActionListener listener)
	{
		// Help menu
		final JMenu menuHelp = new JMenu("Help"); //$NON-NLS-1$
		menuHelp.setMnemonic('H');

		// Help JMenuItems
		// Help content
		final JMenuItem mihHelpContent = new JMenuItem("Content", 'c'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mihHelpContent, 'H');

		menuHelp.add(mihHelpContent);

		// 2. assign help to components
		CSH.setHelpIDString(mihHelpContent, "Overview");
		// 3. handle events
		final CSH.DisplayHelpFromSource displayHelpFromSource = new CSH.DisplayHelpFromSource(
			helpBroker);
		mihHelpContent.addActionListener(displayHelpFromSource);

		return menuHelp;
	}

	protected Window newHelpWindow(final DefaultHelpBroker helpBroker)
	{
		// found bug with the javax.help
		// Exception in thread "main" java.lang.SecurityException: no manifiest
		// section for signature file entry
		// com/sun/java/help/impl/TagProperties.class
		// Solution is to remove the rsa files from the jar
		final WindowPresentation pres = helpBroker.getWindowPresentation();
		pres.createHelpWindow();
		Window helpWindow = pres.getHelpWindow();

		helpWindow.setLocationRelativeTo(null);

		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (final Exception e)
		{
			String title = e.getLocalizedMessage();
			String htmlMessage = "<html><body width='650'>" + "<h2>" + title + "</h2>" + "<p>"
				+ e.getMessage();
			JOptionPane.showMessageDialog(this.getParent(), htmlMessage, title,
				JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage(), e);
		}
		SwingUtilities.updateComponentTreeUI(helpWindow);
		return helpWindow;

	}

	/**
	 * Creates a new {@link JMenuBar}
	 *
	 * @return the new {@link JMenuBar}
	 */
	protected JMenuBar newJMenuBar()
	{
		return new JMenuBar();
	}

	/**
	 * Creates the look and feel menu.
	 *
	 * @param listener
	 *            the listener
	 * @return the j menu
	 */
	protected JMenu newLookAndFeelMenu(final ActionListener listener)
	{

		final JMenu menuLookAndFeel = new JMenu("Look and Feel");
		menuLookAndFeel.setMnemonic('L');

		// Look and Feel JMenuItems
		// GTK
		JMenuItem jmiPlafGTK;
		jmiPlafGTK = new JMenuItem("GTK", 'g'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiPlafGTK, 'G');
		jmiPlafGTK.addActionListener(new LookAndFeelGTKAction("GTK", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafGTK);
		// Metal default Metal theme
		JMenuItem jmiPlafMetal;
		jmiPlafMetal = new JMenuItem("Metal", 'm'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiPlafMetal, 'M');
		jmiPlafMetal.addActionListener(new LookAndFeelMetalAction("Metal", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafMetal);
		// Metal Ocean theme
		JMenuItem jmiPlafOcean;
		jmiPlafOcean = new JMenuItem("Ocean", 'o'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiPlafOcean, 'O');
		jmiPlafOcean.addActionListener(new LookAndFeelMetalAction("Ocean", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafOcean);
		// Motif
		JMenuItem jmiPlafMotiv;
		jmiPlafMotiv = new JMenuItem("Motif", 't'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiPlafMotiv, 'T');
		jmiPlafMotiv.addActionListener(new LookAndFeelMotifAction("Motif", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafMotiv);
		// Nimbus
		JMenuItem jmiPlafNimbus;
		jmiPlafNimbus = new JMenuItem("Nimbus", 'n'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiPlafNimbus, 'N');
		jmiPlafNimbus
			.addActionListener(new LookAndFeelNimbusAction("Nimbus", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafNimbus);
		// Windows
		JMenuItem jmiPlafSystem;
		jmiPlafSystem = new JMenuItem("System", 'd'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiPlafSystem, 'W');
		jmiPlafSystem
			.addActionListener(new LookAndFeelSystemAction("System", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafSystem);

		return menuLookAndFeel;

	}

}