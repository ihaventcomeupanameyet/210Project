package model;

import exception.DuplicateBookException;
import exception.NoBookException;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    Library a;
    Book b;
    Book c;
    Book d;
    BorrowRecord e;
    @BeforeEach
    void setUp() {
        a = new Library();
        b = new Book("Discrete Math", "UBC Book store", "Math Nerd", 2020);
        c = new Book("Linear Algebra", "UBC Book store", "Math Nerd", 2020);
        d = new Book("Calculus III", "UBC Book store", "Math Nerd", 2020);
        try {
            a.addBook(b);
        } catch (DuplicateBookException e) {
            fail(); //No exception should be thrown
        }
        try {
            a.addBook(c);
        } catch (DuplicateBookException e) {
            fail(); //No exception should be thrown
        }
        try {
            a.addBook(d);
        } catch (DuplicateBookException e) {
            fail(); //No exception should be thrown
        }
    }

    @Test
    void TestConstructor() {
        a = new Library();
        assertEquals(0,a.getAllBooks().size());
        assertEquals(0,a.getRecords().size());
    }
    @Test
    void TestAddBook() {
        a = new Library();
        try {
            a.addBook(b);
        } catch (DuplicateBookException e) {
            fail(); //No exception should be thrown
        }
        assertEquals(1,a.sizeOfCollection());
        assertEquals(0,a.sizeOfBorrowRecord());

        try {
            a.addBook(c);
        } catch (DuplicateBookException e) {
            fail(); //No exception should be thrown
        }
        assertEquals(2,a.sizeOfCollection());
        assertEquals(0,a.sizeOfBorrowRecord());

        try {
            a.addBook(d);
        } catch (DuplicateBookException e) {
            fail(); //No exception should be thrown
        }
        assertEquals(3,a.sizeOfCollection());
        assertEquals(0,a.sizeOfBorrowRecord());

        //check insert book with duplicate name
        try {
            a.addBook(b);
            fail(); // should not run if program successfully detect this and throw exception
        } catch (DuplicateBookException e) {
            //
        }
    }

    @Test
    void TestAddBorrowRecord() {

        e = new BorrowRecord("John","Discrete Math");

        // borrow available book
        try {
            assertTrue(a.addBorrowRecord(e));
        } catch (NoBookException e) {
            fail(); //No exception should be thrown
        }
        assertEquals(3,a.sizeOfCollection());
        assertEquals(1,a.sizeOfBorrowRecord());

        e = new BorrowRecord("Bob","Discrete Math");
        // borrow not available book
        try {
            assertFalse(a.addBorrowRecord(e));
        } catch (NoBookException e) {
            fail(); //No exception should be thrown
        }
        assertEquals(3,a.sizeOfCollection());
        assertEquals(1,a.sizeOfBorrowRecord());

        e = new BorrowRecord("Math Nerd","Calculus IV");
        // borrow book that is can not be found in library
        try {
            a.addBorrowRecord(e);
            fail(); // should not run if program successfully detect this and throw exception
        } catch (NoBookException e) {
            //
        }
        assertEquals(3,a.sizeOfCollection());
        assertEquals(1,a.sizeOfBorrowRecord());
    }

    @Test
    void TestRemoveBook() {
        // remove available book
        try {
            assertTrue(a.removeBook("Discrete Math"));
        } catch (NoBookException e) {
            fail(); //No exception should be thrown
        }

        e = new BorrowRecord("John","Discrete Math");
        // confirm book has been removed
        try {
            a.addBorrowRecord(e);
            fail();
        } catch (NoBookException e) {
            //
        }
        assertEquals(2,a.sizeOfCollection());

        // remove book can't be found in library
        try {
            a.removeBook("Discrete Math");
            fail();
        } catch (NoBookException e) {
            //
        }

        e = new BorrowRecord("John","Linear Algebra");
        try {
            assertTrue(a.addBorrowRecord(e));
        } catch (NoBookException e) {
            fail(); //No exception should be thrown
        }

        // remove book not available in the library right now
        try {
            assertFalse(a.removeBook("Linear Algebra"));
        } catch (NoBookException e) {
            fail(); //No exception should be thrown
        }
    }

    @Test
    void TestAllBooks() {
        String f = "Listing Collection:\n" + b.getInfo() + "\n" + c.getInfo() + "\n" + d.getInfo() + "\n";
        assertEquals(f, a.listAllBooks());
    }

    @Test
    void TestListBorrowRecord() {
        String f = "Listing Borrow Records:\n";
        assertEquals(f,a.listBorrowRecords());

        e = new BorrowRecord("John", "Discrete Math");
        try {
            a.addBorrowRecord(e);
        } catch (NoBookException e) {
            fail(); //No exception should be thrown
        }

        f = f + e.getInfo()+"\n";

        assertEquals(f,a.listBorrowRecords());

        e = new BorrowRecord("Bob", "Calculus III");
        try {
            a.addBorrowRecord(e);
        } catch (NoBookException e) {
            fail(); //No exception should be thrown
        }

        f = f + e.getInfo()+"\n";
        assertEquals(f,a.listBorrowRecords());
    }

    @Test
    void TestReturnBook() {
        e = new BorrowRecord("John", "Discrete Math");

        try {
            a.addBorrowRecord(e);
        } catch (NoBookException ex) {
            fail(); //No exception should be thrown
        }
        assertEquals(3,a.sizeOfCollection());
        assertEquals(1,a.sizeOfBorrowRecord());

        //check if attempt to return book not in the list
        try {
            a.returnBook("Linear Algebra");
            fail(); // won't run if method act accordingly
        } catch (NoBookException ex) {
            //
        }

        //check return a book within expected date
        try {
            assertTrue(a.returnBook(e.getBookName()));
        } catch (NoBookException ex) {
            fail(); //No exception should be thrown
        }

        //check if attempt to return book when record list is empty
        try {
            a.returnBook(e.getBookName());
            fail(); // won't run if method act accordingly
        } catch (NoBookException ex) {
            //
        }

        LocalDate yesterday = LocalDate.now().minusDays(1);
        e.setExpectedReturnDate(yesterday);
        try {
            a.addBorrowRecord(e);
        } catch (NoBookException ex) {
            fail(); //No exception should be thrown
        }

        // check return a book later than expected date
        try {
            assertFalse(a.returnBook(e.getBookName()));
        } catch (NoBookException ex) {
            fail(); //No exception should be thrown
        }
    }

    @Test
    void TestListAvailableBooks() {
        // all book is available
        String f = "Listing Available Books:\n" + b.getInfo() + "\n" + c.getInfo() + "\n" + d.getInfo() + "\n";
        assertEquals(f, a.listAvailableBooks());

        // 2 book is available
        e = new BorrowRecord("John","Discrete Math");
        try {
            a.addBorrowRecord(e);
        } catch (NoBookException ex) {
            fail();//No exception should be thrown
        }

        f = "Listing Available Books:\n" + c.getInfo() + "\n" + d.getInfo() + "\n";
        assertEquals(f, a.listAvailableBooks());

        // 1 book is available
        e = new BorrowRecord("John","Linear Algebra");
        try {
            a.addBorrowRecord(e);
        } catch (NoBookException ex) {
            fail();//No exception should be thrown
        }

        f = "Listing Available Books:\n" + d.getInfo() + "\n";
        assertEquals(f, a.listAvailableBooks());

        // no book is available
        e = new BorrowRecord("John","Calculus III");
        try {
            a.addBorrowRecord(e);
        } catch (NoBookException ex) {
            fail();//No exception should be thrown
        }
        f = "Listing Available Books:\n";
        assertEquals(f, a.listAvailableBooks());
    }

    @Test
    void TestListBookInfo() {
        try {
            assertEquals(b.getInfo(),a.listBookInfo("Discrete Math"));
        } catch (NoBookException ex) {
            fail();//No exception should be thrown
        }

        try {
            assertEquals(c.getInfo(),a.listBookInfo("Linear Algebra"));
        } catch (NoBookException ex) {
            fail();//No exception should be thrown
        }

        try {
            assertEquals(d.getInfo(),a.listBookInfo("Calculus III"));
        } catch (NoBookException ex) {
            fail();//No exception should be thrown
        }

        try {
            assertEquals(d.getInfo(),a.listBookInfo("Calculus IV"));
            fail();// won't run if method act accordingly
        } catch (NoBookException ex) {
            //
        }
    }

    @Test
    void TestGetFine() {
        assertEquals(5, a.getFine());
    }
}
