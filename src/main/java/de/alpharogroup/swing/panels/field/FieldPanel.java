package de.alpharogroup.swing.panels.field;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import lombok.Getter;

/**
 * The class {@link FieldPanel} for create a new field.
 */
public abstract class FieldPanel<T> extends JPanel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


    /** The {@link JLabel} type. */
    @Getter
    private JLabel lblType;

	/** The {@link JComboBox} type. */
    @Getter
	private JComboBox<T> dropDownType;

    /** The {@link JLabel} field name. */
    @Getter
    private JLabel lblFieldName;

    /** The {@link JTextField} field name. */
    @Getter
    private JTextField txtFieldName;


    /**
     * Instantiates a new {@link FieldPanel}.
     */
    public FieldPanel()
	{
        initComponents();
		initLayout();
    }

    protected void initComponents()
	{
        txtFieldName = new JTextField();
        lblFieldName = new JLabel();
        lblType = new JLabel();
        dropDownType = new JComboBox<>();

        txtFieldName.setToolTipText("Enter a name");

        lblFieldName.setText("Field Name");

        lblType.setText("Type");

        dropDownType.setModel(newTypeModel());
    }

	protected abstract DefaultComboBoxModel<T> newTypeModel();

	protected void initLayout()
	{
        final GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFieldName)
                    .addComponent(lblFieldName, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(dropDownType, 0, 168, Short.MAX_VALUE)
                    .addComponent(lblType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFieldName)
                    .addComponent(lblType))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropDownType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
	}

}
