package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BorrowRecordTest {
    BorrowRecord a;

    @BeforeEach
    void setUp() {
        a = new BorrowRecord("John Doe", "Linear Algebra");
    }

    @Test
    void TestConstructor() {
        LocalDate now = LocalDate.now();
        LocalDate oneMonthLater = LocalDate.now().plusMonths(1);

        assertEquals(now, a.getBorrowDate());
        assertEquals(oneMonthLater, a.getExpectedReturnDate());
        assertEquals("John Doe", a.getName());
        assertEquals("Linear Algebra", a.getBookName());
    }

    @Test
    void TestCheckLate() {
        assertTrue(a.checkLate());
        LocalDate yesterday = LocalDate.now().minusDays(1);
        a.setExpectedReturnDate(yesterday);
        assertFalse(a.checkLate());
    }

    @Test
    void TestGetInfo() {
        String b = "Borrower : " + a.getName() + " Book name:"
                + a.getBookName() + " Date borrowed: " + a.getBorrowDate()
                + " Expected return date: " + a.getExpectedReturnDate();
        assertEquals(b,a.getInfo());
    }
}
