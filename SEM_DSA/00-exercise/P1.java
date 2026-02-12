import java.io.*;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            FileOutputStream fos = new FileOutputStream("studentout1.dat");
            String data = "Implementing data structures would be fun.";
            fos.write(data.getBytes());
            fos.close();
            System.out.println("Data written successfully to studentout1.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
