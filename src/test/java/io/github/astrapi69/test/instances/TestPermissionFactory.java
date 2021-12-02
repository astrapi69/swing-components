package io.github.astrapi69.test.instances;

import io.github.astrapi69.test.objects.Permission;

import java.util.ArrayList;
import java.util.List;

public class TestPermissionFactory
{

	public static List<Permission> getPermissions()
	{
		final List<Permission> permissions = new ArrayList<>();
		permissions
			.add(Permission.builder().name("read").shortcut("r").description("Permission to read.").build());
		permissions
			.add(Permission.builder().name("write").shortcut("w").description("Permission to write.").build());
		permissions
			.add(Permission.builder().name("delete").shortcut("d").description("Permission to delete.").build());
		permissions.add(
			Permission.builder().name("execute").shortcut("e").description("Permission to execute.").build());
		permissions.add(Permission.builder().shortcut("b").name("buy").description("Permission to buy.").build());
		permissions
			.add(Permission.builder().name("sale").shortcut("s").description("Permission to sale.").build());
		return permissions;
	}


	public static List<Permission> getPermissionsInGerman()
	{
		final List<Permission> permissions = new ArrayList<>();
		permissions
			.add(Permission.builder().name("lesen").shortcut("r").description("Permission zum lesen.").build());
		permissions
			.add(Permission.builder().name("schreiben").shortcut("w").description("Permission zum schreiben.").build());
		permissions
			.add(Permission.builder().name("löschen").shortcut("d").description("Permission zum löschen.").build());
		permissions.add(
			Permission.builder().name("ausführen").shortcut("e").description("Permission zum ausführen.").build());
		permissions.add(Permission.builder().name("kaufen").shortcut("b").description("Permission zum kaufen.").build());
		permissions
			.add(Permission.builder().name("verkaufen").shortcut("s").description("Permission zum verkaufen.").build());
		return permissions;
	}
}
