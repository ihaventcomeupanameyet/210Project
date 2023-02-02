package model;

public class Book {
    private String name;
    private String publisher;
    private String authorName;
    private int yearPublished;
    private boolean available;

    public Book(String name, String publisher, String authorName, int yearPublished) {
        this.name = name;
        this.publisher = publisher;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
        available = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getInfo() {
        return ""; //stub
    }
}
