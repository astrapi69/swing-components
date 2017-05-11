package de.alpharogroup.swing.panels.thread;

import javax.swing.JFrame;

public class CurrentThreadsTableDemo {

	public static void main(final String[] args) {
		final JFrame f = new JFrame();
		final CurrentThreadsTablePanel viewer = new CurrentThreadsTablePanel();

		f.setContentPane(viewer);
		f.setSize(500, 300);
		f.setVisible(true);

	}

}
