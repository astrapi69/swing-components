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
package io.github.astrapi69.swing.panels.splitpane;

import org.jdesktop.swingx.MultiSplitLayout;

/**
 * The class {@link SplitFactory}
 *
 * @deprecated use instead the same named class in project swing-base-components<br>
 *             <br>
 *             Note: will be deleted in next minor version
 */
public class SplitFactory
{


	public static MultiSplitLayout.Leaf newLeaf(String name, double weight)
	{
		MultiSplitLayout.Leaf source = new MultiSplitLayout.Leaf(name);
		source.setWeight(weight);
		return source;
	}

	public static MultiSplitLayout newMultiSplitLayout(MultiSplitLayout.Split split)
	{
		MultiSplitLayout layout = new MultiSplitLayout(split);
		return layout;
	}

	public static MultiSplitLayout.Split newSplit(boolean rowLayout, double weight)
	{
		MultiSplitLayout.Split col1 = new MultiSplitLayout.Split();
		col1.setRowLayout(rowLayout);
		col1.setWeight(weight);
		return col1;
	}

	public static void setChildren(MultiSplitLayout.Split split, MultiSplitLayout.Node... children)
	{
		split.setChildren(children);
	}

}
