import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountrySelector extends JFrame {
    private JComboBox<String> countryComboBox;

    public CountrySelector() {
        setTitle("Country Selector");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(clearItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Choose a country:");
        String[] countries = {"USA", "Canada", "Germany", "Japan", "Australia"};
        countryComboBox = new JComboBox<>(countries);
        JButton showButton = new JButton("Show Country");

        mainPanel.add(label);
        mainPanel.add(countryComboBox);
        mainPanel.add(showButton);

        add(mainPanel, BorderLayout.CENTER);

        clearItem.addActionListener(e -> countryComboBox.setSelectedIndex(0));
        exitItem.addActionListener(e -> System.exit(0));
        showButton.addActionListener(e -> {
            String selectedCountry = (String) countryComboBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Selected Country: " + selectedCountry);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CountrySelector().setVisible(true);
        });
    }
}
