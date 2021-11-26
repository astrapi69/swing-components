package io.github.astrapi69.swing.mouse;

import java.awt.event.MouseEvent;
import java.util.Optional;

public class MouseClickExtensions
{
	public static Optional<MouseClickType> getMouseClickType(MouseEvent mouseEvent)
	{
		int clickCount = mouseEvent.getClickCount();
		int button = mouseEvent.getButton();
		// middle button clicks
		if (button == MouseEvent.BUTTON2)
		{
			if (clickCount == 1)
			{
				return Optional.of(MouseClickType.SINGLE_MIDDLE);
			}
			else if (clickCount == 2)
			{
				return Optional.of(MouseClickType.DOUBLE_MIDDLE);
			}
		}
		// right clicks
		if (mouseEvent.isPopupTrigger())
		{
			if (clickCount == 1)
			{
				return Optional.of(MouseClickType.SINGLE_RIGHT);
			}
			else if (clickCount == 2)
			{
				return Optional.of(MouseClickType.DOUBLE_RIGHT);
			}
		}
		// left clicks
		if (!mouseEvent.isPopupTrigger())
		{
			if (clickCount == 1)
			{
				return Optional.of(MouseClickType.SINGLE_LEFT);
			}
			else if (clickCount == 2)
			{
				return Optional.of(MouseClickType.DOUBLE_LEFT);
			}
		}
		return Optional.empty();
	}
}
