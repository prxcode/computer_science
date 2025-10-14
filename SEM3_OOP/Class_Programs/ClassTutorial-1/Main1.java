public class Meeting {
    // Private fields
    private String time;
    private String location;
    private String subject;

    // Constructor
    public Meeting(String time, String location, String subject) {
        this.time = time;
        this.location = location;
        this.subject = subject;
    }

    // Getter for subject
    public String getSubject() {
        return subject;
    }

    // Method to print meeting details
    public void printDetails() {
        System.out.println("Meeting in " + location + ", " + time);
    }
}
public class Main1 {
    public static void main(String[] args) {
        // Create a Meeting object
        Meeting meeting1 = new Meeting("12:30", "Room 205", "Examiners Meeting");

        // Get and print the subject
        System.out.println("Subject: " + meeting1.getSubject());

        // Print all meeting details
        meeting1.printDetails();
    }
}
