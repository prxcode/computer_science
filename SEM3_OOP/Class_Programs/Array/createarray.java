// Accessor = Getter
// Setter = Mutator
// Public > Protected > Default > Private 

public class createarray {
    public static void main(String[] args) {
        int[] anArray; // Declare the array

        // Allocating space for array
        anArray = new int[10];

        // Adding values into array
        anArray[0] = 0;
        anArray[1] = 100;
        anArray[2] = 200;
        anArray[3] = 300;
        anArray[4] = 400;
        anArray[5] = 500;

        // Optional: Print the values
        for (int i = 0; i < 6; i++) {
            System.out.println("Element at index " + i + ": " + anArray[i]);
        }
    }
}
