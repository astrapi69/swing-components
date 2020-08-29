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

import de.alpharogroup.layout.ScreenSizeExtensions;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.base.BaseWindow;
import lombok.NonNull;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * The BaseSplashScreen for an application
 *
 * @version 1.0
 *
 * @author Asterios Raptis
 *
 */
public class BaseSplashScreen extends BaseWindow<SplashScreenModelBean>
{
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private JProgressBar progressBar;
	private JPanel contentPanel;
	private ImageIcon icon;
	private final JFrame frame;

	public BaseSplashScreen(final @NonNull JFrame frame, final Model<SplashScreenModelBean> model)
	{
		super(frame, model);
		this.frame = frame;
	}

	protected JPanel newContentPanel() {
		return new JPanel();
	}

	@Override protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		icon = new ImageIcon(ClassLoader.getSystemResource(getModelObject().getImagePath()));
		progressBar = new JProgressBar(getModelObject().getMin(), getModelObject().getMax());

		contentPanel = newContentPanel();
	}

	@Override protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		this.setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout());
		final Border bd1 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		final Border bd2 = BorderFactory.createEtchedBorder();
		final Border bd3 = BorderFactory.createCompoundBorder(bd1, bd2);
		contentPanel.setBorder(bd3);
		contentPanel.add(new JLabel(getModelObject().getText(), JLabel.CENTER), BorderLayout.NORTH);
		contentPanel.add(new JLabel(icon, JLabel.CENTER), BorderLayout.CENTER);
		contentPanel.add(progressBar, BorderLayout.SOUTH);
		onSetLocationAndSize();
		this.setVisible(true);
	}

	protected void onSetLocationAndSize()
	{
		ScreenSizeExtensions.centralize(this, 3, 3);
	}

	@Override protected void onAfterInitialize()
	{
		super.onAfterInitialize();
		final StepSleepTimerThread stepSleepTimerThread = new StepSleepTimerThread(getModelObject().getShowTime());
		Thread splashscreenThread = new Thread() {
			public void run() {
				stepSleepTimerThread.start();
				while (getModelObject().isShowing() && stepSleepTimerThread.getCount() <= getModelObject().getShowTime()) {
					BaseSplashScreen.this.setVisible(true);
				}
				BaseSplashScreen.this.setVisible(false);
				BaseSplashScreen.this.dispose();
				frame.setVisible(true);
			}
		};

		final Runnable progressBarRunnable = new Runnable() {
			public void run() {
				System.out.println("running progress bar");
				for (int i = getModelObject().getMin(); i <= getModelObject().getMax(); i++) {
					try {
						Thread.sleep(getModelObject().getShowTime() / getModelObject().getMax());
					} catch (InterruptedException e) {
					}
					progressBar.setValue(i);
				}
			}
		};
		new Thread(splashscreenThread).start();
		new Thread(progressBarRunnable).start();
	}
}