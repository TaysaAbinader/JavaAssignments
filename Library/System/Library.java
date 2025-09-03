package Library.System;
import Library.Model.Book;
import Library.Model.LibraryMember;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> booksCatalogue = new ArrayList<>();
    private ArrayList<LibraryMember> membersList = new ArrayList<>();

    public Library () {}

    public void addBook (Book book) {
        if (booksCatalogue.contains(book)) {
            System.err.println(book.getTitle() + " already on catalogue.");
            return;
        }
        booksCatalogue.add(book);
    }

    public void addMember (LibraryMember member) {
        if (membersList.contains(member)) {
            System.err.println(member.getName() + " already registered.");
        }
        membersList.add(member);
    }

    public void borrowBook (Book book, LibraryMember member) {
        if (!booksCatalogue.contains(book)) {
            System.out.println("Error: " + book.getTitle() + " not available for borrowing.");
            return;
        }
        System.out.println(book.getTitle() + " is being borrowed.");
        booksCatalogue.remove(book);
        member.addBorrowedBook(book);
    }

    public void returnBook (Book book, LibraryMember member) {
        if (booksCatalogue.contains(book)) {
            System.err.println("Error: " + book.getTitle() + " still in catalogue.");
            return;
        }
        System.out.println(book.getTitle() + " is being returned.");
        booksCatalogue.add(book);
        member.returnBorrowedBook(book);
    }

    public void displayCatalogue() {
        if (booksCatalogue.isEmpty()) {
            System.err.println("Error: Library is empty.");
        }
        System.out.println("Book Catalogue");
        for (Book item : booksCatalogue) {
            System.out.println("Book:\n" + item.getTitle() + " - " + item.getAuthor());
        }
    }

    public void displayMembers() {
        if (membersList.isEmpty()) {
            System.err.println("Error: Members' list is empty.");
        }
        System.out.println("Members' List");
        for (LibraryMember item : membersList) {
            System.out.println("Member:\n" + item.getName() + " - " + item.getMemberID());
        }
    }

    public void reserveBook (Book book, LibraryMember member) {
        if (!booksCatalogue.contains(book)) {
            System.err.println("Error: " + book.getTitle() + " not available for reservation.");
            return;
        } 
        if (book.isReserved()) {
            System.err.println("Error: " + book.getTitle() + " already reserved.");
            return;
        }
        if (!membersList.contains(member)) {
            System.err.println("Error: " + member.getName() + " not found.");
            return;
        }
        if (member.isBookReserved(book)) {
            System.err.println("Error: " + book.getTitle() + " already reserved to " + member.getName() + ".");
            return;
        }
        System.out.println(book.getTitle() + " is reserved.");
        book.setReserved(true);
        member.addReservedBook(book);
    }

    public void cancelReservation (Book book, LibraryMember member) {
        if (!booksCatalogue.contains(book)) {
            System.err.println("Error: " + book.getTitle() + " does not belong to this library.");
            return;
        } 
        if (!book.isReserved()) {
            System.err.println("Error: " + book.getTitle() + " was not reserved.");
            return;
        }
        if (!membersList.contains(member)) {
            System.err.println("Error: " + member.getName() + " not found.");
            return;
        }
        if (!member.isBookReserved(book)) {
            System.err.println("Error: " + book.getTitle() + " was not reserved by " + member.getName() + ".");
            return;
        }
        System.out.println(book.getTitle() + " reserve is being cancelled.");
        book.setReserved(false);
        member.removeReservedBook(book);
    }

    public void displayReservedBooks () {
        System.out.println("Reserved Books: ");
        for (Book item : booksCatalogue) {
            if (item.isReserved()) {
                System.out.println(item.toString());
            }
        }
    }
}
