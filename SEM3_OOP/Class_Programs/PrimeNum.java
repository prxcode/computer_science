import java.util.Scanner;
// No need to import Math class 
public class PrimeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        System.out.print("Enter a number: ");
        int num = sc.nextInt(); 

        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is NOT a prime number.");
        }

        sc.close(); 
    }

    // Method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;      // 0 and 1 are not prime
        if (n == 2) return true;       // 2 is prime
        if (n % 2 == 0) return false;  // Even numbers > 2 are not prime

        // Check odd divisors only up to √n
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
