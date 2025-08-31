package Chapter_2_3;

import java.util.ArrayList;

public class Book {
    private  String title;
    private String author;
    private int publicationYear;
    private double ratings;
    private ArrayList<String> reviews = new ArrayList<>();

    public Book (String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void addRating (double rating) {
        this.ratings = rating;
    }

    public double getRating () {
        return this.ratings;
    }

    public void addReview (String review) {
        for (String item : reviews) {
            if (item == review)
            System.err.println("Error: Repeated review");
        }
        reviews.add(review);
        
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

    public ArrayList<String> getReview () {
        return reviews;
    }

    public int getReviewAmount () {
        return reviews.size();

    }

    @Override
    public String toString () {
        return "Title: " + title + ", Author: " + author + ", Year: " + publicationYear + ", Rating: " + ratings + ", Reviews: " + reviews.size();
    }
}
