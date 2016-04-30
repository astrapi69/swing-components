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