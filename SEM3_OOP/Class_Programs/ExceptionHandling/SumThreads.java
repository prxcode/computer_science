class EvenSumThread extends Thread {
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("Sum of even numbers: " + sum);
    }
}

class OddSumThread extends Thread {
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println("Sum of odd numbers: " + sum);
    }
}

public class SumThreads {
    public static void main(String[] args) {
        EvenSumThread t1 = new EvenSumThread();
        OddSumThread t2 = new OddSumThread();
        t1.start();
        t2.start();
    }
}
