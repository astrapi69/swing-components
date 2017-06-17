package de.alpharogroup.swing.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

import de.alpharogroup.check.Check;
import lombok.Getter;

/**
 * The class {@link OpenFileAction}.
 */
public abstract class OpenFileAction extends AbstractAction
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The parent component. */
	@Getter
	private final Component parent;

	/** The file chooser. */
	@Getter
	private JFileChooser fileChooser;

	/**
	 * Instantiates a new {@link OpenFileAction} object.
	 *
	 * @param name
	 *            the name
	 */
	public OpenFileAction(final String name, Component parent)
	{
		super(name);
		Check.get().notNull(parent, "parent");
		this.parent = parent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		fileChooser = new JFileChooser();
		onFileChoose(fileChooser, actionEvent);
	}

	/**
	 * Callback method to interact on file choose.
	 *
	 * @param fileChooser
	 *            the file chooser
	 * @param actionEvent
	 *            the action event
	 */
	protected void onFileChoose(JFileChooser fileChooser, ActionEvent actionEvent)
	{
		final int returnVal = fileChooser.showOpenDialog(parent);

		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			final File file = fileChooser.getSelectedFile();
			onApproveOption(file, actionEvent);
		}
		else
		{
			onCancel(actionEvent);
		}
	}

	/**
	 * Abstract callback method to interact on file choose approve option.
	 *
	 * @param file
	 *            the file
	 * @param actionEvent
	 *            the action event
	 */
	protected abstract void onApproveOption(File file, ActionEvent actionEvent);

	/**
	 * Abstract callback method to interact on cancel from file choose.
	 *
	 * @param actionEvent
	 *            the action event
	 */
	protected abstract void onCancel(ActionEvent actionEvent);

}