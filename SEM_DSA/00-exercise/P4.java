import java.io.*;

public class P4 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("studentout1.dat");
            FileOutputStream fos = new FileOutputStream("studentout2.dat");

            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }

            fis.close();
            fos.close();
            System.out.println("Content copied to studentout2.dat successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
