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
package de.alpharogroup.swing.panels.network;

import java.io.Serializable;

/**
 * The Class NetworkSettingsModelBean.
 */
public class NetworkSettingsModelBean implements Serializable
{

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 3097232755356031060L;

	/** The flag proxy is used. */
	private Boolean proxy;

	/** The flag if socks is used. */
	private Boolean socks;

	/** The host. */
	private String host;

	/** The port. */
	private Integer port;

	/** The proxy authetication. */
	private Boolean proxyAuthetication;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** The flag if the password should be remembered. */
	private Boolean rememberPassword;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null)
		{
			return false;
		}
		if (o.getClass() != getClass())
		{
			return false;
		}
		final NetworkSettingsModelBean castedObj = (NetworkSettingsModelBean)o;
		return (this.proxy == null ? castedObj.proxy == null : this.proxy.equals(castedObj.proxy))
			&& (this.socks == null ? castedObj.socks == null : this.socks.equals(castedObj.socks))
			&& (this.host == null ? castedObj.host == null : this.host.equals(castedObj.host))
			&& (this.port == null ? castedObj.port == null : this.port.equals(castedObj.port))
			&& (this.proxyAuthetication == null
				? castedObj.proxyAuthetication == null
				: this.proxyAuthetication.equals(castedObj.proxyAuthetication))
			&& (this.username == null ? castedObj.username == null : this.username
				.equals(castedObj.username))
			&& (this.password == null ? castedObj.password == null : this.password
				.equals(castedObj.password))
			&& (this.rememberPassword == null
				? castedObj.rememberPassword == null
				: this.rememberPassword.equals(castedObj.rememberPassword));
	}

	/**
	 * Gets the host.
	 * 
	 * @return the host
	 */
	public String getHost()
	{
		return host;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Gets the port.
	 * 
	 * @return the port
	 */
	public Integer getPort()
	{
		return port;
	}

	/**
	 * Gets the proxy.
	 * 
	 * @return the proxy
	 */
	public Boolean getProxy()
	{
		return proxy;
	}

	/**
	 * Gets the proxy authetication.
	 *
	 * @return the proxy authetication
	 */
	public Boolean getProxyAuthetication()
	{
		return proxyAuthetication;
	}

	/**
	 * Gets the remember password.
	 *
	 * @return the remember password
	 */
	public Boolean getRememberPassword()
	{
		return rememberPassword;
	}

	/**
	 * Gets the socks.
	 * 
	 * @return the socks
	 */
	public Boolean getSocks()
	{
		return socks;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode()
	{
		int hashCode = 1;
		hashCode = 31 * hashCode + (int)(+serialVersionUID ^ serialVersionUID >>> 32);
		hashCode = 31 * hashCode + (proxy == null ? 0 : proxy.hashCode());
		hashCode = 31 * hashCode + (socks == null ? 0 : socks.hashCode());
		hashCode = 31 * hashCode + (host == null ? 0 : host.hashCode());
		hashCode = 31 * hashCode + (port == null ? 0 : port.hashCode());
		hashCode = 31 * hashCode + (proxyAuthetication == null ? 0 : proxyAuthetication.hashCode());
		hashCode = 31 * hashCode + (username == null ? 0 : username.hashCode());
		hashCode = 31 * hashCode + (password == null ? 0 : password.hashCode());
		hashCode = 31 * hashCode + (rememberPassword == null ? 0 : rememberPassword.hashCode());
		return hashCode;
	}

	/**
	 * Sets the host.
	 * 
	 * @param host
	 *            the new host
	 */
	public void setHost(final String host)
	{
		this.host = host;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(final String password)
	{
		this.password = password;
	}

	/**
	 * Sets the port.
	 * 
	 * @param port
	 *            the new port
	 */
	public void setPort(final Integer port)
	{
		this.port = port;
	}

	/**
	 * Sets the proxy.
	 * 
	 * @param proxy
	 *            the new proxy
	 */
	public void setProxy(final Boolean proxy)
	{
		this.proxy = proxy;
	}

	/**
	 * Sets the proxy authetication.
	 *
	 * @param proxyAuthetication
	 *            the new proxy authetication
	 */
	public void setProxyAuthetication(final Boolean proxyAuthetication)
	{
		this.proxyAuthetication = proxyAuthetication;
	}

	/**
	 * Sets the remember password.
	 *
	 * @param rememberPassword
	 *            the new remember password
	 */
	public void setRememberPassword(final Boolean rememberPassword)
	{
		this.rememberPassword = rememberPassword;
	}

	/**
	 * Sets the socks.
	 * 
	 * @param socks
	 *            the new socks
	 */
	public void setSocks(final Boolean socks)
	{
		this.socks = socks;
	}

	/**
	 * Sets the username.
	 *
	 * @param username
	 *            the new username
	 */
	public void setUsername(final String username)
	{
		this.username = username;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		final StringBuffer buffer = new StringBuffer();
		buffer.append("[NetworkSettingsModelBean:");
		buffer.append(" proxy: ");
		buffer.append(proxy);
		buffer.append(" socks: ");
		buffer.append(socks);
		buffer.append(" host: ");
		buffer.append(host);
		buffer.append(" port: ");
		buffer.append(port);
		buffer.append(" proxyAuthetication: ");
		buffer.append(proxyAuthetication);
		buffer.append(" username: ");
		buffer.append(username);
		buffer.append(" password: ");
		buffer.append(password);
		buffer.append(" rememberPassword: ");
		buffer.append(rememberPassword);
		buffer.append("]");
		return buffer.toString();
	}

}
