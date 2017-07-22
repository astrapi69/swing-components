package de.alpharogroup.swing.base;

import java.awt.LayoutManager;

import org.jdesktop.swingx.JXPanel;

import de.alpharogroup.model.IModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link BasePanel} for swing panels to provide an initialization cycle where the user
 * can overwrite the callback methods for interaction.
 *
 * @param <T>
 *            the generic type
 */
@Getter
@Setter
public class BasePanel<T> extends JXPanel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	private IModel<T> model;

	/**
	 * Initializer block.
	 */
	{
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 */
	public BasePanel()
	{
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param model the model
	 */
	public BasePanel(final IModel<T> model)
	{
		this.model = model;
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param isDoubleBuffered
	 *            the is double buffered
	 */
	public BasePanel(final boolean isDoubleBuffered)
	{
		super(isDoubleBuffered);
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param layout
	 *            the layout
	 * @param isDoubleBuffered
	 *            the is double buffered
	 */
	public BasePanel(final LayoutManager layout, final boolean isDoubleBuffered)
	{
		super(layout, isDoubleBuffered);
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param layout
	 *            the layout
	 */
	public BasePanel(final LayoutManager layout)
	{
		super(layout);
	}

	/**
	 * Initialize the component.
	 */
	protected void initialize()
	{
		onBeforeInitialize();
		onBeforeInitializeComponents();
		initializeComponents();
		onAfterInitializeComponents();
		onBeforeInitializeLayout();
		initializeLayout();
		onAfterInitializeLayout();
		onAfterInitialize();
	};

	/**
	 * Callback method to initialize components from the component.
	 */
	protected void initializeComponents()
	{
	}

	/**
	 * Callback method to initialize layout from the component.
	 */
	protected void initializeLayout()
	{
	}

	/**
	 * Callback method to interact when the initialization of the component is finished.
	 */
	protected void onAfterInitialize()
	{
	}


	/**
	 * Callback method to interact when the initialization is finished of the components from the
	 * component.
	 */
	protected void onAfterInitializeComponents()
	{
	}

	/**
	 * Callback method to interact when the initialization of the layout is finished.
	 */
	protected void onAfterInitializeLayout()
	{
	}

	/**
	 * Callback method to interact on before initialization of the component.
	 */
	protected void onBeforeInitialize()
	{
	}


	/**
	 * Callback method to interact on before initialization of the components from the component.
	 */
	protected void onBeforeInitializeComponents()
	{
	}

	/**
	 * Callback method to interact on before initialization of the layout.
	 */
	protected void onBeforeInitializeLayout()
	{
	}

	/**
	 * Getter for the model's object
	 *
	 * @return the model object
	 */
	public final T getModelObject()
	{
		return getModel().getObject();
	}

	/**
	 * Setter for the model object
	 *
	 * @param modelObject
	 *            the new model object
	 */
	public final BasePanel<T> setModelObject(final T modelObject)
	{
		getModel().setObject(modelObject);
		return this;
	}


}
