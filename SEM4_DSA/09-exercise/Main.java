import java.util.Scanner; 
 
public class Main { 
    static final int MAX_SIZE = 7; 
    static final String EMPTY = "EMPTY"; 
    static final String DELETED = "DELETED"; 
 
    static int computeHash(String s) { 
        int sumAlpha = 0, sumDigit = 0, sumSymbol = 0; 
        for (char c : s.toCharArray()) { 
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) sumAlpha += (int) c; 
            else if (c >= '0' && c <= '9') sumDigit += (int) c; 
            else sumSymbol += (int) c; 
        } 
        return (sumAlpha + 3 * sumDigit + 5 * sumSymbol + 7) % MAX_SIZE; 
    } 
 
    static void display(String[] table) { 
        System.out.println("--- Full Hash Table ---"); 
        for (int i = 0; i < MAX_SIZE; i++) { 
            System.out.println(i + ": " + table[i]); 
        } 
    } 
 
    static void linearAdd(String[] table, String key) { 
        int hash = computeHash(key); 
        for (int i = 0; i < MAX_SIZE; i++) { 
            int idx = (hash + i) % MAX_SIZE; 
            if (table[idx].equals(EMPTY) || table[idx].equals(DELETED)) { 
                table[idx] = key; 
                System.out.println("Key " + key + " added at index " + idx); 
                display(table); 
                return; 
            } 
        } 
        System.out.println("Hash table is full!"); 
    } 
 
    static void linearSearch(String[] table, String key) { 
        int hash = computeHash(key); 
        for (int i = 0; i < MAX_SIZE; i++) { 
            int idx = (hash + i) % MAX_SIZE; 
            if (table[idx].equals(EMPTY)) break; 
            if (table[idx].equals(key)) { 
                System.out.println("Key found!!"); 
                return; 
            } 
        } 
        System.out.println("Key not Found!!"); 
    } 
 
    static void linearDelete(String[] table, String key) { 
        int hash = computeHash(key); 
        for (int i = 0; i < MAX_SIZE; i++) { 
            int idx = (hash + i) % MAX_SIZE; 
            if (table[idx].equals(EMPTY)) break; 
            if (table[idx].equals(key)) { 
                table[idx] = DELETED; 
                System.out.println("Deleted " + key); 
                display(table); 
                return; 
            } 
        } 
        System.out.println("Key not Found!!"); 
    } 
 
    static void quadraticAdd(String[] table, String key) { 
        int hash = computeHash(key); 
        for (int i = 0; i < MAX_SIZE; i++) { 
            int idx = (hash + (i * i)) % MAX_SIZE; 
            if (table[idx].equals(EMPTY) || table[idx].equals(DELETED)) { 
                table[idx] = key; 
                System.out.println("Key " + key + " added at index " + idx); 
                display(table); 
                return; 
            } else { 
                System.out.println("Collision detected @index " + idx + " for key:" + key + ", Occupied by: " + 
table[idx]); 
            } 
        } 
        System.out.println("Hash table is full!"); 
    } 
 
    static void quadraticSearch(String[] table, String key) { 
        int hash = computeHash(key); 
        for (int i = 0; i < MAX_SIZE; i++) { 
            int idx = (hash + (i * i)) % MAX_SIZE; 
            if (table[idx].equals(EMPTY)) break; 
            if (table[idx].equals(key)) { 
                System.out.println("Key found!!"); 
                return; 
            } 
        } 
        System.out.println("Key not Found!!"); 
    } 
 
    static void quadraticDelete(String[] table, String key) { 
        int hash = computeHash(key); 
        for (int i = 0; i < MAX_SIZE; i++) { 
            int idx = (hash + (i * i)) % MAX_SIZE; 
            if (table[idx].equals(EMPTY)) break; 
            if (table[idx].equals(key)) { 
                table[idx] = DELETED; 
                System.out.println("Deleted " + key); 
                display(table); 
                return; 
            } 
        } 
        System.out.println("Key not Found!!"); 
    } 
 
    static void runProbing(Scanner sc, String mode) { 
        String[] table = new String[MAX_SIZE]; 
        for (int i = 0; i < MAX_SIZE; i++) table[i] = EMPTY; 
 
        while (true) { 
            System.out.print("\nEnter your choice: 1. Add 2. Search 3. Delete 4. Display 5. Exit::"); 
            int choice = Integer.parseInt(sc.nextLine().trim()); 
            if (choice == 5) break; 
 
            String key = ""; 
            if (choice >= 1 && choice <= 3) { 
                System.out.print("Enter the string: "); 
                key = sc.nextLine().trim(); 
            } 
 
            if (mode.equals("linear")) { 
                if (choice == 1) linearAdd(table, key); 
                else if (choice == 2) linearSearch(table, key); 
                else if (choice == 3) linearDelete(table, key); 
                else if (choice == 4) display(table); 
            } else { 
                if (choice == 1) quadraticAdd(table, key); 
                else if (choice == 2) quadraticSearch(table, key); 
                else if (choice == 3) quadraticDelete(table, key); 
                else if (choice == 4) display(table); 
            } 
        } 
    } 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("=== LINEAR PROBING ==="); 
        runProbing(sc, "linear"); 
 
        System.out.println("\n=== QUADRATIC PROBING ==="); 
        runProbing(sc, "quadratic"); 
        sc.close(); 
    } 
} 
