import java.io.*;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            FileOutputStream fos = new FileOutputStream("studentout1.dat", true); 
            System.out.println("Enter 3 more lines to append:");
            for (int i = 0; i < 3; i++) {
                String line = sc.nextLine();
                fos.write((line + "\n").getBytes());
            }
            fos.close();
            System.out.println("Lines appended successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
