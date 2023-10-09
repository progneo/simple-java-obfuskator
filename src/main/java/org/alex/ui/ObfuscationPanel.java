package org.alex.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class ObfuscationPanel extends JPanel {

  public static JCheckBox AccessCodeCheckBox;
  public static JCheckBox flowObfuscationCheckBox;
  public static JCheckBox NumberObfuscationCheckBox;
  public static JCheckBox BooleansCheckBox;

  public ObfuscationPanel() {
    setBackground(Color.WHITE);
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] {0, 0};
    gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
    gridBagLayout.columnWeights = new double[] {0.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    setLayout(gridBagLayout);

    AccessCodeCheckBox = new JCheckBox("Block Access to Code");
    AccessCodeCheckBox.setBackground(Color.WHITE);
    GridBagConstraints gbc_AccessCodeCheckBox = new GridBagConstraints();
    gbc_AccessCodeCheckBox.anchor = GridBagConstraints.WEST;
    gbc_AccessCodeCheckBox.insets = new Insets(0, 0, 5, 0);
    gbc_AccessCodeCheckBox.gridx = 0;
    gbc_AccessCodeCheckBox.gridy = 1;
    add(AccessCodeCheckBox, gbc_AccessCodeCheckBox);

    flowObfuscationCheckBox = new JCheckBox("Add Random Constructions Obfuscation");
    flowObfuscationCheckBox.setBackground(Color.WHITE);
    GridBagConstraints gbc_flowObfuscationCheckBox = new GridBagConstraints();
    gbc_flowObfuscationCheckBox.anchor = GridBagConstraints.WEST;
    gbc_flowObfuscationCheckBox.insets = new Insets(0, 0, 5, 0);
    gbc_flowObfuscationCheckBox.gridx = 0;
    gbc_flowObfuscationCheckBox.gridy = 2;
    add(flowObfuscationCheckBox, gbc_flowObfuscationCheckBox);

    NumberObfuscationCheckBox = new JCheckBox("Number Obfuscation");
    NumberObfuscationCheckBox.setBackground(Color.WHITE);
    GridBagConstraints gbc_NumberObfuscationCheckBox = new GridBagConstraints();
    gbc_NumberObfuscationCheckBox.insets = new Insets(0, 0, 5, 0);
    gbc_NumberObfuscationCheckBox.anchor = GridBagConstraints.WEST;
    gbc_NumberObfuscationCheckBox.gridx = 0;
    gbc_NumberObfuscationCheckBox.gridy = 3;
    add(NumberObfuscationCheckBox, gbc_NumberObfuscationCheckBox);

    BooleansCheckBox = new JCheckBox("Booleans");
    BooleansCheckBox.setBackground(Color.WHITE);
    GridBagConstraints gbc_BooleansCheckBox = new GridBagConstraints();
    gbc_BooleansCheckBox.anchor = GridBagConstraints.WEST;
    gbc_BooleansCheckBox.gridx = 0;
    gbc_BooleansCheckBox.gridy = 4;
    add(BooleansCheckBox, gbc_BooleansCheckBox);
  }
}
