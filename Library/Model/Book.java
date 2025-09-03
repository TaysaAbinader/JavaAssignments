package Library.Model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean reserved = false;

    public Book (String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public boolean isReserved () {
        return reserved;
    }

    public void setReserved (boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\n";
    }

}
