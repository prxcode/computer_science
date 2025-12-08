import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame {
    private JTextField nameField, emailField;
    private JCheckBox javaCheck, pythonCheck, cppCheck;
    private JRadioButton onlineRadio, offlineRadio;
    private JComboBox<String> semesterCombo;
    private ButtonGroup courseTypeGroup;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name: ");
        nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel emailLabel = new JLabel("Email: ");
        emailField = new JTextField(20);
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);

        JPanel skillsPanel = new JPanel(new GridLayout(0, 1));
        skillsPanel.setBorder(BorderFactory.createTitledBorder("Skills"));
        javaCheck = new JCheckBox("Java");
        pythonCheck = new JCheckBox("Python");
        cppCheck = new JCheckBox("C++");
        skillsPanel.add(javaCheck);
        skillsPanel.add(pythonCheck);
        skillsPanel.add(cppCheck);

        JPanel coursePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        coursePanel.setBorder(BorderFactory.createTitledBorder("Course Type"));
        onlineRadio = new JRadioButton("Online");
        offlineRadio = new JRadioButton("Offline");
        courseTypeGroup = new ButtonGroup();
        courseTypeGroup.add(onlineRadio);
        courseTypeGroup.add(offlineRadio);
        coursePanel.add(onlineRadio);
        coursePanel.add(offlineRadio);

        JPanel semesterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel semesterLabel = new JLabel("Semester: ");
        String[] semesters = {"Fall", "Spring", "Summer"};
        semesterCombo = new JComboBox<>(semesters);
        semesterPanel.add(semesterLabel);
        semesterPanel.add(semesterCombo);

        JButton registerButton = new JButton("Register");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        registerButton.addActionListener(e -> showRegistrationInfo());

        add(namePanel);
        add(emailPanel);
        add(skillsPanel);
        add(coursePanel);
        add(semesterPanel);
        add(Box.createVerticalStrut(10));
        add(registerButton);
    }

    private void showRegistrationInfo() {
        String name = nameField.getText();
        String email = emailField.getText();

        StringBuilder skills = new StringBuilder();
        if (javaCheck.isSelected()) skills.append("Java ");
        if (pythonCheck.isSelected()) skills.append("Python ");
        if (cppCheck.isSelected()) skills.append("C++ ");
        if (skills.isEmpty()) skills.append("None");

        String courseType = onlineRadio.isSelected() ? "Online" :
                            offlineRadio.isSelected() ? "Offline" : "None";

        String semester = (String) semesterCombo.getSelectedItem();

        String message = "Name: " + name +
                         "\nEmail: " + email +
                         "\nSkills: " + skills +
                         "\nCourse Type: " + courseType +
                         "\nSemester: " + semester;

        JOptionPane.showMessageDialog(this, message, "Registration Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentRegistrationForm().setVisible(true);
        });
    }
}
