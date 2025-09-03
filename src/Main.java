import Library.Model.Book;
import Library.Model.LibraryMember;
import Library.System.*;


public class Main {
    public static void main(String[] args) {

        Library fakeLibrary = new Library();

        LibraryMember member1 = new LibraryMember("John Doe");
        LibraryMember member2 = new LibraryMember("Peter Parker");
        LibraryMember member3 = new LibraryMember("Harry Potter");
        LibraryMember member4 = new LibraryMember("Frodo Baggins");
        LibraryMember member5 = new LibraryMember("Lea Organa");

        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book2 = new Book("1984", "George Orwell", "9780451524935");
        Book book3 = new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488");
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "9780141439518");
        Book book5 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");


        fakeLibrary.addBook(book1);
        fakeLibrary.addBook(book2);
        fakeLibrary.addBook(book3);
        fakeLibrary.addBook(book4);
        fakeLibrary.addBook(book5);

        fakeLibrary.addMember(member1);
        fakeLibrary.addMember(member2);
        fakeLibrary.addMember(member3);
        fakeLibrary.addMember(member4);
        fakeLibrary.addMember(member5);

        fakeLibrary.borrowBook(book2, member4);
        fakeLibrary.borrowBook(book3, member5);
        fakeLibrary.borrowBook(book1, member3);
        fakeLibrary.borrowBook(book4, member1);

        fakeLibrary.returnBook(book2, member4);
        fakeLibrary.returnBook(book3, member5);
        fakeLibrary.returnBook(book1, member3);
        fakeLibrary.returnBook(book4, member1);

        fakeLibrary.displayCatalogue();
        fakeLibrary.displayMembers();
    }

}
