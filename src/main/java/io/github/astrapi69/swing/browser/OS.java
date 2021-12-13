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

import java.util.regex.Pattern;

/**
 * The Enum OS has constants for the operating systems.
 *
 * @deprecated use instead the same named class in project menu-actions<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public enum OS
{

	/** The LINUX. */
	LINUX("Linux"),

	/** The MAC. */
	MAC("Mac OS"),

	/** The OTHER. */
	OTHER("Other"),

	/** The UNIX. */
	UNIX("Unix"),

	/** The WINDOWS. */
	WINDOWS("Windows");


	/** The Constant LINUX_PATTERN. */
	private static final Pattern LINUX_PATTERN = Pattern.compile(".*[L|l]inux.*");

	/** The Constant MAC_PATTERN. */
	private static final Pattern MAC_PATTERN = Pattern.compile("mac|darwin");

	/** The Constant OS_NAME. */
	private static final String OS_NAME = "os.name";

	/** The Constant WINDOWS_PATTERN. */
	private static final Pattern WINDOWS_PATTERN = Pattern.compile(".*[W|w]indows.*");
	/** The os. */
	private final String os;

	/**
	 * Instantiates a new oS.
	 *
	 * @param os
	 *            the os
	 */
	OS(final String os)
	{
		this.os = os;
	}

	public static OS get()
	{
		return getOperatingSystem();
	}

	/**
	 * Returns true if the operating system is windows
	 *
	 * @return true if the operating system is windows otherwise false
	 */
	public static boolean isWindows()
	{
		return getOperatingSystemName().startsWith(OS.WINDOWS.getOs());
	}

	/**
	 * Returns true if the operating system is Macintosh
	 *
	 * @return true if the operating system is Macintosh otherwise false
	 */
	public static boolean isMac()
	{
		return getOperatingSystemName().startsWith(OS.MAC.getOs());
	}

	/**
	 * Returns true if the operating system is Linux
	 *
	 * @return true if the operating system is Linux otherwise false
	 */
	public static boolean isLinux()
	{
		return getOperatingSystemName().startsWith(OS.LINUX.getOs());
	}

	/**
	 * Gets the operating system.
	 *
	 * @return the operating system
	 */
	public static OS getOperatingSystem()
	{
		final String osname = System.getProperty(OS_NAME);
		if (WINDOWS_PATTERN.matcher(osname).matches())
		{
			return WINDOWS;
		}
		else if (LINUX_PATTERN.matcher(osname).matches())
		{
			return LINUX;
		}
		else if (MAC_PATTERN.matcher(osname).matches())
		{
			return MAC;
		}
		else
		{
			return OTHER;
		}
	}

	/**
	 * Gets the name of the operating system
	 *
	 * @return the name of the operating system
	 */
	public static String getOperatingSystemName()
	{
		return get().getOs();
	}

	/**
	 * Gets the os.
	 *
	 * @return the os
	 */
	public String getOs()
	{
		return os;
	}

}
