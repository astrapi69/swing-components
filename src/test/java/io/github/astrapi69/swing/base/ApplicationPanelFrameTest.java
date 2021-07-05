package io.github.astrapi69.swing.base;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.panels.lottery.LotteryBox;
import io.github.astrapi69.swing.panels.lottery.LotteryPanel;
import io.github.astrapi69.window.adapter.CloseWindow;

import java.util.LinkedHashSet;

public class ApplicationPanelFrameTest
	extends
	ApplicationPanelFrame<LotteryBox>
{
	/**
	 * Instantiates a new {@link ApplicationPanelFrame}
	 *
	 * @param title the title
	 */
	public ApplicationPanelFrameTest(String title)
	{
		super(title);
	}

	/**
	 * Test init layout.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		final ApplicationPanelFrameTest frame = new ApplicationPanelFrameTest("ApplicationPanelFrameTest");
		frame.addWindowListener(new CloseWindow());
		frame.pack();
		frame.setVisible(true);
	}

	@Override protected String newIconPath()
	{
		return "img/xmas/bell.png";
	}

	@Override protected BasePanel<LotteryBox> newMainComponent()
	{
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
		return panel;
	}
}
