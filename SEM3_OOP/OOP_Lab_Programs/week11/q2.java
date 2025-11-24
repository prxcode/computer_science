import java.io.IOException;

class FileReaderUtility {

    public static void readFile(String fileName) throws IOException {

        if (fileName.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be empty.");
        }

        if (fileName.equals("missing.txt")) {
            throw new IOException("File not found.");
        }

        System.out.println("Reading file: " + fileName);
    }
}

public class q2 {
    public static void main(String[] args) {

        String[] files = {"data.txt", "", "missing.txt"};

        for (String file : files) {
            try {
                FileReaderUtility.readFile(file);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                // finally block required by your instructions 
                // but no output is needed from it
            }
        }
    }
}
