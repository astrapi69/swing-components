package de.alpharogroup.swing.base;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.border.LineBorder;

import de.alpharogroup.model.api.Model;
import lombok.Getter;

/**
 * The class {@link BaseCardLayoutPanel} is a {@link BasePanel} with an initialized {@link CardLayout}.
 *
 * @param <T>
 *            the generic type of the model object
 */
public class BaseCardLayoutPanel<T> extends BasePanel<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The card layout. */
	@Getter
	private CardLayout cardLayout;

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
	 * @param isDoubleBuffered the is double buffered
	 */
	public BaseCardLayoutPanel(boolean isDoubleBuffered)
	{
		super(isDoubleBuffered);
	}

	/**
	 * Instantiates a new {@link BaseCardLayoutPanel}.
	 *
	 * @param layout the layout
	 * @param isDoubleBuffered the is double buffered
	 */
	public BaseCardLayoutPanel(LayoutManager layout, boolean isDoubleBuffered)
	{
		super(layout, isDoubleBuffered);
	}

	/**
	 * Instantiates a new {@link BaseCardLayoutPanel}.
	 *
	 * @param layout the layout
	 */
	public BaseCardLayoutPanel(LayoutManager layout)
	{
		super(layout);
	}

	/**
	 * Instantiates a new {@link BaseCardLayoutPanel}.
	 *
	 * @param model the model
	 */
	public BaseCardLayoutPanel(Model<T> model)
	{
		super(model);
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

	/**
	 * The layout have to initialize before components.
	 * {@inheritDoc}
	 */
	@Override
	protected void onBeforeInitializeComponents()
	{
		super.onBeforeInitializeComponents();
		cardLayout = newCardLayout();
		setLayout(cardLayout);
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

}
