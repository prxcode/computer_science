import java.io.*;

public class P2 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("studentout1.dat");
            int ch;
            System.out.println("Content of studentout1.dat:");
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
