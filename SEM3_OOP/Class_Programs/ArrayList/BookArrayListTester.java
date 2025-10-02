import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class BookList {
    private ArrayList<Book> blList;

    public BookList() {
        blList = new ArrayList<Book>();
    }

    public void add(String title, String author) {
        Book book = new Book(title, author);
        blList.add(book);
    }

    public String searchAuthor(String title) {
        for (Book book : blList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.getAuthor();
            }
        }
        return "";
    }

    public void display() {
        for (Book book : blList) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}

public class BookArrayListTester {
    public static void main(String[] args) {
        BookList blist = new BookList();

        blist.add("Death Note", "Tsugumi Ohba");
        blist.add("Harry Potter", "J.K. Rowling");
        blist.add("Alice in Wonderland", "Lewis Carroll");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a book title: ");
        String inputTitle = sc.nextLine();

        String author = blist.searchAuthor(inputTitle);
        if (!author.equals("")) {
            System.out.println("The author of \"" + inputTitle + "\" is: " + author);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nAll books in the list:");
        blist.display();

        sc.close();
    }
}
