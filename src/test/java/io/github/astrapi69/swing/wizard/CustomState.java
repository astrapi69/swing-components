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
package io.github.astrapi69.swing.wizard;

import de.alpharogroup.design.pattern.state.wizard.WizardState;
import de.alpharogroup.design.pattern.state.wizard.WizardStateMachine;

/**
 * The enum {@link CustomState} represents three wizard states and the cancel with the finish
 * states.
 */
public enum CustomState implements WizardState<WizardStateMachine>
{

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
		public String getName()
		{
			return name();
		}

		@Override
		public void goNext(final WizardStateMachine stateMachine)
		{
		}

		@Override
		public void goPrevious(final WizardStateMachine stateMachine)
		{
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
		public String getName()
		{
			return name();
		}

		@Override
		public void goNext(final WizardStateMachine stateMachine)
		{
		}

		@Override
		public void goPrevious(final WizardStateMachine stateMachine)
		{
		}

	},

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
		public String getName()
		{
			return name();
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
		public String getName()
		{
			return name();
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
		public String getName()
		{
			return name();
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
		public boolean hasNext()
		{
			return false;
		}

		@Override
		public boolean isLast()
		{
			return true;
		}

	};
}
