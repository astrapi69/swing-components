package io.github.astrapi69.swing.component;

import io.github.astrapi69.model.LambdaModel;
import io.github.astrapi69.model.PropertyModel;
import io.github.astrapi69.model.SerializableModel;
import io.github.astrapi69.model.api.Model;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.model.BaseModel;

import javax.swing.*;

@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMMenuItem<T> extends JMenuItem
{
//	Model<ButtonModelBean> beanModel;
//
//	{
//		ButtonModelBean buttonModelBean = ButtonModelBean.builder().build();
//		DefaultButtonModel buttonModel = (DefaultButtonModel)getModel();
//		beanModel = SerializableModel.of(buttonModelBean);
//		Model<DefaultButtonModel> componentModel = SerializableModel.of(buttonModel);
//	}

	public JMMenuItem()
	{
	}

	public JMMenuItem(Icon icon)
	{
		super(icon);
	}

	public JMMenuItem(String text)
	{
		super(text);
	}

	public JMMenuItem(Action a)
	{
		super(a);
	}

	public JMMenuItem(String text, Icon icon)
	{
		super(text, icon);
	}

	public JMMenuItem(String text, int mnemonic)
	{
		super(text, mnemonic);
	}

}
