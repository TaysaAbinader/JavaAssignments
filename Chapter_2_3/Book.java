package Chapter_2_3;

public class Book {
    private  String title;
    private String author;
    private int publicationYear;
    private double rating = 0.0;
    private String review = null;

    public Book (String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        
    }

    public void setRating (double rating) {
        this.rating = rating;
    }

    public void setReview (String review) {
        this.review = review;
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

    public double getRate () {
        return this.rating;
    }

    public String getReview () {
        return this.review;
    }



    @Override
    public String toString () {
        return "Title: " + title + ", Author: " + author + ", Year: " + publicationYear + ", Rating: " + rating + ", Reviews: " + review;
    }

}
