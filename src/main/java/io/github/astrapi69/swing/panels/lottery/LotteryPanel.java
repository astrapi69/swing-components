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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import javax.swing.*;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.Model;
import io.github.astrapi69.swing.base.BasePanel;

public class LotteryPanel extends BasePanel<LotteryBox> implements ActionListener
{

	LinkedHashMap<Integer, JCheckBox> lotteryBoxes;

	public LotteryPanel()
	{
		this(BaseModel.of(LotteryBox.builder().selectedNumbers(new LinkedHashSet<>()).build()));
	}

	public LotteryPanel(Model<LotteryBox> model)
	{
		super(model);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		LinkedHashSet<Integer> selectedNumbers = getModelObject().getSelectedNumbers();

		JCheckBox source = (JCheckBox)e.getSource();
		boolean selected = source.isSelected();
		StringIcon icon = (StringIcon)source.getIcon();
		Integer selectedNumber = Integer.valueOf(icon.getText().trim());
		if (selected)
		{
			selectedNumbers.add(selectedNumber);
		}
		else
		{
			selectedNumbers.remove(selectedNumber);
		}

		if (selectedNumbers.size() == getModelObject().getMaxNumbers())
		{
			lotteryBoxes.entrySet().stream()
				.filter(entry -> !selectedNumbers.contains(entry.getKey())).map(Map.Entry::getValue)
				.forEach(cb -> cb.setEnabled(false));
			revalidate();
		}
		else
		{
			lotteryBoxes.values().forEach(cb -> {
				if (!cb.isEnabled())
				{
					cb.setEnabled(true);
				}
			});
		}

	}


	@Override
	protected void onInitializeComponents()
	{
		lotteryBoxes = new LinkedHashMap<>();
		for (int i = getModelObject().getMinVolume(); i <= getModelObject()
			.getMaxVolume(); i += getModelObject().getStep())
		{
			StringIcon icon = new StringIcon(this, Integer.valueOf(i).toString());
			JCheckBox checkBox = new JCheckBox(icon);
			checkBox.addActionListener(this);
			checkBox.setBorderPainted(true);
			lotteryBoxes.put(i, checkBox);
			add(checkBox);
		}
	}

	@Override
	protected void onInitializeLayout()
	{
		setLayout(new GridLayout(getModelObject().getRows(), getModelObject().getColumns()));
	}
}