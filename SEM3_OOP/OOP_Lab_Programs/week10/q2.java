import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private double price;
    
 
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
 
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public double getPrice() {
        return price;
    }
    
   
    @Override
    public int compareTo(Book other) {
        if (this.price < other.price) {
            return -1;
        } else if (this.price > other.price) {
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return "Title: " + title + " Author: " + author + " Price: " + price;
    }
}


public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        
        System.out.print("How many books do you want to enter? ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); 
 
        for (int i = 1; i <= numBooks; i++) {
            System.out.println("
Enter details for Book " + i + ":");
            
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); 
            
           
            books.add(new Book(title, author, price));
        }
       
        Collections.sort(books);
    
        System.out.println("
Books sorted by price (ascending):");
        for (Book book : books) {
            System.out.println(book);
        }
        
        scanner.close();
    }
}
