package de.alpharogroup.swing.wizard;

import de.alpharogroup.design.pattern.state.wizard.WizardState;
import de.alpharogroup.design.pattern.state.wizard.WizardStateMachine;

/**
 * The enum {@link CustomState} represents three wizard states and the cancel with the finish states.
 */
public enum CustomState implements WizardState<WizardStateMachine>
{

	/** The first {@link CustomState} object. */
	FIRST {

		@Override
		public void cancel(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.CANCELED);
		}

		@Override
		public void finish(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.FINISHED);
		}

		@Override
		public void goNext(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.SECOND);
		}

		@Override
		public void goPrevious(final WizardStateMachine input)
		{
		}

		@Override
		public String getName()
		{
			return name();
		}

		@Override
		public boolean hasPrevious()
		{
			return false;
		}

		@Override
		public boolean isFirst()
		{
			return true;
		}

	},

	/** The second {@link CustomState} object. */
	SECOND {

		@Override
		public void cancel(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.CANCELED);
		}

		@Override
		public void finish(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.FINISHED);
		}

		@Override
		public void goNext(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.THIRD);
		}

		@Override
		public void goPrevious(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.FIRST);
		}

		@Override
		public String getName()
		{
			return name();
		}

	},

	/** The third {@link CustomState} object. */
	THIRD {

		@Override
		public void cancel(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.CANCELED);
		}

		@Override
		public void finish(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.FINISHED);
		}

		@Override
		public void goNext(final WizardStateMachine stateMachine)
		{
		}

		@Override
		public void goPrevious(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(SECOND);
		}

		@Override
		public String getName()
		{
			return name();
		}

		@Override
		public boolean hasNext()
		{
			return false;
		}

		@Override
		public boolean isLast()
		{
			return true;
		}

	},

	/** The cancel {@link CustomState} object. */
	CANCELED {


		@Override
		public void cancel(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.CANCELED);
		}

		@Override
		public void finish(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.FINISHED);
		}

		@Override
		public void goNext(final WizardStateMachine stateMachine)
		{
		}

		@Override
		public void goPrevious(final WizardStateMachine stateMachine)
		{
		}

		@Override
		public String getName()
		{
			return name();
		}

	},

	/** The finish {@link CustomState} object. */
	FINISHED {

		@Override
		public void cancel(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.CANCELED);
		}

		@Override
		public void finish(final WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(CustomState.FINISHED);
		}

		@Override
		public void goNext(final WizardStateMachine stateMachine)
		{
		}

		@Override
		public void goPrevious(final WizardStateMachine stateMachine)
		{
		}

		@Override
		public String getName()
		{
			return name();
		}

	};
}
