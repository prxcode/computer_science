import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Basics", "John Doe", 350.0));
        books.add(new Book("Data Structures", "Smith", 450.0));
        books.add(new Book("Advanced Java", "Jane", 550.0));

        Collections.sort(books);


        System.out.println("Books sorted by price (ascending):");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
