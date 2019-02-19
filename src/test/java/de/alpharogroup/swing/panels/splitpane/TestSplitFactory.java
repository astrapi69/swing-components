package de.alpharogroup.swing.panels.splitpane;

import org.jdesktop.swingx.MultiSplitLayout;

import static de.alpharogroup.swing.panels.splitpane.SplitFactory.newLeaf;
import static de.alpharogroup.swing.panels.splitpane.SplitFactory.setChildren;

public class TestSplitFactory {



    public static MultiSplitLayout.Split newTestSplit()
    {
        MultiSplitLayout.Split col1 = SplitFactory.newSplit(false, 0.75);
        MultiSplitLayout.Leaf source = newLeaf("content", 0.75);
        MultiSplitLayout.Leaf info =  newLeaf("bottom", 0.25);
        col1.setChildren(source, new MultiSplitLayout.Divider(), info);
        MultiSplitLayout.Split row1 = new MultiSplitLayout.Split();
        row1.setRowLayout(true);
        MultiSplitLayout.Leaf conf = newLeaf("left", 0.25);
        setChildren(row1, conf, new MultiSplitLayout.Divider(), col1);
        return row1;
    }


}
