package de.alpharogroup.swing.panels;

import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.base.BasePanel;

public class TemplateBasePanel extends BasePanel<Object>
{

	public TemplateBasePanel()
	{
		super();
	}

	public TemplateBasePanel(Model<Object> model)
	{
		super(model);
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
	}

}
