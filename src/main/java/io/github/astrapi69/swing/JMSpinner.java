package io.github.astrapi69.swing;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import lombok.NonNull;

public class JMSpinner<T> extends JSpinner
{
	Model<T> propertyModel = BaseModel.of();
	{
		JComponent comp = this.getEditor();
		JFormattedTextField field = (JFormattedTextField)comp.getComponent(0);
		DefaultFormatter formatter = (DefaultFormatter)field.getFormatter();
		formatter.setCommitsOnValidEdit(true);
		addChangeListener(e -> {
			JSpinner s = (JSpinner)e.getSource();
			T value = (T)s.getValue();
			propertyModel.setObject(value);
		});
	}

	public void setPropertyModel(final @NonNull Model<T> propertyModel)
	{
		this.propertyModel = propertyModel;
		getModel().setValue(this.propertyModel.getObject());
	}

	/**
	 * Constructs a spinner for the given model. The spinner has
	 * a set of previous/next buttons, and an editor appropriate
	 * for the model.
	 *
	 * @param model
	 * @throws NullPointerException if the model is {@code null}
	 */
	public JMSpinner(SpinnerModel model)
	{
		super(model);
	}

	/**
	 * Constructs a spinner with an <code>Integer SpinnerNumberModel</code>
	 * with initial value 0 and no minimum or maximum limits.
	 */
	public JMSpinner()
	{
	}
}
