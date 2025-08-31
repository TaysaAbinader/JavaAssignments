package Chapter_2_3;

import java.util.Optional;

public class LibraryMain {

    public static void main(String[] args) {
        
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020 );
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        User user1 = new User("John", 20);
        User user2 = new User("Mary", 35);
        User user3 = new User("Jack", 50);

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        user1.addToBorrowedBooks(book1);
        user2.addToBorrowedBooks(book3);
        user3.addToBorrowedBooks(book2);

        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);

        book1.addRating(3.5);
        book2.addRating(4.0);
        book3.addRating(5);

        book3.addReview("Very entertaining for your free time.");
        book3.addReview("Nice book.");
        book3.addReview("Highly recommend.");
        book2.addReview("Useful.");
        book1.addReview("Nice book.");

        library.displayBooks();

        library.findBookByAuthor("Jane Doe");

        library.isBookAvailable("Data Structures and Algorithms");

        library.isBookAvailable("Love and Prejudice");

        Optional<Book> maybeBorrowedBook = library.borrowBook(book2.getTitle());
        if (maybeBorrowedBook.isPresent()) {
            boolean isTheSameBook = maybeBorrowedBook.get() == book2;
            System.out.println("Check if the borrowed book is the same as the one previously added: " + isTheSameBook);
            library.returnBook(maybeBorrowedBook.get());
        }
        library.getAverageBookRating();

        library.getMostReviewedBook();

        library.getUser("Jane");
        library.getUser("Jack");
    }

    

    

}
