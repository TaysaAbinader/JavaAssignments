package Chapter_2_3;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addToBorrowedBooks (Book book) {
        borrowedBooks.add(book);
    }

    public String getName () {
        return this.name;
    }

    public int getAge () {
        return this.age;
    }

    public ArrayList<Book> getBorrowedBooks () {
        return borrowedBooks;
    }

    public String toString() {
        return "Name: " + name + " Borrowed books: " + borrowedBooks.size();
    }
}
