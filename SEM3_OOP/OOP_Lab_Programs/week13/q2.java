import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class q2 {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("User Selection Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        frame.setLayout(new GridLayout(0, 1));

        JLabel hobbiesLabel = new JLabel("Choose your hobbies:");
        frame.add(hobbiesLabel);

        JCheckBox readingCheck = new JCheckBox("Reading");
        JCheckBox gamingCheck = new JCheckBox("Gaming");
        JCheckBox musicCheck = new JCheckBox("Music");

        
        frame.add(readingCheck);
        frame.add(gamingCheck);
        frame.add(musicCheck);

        
        JLabel genderLabel = new JLabel("Choose your gender:");
        frame.add(genderLabel);

        JRadioButton maleRadio = new JRadioButton("Male");
        JRadioButton femaleRadio = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        
        frame.add(maleRadio);
        frame.add(femaleRadio);
        JButton showButton = new JButton("Show Selection");
        frame.add(showButton);


        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                String hobbies = "";
                if (readingCheck.isSelected()) hobbies += "Reading ";
                if (gamingCheck.isSelected()) hobbies += "Gaming ";
                if (musicCheck.isSelected()) hobbies += "Music ";
                if (hobbies.isEmpty()) hobbies = "None";

          
                String gender = "Not selected";
                if (maleRadio.isSelected()) gender = "Male";
                if (femaleRadio.isSelected()) gender = "Female";

                
                JOptionPane.showMessageDialog(
                        frame,
                        "Hobbies: " + hobbies + "\nGender: " + gender,
                        "Your Selection",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        frame.setVisible(true);
    }
}
