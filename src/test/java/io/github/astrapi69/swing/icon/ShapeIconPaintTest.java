package io.github.astrapi69.swing.icon;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import javax.swing.*;

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

		ShapeIcon customIcon = ShapeIcon
			.builder().
		shape(createArrowShape()).shapeColor(Color.RED)
			.backgroundColor(Color.GREEN).iconHeight(16).iconWidth(16).
				build();
        panel.add(new JLabel(customIcon));
        
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        JPanel controlPanel = new JPanel(new FlowLayout());
        JSlider slider = new JSlider(16, 64, 16);
        slider.addChangeListener(e -> 
        {
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