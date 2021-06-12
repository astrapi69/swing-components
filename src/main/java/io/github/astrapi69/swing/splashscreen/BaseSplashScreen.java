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
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import de.alpharogroup.lang.ClassExtensions;
import io.github.astrapi69.layout.ScreenSizeExtensions;
import de.alpharogroup.model.api.Model;
import io.github.astrapi69.swing.base.BaseWindow;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * The BaseSplashScreen for an application
 *
 * @version 1.0
 *
 * @author Asterios Raptis
 *
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseSplashScreen extends BaseWindow<SplashScreenModelBean>
{
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	JPanel contentPanel;
	final JFrame frame;
	ImageIcon icon;
	JLabel iconLabel;
	JLabel textLabel;


	public BaseSplashScreen(final JFrame frame, final Model<SplashScreenModelBean> model)
	{
		super(frame, model);
		this.frame = frame;
	}

	private BufferedImage getBufferedImage() throws IOException
	{
		InputStream stream = ClassExtensions.getResourceAsStream(getModelObject().getImagePath());
		BufferedImage image = ImageIO.read(stream);
		return image;
	}

	private void initIcon() throws IOException
	{
		URL imageResource = ClassLoader.getSystemResource(getModelObject().getImagePath());
		if (imageResource == null)
		{
			BufferedImage image = getBufferedImage();
			icon = new ImageIcon(image);
		}
		else
		{
			icon = new ImageIcon(imageResource);
		}
	}

	protected JPanel newContentPanel()
	{
		return new JPanel();
	}

	protected JLabel newIconLabel(final ImageIcon icon)
	{
		return new JLabel(icon, SwingConstants.CENTER);
	}

	protected JLabel newTextLabel(final Model<SplashScreenModelBean> model)
	{
		return new JLabel(getModel().getObject().getText(), SwingConstants.CENTER);
	}

	@Override
	protected void onAfterInitialize()
	{
		super.onAfterInitialize();
		showFor(getModelObject().getShowTime());
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		try
		{
			initIcon();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		contentPanel = newContentPanel();
		textLabel = newTextLabel(getModel());
		iconLabel = newIconLabel(icon);
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		this.setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout());
		final Border bd1 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		final Border bd2 = BorderFactory.createEtchedBorder();
		final Border bd3 = BorderFactory.createCompoundBorder(bd1, bd2);
		contentPanel.setBorder(bd3);
		contentPanel.add(textLabel, BorderLayout.NORTH);
		contentPanel.add(iconLabel, BorderLayout.CENTER);
		onSetLocationAndSize();
		this.setVisible(true);
		resizeIconLabel();
	}

	protected void onSetLocationAndSize()
	{
		ScreenSizeExtensions.centralize(this, 3, 3);
	}

	private void resizeIconLabel()
	{
		try
		{
			BufferedImage img = getBufferedImage();
			Image dimg = img.getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(),
				Image.SCALE_SMOOTH);
			icon = new ImageIcon(dimg);
			iconLabel.setIcon(icon);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void showFor(final int millis)
	{
		setVisible(true);
		try
		{
			Thread.sleep(millis);
		}
		catch (final InterruptedException e)
		{
		}
		setVisible(false);
	}

}