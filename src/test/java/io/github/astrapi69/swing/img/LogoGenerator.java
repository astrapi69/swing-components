/**
 * The MIT License
 *
 * Copyright (C) 2026 Asterios Raptis
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
package io.github.astrapi69.swing.img;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class LogoGenerator extends JPanel
{

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		// Background color
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);

		// Anti-aliasing for smoother graphics
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw the circle
		int circleRadius = Math.min(width, height) / 2 - 40;
		int circleX = (width - 2 * circleRadius) / 2;
		int circleY = (height - 2 * circleRadius) / 2;

		g2d.setColor(new Color(255, 165, 0)); // Orange color
		g2d.setStroke(new BasicStroke(10));
		g2d.draw(new Ellipse2D.Double(circleX, circleY, 2 * circleRadius, 2 * circleRadius));

		// Draw the number 69
		g2d.setFont(new Font("Orbitron", Font.PLAIN, 150)); // Futuristic font
		FontMetrics fm = g2d.getFontMetrics();
		String text = "69";
		int textWidth = fm.stringWidth(text);
		int textHeight = fm.getAscent();

		int textX = (width - textWidth) / 2;
		int textY = (height + textHeight) / 2 - 20;

		g2d.setColor(new Color(173, 216, 230)); // Light blue color
		g2d.drawString(text, textX, textY);
	}

	private static void createAndShowGUI()
	{
		JFrame frame = new JFrame("Logo Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.add(new LogoGenerator());
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() -> createAndShowGUI());
	}
}
