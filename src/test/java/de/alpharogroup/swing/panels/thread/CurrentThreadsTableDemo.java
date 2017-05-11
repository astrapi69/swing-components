package de.alpharogroup.swing.panels.threads;

import javax.swing.JFrame;

import de.alpharogroup.swing.panels.thread.CurrentThreadsTablePanel;

public class CurrentThreadsTableDemo {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		CurrentThreadsTablePanel viewer = new CurrentThreadsTablePanel();

		f.setContentPane(viewer);
		f.setSize(500, 300);
		f.setVisible(true);

	}

}
