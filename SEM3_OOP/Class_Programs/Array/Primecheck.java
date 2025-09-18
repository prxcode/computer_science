import java.util.ArrayList;

public class PrimeCheck {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }

        // Use ArrayList to store primes
        ArrayList<Integer> primeList = new ArrayList<>();

        for (int num : numbers) {
            if (isPrime(num)) {
                primeList.add(num);
            }
        }

        // Convert ArrayList to final array
        final int[] primes = new int[primeList.size()];
        for (int i = 0; i < primeList.size(); i++) {
            primes[i] = primeList.get(i);
        }

        // Print the final array of prime numbers
        System.out.print("Prime numbers: ");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
