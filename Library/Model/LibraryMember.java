package Library.Model;

import java.util.ArrayList;

public class LibraryMember {
    private String name;
    private int memberID;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private static int counter = 0;
    private ArrayList<Book> reservedBooks = new ArrayList<>();

    public LibraryMember (String name) {
        this.name = name;
        this.memberID = ++counter;
    }

    public String getName () {
        return this.name;
    }

    public int getMemberID () {
        return this.memberID;
    }

    public void addBorrowedBook (Book book) {
        if (borrowedBooks.contains(book)) {
            System.err.println("Error: " + book + " already borrowed.");
            return;
        }
        borrowedBooks.add(book);
    }

    public void returnBorrowedBook (Book book) {
        if (!borrowedBooks.contains(book)) {
            System.err.println("Error: " + book.getTitle() + "not among your borrowed books.");
            return;
        }
        borrowedBooks.remove(book);
    }

    public void addReservedBook (Book book) {
        if (reservedBooks.contains(book)) {
            System.err.println("Error: " + book + " already reserved.");
            return;
        }
        reservedBooks.add(book);
    }

    public void removeReservedBook (Book book) {
        if (!reservedBooks.contains(book)) {
            System.err.println("Error: " + book + "is not on reserved list.");
            return;
        }
        reservedBooks.remove(book);
    }

    public boolean isBookReserved (Book book) {
        return reservedBooks.contains(book);
    }
}

