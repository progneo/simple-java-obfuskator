package org.alex;

import org.alex.ui.FilePanel;
import org.alex.ui.ObfuscationPanel;
import org.alex.utils.OutputUtil;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import static org.alex.ui.FilePanel.input;
import static org.alex.ui.FilePanel.output;
import static org.alex.ui.ObfuscationPanel.namesLengthField;
import static org.alex.utils.OutputUtil.modules;

public class MainGUI extends JFrame {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        () -> {
          try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            MainGUI frame = new MainGUI();
            frame.setVisible(true);
          } catch (Exception ignored) {
          }
        });
  }

  public MainGUI() {
    setTitle("Obfuscator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 881, 305);
    setLocationRelativeTo(null);
    JPanel contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));

    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setSize(881, 200);
    contentPane.add(tabbedPane, BorderLayout.NORTH);

    FilePanel file = new FilePanel();
    tabbedPane.addTab("File", file);

    ObfuscationPanel obf = new ObfuscationPanel();
    tabbedPane.addTab("Obfuscation", obf);

    JPanel buttonBar = new JPanel();
    buttonBar.setBackground(Color.WHITE);
    contentPane.add(buttonBar, BorderLayout.SOUTH);
    buttonBar.setLayout(new BorderLayout(0, 0));

    JPanel buttons = new JPanel();
    buttons.setBackground(Color.WHITE);
    buttonBar.add(buttons, BorderLayout.EAST);

    JButton obfuscateButton = getObfuscateButton();
    buttons.add(obfuscateButton);
  }

  private static JButton getObfuscateButton() {
    JButton obfuscateButton = new JButton("Obfuscate");
    obfuscateButton.setVerticalAlignment(SwingConstants.TOP);

    obfuscateButton.addActionListener(
        e -> {
          if (input() == null || input().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ZipStream is skipped");
          }
          if (modules().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select any modifiers");
            return;
          }
          if (namesLengthField.getText().isEmpty() || namesLengthField.getText() == null) {
            namesLengthField.setText("5");
          }
          OutputUtil.run(input(), output());
        });
    return obfuscateButton;
  }
}
