import java.util.Scanner;

class Student {
	static void Details(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = sc.nextLine();

		System.out.print("Enter score for exam 1: ");
		float e1 = sc.nextInt();
	
		System.out.print("Enter score for exam 2: ");
		float e2 = sc.nextInt();
		
		System.out.print("Enter score for exam 3: ");
		float e3 = sc.nextInt();
	
		float finalmean = ((e1+e2+e3)/3);
		System.out.println("Student: "+ name);
		System.out.println("Average score: "+ finalmean);

	}
}

public class q1{
	public static void main(String args[]){
		Student.Details();
	}
}
