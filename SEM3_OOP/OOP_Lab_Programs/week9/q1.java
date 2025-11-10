import java.util.*;

class Staff {
	String name;
	String staffid;

	public  Staff(String name, String staffid) {
		this.name = name;
		this.staffid = staffid;
	}

	public void displayDetails() {
		System.out.println("Name: " + name + "\nStaff ID: " + staffid);
	}
}

class TeachingStaff extends Staff {
	String subject;
	int YOE;

	public TeachingStaff(String name, String staffid, String subject, int YOE) {
		super(name,staffid);
		this.subject = subject;
        	this.YOE = YOE;
	}

	public void showTeachingInfo() {
		super.displayDetails();
		System.out.println("Subject: " + subject + "\nYears of Experience: " + YOE + " years");
	}
}

public class q1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter staff id: ");
                String staffid = sc.nextLine();
		System.out.print("Enter subject: ");
                String subject = sc.nextLine();
		System.out.print("Enter years of experience: ");
                int yoe = sc.nextInt();
		TeachingStaff staff = new TeachingStaff(name,staffid,subject,yoe);
		staff.showTeachingInfo();
	}
}
