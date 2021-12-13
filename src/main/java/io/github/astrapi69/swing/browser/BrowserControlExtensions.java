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
package io.github.astrapi69.swing.browser;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.swing.*;

import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

/**
 * The class {@link BrowserControlExtensions} helps you to open an url in the standard web-browser.
 *
 * @deprecated use instead the same named class in project menu-actions<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public class BrowserControlExtensions
{

	/** Constant for the name from the mac file manager. */
	private static final String MAC_FILE_MANAGER = "com.apple.eio.FileManager";

	/** Constant for the unix command 'which'. */
	private static final String UNIX_COMMAND_WHICH = "which";

	/** The flag to display a url. */
	private static final String WINDOWS_FLAG = "url.dll,FileProtocolHandler";

	/** The default system browser under windows. */
	private static final String WINDOWS_PATH = "rundll32";

	/**
	 * This method opens the specified url in the standard web-browser.
	 *
	 * @param url
	 *            An url like "http://www.yahoo.com/"
	 * @return the object
	 */
	public static Object displayURLonStandardBrowser(final String url)
	{
		Object obj = null;

		if (OS.isMac())
		{
			obj = RuntimeExceptionDecorator.decorate(() -> openURLinMacOS(url));
		}
		else if (OS.isWindows())
		{
			obj = RuntimeExceptionDecorator.decorate(() -> openURLinWindowsOS(url));
		}
		else
		{ // if operate syste is Unix or Linux
			obj = RuntimeExceptionDecorator.decorate(() -> openURLinUnixOS(url));
		}
		return obj;
	}

	/**
	 * This method opens the specified url in the standard web-browser.
	 *
	 * @param parentComponent
	 *            The parent component. Can be null.
	 * @param url
	 *            An url like "http://www.yahoo.com/"
	 * @return the object
	 */
	public static Object displayURLonStandardBrowser(final Component parentComponent,
		final String url)
	{
		Object obj = null;
		try
		{
			obj = displayURLonStandardBrowser(url);
		}
		catch (final Exception e)
		{
			JOptionPane.showMessageDialog(parentComponent,
				"An exception occured attempting to run the default web browser\n" + e);
		}
		return obj;
	}

	/**
	 * Opens the given URL in mac os.
	 * 
	 * @param url
	 *            the url
	 * 
	 * @return the object
	 * 
	 * @throws ClassNotFoundException
	 *             occurs if a given class cannot be located by the specified class loader
	 * @throws NoSuchMethodException
	 *             is thrown if a matching method is not found
	 * @throws IllegalAccessException
	 *             is thrown if this {@code Method} object is enforcing Java language access control
	 *             and the underlying method is inaccessible
	 * @throws InvocationTargetException
	 *             is thrown if the underlying method throws an exception.
	 */
	private static Object openURLinMacOS(final String url) throws ClassNotFoundException,
		NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		final Class<?> fileManagerClass = Class.forName(MAC_FILE_MANAGER);
		final Method openURL = fileManagerClass.getDeclaredMethod("openURL", String.class);
		return openURL.invoke(null, url);
	}

	/**
	 * Opens the given URL in unix os.
	 * 
	 * @param url
	 *            the url
	 * 
	 * @return the boolean
	 * 
	 * @throws InterruptedException
	 *             the interrupted exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws Exception
	 *             the exception
	 */
	private static Boolean openURLinUnixOS(final String url)
		throws InterruptedException, IOException, Exception
	{
		Boolean executed = false;
		for (final Browsers browser : Browsers.values())
		{
			if (!executed)
			{
				executed = Runtime.getRuntime()
					.exec(new String[] { UNIX_COMMAND_WHICH, browser.getBrowserName() })
					.waitFor() == 0;
				if (executed)
				{
					Runtime.getRuntime().exec(new String[] { browser.getBrowserName(), url });
				}
			}
		}
		if (!executed)
		{
			throw new Exception(Arrays.toString(Browsers.values()));
		}
		return executed;
	}

	/**
	 * Opens the given URL in windows os.
	 * 
	 * @param url
	 *            the url
	 * 
	 * @return the process
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static Process openURLinWindowsOS(final String url) throws IOException
	{
		String cmd;
		cmd = WINDOWS_PATH + " " + WINDOWS_FLAG + " ";
		return Runtime.getRuntime().exec(cmd + url);
	}

}
