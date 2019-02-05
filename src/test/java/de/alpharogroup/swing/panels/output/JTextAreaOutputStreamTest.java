package de.alpharogroup.swing.panels.output;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JTextAreaOutputStreamTest
{
	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame();
		
		frame.add(new JLabel(" Console"), BorderLayout.NORTH);
		frame.add(new ConsolePanel());
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600, 400);

		for (int i = 0; i < 1000; i++)
		{
			System.out.println(i);
			Thread.sleep(50);
		}
	}
}
