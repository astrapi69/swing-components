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
