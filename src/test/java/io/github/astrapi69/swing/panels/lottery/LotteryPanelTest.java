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
package io.github.astrapi69.swing.panels.lottery;

import java.awt.Frame;
import java.util.LinkedHashSet;

import io.github.astrapi69.layout.CloseWindow;
import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;

public class LotteryPanelTest
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{

		final Frame frame = new Frame();
		frame.addWindowListener(new CloseWindow());
		frame.setTitle("Lottery Panel");
		Model<LotteryBox> lotteryModel;

		lotteryModel = BaseModel.of(
			LotteryBox.builder().selectedNumbers(new LinkedHashSet<>()).minVolume(1).maxVolume(49)
				// .step(1)
				.rows(7).columns(7).build());

		// lotteryModel = BaseModel.of(LotteryBox.builder().selectedNumbers(new LinkedHashSet<>())
		// .minVolume(2)
		// .maxVolume(98)
		// .step(2)
		// .rows(7)
		// .columns(7)
		// .build());

		// lotteryModel = BaseModel.of(LotteryBox.builder().selectedNumbers(new LinkedHashSet<>())
		// .minVolume(2)
		// .maxVolume(72)
		// .step(2)
		// .rows(6)
		// .columns(6)
		// .build());

		final LotteryPanel panel = new LotteryPanel(lotteryModel);

		frame.add(panel);
		frame.pack();
		frame.setSize(500, 300);
		frame.setVisible(true);
	}

}
