package org.alex.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class SettingsPanel extends JPanel {
  public static JTextField namesLengthField;

  public SettingsPanel() {
    setBackground(Color.WHITE);
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] {0, 0};
    gridBagLayout.rowHeights = new int[] {140, 98, 0};
    gridBagLayout.columnWeights = new double[] {1.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[] {0.0, 0.0, Double.MIN_VALUE};
    setLayout(gridBagLayout);

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
