package de.alpharogroup.swing.panels.splitpane;

import org.jdesktop.swingx.MultiSplitLayout;

public class SplitFactory {


    public static  MultiSplitLayout newMultiSplitLayout(MultiSplitLayout.Split split)
    {
        MultiSplitLayout layout = new MultiSplitLayout(split);
        return layout;
    }

    public static void setChildren(MultiSplitLayout.Split split, MultiSplitLayout.Node... children) {
        split.setChildren(children);
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
