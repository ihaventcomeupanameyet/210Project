package model;

// Book info kept by the library
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

    public String getPublisher() {
        return publisher;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getInfo() {
        return "Book name: " + name + " Author:"
                + authorName + " Publisher: " + publisher + " Year published: " + yearPublished;
    }
}
