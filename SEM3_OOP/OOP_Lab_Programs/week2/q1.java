import java.util.Scanner;

public class q1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = sc.nextLine();

		Scanner tm = new Scanner(System.in);
		System.out.print("Enter current hour: ");
		int time = tm.nextInt();
	

		if ((5<= time) && (time <= 11)){
		System.out.println("Good morning " + name);
		}
		
		else if ((12<= time) && (time <= 17)){
		System.out.println("Good Afternoon " + name);
		}

		else if ((18<= time) && (time <= 21)){
		System.out.println("Good Evening "+ name);
		}
	
		else if ((22<= time) || (time <= 4)){
		System.out.println("Good Night "+ name);
		}
		tm.close();
		sc.close();
	}
}
