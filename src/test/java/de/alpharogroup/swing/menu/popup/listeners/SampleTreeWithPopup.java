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
package de.alpharogroup.swing.menu.popup.listeners;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import de.alpharogroup.swing.components.factories.JComponentFactory;

public class SampleTreeWithPopup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPopupMenu menu;

	public SampleTreeWithPopup() throws HeadlessException {
		super("Tree");
		final JTree tree = new JTree();
		JMenuItem menuItem = new JMenuItem("A popup menu item");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath tp = tree.getSelectionPath();

				System.out.println("TreePath:" + tp);

				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				System.out.println("DefaultMutableTreeNode:" + node);

			}
		});
		menu = JComponentFactory.newJPopupMenu(tree, menuItem, new JMenuItem("A second popup menu item"));

		tree.addMouseListener(new MouseAdapter() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				TreePath tp = tree.getClosestPathForLocation(e.getX(), e.getY());

				if (e.isPopupTrigger()) {
					if (tp != null) {
						System.out.println(tp);
						tree.setSelectionPath(tp);
					}
				}
			}

		});

		tree.add(menu);

		add(new JScrollPane(tree));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SampleTreeWithPopup st = new SampleTreeWithPopup();
				st.setSize(200, 200);
				st.setLocationRelativeTo(null);
				st.setVisible(true);
			}
		});
	}
}