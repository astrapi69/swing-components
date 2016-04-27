package de.alpharogroup.swing.renderer;

import java.text.SimpleDateFormat;
import java.util.Objects;

import de.alpharogroup.date.DatePatterns;
import lombok.Getter;

import javax.swing.table.DefaultTableCellRenderer;

/**
 * The Class DateRenderer.
 */
public class DateRenderer extends DefaultTableCellRenderer {

	/** The constant for the serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The constant for the default date pattern. */
	public static final String DEFAULT_PATTERN = DatePatterns.DOT_DD_MM_YYYY;

	/** The date pattern. */
	@Getter
	private String datePattern;
	
	/** The date formatter. */
	private final SimpleDateFormat dateFormatter;	
     
    /**
	 * Instantiates a new {@link DateRenderer}.
     */
    public DateRenderer() {
    	this(DEFAULT_PATTERN);
    }    

	/**
	 * Instantiates a new {@link DateRenderer}.
	 *
	 * @param pattern the pattern
	 */
	public DateRenderer(String pattern) {
		this.datePattern = pattern;
        this.dateFormatter = new SimpleDateFormat(this.datePattern);
	}
     
	/**
	 * {@inheritDoc}
	 */
    @Override
    protected void setValue(Object value) {
        setText((Objects.isNull(value)) ? "" : dateFormatter.format(value));
    }
 
}
