package io.github.astrapi69.swing.icon;

import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.Assert.*;

public class ImageIconFactoryTest
{

	@Test public void testNewImageIcon()
	{
		ImageIcon imageIcon = ImageIconFactory.newImageIcon("img/xmas/stars.png");
		assertNotNull(imageIcon);
	}
}