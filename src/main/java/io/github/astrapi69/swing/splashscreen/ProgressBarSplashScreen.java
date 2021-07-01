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
package io.github.astrapi69.swing.splashscreen;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import io.github.astrapi69.model.api.Model;

/**
 * The {@link ProgressBarSplashScreen} for an application that have to support progress bar
 *
 * @version 1.0
 *
 * @author Asterios Raptis
 *
 */
public class ProgressBarSplashScreen extends BaseSplashScreen
{
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private JProgressBar progressBar;

	public ProgressBarSplashScreen(final JFrame frame, final Model<SplashScreenModelBean> model)
	{
		super(frame, model);
	}

	@Override
	protected JPanel newContentPanel()
	{
		return new JPanel();
	}

	@Override
	protected void onAfterInitialize()
	{
		final StepSleepTimerThread stepSleepTimerThread = new StepSleepTimerThread(
			getModelObject().getShowTime());
		Thread splashscreenThread = new Thread()
		{
			@Override
			public void run()
			{
				stepSleepTimerThread.start();
				while (getModelObject().isShowing()
					&& stepSleepTimerThread.getCount() <= getModelObject().getShowTime())
				{
					ProgressBarSplashScreen.this.setVisible(true);
				}
				ProgressBarSplashScreen.this.setVisible(false);
				ProgressBarSplashScreen.this.dispose();
				getFrame().setVisible(true);
			}
		};

		final Runnable progressBarRunnable = new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("running progress bar");
				for (int i = getModelObject().getMin(); i <= getModelObject().getMax(); i++)
				{
					try
					{
						Thread.sleep(getModelObject().getShowTime() / getModelObject().getMax());
					}
					catch (InterruptedException e)
					{
					}
					progressBar.setValue(i);
				}
			}
		};
		new Thread(splashscreenThread).start();
		new Thread(progressBarRunnable).start();
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		progressBar = new JProgressBar(getModelObject().getMin(), getModelObject().getMax());
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		getContentPanel().add(progressBar, BorderLayout.SOUTH);
	}
}