package de.alpharogroup.swing.bind;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import de.alpharogroup.check.Check;
import de.alpharogroup.model.api.Model;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The class {@link StringBindingListener} acts as listener of the input of a text component and
 * updates the given {@link Model}.
 *
 */
@Getter
@Slf4j
public class StringBindingListener implements DocumentListener
{

	/** The model. */
	private Model<String> model;

	/**
	 * Instantiates a new {@link StringBindingListener}.
	 *
	 * @param model the model
	 */
	public StringBindingListener(Model<String> model)
	{
		Check.get().notNull(model, "model");
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUpdate(DocumentEvent event)
	{
		update(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeUpdate(DocumentEvent event)
	{
		update(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changedUpdate(DocumentEvent event)
	{
		update(event);
	}

	/**
	 * Update the underlying model object.
	 *
	 * @param event the event
	 */
	protected void update(DocumentEvent event)
	{
		String text;
		try
		{
			text = event.getDocument().getText(event.getDocument().getStartPosition().getOffset(),
				event.getDocument().getEndPosition().getOffset() - 1);
			model.setObject(text);
		}
		catch (BadLocationException e1)
		{
			log.error("some portion of the given range was not a valid part of the document. "
				+ "The location in the exception is the first bad position encountered.", e1);
			e1.printStackTrace();
		}
	}

}
