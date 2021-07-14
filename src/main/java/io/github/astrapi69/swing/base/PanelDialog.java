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
package io.github.astrapi69.swing.base;

import java.awt.*;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.model.api.Model;

/**
 * The class {@link PanelDialog} contains a panel for the content and a panel for the buttons
 *
 * @param <T>
 *            the generic type
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PanelDialog<T> extends BaseDialog<T>
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	JPanel buttons;

	Container container;

	JPanel content;

	/**
	 * Instantiates a new {@link PanelDialog}.
	 *
	 * @param owner
	 *            the owner
	 * @param title
	 *            the title
	 * @param modal
	 *            the modal
	 * @param model
	 *            the model
	 */
	public PanelDialog(final Frame owner, final String title, final boolean modal,
		final Model<T> model)
	{
		super(owner, title, modal, model);
	}

	/**
	 * Instantiates a new {@link PanelDialog}.
	 *
	 * @param owner
	 *            the owner
	 * @param title
	 *            the title
	 * @param model
	 *            the model
	 */
	public PanelDialog(final Frame owner, final String title, final Model<T> model)
	{
		super(owner, title, model);
	}
	/**
	 * Instantiates a new {@link PanelDialog} object
	 *
	 * @param owner
	 *            the owner
	 * @param title
	 *            the title
	 * @param modal
	 *            the modal
	 * @param model
	 *            the model
	 */
	public PanelDialog(final Window owner, final String title, final boolean modal,
		final Model<T> model)
	{
		super(owner, title, modal, model);
	}

	/**
	 * Instantiates a new {@link PanelDialog} object
	 *
	 * @param owner
	 *            the owner
	 * @param title
	 *            the title
	 * @param model
	 *            the model
	 */
	public PanelDialog(final Window owner, final String title,
		final Model<T> model)
	{
		super(owner, title, model);
	}

	protected Container getContentPaneContainer()
	{
		return getContentPane();
	}

	protected JPanel newButtons(final Model<T> model)
	{
		JPanel buttonsPanel = new JPanel();
		return buttonsPanel;
	}


	protected JPanel newContent(final Model<T> model)
	{
		JPanel emptyPanel = new JPanel();
		return emptyPanel;
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		setModal(isModal());
		container = getContentPaneContainer();
		content = newContent(getModel());
		buttons = newButtons(getModel());
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		container = getContentPane();
		container.add(content, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
	}

}
