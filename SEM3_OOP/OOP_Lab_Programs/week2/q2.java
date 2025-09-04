import java.util.Scanner;

public class q2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your first num: ");
		int num1 = sc.nextInt();
		
		Scanner tw = new Scanner(System.in);
		System.out.print("Enter your second num: ");
		int num2 = tw.nextInt();

		Scanner th = new Scanner(System.in);
		System.out.print("Enter operator: ");
		String op = th.nextLine();

		switch(op) {
			case "+":
			System.out.println("Result: " + (num1+num2));
			break;
			case "-":
			System.out.println("Result: "+ (num1-num2));
			break;
			case "*":
			System.out.println("Result: "+ (num1*num2));
			break;
			case "/":
			System.out.println("Result: "+ (num1/num2));
			break;
			
			case "%":
			System.out.println("Result: "+ (num1%num2));
			default:
			System.out.println("Invalid Input!");
			break;
		}


	}
}
