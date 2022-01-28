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
package io.github.astrapi69.swing.icon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Shape;
import java.awt.geom.Path2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class ShapeIconPaintTest
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() -> createAndShowGui());
	}

	private static void createAndShowGui()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel(new FlowLayout());

		ShapeIcon customIcon = ShapeIcon.builder().shape(createArrowShape()).shapeColor(Color.RED)
			.backgroundColor(Color.GREEN).iconHeight(16).iconWidth(16).build();
		panel.add(new JLabel(customIcon));

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JPanel controlPanel = new JPanel(new FlowLayout());
		JSlider slider = new JSlider(16, 64, 16);
		slider.addChangeListener(e -> {
			int value = slider.getValue();
			customIcon.setIconWidth(value);
			customIcon.setIconHeight(value);
			panel.revalidate();
		});
		controlPanel.add(slider);

		frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);

		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static Shape createArrowShape()
	{
		Path2D path = new Path2D.Double();
		path.moveTo(0.0, 0.25);
		path.lineTo(0.5, 0.25);
		path.lineTo(0.5, 0.0);
		path.lineTo(1.0, 0.5);
		path.lineTo(0.5, 1.0);
		path.lineTo(0.5, 0.75);
		path.lineTo(0.0, 0.75);
		path.closePath();
		return path;
	}

}