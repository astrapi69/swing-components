package de.alpharogroup.swing.panels.splitpane;

import org.jdesktop.swingx.MultiSplitLayout;

import static de.alpharogroup.swing.panels.splitpane.SplitFactory.newLeaf;
import static de.alpharogroup.swing.panels.splitpane.SplitFactory.setChildren;

public class TestSplitFactory {



    public static MultiSplitLayout.Split newTestSplit()
    {
        MultiSplitLayout.Split col1 = SplitFactory.newSplit(false, 0.75);
        MultiSplitLayout.Leaf content = newLeaf("content", 0.75);
        MultiSplitLayout.Leaf bottom =  newLeaf("bottom", 0.25);
        col1.setChildren(content, new MultiSplitLayout.Divider(), bottom);
        MultiSplitLayout.Split root = new MultiSplitLayout.Split();
        root.setRowLayout(true);
        MultiSplitLayout.Leaf left = newLeaf("left", 0.25);
        setChildren(root, left, new MultiSplitLayout.Divider(), col1);
        return root;
    }


}
