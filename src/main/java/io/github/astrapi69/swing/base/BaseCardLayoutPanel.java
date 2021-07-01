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

import javax.swing.border.LineBorder;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.model.api.Model;

/**
 * The class {@link BaseCardLayoutPanel} is a {@link BasePanel} with an initialized
 * {@link CardLayout}.
 *
 * @param <T>
 *            the generic type of the model object
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseCardLayoutPanel<T> extends BasePanel<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The card layout. */
	@Getter
	CardLayout cardLayout;

	/**
	 * Instantiates a new {@link BaseCardLayoutPanel}.
	 */
	public BaseCardLayoutPanel()
	{
		super();
	}

	/**
	 * Instantiates a new {@link BaseCardLayoutPanel}.
	 *
	 * @param isDoubleBuffered
	 *            the is double buffered
	 */
	public BaseCardLayoutPanel(boolean isDoubleBuffered)
	{
		super(isDoubleBuffered);
	}

	/**
	 * Instantiates a new {@link BaseCardLayoutPanel}.
	 *
	 * @param layout
	 *            the layout
	 */
	public BaseCardLayoutPanel(LayoutManager layout)
	{
		super(layout);
	}

	/**
	 * Instantiates a new {@link BaseCardLayoutPanel}.
	 *
	 * @param layout
	 *            the layout
	 * @param isDoubleBuffered
	 *            the is double buffered
	 */
	public BaseCardLayoutPanel(LayoutManager layout, boolean isDoubleBuffered)
	{
		super(layout, isDoubleBuffered);
	}

	/**
	 * Instantiates a new {@link BaseCardLayoutPanel}.
	 *
	 * @param model
	 *            the model
	 */
	public BaseCardLayoutPanel(Model<T> model)
	{
		super(model);
	}

	/**
	 * Factory method for create a new {@link CardLayout}.
	 *
	 * @return the new {@link CardLayout}.
	 */
	protected CardLayout newCardLayout()
	{
		final CardLayout cardLayout = new CardLayout();
		return cardLayout;
	}

	/**
	 * The layout have to initialize before components. {@inheritDoc}
	 */
	@Override
	protected void onBeforeInitializeComponents()
	{
		super.onBeforeInitializeComponents();
		cardLayout = newCardLayout();
		setLayout(cardLayout);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		setBorder(new LineBorder(Color.BLACK));
	}

}
