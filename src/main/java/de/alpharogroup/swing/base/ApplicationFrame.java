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
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.UnsupportedLookAndFeelException;

import de.alpharogroup.lang.ClassExtensions;
import de.alpharogroup.layout.ScreenSizeExtensions;
import de.alpharogroup.swing.components.factories.JComponentFactory;
import de.alpharogroup.swing.desktoppane.SingletonDesktopPane;
import de.alpharogroup.swing.plaf.LookAndFeels;
import de.alpharogroup.swing.utils.JInternalFrameExtensions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;


/**
 * The class {@link ApplicationFrame}
 *
 * @param <T>
 *            the generic type of the model object
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class ApplicationFrame<T> extends BaseFrame<T>
{

	/** The current look and feels. */
	@Getter
	@Setter
	LookAndFeels currentLookAndFeels = LookAndFeels.SYSTEM;

	/** The current visible internal frame. */
	@Getter
	@Setter
	JInternalFrame currentVisibleInternalFrame;

	/** The desktop pane. */
	@Getter
	JDesktopPane desktopPane;

	@Getter
	BufferedImage icon;

	@Getter
	BaseDesktopMenu menu;

	/** The toolbar. */
	@Getter
	JToolBar toolbar;

	/** The configuration directory for configuration file. */
	@Getter
	File configurationDir;

	public ApplicationFrame(String title)
	{
		super(title);
		configurationDir = newConfigurationDir(System.getProperty("user.home"), ".config");
	}

	/**
	 * Factory method for create a new configuration {@link File} object if it is not exists. This
	 * method is invoked in the constructor and can be overridden from the derived classes so users
	 * can provide their own version of a new configuration {@link File} object
	 *
	 * @param parent
	 *            the parent
	 * @param child
	 *            the child
	 * @return the file
	 */
	protected File newConfigurationDir(final @NonNull String parent, final @NonNull String child)
	{
		configurationDir = new File(parent, child);
		if (!configurationDir.exists())
		{
			configurationDir.mkdir();
		}
		return configurationDir;
	}

	/**
	 * Factory method for create a new {@link Optional} object that contains a {@link BufferedImage}
	 * with the icon
	 *
	 * @param iconPath
	 *            the icon path
	 * @return the icon
	 */
	protected Optional<BufferedImage> getIcon(@NonNull String iconPath)
	{
		Optional<BufferedImage> optional = Optional.empty();
		try
		{
			BufferedImage bufferedImage = ImageIO
				.read(ClassExtensions.getResourceAsStream(iconPath));
			optional = Optional.of(bufferedImage);
		}
		catch (IOException e)
		{
			String title = e.getLocalizedMessage();
			String htmlMessage = "<html><body width='650'>" + "<h2>" + title + "</h2>" + "<p>"
				+ e.getMessage();
			JOptionPane.showMessageDialog(this, htmlMessage, title, JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage(), e);
		}
		return optional;
	}

	/**
	 * Factory method for create a new {@link BaseDesktopMenu} object.
	 *
	 * @param applicationFrame
	 *            the application frame
	 * @return the new {@link BaseDesktopMenu} object
	 */
	protected BaseDesktopMenu newDesktopMenu(@NonNull Component applicationFrame)
	{
		return new BaseDesktopMenu(applicationFrame);
	}

	/**
	 * Abstact factory method that returns the path of the icon of the application
	 *
	 * @return the path of the icon of the application as string
	 */
	protected abstract String newIconPath();

	/**
	 * Factory method for create a new {@link JDesktopPane} object
	 *
	 * @return the new {@link JDesktopPane} object
	 */
	protected JDesktopPane newJDesktopPane()
	{
		return SingletonDesktopPane.getInstance();
	}

	/**
	 * Factory method for create a new {@link JToolBar} object
	 *
	 * @return the new {@link JToolBar} object
	 */
	protected JToolBar newJToolBar()
	{
		return new JToolBar();
	}

	/**
	 * Factory method for create a new {@link LookAndFeels} object
	 *
	 * @return the new {@link LookAndFeels} object
	 */
	protected LookAndFeels newLookAndFeels()
	{
		return LookAndFeels.SYSTEM;
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		menu = newDesktopMenu(this);
		setJMenuBar(menu.getMenubar());
		setToolBar(toolbar = newJToolBar());
		getContentPane().add(desktopPane = newJDesktopPane());
		Optional<BufferedImage> optionalIcon = getIcon(newIconPath());
		if (optionalIcon.isPresent())
		{
			setIconImage(icon = optionalIcon.get());
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		final GraphicsDevice[] gs = ge.getScreenDevices();
		setSize(ScreenSizeExtensions.getScreenWidth(gs[0]),
			ScreenSizeExtensions.getScreenHeight(gs[0]));
		setVisible(true);

		// Set default look and feel...
		setDefaultLookAndFeel(newLookAndFeels(), this);
	}

	/**
	 * Replace the current internal frame with a new internal frame with the given {@link Component}
	 * as content.
	 *
	 * @param title
	 *            the title
	 * @param component
	 *            the component
	 */
	public void replaceInternalFrame(final String title, final Component component)
	{
		if (getCurrentVisibleInternalFrame() != null)
		{
			getCurrentVisibleInternalFrame().dispose();
		}
		// create internal frame
		final JInternalFrame internalFrame = JComponentFactory.newInternalFrame(title, true, true,
			true, true);
		JInternalFrameExtensions.addComponentToFrame(internalFrame, component);
		JInternalFrameExtensions.addJInternalFrame(desktopPane, internalFrame);
		setCurrentVisibleInternalFrame(internalFrame);
	}

	/**
	 * Sets the given {@link LookAndFeels} to the given {@link Component} and returns given
	 * {@link LookAndFeels}
	 *
	 * @param lookAndFeels
	 *            the look and feels
	 * @param component
	 *            the component
	 * @return the current {@link LookAndFeels}
	 */
	protected LookAndFeels setDefaultLookAndFeel(@NonNull LookAndFeels lookAndFeels,
		Component component)
	{
		try
		{
			LookAndFeels.setLookAndFeel(lookAndFeels, component);
			setCurrentLookAndFeels(lookAndFeels);
		}
		catch (final ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e)
		{
			String title = e.getLocalizedMessage();
			String htmlMessage = "<html><body width='650'>" + "<h2>" + title + "</h2>" + "<p>"
				+ e.getMessage();
			JOptionPane.showMessageDialog(this, htmlMessage, title, JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage(), e);
		}
		return lookAndFeels;
	}

}
