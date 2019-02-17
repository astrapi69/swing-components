package de.alpharogroup.swing.panels.splitpane;

import org.jdesktop.swingx.MultiSplitLayout;

public class SplitFactory {


    public static  MultiSplitLayout newMultiSplitLayout(MultiSplitLayout.Split split)
    {
        MultiSplitLayout layout = new MultiSplitLayout(split);
        return layout;
    }

    public static MultiSplitLayout.Split newSplit1()
    {
        MultiSplitLayout.Split col1 = newSplit(false, 0.75);
        MultiSplitLayout.Leaf source = newLeaf("source", 0.75);
        MultiSplitLayout.Leaf info =  newLeaf("info", 0.25);
        col1.setChildren(source, new MultiSplitLayout.Divider(), info);
        MultiSplitLayout.Split row1 = new MultiSplitLayout.Split();
        row1.setRowLayout(true);
        MultiSplitLayout.Leaf conf = newLeaf("conf", 0.25);
        setChildren(row1, conf, new MultiSplitLayout.Divider(), col1);
        return row1;
    }

    private static void setChildren(MultiSplitLayout.Split col1, MultiSplitLayout.Node... children) {
        col1.setChildren(children);
    }

    public static MultiSplitLayout.Split newSplit(boolean rowLayout, double weight) {
        MultiSplitLayout.Split col1 = new MultiSplitLayout.Split();
        col1.setRowLayout(rowLayout);
        col1.setWeight(weight);
        return col1;
    }

    public static MultiSplitLayout.Leaf newLeaf(String name, double weight) {
        MultiSplitLayout.Leaf source = new MultiSplitLayout.Leaf(name);
        source.setWeight(weight);
        return source;
    }
}
