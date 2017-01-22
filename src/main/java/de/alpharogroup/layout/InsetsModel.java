package de.alpharogroup.layout;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsetsModel
{

    /**
     * The inset from the top.
     */
    private int top;

    /**
     * The inset from the left.
     */
    private int left;

    /**
     * The inset from the bottom.
     */
    private int bottom;

    /**
     * The inset from the right.
     */
    private int right;
}
