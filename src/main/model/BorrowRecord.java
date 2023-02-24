package model;

import java.time.LocalDate;

// Borrow records kept by the library
public class BorrowRecord {
    private String name;
    private String bookName;
    private LocalDate borrowDate;
    private LocalDate expectedReturnDate;

    public BorrowRecord(String name, String bookName) {
        this.name = name;
        this.bookName = bookName;
        borrowDate = LocalDate.now();
        expectedReturnDate = LocalDate.now().plusMonths(1);
    }

    public String getBookName() {
        return bookName;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    // EFFECTS: return true if return date is before the expected return date
    public boolean checkLate() {
        LocalDate now = LocalDate.now();
        return now.isBefore(expectedReturnDate);
    }

    // EFFECTS: return a string with description of this borrow record
    public String getInfo() {
        return  "Borrower : " + name + " Book name:"
                + bookName + " Date borrowed: " + borrowDate + " Expected return date: " + expectedReturnDate;
    }
}
