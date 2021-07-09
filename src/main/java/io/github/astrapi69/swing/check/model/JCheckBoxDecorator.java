package io.github.astrapi69.swing.check.model;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JCheckBoxDecorator extends JCheckBox
{

	/** The model. */
	Model<Boolean> bindModel;

	public JCheckBoxDecorator()
	{
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(Icon icon)
	{
		super(icon);
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(Icon icon, boolean selected)
	{
		super(icon, selected);
		initializeBindModel(selected);
	}

	public JCheckBoxDecorator(String text)
	{
		super(text);
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(Action a)
	{
		super(a);
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(String text, boolean selected)
	{
		super(text, selected);
		initializeBindModel(selected);
	}

	public JCheckBoxDecorator(String text, Icon icon)
	{
		super(text, icon);
		initializeBindModel(false);
	}

	public JCheckBoxDecorator(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
		initializeBindModel(selected);
	}

	@Override public void setModel(ButtonModel newModel)
	{
		super.setModel(newModel);
		if(newModel != null) {
			if(bindModel == null) {
				bindModel = BaseModel.of(newModel.isSelected());
			} else {
				bindModel.setObject(newModel.isSelected());
			}
			newModel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					bindModel.setObject(newModel.isSelected());
				}
			});
		}
	}

	public void setBindModel(final @NonNull Model<Boolean> bindModel) {
		ButtonModel buttonModel = getModel();
		if(buttonModel == null) {
			buttonModel = new DefaultButtonModel();
		}
		buttonModel.setSelected(bindModel.getObject());
	}

	public void setBindModelObject(final boolean modelObject) {
		bindModel.setObject(modelObject);
		setBindModel(bindModel);
	}

	protected void initializeBindModel(boolean selected) {
		bindModel.setObject(selected);
	}
}
