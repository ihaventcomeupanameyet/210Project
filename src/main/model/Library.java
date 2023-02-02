package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static final int fine = 5;
    private List<Book> allBooks;
    private List<BorrowRecord> records;

    public Library() {
        allBooks = new ArrayList<>();
        records = new ArrayList<>();
    }

    // REQUIRES: Book can not have duplicate name with books already in the list
    // MODIFIES: This
    // EFFECTS: Add a new book to library
    public void addBook(Book a) {
        allBooks.add(a);
    }

    // MODIFIES: This
    // EFFECTS: Add a borrow record to library and return true if the requested book is available
    // false if book is not available or does not exist in library
    public boolean addBorrowRecord(String bookName, String name) {
        return false; //stub
    }

    // MODIFIES: This
    // EFFECTS:
    // if book can be found in the record remove borrow record of that book
    // form record list, make the book available and check if it's returned within
    // expected return date and decide whether fine should be applied for late return,
    //
    // if book can't be found in the record do nothing and return a string report of the return action
    public boolean returnBook(String bookName) {
        return false; //stub
    }

    // MODIFIES: This
    // EFFECTS: remove a book form library,
    public boolean removeBook(String bookName) {
        return false; //stub
    }

    public String listAllBooks() {
        return ""; //stub
    }

    public String listBorrowRecords() {
        return ""; //stub
    }

    public String listAvailableBooks() {
        return ""; //stub
    }

    public String listBookInfo(String bookName) {
        return ""; //stub
    }

    public Book findBook(String bookName) {
        return null;
    }

    public BorrowRecord findRecord(String bookName) {
        return null;
    }
}
