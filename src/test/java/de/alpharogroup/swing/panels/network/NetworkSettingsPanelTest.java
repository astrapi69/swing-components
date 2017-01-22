package de.alpharogroup.swing.panels.network;

import java.io.IOException;

import javax.swing.JFrame;

import de.alpharogroup.layout.CloseWindow;

public class NetworkSettingsPanelTest
{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {
		final JFrame frame = new JFrame();
		frame.addWindowListener(new CloseWindow());
		frame.setTitle("NetworkSettingsPanel");

		final NetworkSettingsPanel panel = new NetworkSettingsPanel();
		frame.add( panel);
        frame.setBounds(0, 0, 1020, 420);
        frame.setVisible( true );
	}
}
