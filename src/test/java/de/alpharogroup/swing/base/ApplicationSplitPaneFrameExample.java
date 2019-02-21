package de.alpharogroup.swing.base;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.swing.panels.splitpane.ApplicationTestModel;
import de.alpharogroup.swing.panels.splitpane.JXMultiSplitPanePanel;
import de.alpharogroup.swing.panels.splitpane.SplitFactory;
import org.jdesktop.swingx.MultiSplitLayout;

import javax.swing.*;

import java.awt.*;

public class ApplicationSplitPaneFrameExample extends ApplicationSplitPaneFrame<ApplicationTestModel<String>>{


    /**
     * Test init layout.
     */

    public static void main(final String[] args)
    {
        final Frame frame = new ApplicationSplitPaneFrameExample("ApplicationSplitPaneFrameExample");
        frame.addWindowListener(new CloseWindow());
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Instantiates a new {@link ApplicationSplitPaneFrame}
     *
     * @param title the title
     */
    public ApplicationSplitPaneFrameExample(String title) {
        super(title);
    }

    @Override
    protected String newIconPath() {
        return "/home/astrapi69/git/swing-components/src/test/resources/img/xmas/bell.png";
    }


    @Override
    protected JXMultiSplitPanePanel<ApplicationTestModel<String>> newMainComponent() {
        final JXMultiSplitPanePanel<ApplicationTestModel<String>> multiSplitPanePanel
                = new JXMultiSplitPanePanel<ApplicationTestModel<String>>()
        {
            @Override
            protected MultiSplitLayout.Node newRootNode(String layoutDefinition) {
                return ApplicationSplitPaneFrameExample.this.newRootNode();
            }
        };
        multiSplitPanePanel.getMultiSplitPane().add(newTopComponent(), "content");
        multiSplitPanePanel.getMultiSplitPane().add(newBottomComponent(), "bottom");
        multiSplitPanePanel.getMultiSplitPane().add(newLeftComponent(), "left");
        return multiSplitPanePanel;
    }

    protected JComponent newLeftComponent() {
        return new JLabel("Left Component");
    }

    protected JComponent newTopComponent() {
        return new JLabel("Top Component");
    }

    protected JComponent newBottomComponent() {
//		ConsolePanel consolePanel = new ConsolePanel();
//		JScrollPane jScrollPane = new JScrollPane(consolePanel);
        return new JLabel("Right Component");
    }

    protected MultiSplitLayout.Split newRootNode() {

        MultiSplitLayout.Split col1 = SplitFactory.newSplit(false, 0.75);
        MultiSplitLayout.Leaf content = SplitFactory.newLeaf("content", 0.75);
        MultiSplitLayout.Leaf bottom =  SplitFactory.newLeaf("bottom", 0.25);
        col1.setChildren(content, new MultiSplitLayout.Divider(), bottom);
        MultiSplitLayout.Split root = new MultiSplitLayout.Split();
        root.setRowLayout(true);
        MultiSplitLayout.Leaf left = SplitFactory.newLeaf("left", 0.25);
        SplitFactory.setChildren(root, left, new MultiSplitLayout.Divider(), col1);
        return root;
    }
}