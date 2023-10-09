package org.alex.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ObfuscationPanel extends JPanel {

  public static JCheckBox AccessCodeCheckBox;
  public static JCheckBox flowObfuscationCheckBox;
  public static JCheckBox BooleansCheckBox;
  public static JTextField namesLengthField;

  public ObfuscationPanel() {
    setBackground(Color.WHITE);
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] {0, 0};
    gridBagLayout.rowHeights = new int[] {70, 70, 0};
    gridBagLayout.columnWeights = new double[] {1.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[] {0.0, 0.0, Double.MIN_VALUE};
    setLayout(gridBagLayout);

    JPanel modifiersPanel = new JPanel();
    modifiersPanel.setBackground(Color.WHITE);
    modifiersPanel.setBorder(
        new TitledBorder(
            UIManager.getBorder("TitledBorder.border"),
            "Modifiers",
            TitledBorder.LEADING,
            TitledBorder.TOP,
            null,
            new Color(0, 0, 0)));

    GridBagConstraints gbc_ModifiersPanel = new GridBagConstraints();
    gbc_ModifiersPanel.insets = new Insets(0, 0, 5, 0);
    gbc_ModifiersPanel.fill = GridBagConstraints.BOTH;
    gbc_ModifiersPanel.gridx = 0;
    gbc_ModifiersPanel.gridy = 0;
    add(modifiersPanel, gbc_ModifiersPanel);
    GridBagLayout gbl_ModifiersPanel = new GridBagLayout();
    gbl_ModifiersPanel.columnWidths = new int[] {0, 0, 0};
    gbl_ModifiersPanel.rowHeights = new int[] {0, 0};
    gbl_ModifiersPanel.columnWeights = new double[] {0.0, 1.0, Double.MIN_VALUE};
    gbl_ModifiersPanel.rowWeights = new double[] {0.0, Double.MIN_VALUE};
    modifiersPanel.setLayout(gbl_ModifiersPanel);

    AccessCodeCheckBox = new JCheckBox("Block Access to Code");
    AccessCodeCheckBox.setBackground(Color.WHITE);
    GridBagConstraints gbc_AccessCodeCheckBox = new GridBagConstraints();
    gbc_AccessCodeCheckBox.anchor = GridBagConstraints.WEST;
    gbc_AccessCodeCheckBox.insets = new Insets(0, 0, 5, 0);
    gbc_AccessCodeCheckBox.gridx = 0;
    gbc_AccessCodeCheckBox.gridy = 0;
    modifiersPanel.add(AccessCodeCheckBox, gbc_AccessCodeCheckBox);

    flowObfuscationCheckBox = new JCheckBox("Add Random Constructions");
    flowObfuscationCheckBox.setBackground(Color.WHITE);
    GridBagConstraints gbc_flowObfuscationCheckBox = new GridBagConstraints();
    gbc_flowObfuscationCheckBox.anchor = GridBagConstraints.WEST;
    gbc_flowObfuscationCheckBox.insets = new Insets(0, 0, 5, 0);
    gbc_flowObfuscationCheckBox.gridx = 0;
    gbc_flowObfuscationCheckBox.gridy = 1;
    modifiersPanel.add(flowObfuscationCheckBox, gbc_flowObfuscationCheckBox);

    BooleansCheckBox = new JCheckBox("Hide Boolean Names");
    BooleansCheckBox.setBackground(Color.WHITE);
    GridBagConstraints gbc_BooleansCheckBox = new GridBagConstraints();
    gbc_BooleansCheckBox.anchor = GridBagConstraints.WEST;
    gbc_BooleansCheckBox.gridx = 0;
    gbc_BooleansCheckBox.gridy = 2;
    modifiersPanel.add(BooleansCheckBox, gbc_BooleansCheckBox);

    JPanel namesPanel = new JPanel();
    namesPanel.setBackground(Color.WHITE);
    namesPanel.setBorder(
        new TitledBorder(
            UIManager.getBorder("TitledBorder.border"),
            "Names",
            TitledBorder.LEADING,
            TitledBorder.TOP,
            null,
            new Color(0, 0, 0)));

    GridBagConstraints gbc_NamesPanel = new GridBagConstraints();
    gbc_NamesPanel.fill = GridBagConstraints.BOTH;
    gbc_NamesPanel.gridx = 0;
    gbc_NamesPanel.gridy = 1;
    add(namesPanel, gbc_NamesPanel);
    GridBagLayout gbl_NamesPanel = new GridBagLayout();
    gbl_NamesPanel.columnWidths = new int[] {0, 0, 0};
    gbl_NamesPanel.rowHeights = new int[] {0, 0};
    gbl_NamesPanel.columnWeights = new double[] {0.0, 1.0, Double.MIN_VALUE};
    gbl_NamesPanel.rowWeights = new double[] {0.0, Double.MIN_VALUE};
    namesPanel.setLayout(gbl_NamesPanel);

    JLabel lblNewLabel = new JLabel("Length:");
    GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
    gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
    gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
    gbc_lblNewLabel.gridx = 0;
    gbc_lblNewLabel.gridy = 0;
    namesPanel.add(lblNewLabel, gbc_lblNewLabel);

    namesLengthField = new JTextField();
    namesLengthField.setText("5");
    GridBagConstraints gbc_namesLengthField = new GridBagConstraints();
    gbc_namesLengthField.fill = GridBagConstraints.HORIZONTAL;
    gbc_namesLengthField.gridx = 1;
    gbc_namesLengthField.gridy = 0;
    namesPanel.add(namesLengthField, gbc_namesLengthField);
    namesLengthField.setColumns(10);
  }
}
