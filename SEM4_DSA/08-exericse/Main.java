import java.util.Scanner; 
 
class Node { 
    String key; 
    Node next; 
 
    Node(String key) { 
        this.key = key; 
        this.next = null; 
    } 
} 
 
public class Main { 
    static final int MAX_SIZE = 7; 
    static Node[] table = new Node[MAX_SIZE]; 
 
    static int computeHash(String s) { 
        int sumAlpha = 0, sumDigit = 0, sumSymbol = 0; 
        for (char c : s.toCharArray()) { 
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) { 
                sumAlpha += (int) c; 
            } else if (c >= '0' && c <= '9') { 
                sumDigit += (int) c; 
            } else { 
                sumSymbol += (int) c; 
            } 
        } 
        return (sumAlpha + 3 * sumDigit + 5 * sumSymbol + 7) % MAX_SIZE; 
    } 
 
    static void insert(String key) { 
        int idx = computeHash(key); 
        Node newNode = new Node(key); 
        newNode.next = table[idx]; 
        table[idx] = newNode; 
    } 
 
    static void display() { 
        System.out.println("Hash table"); 
        for (int i = 0; i < MAX_SIZE; i++) { 
            System.out.print("[" + i + "]: "); 
            Node curr = table[i]; 
            while (curr != null) { 
                System.out.print("-> " + curr.key + " "); 
                curr = curr.next; 
            } 
            System.out.println(); 
        } 
    } 
 
    static void search(String key) { 
        System.out.print("Search: " + key + " -> "); 
        int idx = computeHash(key); 
        Node curr = table[idx]; 
        while (curr != null) { 
            if (curr.key.equals(key)) { 
                System.out.println("Key found at index " + idx); 
                return; 
            } 
            curr = curr.next; 
        } 
        System.out.println("Key not found"); 
    } 
 
    static void delete(String key) { 
        System.out.println("Delete: " + key); 
        int idx = computeHash(key); 
        Node curr = table[idx]; 
        Node prev = null; 
 
        while (curr != null) { 
            if (curr.key.equals(key)) { 
                if (prev == null) { 
                    table[idx] = curr.next; 
                } else { 
                    prev.next = curr.next; 
                } 
                display(); 
                return; 
            } 
            prev = curr; 
            curr = curr.next; 
        } 
        System.out.println("Key \"" + key + "\" not found for deletion."); 
    } 
 
    public static void main(String[] args) { 
        String[] keys = { 
            "M2y", "N3x", "F4w", "O5v", "D*2u", "A2t", "K5#y", "M6z", 
            "N7a", "Y3w", "b2Y", "e3X", "f4W", "c5V", "d2U", "a2T", 
            "J5Y", "m6%Z", "n7A", "y3W" 
        }; 
for (String key : keys) { 
System.out.println("Hash value for " + key + " = " + computeHash(key)); 
} 
for (String key : keys) { 
insert(key); 
} 
System.out.println(); 
display(); 
System.out.println(); 
delete("b2Y"); 
System.out.println(); 
search("a2T"); 
search("wew423"); 
} 
} 
