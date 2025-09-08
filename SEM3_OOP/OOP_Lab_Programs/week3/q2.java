import java.util.Scanner;

class BankAccount{
	private String accountNumber;
	private double balance;
	public static void details(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your account number: ");
		String accountNumber = sc.nextLine();

		System.out.println("Account created with balance $0.00");
		double balance =  0.0;

		System.out.print("Enter deposit amount: ");
		double deposit = sc.nextDouble();
		System.out.println("Deposit Successful.");
		balance += deposit;
		System.out.println("Account: " + accountNumber+ ", Balance : " + balance);

		System.out.print("Enter witdrawl amount: ");
		double withdraw = sc.nextDouble();

		if (withdraw <= balance){
			System.out.println("Withdrawl Successful.");
			balance = (balance-withdraw);
		}
		else {
			System.out.println("Insufficient balance.");
		}
		
		System.out.println("Account: "+accountNumber+", Balance: "+balance);
		
		System.out.print("Enter withdrawl amount: ");
		withdraw = sc.nextDouble();

		if (withdraw <= balance){
			System.out.println("Withdrawl Successful.");
			balance = (balance-withdraw);
		}
		
		else {
			System.out.println("Insufficient balance.");
		}

		System.out.println("Account: "+accountNumber+", Balance: "+ balance);

		sc.close();


	}
}
public class q2{
	public static void main(String args[]){
		BankAccount.details();
}
}
