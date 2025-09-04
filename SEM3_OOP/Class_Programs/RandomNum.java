import java.util.Scanner;

class RandomNum{
    public static void main(String[] args) {
        int randomNum = (int) (Math.random() * 10);  // fixed Math.random() and removed 'System.out.print(' from variable declaration
        System.out.print(randomNum);                  // print the random number
    }
}
