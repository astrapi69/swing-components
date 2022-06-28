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
package io.github.astrapi69.swing.check.model;

import java.awt.Frame;

import org.assertj.swing.fixture.FrameFixture;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.model.check.CheckableItem;
import io.github.astrapi69.model.check.CheckableListModel;
import io.github.astrapi69.model.check.CheckableValue;
import io.github.astrapi69.swing.list.JListExtensions;
import io.github.astrapi69.window.adapter.CloseWindow;

/**
 * GUI unit test with assertj-swing module
 */
public class CheckListPanelAssertjSwingTest
{

	private FrameFixture testUnit;

	@Test(enabled = false)
	public void test()
	{
		final Frame frame = new Frame("CheckListPanel");
		String[] strs = { "root", "home", "kde", "mint", "ubuntu" };
		CheckableItem<CheckableValue>[] checkableItems = JListExtensions.newCheckableItems(strs);
		IModel<CheckableListModel> model = BaseModel.of(
			CheckableListModel.builder().values(JListExtensions.newCheckableItems(strs)).build());
		frame.add(new CheckListPanel(model));
		frame.addWindowListener(new CloseWindow());
		frame.setSize(300, 200);
		frame.setVisible(true);
		testUnit = new FrameFixture(frame);

		testUnit.list("list").clickItem(0);
		testUnit.button("printButton").click();
		testUnit.textBox("textArea").requireText("root\n");
	}
}
