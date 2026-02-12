import java.io.*;

public class P5 {
    public static void main(String[] args) {
        int charCount = 0, wordCount = 0, lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("studentout2.dat"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Characters: " + charCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Lines: " + lineCount);
    }
}
