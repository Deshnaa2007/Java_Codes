import java.util.*;

class InvalidBookException extends Exception {
    public InvalidBookException(String msg) {
        super(msg);
    }
}

class Book {

    String title;
    String author;
    double price;
    int stock;
    String isbn;

    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0;
        stock = 0;
        isbn = "NA";
    }

    public Book(String t, String a, double p, int s, String i) throws InvalidBookException {

        if (p < 0) {
            throw new InvalidBookException("Price must be positive");
        }

        if (s < 0) {
            throw new InvalidBookException("Stock cannot be negative");
        }

        if (i == null || i.length() < 5) {
            throw new InvalidBookException("ISBN not valid");
        }

        title = t;
        author = a;
        price = p;
        stock = s;
        isbn = i;
    }

    public Book(Book obj) {
        title = obj.title;
        author = obj.author;
        price = obj.price;
        stock = obj.stock;
        isbn = obj.isbn;
    }

    void show() {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
        System.out.println("Stock : " + stock);
        System.out.println("ISBN : " + isbn);
        System.out.println("----------------------");
    }
}

public class BookStoreDemo {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        try {

            Book b1 = new Book("Java Programming", "Herbert Schildt", 550, 10, "ISBN001");

            Book b2 = new Book("Python for Data Science", "Jake VanderPlas", 650, 5, "ISBN002");

            Book b3 = new Book(b1);

            books.add(b1);
            books.add(b2);
            books.add(b3);

            System.out.println("Book Records\n");

            for (int i = 0; i < books.size(); i++) {
                books.get(i).show();
            }

            Book b4 = new Book("Invalid Book", "Test Author", -200, 3, "ISBN003");

            books.add(b4);

        }
        catch (InvalidBookException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
