package de.alpharogroup.swing.dialog.factories;

import de.alpharogroup.file.create.FileFactory;
import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.swing.components.factories.JComponentFactory;
import de.alpharogroup.swing.listener.RequestFocusListener;
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
public class JDialogFactoryTest {

    public static void main(final String[] a) {

        final Frame frame = new Frame("JDialogFactoryDemo");
        frame.addWindowListener(new CloseWindow());
        JPanel buttonPanel;
        JButton buttonShow;
        buttonPanel = new JPanel();
        buttonShow = newButtonShow();
        buttonPanel.add(buttonShow, BorderLayout.EAST);
        frame.add(buttonPanel);
        buttonShow.addActionListener(e -> {
            JPasswordField pf = new JPasswordField("", 10);
            pf.setFocusable(true);
            pf.setRequestFocusEnabled(true);
            JPanel panel = new JPanel(new MigLayout(""));
            panel.add(new JLabel("Password:"));
            panel.add(pf, "growy");

            JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.OK_CANCEL_OPTION);

            JDialog dialog = JDialogFactory.newJDialog(frame,  optionPane, "Enter Password");
            dialog.addWindowFocusListener(new RequestFocusListener(pf));
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });

        final int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        final int y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        frame.setLocation((x / 3), (y / 3));
        frame.setSize((x / 3), (y / 3));
        // 8. Show the Frame.
        frame.setVisible(true);
        if (!frame.isActive())
        {
            frame.toFront();
        }
    }
        /**
         * Test method for
         * {@link JDialogFactory#newJDialog(Component, String, boolean, GraphicsConfiguration)}
         */
    @Test(enabled = false)
    public void testTestNewJDialog() {
        final Frame frame = new Frame("JDialogFactoryDemo");
        frame.addWindowListener(new CloseWindow());
        JPanel buttonPanel;
        JButton buttonShow;
        buttonPanel = new JPanel();
        buttonShow = newButtonShow();
        buttonPanel.add(buttonShow, BorderLayout.EAST);
        frame.add(buttonPanel);

    }

    protected static JButton newButtonShow(){
        JButton button = JComponentFactory.newJButton("Show dialog");
        return button;
    }

    /**
     * Test method for
     * {@link JDialogFactory#newJDialog(Component, String, Dialog.ModalityType, GraphicsConfiguration)}
     */
    @Test(enabled = false)
    public void testTestNewJDialog1() {
    }

    /**
     * Test method for
     * {@link JDialogFactory#newJDialog(JOptionPane, String)}
     */
    @Test(enabled = false)
    public void testTestNewJDialogJOptionPaneString() {
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
    @Test(enabled = false)
    public void testNewJDialogComponentJOptionPaneString() {

        final Frame frame = new Frame("JDialogFactoryDemo");
        frame.addWindowListener(new CloseWindow());
        JPanel buttonPanel;
        JButton buttonShow;
        buttonPanel = new JPanel();
        buttonShow = newButtonShow();
        buttonPanel.add(buttonShow, BorderLayout.EAST);
        frame.add(buttonPanel);
        buttonShow.addActionListener(e -> {
            JPasswordField pf = new JPasswordField("", 10);
            pf.setFocusable(true);
            pf.setRequestFocusEnabled(true);
            JPanel panel = new JPanel(new MigLayout(""));
            panel.add(new JLabel("Password:"));
            panel.add(pf, "growy");

            JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.OK_CANCEL_OPTION);

            JDialog dialog = JDialogFactory.newJDialog(null,
                    optionPane, "Enter Password");
            dialog.addWindowFocusListener(new RequestFocusListener(pf));
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });
        frame.setSize(600, 400);
        // 8. Show the Frame.
        frame.setVisible(true);
        if (!frame.isActive())
        {
            frame.toFront();
        }
    }
}