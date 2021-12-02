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
package io.github.astrapi69.swing.table.model.dynamic;

import lombok.NonNull;
import io.github.astrapi69.test.objects.Permission;

/**
 * The class DynamicPermissionsTableModel
 */
public class DynamicPermissionsTableModel extends DynamicTableModel<Permission>
{

	public DynamicPermissionsTableModel(@NonNull DynamicTableColumnsModel<Permission> columnsModel)
	{
		super(columnsModel);
	}

	@Override
	public Object getValueAt(final int row, final int col)
	{
		final Permission permission = getData().get(row);
		switch (col)
		{
			case 0 :
				return permission.getName();
			case 1 :
				return permission.getDescription();
			case 3 :
				return permission.getDescription();
			default :
				return null;
		}
	}

}
