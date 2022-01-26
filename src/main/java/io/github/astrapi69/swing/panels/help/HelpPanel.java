/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.astrapi69.swing.panels.help;

import javax.swing.*;

import lombok.Getter;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.base.BasePanel;

/**
 * Panel for a simple help with title and content.
 */
@Getter
public class HelpPanel extends BasePanel<HelpModelBean>
{

	private JLabel lblHelpTitle;
	private JScrollPane scrHelpContent;
	private JTextArea txtHelpContent;

	public HelpPanel(final IModel<HelpModelBean> model)
	{
		super(model);
	}

	/**
	 * Creates new form HelpPanel
	 */
	public HelpPanel()
	{
		this(BaseModel.of(HelpModelBean.builder().build()));
	}

	@Override
	protected void onInitializeComponents()
	{
		lblHelpTitle = new JLabel();
		scrHelpContent = new JScrollPane();
		txtHelpContent = new JTextArea();

		lblHelpTitle
			.setText(getModelObject().getTitle() != null ? getModelObject().getTitle() : "Help");
		txtHelpContent.setText(getModelObject().getContent() != null
			? getModelObject().getContent()
			: "No help content. Please set content for the help of your application.");
		txtHelpContent.setCaretPosition(0);
		txtHelpContent.setEnabled(false);
		txtHelpContent.setLineWrap(true);
		scrHelpContent.setViewportView(txtHelpContent);
	}

	@Override
	protected void onInitializeLayout()
	{
		switch (getModelObject().getSize())
		{
			case MEDIUM :
				onInitializeMediumGroupLayout();
				break;
			case LARGE :
				onInitializeLargeGroupLayout();
				break;
			default :
				onInitializeSmallGroupLayout();
				break;
		}
	}

	protected void onInitializeMediumGroupLayout()
	{
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout
			.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addGap(32, 32, 32)
						.addGroup(layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							.addComponent(scrHelpContent).addComponent(lblHelpTitle,
								javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE))
						.addContainerGap(28, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
				.addComponent(lblHelpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(scrHelpContent, javax.swing.GroupLayout.PREFERRED_SIZE, 320,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(48, Short.MAX_VALUE)));
	}

	protected void onInitializeLargeGroupLayout()
	{
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout
			.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addGap(32, 32, 32)
						.addGroup(layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							.addComponent(scrHelpContent).addComponent(lblHelpTitle,
								javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE))
						.addContainerGap(28, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
				.addComponent(lblHelpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(scrHelpContent, javax.swing.GroupLayout.PREFERRED_SIZE, 520,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(48, Short.MAX_VALUE)));
	}

	protected void onInitializeSmallGroupLayout()
	{
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout
			.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addGap(32, 32, 32)
						.addGroup(layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							.addComponent(scrHelpContent).addComponent(lblHelpTitle,
								javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE))
						.addContainerGap(28, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
				.addComponent(lblHelpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(scrHelpContent, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(28, Short.MAX_VALUE)));
	}

}
