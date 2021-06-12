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
package io.github.astrapi69.swing.dialog.factories;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import org.testng.annotations.Test;

import io.github.astrapi69.swing.components.factories.JComponentFactory;
import io.github.astrapi69.swing.listener.RequestFocusListener;
import io.github.astrapi69.swing.test.TestComponentFactory;
import net.miginfocom.swing.MigLayout;


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
	 * Test method for {@link JDialogFactory#newJDialog(Component, JOptionPane, String)}
	 */
	@Test(enabled = false)
	public void testNewJDialogComponentJOptionPaneString()
	{
	}

	/**
	 * Test method for
	 * {@link JDialogFactory#newJDialog(Component, String, boolean, GraphicsConfiguration)}
	 */
	@Test(enabled = false)
	public void testTestNewJDialog()
	{
	}

	/**
	 * Test method for
	 * {@link JDialogFactory#newJDialog(Component, String, Dialog.ModalityType, GraphicsConfiguration)}
	 */
	@Test(enabled = false)
	public void testTestNewJDialog1()
	{
	}

	/**
	 * Test method for {@link JDialogFactory#newJDialog(JOptionPane, String)}
	 */
	@Test(enabled = false)
	public void testTestNewJDialogJOptionPaneString()
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
}