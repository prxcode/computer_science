import java.util.Scanner;

public class LargestCheck {
  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter num1: ");
      int n1 = sc.nextInt();

      System.out.print("Enter num2: ");
      int n2 = sc.nextInt();

      System.out.print("Enter num3: ");
      int n3 = sc.nextInt();

      int largest = n1;
      if (n2>largest){
          largest = n2;
      }
      if (n3>largest){
        largest = n3;
      }
    System.out.println("Largest Number: " + largest);
  }
}
        
    
