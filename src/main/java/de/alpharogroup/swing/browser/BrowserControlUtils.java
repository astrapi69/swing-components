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
package de.alpharogroup.swing.browser;

import java.awt.Component;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.swing.JOptionPane;


/**
 * The Class BrowserControlUtils helps you to open an url in the standard web-browser.
 */
public class BrowserControlUtils
{

	/** Constant for the name from the mac file manager. */
	private static final String MAC_FILE_MANAGER = "com.apple.eio.FileManager";

	/** Constant for the unix command 'which'. */
	private static final String UNIX_COMMAND_WHICH = "which";

	/** Constant for the system property from the operating system. */
	private static final String SYSTEM_PROPERTY_OS_NAME = "os.name";

	/** The default system browser under windows. */
	private static final String WINDOWS_PATH = "rundll32";

	/** The flag to display a url. */
	private static final String WINDOWS_FLAG = "url.dll,FileProtocolHandler";

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
			if (System.getProperty(SYSTEM_PROPERTY_OS_NAME).startsWith(OS.MAC.getOs()))
			{
				obj = openURLinMacOS(url);
			}
			else if (System.getProperty(SYSTEM_PROPERTY_OS_NAME).startsWith(OS.WINDOWS.getOs()))
			{
				obj = openURLinWindowsOS(url);
			}
			else
			{ // if operate syste is Unix or Linux
				obj = openURLinUnixOS(url);
			}
		}
		catch (final Exception e)
		{
			JOptionPane.showMessageDialog(parentComponent,
				"An exception occured attempting to run the default web browser\n" + e.toString());
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
	 *             the class not found exception
	 * @throws NoSuchMethodException
	 *             the no such method exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws InvocationTargetException
	 *             the invocation target exception
	 */
	private static Object openURLinMacOS(final String url) throws ClassNotFoundException,
		NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		final Class<?> fileManagerClass = Class.forName(MAC_FILE_MANAGER);
		final Method openURL = fileManagerClass.getDeclaredMethod("openURL",
			new Class[] { String.class });
		return openURL.invoke(null, new Object[] { url });
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
	private static Boolean openURLinUnixOS(final String url) throws InterruptedException,
		IOException, Exception
	{
		Boolean executed = false;
		for (final Browsers browser : Browsers.values())
		{
			if (!executed)
			{
				executed = Runtime.getRuntime()
					.exec(new String[] { UNIX_COMMAND_WHICH, browser.getBrowserName() }).waitFor() == 0;
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
		String cmd = null;
		cmd = WINDOWS_PATH + " " + WINDOWS_FLAG + " ";
		return Runtime.getRuntime().exec(cmd + url);
	}

}
