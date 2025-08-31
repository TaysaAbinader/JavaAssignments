package Chapter_2_3;

import java.util.ArrayList;
import java.util.Optional;

public class Library {
    private ArrayList<Book> bookList;

    public Library () {
        this.bookList = new ArrayList<>();
    }

    public void addBook (Book book) {
        if (bookList.contains(book)) {
            System.err.println("Error: Book already on library list.");
        }
        bookList.add(book);
    }

    public void displayBooks () {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void findBookByAuthor (String author) {
        for (Book book : bookList) {
            String bookAuthor = book.getAuthor();
            if (bookAuthor.equals(author)) {
                String bookFound = book.getTitle();
                int bookFoundYear = book.getYear();
                System.out.println("Books by: " + bookAuthor);
                System.out.println("Title: " + bookFound + ", Year: " + bookFoundYear);
            } 
        }
    }

    public Optional<Book> borrowBook (String titleSearched) {
        for (Book book : bookList) {
            String title = book.getTitle();
            if (titleSearched.equals(title)) {
                System.out.println(book + " is being borrowed.");
                bookList.remove(book);
                return Optional.of(book);
            }
        }
        System.err.println("Error: " + titleSearched + " was not found.");
        return Optional.empty();
    }

    public void returnBook (Book book) {
        if (!bookList.contains(book)) {
            System.out.println(book + " is being returned.");
            bookList.add(book);
            return;
        }
        System.err.println("Error: book " + book.getTitle() + " is already on the list.");
    }

}
