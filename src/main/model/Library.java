package model;

import exception.DuplicateBookException;
import exception.NoBookException;


import java.util.ArrayList;
import java.util.List;


public class Library {
    private static final int fine = 5;
    private List<Book> allBooks;
    private List<BorrowRecord> records;

    // EFFECTS: create a new library object with empty collection and records
    public Library() {
        allBooks = new ArrayList<>();
        records = new ArrayList<>();
    }


    // MODIFIES: This
    // EFFECTS: Add a new book to library
    public void addBook(Book a) throws DuplicateBookException {
        if (checkDuplicate(a)) {
            throw new DuplicateBookException();
        }
        allBooks.add(a);
    }

    // MODIFIES: This
    // EFFECTS: Add a borrow record to library and return true if the requested book is can be fund and available
    // return false if book is not available, throw exception if book can't find in the library
    public boolean addBorrowRecord(BorrowRecord a) throws NoBookException {
        Book b = findBook(a.getBookName());
        if (b == null) {
            throw new NoBookException();
        }

        if (b.isAvailable()) {
            b.setAvailable(false);
            records.add(a);
            return true;
        } else {
            return false;
        }
    }

    // MODIFIES: This
    // EFFECTS:
    // if book can be found in the record remove borrow record of that book
    // form record list, make the book available and check if it's returned within
    // expected return date, return true if it is, false if it's not
    //
    // if book can't be found in the record do nothing and throw an exception
    public boolean returnBook(String bookName) throws NoBookException {
        BorrowRecord b = findRecord(bookName);
        if (b == null) {
            throw new NoBookException();
        }

        Book a = findBook(bookName);
        records.remove(b);
        a.setAvailable(true);
        return b.checkLate();
    }

    // MODIFIES: This
    // EFFECTS: if book can be found in the library and is available remove it from library, and return true
    // if book is currently not inside library(not available) do nothing and return false
    // if book can not be found throw an exception
    public boolean removeBook(String bookName) throws NoBookException {
        Book a = findBook(bookName);
        if (a == null) {
            throw new NoBookException();
        }

        if (a.isAvailable()) {
            allBooks.remove(a);
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: return a string that list all books in the library
    public String listAllBooks() {
        String f = "Listing Collection:\n";
        for (Book b : allBooks) {
            f = f + b.getInfo() + "\n";
        }
        return f;
    }

    // EFFECTS: return a string that list borrow records in the library
    public String listBorrowRecords() {
        String f = "Listing Borrow Records:\n";
        for (BorrowRecord b : records) {
            f = f + b.getInfo() + "\n";
        }
        return f;
    }

    // EFFECTS: return a string that list book that is currently available in the library
    public String listAvailableBooks() {
        String f = "Listing Available Books:\n";
        for (Book b : allBooks) {
            if (b.isAvailable()) {
                f = f + b.getInfo() + "\n";
            }
        }
        return f;
    }

    // EFFECTS: return a string that list a book's info
    // Throw exception if book can't be found
    public String listBookInfo(String bookName) throws NoBookException {
        Book a = findBook(bookName);
        if (a == null) {
            throw new NoBookException();
        }

        return a.getInfo();
    }

    // EFFECTS: public helper for testing
    // return size of all book
    public int sizeOfCollection() {
        return allBooks.size();
    }

    // EFFECTS: public helper for testing
    // return size of borrow records
    public int sizeOfBorrowRecord() {
        return records.size();
    }

    // EFFECTS: private helper function
    // search in library and return a book with given name or null is book can't be found
    private Book findBook(String bookName) {
        for (Book b : allBooks) {
            if (bookName.equals(b.getName())) {
                return b;
            }
        }
        return null;
    }

    // EFFECTS: private helper function
    // search in borrow record and return a borrow record
    // with given name or null is borrow record can't be found
    private BorrowRecord findRecord(String bookName) {
        BorrowRecord a = null;
        for (BorrowRecord b : records) {
            if (bookName.equals(b.getBookName())) {
                a = b;
            }
        }
        return a;
    }

    // EFFECTS: private helper function
    // return true if book has a duplicate name to current collection of books
    private boolean checkDuplicate(Book a) {
        for (Book b : allBooks) {
            if (a.getName().equals(b.getName())) {
                return true;
            }
        }
        return false;
    }

    public int getFine() {
        return fine;
    }
}
