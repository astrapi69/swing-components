package de.alpharogroup.swing.wizard.model;

import de.alpharogroup.swing.wizard.NavigationPanel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * The enum {@link NavigationState} holds several navigation states that can occur. Can be used for
 * validate and set the {@link NavigationPanel}.
 */
@Getter
@ToString
@AllArgsConstructor
public enum NavigationState
{
	RESET(false, false, false, false), CANCEL(false, false, true, false), CANCEL_FINISH(false,
		false, true, true), NEXT_CANCEL_FINISH(false, true, true,
			true), PREVIOUS_NEXT_CANCEL_FINISH(true, true, true, true);


	/** The flag that signals if next is valid or not. */
	private final boolean validNext;

	/** The flag that signals if previous is valid or not. */
	private final boolean validPrevious;

	/** The flag that signals if cancel is valid or not. */
	private final boolean validCancel;

	/** The flag that signals if finish is valid or not. */
	private final boolean validFinish;

}