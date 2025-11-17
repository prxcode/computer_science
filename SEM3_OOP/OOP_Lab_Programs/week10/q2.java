import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Book implements Comparable<Book> {
    String title;
    String author;
    double price;
    
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public int compareTo(Book other) {
        if (this.price < other.price) return -1;
        if (this.price > other.price) return 1;
        return 0;
    }
    
    public String toString() {
        return "Title: " + title + " Author: " + author + " Price: " + price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        
        System.out.print("How many books? ");
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("
Book " + i + ":");
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            
            books.add(new Book(title, author, price));
        }
        
        Collections.sort(books);
        
        System.out.println("
Books sorted by price (ascending):");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
