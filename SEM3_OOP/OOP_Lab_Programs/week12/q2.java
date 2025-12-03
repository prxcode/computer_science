class MorningThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.print("Good Morning ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

class EveningThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.print("Good Evening ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        MorningThread m = new MorningThread();
        EveningThread e = new EveningThread();

        m.start();
        e.start();
    }
}

