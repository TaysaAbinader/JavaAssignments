package Chapter_2_3;

import java.util.Optional;

public class LibraryMain {

    public static void main(String[] args) {
        
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        library.findBookByAuthor("Jane Doe");

        Optional<Book> maybeBorrowedBook = library.borrowBook(book2.getTitle());
        if (maybeBorrowedBook.isPresent()) {
            System.out.println("Check if the borrowed book is the same as the one previously added: " + (maybeBorrowedBook.get() == book2));
            library.returnBook(maybeBorrowedBook.get());
        }
    }

}
