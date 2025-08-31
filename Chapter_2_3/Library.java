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
                System.out.println(book.getTitle() + " is being borrowed.");
                bookList.remove(book);
                return Optional.of(book);
            }
        }
        System.err.println("Error: " + titleSearched + " was not found.");
        return Optional.empty();
    }

    public void returnBook (Book book) {
        if (!bookList.contains(book)) {
            System.out.println(book.getTitle() + " is being returned.");
            bookList.add(book);
            return;
        }
        System.err.println("Error: book " + book.getTitle() + " is already on the list.");
    }

    public boolean isBookAvailable (String title) {
        for (Book book : bookList) {
            if (title == book.getTitle()) {
                System.out.println(title + " is available.");
                return true;
            }
        }
        System.out.println(title + " is not available.");
        return false;
    }

    public void getAverageBookRating () {
        double totalValue = 0;
        for (Book item : bookList) {
            totalValue =+ item.getRating();
        }
        double averageValue = totalValue/bookList.size();
        System.out.println("The average rating of all books is: " + String.format("%.2f", averageValue));
    }

    public Book getMostReviewedBook () {
        int highestReviewAmount = 0;
        Book highestReviewedBook = null;
        for (Book item : bookList) {
            int reviewAmount = item.getReviewAmount();
            if (reviewAmount > highestReviewAmount) {
                highestReviewAmount = reviewAmount;
                highestReviewedBook = item;
            }
        }
        System.out.println("The book with most reviews (" + highestReviewAmount + ") is: " + highestReviewedBook.getTitle());
        return highestReviewedBook;
    }

}
