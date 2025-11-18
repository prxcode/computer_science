class Example1 extends Exception {
    public Example1(String message) {
        super(message);
    }
}

public class Example1 {

    public static void checkIfOdd(int number) throws OddNumberException {
        if (number % 2 == 0) {
            throw new OddNumberException("The number " + number + " is even, but only odd numbers are allowed.");
        } else {
            System.out.println(number + " is an odd number.");
        }
    }

    public static void main(String[] args) {
        try {
            checkIfOdd(7); 
            checkIfOdd(10); 
        } catch (OddNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
