import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class q1 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("User Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField(15);
        JButton submitButton = new JButton("Submit");


        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (!name.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Welcome " + name + "!",
                            "Greeting",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter a name.",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
