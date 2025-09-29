import java.util.Scanner;

class OddEven {
    public static void main(String[] args) {
        System.out.print("Enter num: ");
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        
        if (num % 2 == 0) {
            System.out.println("Number is even");
        }
        else {
            System.out.println("Number is odd");
        }
    }
}
