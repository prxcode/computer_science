import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HobbyGenderSelector {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("User Selection Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use GridLayout to keep everything in order (rows x columns)
        frame.setLayout(new GridLayout(0, 1));

        // ------------------ HOBBIES SECTION ------------------

        // Label for hobbies
        JLabel hobbiesLabel = new JLabel("Choose your hobbies:");
        frame.add(hobbiesLabel);

        // Create checkboxes
        JCheckBox readingCheck = new JCheckBox("Reading");
        JCheckBox gamingCheck = new JCheckBox("Gaming");
        JCheckBox musicCheck = new JCheckBox("Music");

        // Add checkboxes to the frame
        frame.add(readingCheck);
        frame.add(gamingCheck);
        frame.add(musicCheck);

        // ------------------ GENDER SECTION ------------------

        JLabel genderLabel = new JLabel("Choose your gender:");
        frame.add(genderLabel);

        // Create radio buttons
        JRadioButton maleRadio = new JRadioButton("Male");
        JRadioButton femaleRadio = new JRadioButton("Female");

        // Group radio buttons so only one can be selected
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // Add radio buttons to the frame
        frame.add(maleRadio);
        frame.add(femaleRadio);

        // ------------------ BUTTON SECTION ------------------

        JButton showButton = new JButton("Show Selection");
        frame.add(showButton);

        // Add event listener for button click
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Build hobby list
                String hobbies = "";
                if (readingCheck.isSelected()) hobbies += "Reading ";
                if (gamingCheck.isSelected()) hobbies += "Gaming ";
                if (musicCheck.isSelected()) hobbies += "Music ";
                if (hobbies.isEmpty()) hobbies = "None";

                // Determine selected gender
                String gender = "Not selected";
                if (maleRadio.isSelected()) gender = "Male";
                if (femaleRadio.isSelected()) gender = "Female";

                // Show dialog message
                JOptionPane.showMessageDialog(
                        frame,
                        "Hobbies: " + hobbies + "\nGender: " + gender,
                        "Your Selection",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // Make the window visible
        frame.setVisible(true);
    }
}
