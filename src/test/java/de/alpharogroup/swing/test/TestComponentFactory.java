package de.alpharogroup.swing.test;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.layout.ScreenSizeExtensions;
import de.alpharogroup.swing.components.factories.JComponentFactory;
import lombok.NonNull;

import java.awt.*;

public final class TestComponentFactory
{

	public static Frame newTestFrame(String title)
	{
		final Frame frame = JComponentFactory.newFrame(title);
		frame.addWindowListener(new CloseWindow());
		return frame;
	}

	public static void showFrame(Frame frame, int divideScreenWith)
	{
		showFrame(frame, divideScreenWith, divideScreenWith);
	}

	public static void showFrame(Frame frame, int divideScreenWith, int divideScreenHeight)
	{
		ScreenSizeExtensions.centralize(frame, divideScreenWith, divideScreenHeight);
		ScreenSizeExtensions.showFrame(frame);
	}

}
