package Chapter_2_3;

public class Book {
    private  String title;
    private String author;
    private int publicationYear;

    public Book (String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle () {
        return this.title;
    }

    public String getAuthor () {
        return this.author;
    }

    public int getYear () {
        return this.publicationYear;
    }

    @Override
    public String toString () {
        return "Title: " + title + ", Author: " + author + ", Year: " + publicationYear;
    }

}
