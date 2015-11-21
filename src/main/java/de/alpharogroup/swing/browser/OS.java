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

import java.util.regex.Pattern;

/**
 * The Enum OS has constants for the operating systems.
 */
public enum OS
{

	/** The WINDOWS. */
	WINDOWS("Windows"),

	/** The MAC. */
	MAC("Mac OS"),

	/** The LINUX. */
	LINUX("Linux"),

	/** The UNIX. */
	UNIX("Unix"),

	/** The OTHER. */
	OTHER("Other");


	/** The Constant OS_NAME. */
	private static final String OS_NAME = "os.name";

	/** The Constant LINUX_PATTERN. */
	private static final Pattern LINUX_PATTERN = Pattern.compile(".*[L|l]inux.*");

	/** The Constant WINDOWS_PATTERN. */
	private static final Pattern WINDOWS_PATTERN = Pattern.compile(".*[W|w]indows.*");
	
	/** The Constant MAC_PATTERN. */
	private static final Pattern MAC_PATTERN = Pattern.compile("mac|darwin");

	public static OS get()
	{
		return getOperatingSystem();
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
		else if (MAC_PATTERN.matcher(osname).matches()) {
			return MAC;
		}
		
		else
		{
			return OTHER;
		}
	}

	/** The os. */
	private final String os;

	/**
	 * Instantiates a new oS.
	 *
	 * @param os
	 *            the os
	 */
	private OS(final String os)
	{
		this.os = os;
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
