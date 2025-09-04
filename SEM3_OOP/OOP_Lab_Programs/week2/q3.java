import java.util.Scanner;

public class q3{
	public static void main (String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the start of range: ");
	int num1 = sc.nextInt();

	
	System.out.print("Enter the end of range: ");
	int num2 = sc.nextInt();
	
	Scanner tm = new Scanner(System.in);
	System.out.println("Enter even/odd: ");
	String type = tm.nextLine();
	
	switch(type){

	case "even":
		System.out.println("Even numbers from "+ num1 + " to "+ num2);
		for (int i= num1; i<=num2; i++){
			if ((i % 2) == 0){
				System.out.println(i);
			 }
		}
		break;

	case "odd":
		System.out.println("Odd numbers from "+ num1 + " to "+ num2);
 		for (int i=num1; i<num2; i++){
			if (i%2 != 0){
				System.out.println(i);
			}
		}
		break;


	}

	}
}
