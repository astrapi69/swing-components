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
package io.github.astrapi69.test.instances;

import java.util.ArrayList;
import java.util.List;

import io.github.astrapi69.test.objects.Permission;

public class TestPermissionFactory
{

	public static List<Permission> getPermissions()
	{
		final List<Permission> permissions = new ArrayList<>();
		permissions.add(Permission.builder().name("read").shortcut("r")
			.description("Permission to read.").build());
		permissions.add(Permission.builder().name("write").shortcut("w")
			.description("Permission to write.").build());
		permissions.add(Permission.builder().name("delete").shortcut("d")
			.description("Permission to delete.").build());
		permissions.add(Permission.builder().name("execute").shortcut("e")
			.description("Permission to execute.").build());
		permissions.add(Permission.builder().shortcut("b").name("buy")
			.description("Permission to buy.").build());
		permissions.add(Permission.builder().name("sale").shortcut("s")
			.description("Permission to sale.").build());
		return permissions;
	}


	public static List<Permission> getPermissionsInGerman()
	{
		final List<Permission> permissions = new ArrayList<>();
		permissions.add(Permission.builder().name("lesen").shortcut("r")
			.description("Permission zum lesen.").build());
		permissions.add(Permission.builder().name("schreiben").shortcut("w")
			.description("Permission zum schreiben.").build());
		permissions.add(Permission.builder().name("löschen").shortcut("d")
			.description("Permission zum löschen.").build());
		permissions.add(Permission.builder().name("ausführen").shortcut("e")
			.description("Permission zum ausführen.").build());
		permissions.add(Permission.builder().name("kaufen").shortcut("b")
			.description("Permission zum kaufen.").build());
		permissions.add(Permission.builder().name("verkaufen").shortcut("s")
			.description("Permission zum verkaufen.").build());
		return permissions;
	}
}
