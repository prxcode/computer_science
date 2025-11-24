import java.util.Scanner;

class q1 {

    public Integer divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q1 calc = new q1();

        System.out.print("Numerator: ");
        int numerator = sc.nextInt();

        System.out.print("Denominator: ");
        int denominator = sc.nextInt();

        Integer result = calc.divide(numerator, denominator);

        if (result != null) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("Program continues safely.");
        }

        sc.close();
    }
}
