import java.io.IOException;
import java.util.Scanner;

class FileReaderUtility {

    // Method declares it may throw IOException
    public void readFile(String fileName) throws IOException {
        // Check if filename is empty and throw IllegalArgumentException
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be empty.");
        }

        // Simulate file reading
        if (fileName.equals("missing.txt")) {
            // Manually throw IOException
            throw new IOException("File not found.");
        }

        // Simulate successful file reading
        System.out.println("Reading file: " + fileName);
    }
}

public class Main {
    public static void main(String[] args) {
        FileReaderUtility fileReader = new FileReaderUtility();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter filenames separated by commas (e.g., data.txt,,missing.txt):");
        String input = scanner.nextLine();

        // Split the input by commas and trim whitespace
        String[] files = input.split(",");

        for (String fileName : files) {
            fileName = fileName.trim(); // remove extra spaces
            try {
                fileReader.readFile(fileName);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
