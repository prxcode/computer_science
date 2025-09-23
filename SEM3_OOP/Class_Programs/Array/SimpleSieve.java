import java.util.Scanner;

public class SimpleSieve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int n = sc.nextInt();

        int[] prime = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            prime[i] = 1;
        }

        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }

        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (prime[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }
}
