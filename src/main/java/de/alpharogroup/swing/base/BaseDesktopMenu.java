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
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Level;

import javax.help.CSH;
import javax.help.DefaultHelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.help.WindowPresentation;
import javax.swing.*;

import de.alpharogroup.lang.ClassExtensions;
import de.alpharogroup.swing.actions.OpenBrowserToDonateAction;
import de.alpharogroup.swing.actions.ShowInfoDialogAction;
import de.alpharogroup.swing.actions.ShowLicenseFrameAction;
import de.alpharogroup.swing.components.factories.JComponentFactory;
import de.alpharogroup.swing.dialog.info.InfoDialog;
import de.alpharogroup.swing.dialog.info.InfoPanel;
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
import lombok.extern.java.Log;

/**
 * The class {@link BaseDesktopMenu} holds the base menu items for an application
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log
public class BaseDesktopMenu extends JMenu
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The application frame. */
	@Getter
	Component applicationFrame;

	/** The edit menu. */
	@Getter
	JMenu editMenu;

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
	 * Instantiates a new {@link BaseDesktopMenu}
	 *
	 * @param applicationFrame
	 *            the application frame
	 */
	public BaseDesktopMenu(@NonNull Component applicationFrame)
	{
		this.applicationFrame = applicationFrame;
		helpBroker = newHelpBroker();
		helpWindow = newHelpWindow(helpBroker);
		menubar = newJMenuBar();
		menubar.add(fileMenu = newFileMenu(e -> log.log(Level.FINE, "file menu")));
		menubar.add(editMenu = newEditMenu(e -> log.log(Level.FINE, "edit menu")));
		menubar.add(
			lookAndFeelMenu = newLookAndFeelMenu(e -> log.log(Level.FINE, "Look and Feel menu")));
		menubar.add(helpMenu = newHelpMenu(e -> log.log(Level.FINE, "Help menu")));
		onRefreshMenus(fileMenu, editMenu, lookAndFeelMenu, helpMenu);
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
			if (hsURL != null)
			{
				hs = new HelpSet(ClassExtensions.getClassLoader(), hsURL);
			}
			else
			{
				hs = new HelpSet();
			}
		}
		catch (final HelpSetException e)
		{
			String title = e.getLocalizedMessage();
			String htmlMessage = "<html><body width='650'>" + "<h2>" + title + "</h2>" + "<p>"
				+ e.getMessage() + "\n" + path;
			JOptionPane.showMessageDialog(this.getParent(), htmlMessage, title,
				JOptionPane.ERROR_MESSAGE);
			log.log(Level.SEVERE, e.getMessage(), e);
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
	protected JMenu newEditMenu(final ActionListener listener)
	{
		final JMenu menu = new JMenu("Edit");
		menu.setMnemonic('E');

		return menu;
	}

	protected void refreshMenu(JMenu menu) {
		MenuElement[] subElements = menu.getSubElements();
		if(subElements.length == 0){
			menu.setVisible(false);
		} else {
			menu.setVisible(true);
		}
	}

	protected void onRefreshMenus(JMenu... menus) {
		for(JMenu menu: menus){
			refreshMenu(menu);
		}
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
		final JMenu menuHelp = new JMenu(newLabelTextHelp());
		menuHelp.setMnemonic('H');

		// Help JMenuItems
		// Help content
		final JMenuItem mihHelpContent = JComponentFactory.newJMenuItem(newLabelTextContent(), 'c',
			'H');
		menuHelp.add(mihHelpContent);

		// 2. assign help to components
		CSH.setHelpIDString(mihHelpContent, newLabelTextOverview());
		// 3. handle events
		final CSH.DisplayHelpFromSource displayHelpFromSource = new CSH.DisplayHelpFromSource(
			helpBroker);
		mihHelpContent.addActionListener(displayHelpFromSource);
		// Donate
		final JMenuItem mihDonate = new JMenuItem(newLabelTextDonate());
		mihDonate.addActionListener(
			newOpenBrowserToDonateAction(newLabelTextDonate(), applicationFrame));
		menuHelp.add(mihDonate);
		// Licence
		final JMenuItem mihLicence = new JMenuItem(newLabelTextLicence());
		mihLicence.addActionListener(
			newShowLicenseFrameAction(newLabelTextLicence() + "Action", newLabelTextLicence()));
		menuHelp.add(mihLicence);
		// Info
		final JMenuItem mihInfo = new JMenuItem(newLabelTextInfo(), 'i'); // $NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mihInfo, 'I');

		mihInfo.addActionListener(newShowInfoDialogAction(newLabelTextInfo(),
			(Frame)applicationFrame, newLabelTextInfo()));
		menuHelp.add(mihInfo);

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
			log.log(Level.SEVERE, e.getMessage(), e);
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


	protected String newLabelTextApplicationName()
	{
		return "";
	}


	protected String newLabelTextContent()
	{
		return "Content";
	}


	protected String newLabelTextCopyright()
	{
		return "";
	}


	protected String newLabelTextDonate()
	{
		return "Donate";
	}


	protected String newLabelTextHelp()
	{
		return "Help";
	}


	protected String newLabelTextInfo()
	{
		return "Info";
	}

	protected String newLabelTextLabelApplicationName()
	{
		return "";
	}

	protected String newLabelTextLabelCopyright()
	{
		return "";
	}

	protected String newLabelTextLabelVersion()
	{
		return "";
	}


	protected String newLabelTextLicence()
	{
		return "Licence";
	}

	protected String newLabelTextOverview()
	{
		return "Overview";
	}

	protected String newLabelTextVersion()
	{
		return "";
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

	protected OpenBrowserToDonateAction newOpenBrowserToDonateAction(final String name,
		final @NonNull Component component)
	{
		return new OpenBrowserToDonateAction(name, component);
	}

	@SuppressWarnings("serial")
	protected ShowInfoDialogAction newShowInfoDialogAction(final String name,
		final @NonNull Frame owner, final @NonNull String title)
	{
		return new ShowInfoDialogAction(name, owner, title)
		{
			@Override
			protected InfoDialog newInfoDialog(Frame owner, String title)
			{
				return BaseDesktopMenu.this.onNewInfoDialog(owner, title);
			}
		};
	}

	protected ShowLicenseFrameAction newShowLicenseFrameAction(final String name,
		final @NonNull String title)
	{
		return new ShowLicenseFrameAction(name, title)
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected String newLicenseText()
			{
				return onNewLicenseText();
			}
		};
	}

	protected String newTextWarning()
	{
		return "";
	}

	@SuppressWarnings("serial")
	protected InfoDialog onNewInfoDialog(Frame owner, String title)
	{
		return new InfoDialog(owner, title)
		{

			@Override
			protected InfoPanel newInfoPanel()
			{
				return new InfoPanel()
				{

					@Override
					protected String newLabelTextApplicationName()
					{
						return BaseDesktopMenu.this.newLabelTextApplicationName();
					}

					@Override
					protected String newLabelTextCopyright()
					{
						return BaseDesktopMenu.this.newLabelTextCopyright();
					}

					@Override
					protected String newLabelTextLabelApplicationName()
					{
						return BaseDesktopMenu.this.newLabelTextLabelApplicationName();
					}

					@Override
					protected String newLabelTextLabelCopyright()
					{
						return BaseDesktopMenu.this.newLabelTextLabelCopyright();
					}

					@Override
					protected String newLabelTextLabelVersion()
					{
						return BaseDesktopMenu.this.newLabelTextLabelVersion();
					}

					@Override
					protected String newLabelTextVersion()
					{
						return BaseDesktopMenu.this.newLabelTextVersion();
					}

					@Override
					protected String newTextWarning()
					{
						return BaseDesktopMenu.this.newTextWarning();
					}

				};
			}

			@Override
			protected String newLabelTextPlaceholder()
			{
				return "";
			}

		};
	}

	protected String onNewLicenseText()
	{
		return "Licence Text";
	}

}