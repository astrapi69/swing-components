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
package de.alpharogroup.swing.splashscreen;

import javax.swing.JFrame;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.check.model.CheckListPanel;

public class ProgressBarSplashScreenTest
{

	public static void main(final String[] args)
	{
		final JFrame frame = new JFrame("CheckListPanel");
		String[] strs = { "root", "home", "kde", "mint", "ubuntu" };
		frame.add(new CheckListPanel(strs));
		frame.addWindowListener(new CloseWindow());
		frame.setSize(300, 200);
		String imagePath = "img/xmas/bell.png";
		SplashScreenModelBean splashScreenModelBean = SplashScreenModelBean.builder()
			.imagePath(imagePath).text("BaseSplashScreen example").min(0).max(100).showTime(2000)
			.showing(true).build();
		Model<SplashScreenModelBean> modelBeanModel = BaseModel.of(splashScreenModelBean);
		new ProgressBarSplashScreen(frame, modelBeanModel);
		try
		{
			Thread.sleep(4000);
		}
		catch (InterruptedException e)
		{
		}
		System.exit(0);
	}

}