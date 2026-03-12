import java.io.*;

public class P6 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("file3.txt");
            
            try (FileInputStream fis1 = new FileInputStream("file1.txt")) {
                int ch;
                while ((ch = fis1.read()) != -1) {
                    fos.write(ch);
                }
            }

            try (FileInputStream fis2 = new FileInputStream("file2.txt")) {
                int ch;
                while ((ch = fis2.read()) != -1) {
                    fos.write(ch);
                }
            }

            fos.close();
            System.out.println("Contents of file1.txt and file2.txt merged into file3.txt");
