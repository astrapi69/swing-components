package de.alpharogroup.swing.dialog.factories;

import de.alpharogroup.file.create.FileFactory;
import de.alpharogroup.swing.listener.RequestFocusListener;
import net.miginfocom.swing.MigLayout;
import org.testng.annotations.Test;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;

import static org.testng.Assert.*;


/**
 * The unit test class for the class {@link JDialogFactory}
 */
public class JDialogFactoryTest {

    /**
     * Test method for
     * {@link JDialogFactory#newJDialog(Component, String, boolean, GraphicsConfiguration)}
     */
    @Test
    public void testTestNewJDialog() {
        final Frame frame = new Frame("JDialogFactoryDemo");

    }

    /**
     * Test method for
     * {@link JDialogFactory#newJDialog(Component, String, Dialog.ModalityType, GraphicsConfiguration)}
     */
    @Test
    public void testTestNewJDialog1() {
    }

    /**
     * Test method for
     * {@link JDialogFactory#newJDialog(JOptionPane, String)}
     */
    @Test
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
    @Test
    public void testNewJDialogComponentJOptionPaneString() {
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
    }
}