package de.alpharogroup.swing.wizard;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import de.alpharogroup.design.pattern.state.WizardStep;

public class WizardContentPanel extends JPanel
{
  public WizardContentPanel()
  {
    setLayout(new CardLayout());
    setBorder(new LineBorder(Color.BLACK));

    add(new FirstStepPanel(), WizardStep.FIRST.getName());
    add(new SecondStepPanel(), WizardStep.SECOND.getName());
    add(new ThirdStepPanel(), WizardStep.THIRD.getName());
  }
}