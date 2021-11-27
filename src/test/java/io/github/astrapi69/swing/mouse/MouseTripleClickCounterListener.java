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
package io.github.astrapi69.swing.mouse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import io.github.astrapi69.window.adapter.CloseWindow;

public class MouseTripleClickCounterListener extends MouseAdapter implements ActionListener
{

	MouseEvent lastEvent;
	Timer timer;
	int delay;
	private boolean leftClick;
	private boolean middleClick;
	private boolean rightClick;
	private boolean doubleClick;
	private boolean tripleClick;

	public MouseTripleClickCounterListener()
	{
		this((Integer)Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval"));
	}

	public MouseTripleClickCounterListener(int delay)
	{
		this.delay = delay;
		this.timer = new Timer(delay, this);
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Test Double Click");
		frame.addWindowListener(new CloseWindow());
		frame.addMouseListener(new MouseTripleClickCounterListener()
		{
			public void singleClick(MouseEvent e)
			{
				System.out.println("single click");
			}

			public void doubleClick(MouseEvent e)
			{
				System.out.println("double click");
			}

			@Override
			public void tripleClick(MouseEvent mouseEvent)
			{
				System.out.println("triple click");
			}
		});
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

	public void mouseClicked(MouseEvent mouseEvent)
	{
		setMouseButton(mouseEvent);

		if (mouseEvent.getClickCount() > 3)
		{
			timer.stop();
			tripleClick(lastEvent);
		}
		lastEvent = mouseEvent;
		if (mouseEvent.getClickCount() > 2)
			return;

		if (timer.isRunning())
		{
			timer.stop();
			doubleClick(lastEvent);
		}
		else
		{
			timer.restart();
		}
	}

	private void setMouseButton(MouseEvent mouseEvent)
	{
		if (mouseEvent.getButton() == MouseEvent.BUTTON1)
		{
			leftClick = true;
			middleClick = false;
			rightClick = false;
		}
		if (mouseEvent.getButton() == MouseEvent.BUTTON2)
		{
			leftClick = false;
			middleClick = true;
			rightClick = false;
		}
		if (mouseEvent.getButton() == MouseEvent.BUTTON3)
		{
			leftClick = false;
			middleClick = false;
			rightClick = true;
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		timer.stop();
		singleClick(lastEvent);
	}

	public void singleClick(MouseEvent mouseEvent)
	{
	}

	public void doubleClick(MouseEvent mouseEvent)
	{
	}

	public void tripleClick(MouseEvent mouseEvent)
	{
	}
}