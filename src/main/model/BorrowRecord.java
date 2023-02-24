package model;

import org.json.JSONObject;
import persistence.Write;

import java.time.LocalDate;

// Borrow records kept by the library
public class BorrowRecord implements Write {
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


    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
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

    @Override
    public JSONObject toJson() {
        // LocalDate.now().withYear(2000).withMonth(12).withDayOfMonth(31)
        JSONObject a = new JSONObject();
        a.put("name", name);
        a.put("bookName", bookName);

        a.put("borrowYear",borrowDate.getYear());
        a.put("borrowMonth",borrowDate.getMonthValue());
        a.put("borrowDay",borrowDate.getDayOfMonth());

        a.put("returnYear",expectedReturnDate.getYear());
        a.put("returnMonth",expectedReturnDate.getMonthValue());
        a.put("returnDay",expectedReturnDate.getDayOfMonth());
        return a;
    }
}
