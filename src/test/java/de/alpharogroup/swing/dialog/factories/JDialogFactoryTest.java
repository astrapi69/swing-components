package de.alpharogroup.swing.dialog.factories;

import de.alpharogroup.file.create.FileFactory;
import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.swing.components.factories.JComponentFactory;
import de.alpharogroup.swing.listener.RequestFocusListener;
import de.alpharogroup.swing.test.TestComponentFactory;
import net.miginfocom.swing.MigLayout;
import org.testng.annotations.Test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Path;

import static org.testng.Assert.*;


/**
 * The unit test class for the class {@link JDialogFactory}
 */
public class JDialogFactoryTest
{

	public static void main(final String[] a)
	{
		final Frame frame;
		JPanel buttonPanel;
		JButton buttonShow;

		buttonPanel = new JPanel();

		frame = TestComponentFactory.newTestFrame("JDialogFactoryDemo");
		frame.add(buttonPanel);
		buttonShow = newButtonShow(frame);
		buttonPanel.add(buttonShow, BorderLayout.EAST);
		TestComponentFactory.showFrame(frame, 4);
	}

	/**
	 * Test method for
	 * {@link JDialogFactory#newJDialog(Component, String, boolean, GraphicsConfiguration)}
	 */
	@Test(enabled = false) public void testTestNewJDialog()
	{
	}

	protected static JButton newButtonShow(final Frame frame)
	{
		JButton button = JComponentFactory.newJButton("Show dialog");
		button.addActionListener(e -> {
			JPasswordField pf = new JPasswordField("", 10);
			pf.setFocusable(true);
			pf.setRequestFocusEnabled(true);
			JPanel panel = new JPanel(new MigLayout(""));
			panel.add(new JLabel("Password:"));
			panel.add(pf, "growy");

			JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION);

			JDialog dialog = JDialogFactory.newJDialog(frame, optionPane, "Enter Password");
			dialog.addWindowFocusListener(new RequestFocusListener(pf));
			dialog.pack();
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		});
		return button;
	}

	/**
	 * Test method for
	 * {@link JDialogFactory#newJDialog(Component, String, Dialog.ModalityType, GraphicsConfiguration)}
	 */
	@Test(enabled = false) public void testTestNewJDialog1()
	{
	}

	/**
	 * Test method for
	 * {@link JDialogFactory#newJDialog(JOptionPane, String)}
	 */
	@Test(enabled = false) public void testTestNewJDialogJOptionPaneString()
	{
		JPasswordField pf = new JPasswordField("", 10);
		pf.setFocusable(true);
		pf.setRequestFocusEnabled(true);
		JPanel panel = new JPanel(new MigLayout(""));
		panel.add(new JLabel("Password:"));
		panel.add(pf, "growy");

		JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE,
			JOptionPane.OK_CANCEL_OPTION);

		JDialog dialog = JDialogFactory.newJDialog(optionPane, "Enter Password");
		dialog.addWindowFocusListener(new RequestFocusListener(pf));
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	/**
	 * Test method for
	 * {@link JDialogFactory#newJDialog(Component, JOptionPane, String)}
	 */
	@Test(enabled = false) public void testNewJDialogComponentJOptionPaneString()
	{
	}
}