package persistence;

import exception.DuplicateBookException;
import exception.NoBookException;
import model.Book;
import model.BorrowRecord;
import model.Library;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest {

    @Test
    public void testWriteEmptyLibrary() {
        JsonWriter a = new JsonWriter("./data/testWriterEmptyLib.json");
        Library b = new Library();
        try {
            a.open();
            a.write(b);
            a.close();
        } catch (FileNotFoundException e) {
            fail("No Exception should be caught at this point");
        }

        JsonReader c = new JsonReader("./data/testWriterEmptyLib.json");
        try {
            b = c.read();
        } catch (Exception e) {
            fail("No Exception should be caught at this point");
        }

        assertEquals(0,b.sizeOfCollection());
        assertEquals(0,b.sizeOfBorrowRecord());
    }

    @Test
    public void testWriteInvalidPath() {
        JsonWriter a = new JsonWriter("./data/\0File.json");
        Library b = new Library();
        try {
            a.open();
            fail("Should not get to this step");
            a.write(b);
            a.close();
        } catch (FileNotFoundException e) {
            //
        }
    }

    @Test
    public void testWriteNoBorrowRecords() {
        Library a = new Library();
        Book b = new Book("Discrete Math", "UBC Book store", "Math Nerd", 2020);
        Book c = new Book("Linear Algebra", "UBC Book store", "Math Nerd", 2020);
        Book d = new Book("Calculus III", "UBC Book store", "Math Nerd", 2020);
        try {
            a.addBook(b);
        } catch (DuplicateBookException e) {
            fail("No Exception should be caught at this point");
        }
        try {
            a.addBook(c);
        } catch (DuplicateBookException e) {
            fail("No Exception should be caught at this point");
        }
        try {
            a.addBook(d);
        } catch (DuplicateBookException e) {
            fail("No Exception should be caught at this point");
        }
        JsonWriter e = new JsonWriter("./data/testWriterNoBorrowRecords.json");
        try {
            e.open();
            e.write(a);
            e.close();
        } catch (FileNotFoundException ex) {
            fail("No Exception should be caught at this point");
        }

        JsonReader f = new JsonReader("./data/testWriterNoBorrowRecords.json");
        try {
            a = f.read();
        } catch (Exception ex) {
            fail("No Exception should be caught at this point");
        }
        assertEquals(3,a.sizeOfCollection());
        assertEquals(0,a.sizeOfBorrowRecord());
    }

    @Test
    public void testWriteOneBorrowRecord() {
        Library a = new Library();
        Book b = new Book("Discrete Math", "UBC Book store", "Math Nerd", 2020);
        Book c = new Book("Linear Algebra", "UBC Book store", "Math Nerd", 2020);
        Book d = new Book("Calculus III", "UBC Book store", "Math Nerd", 2020);
        try {
            a.addBook(b);
        } catch (DuplicateBookException e) {
            fail("No Exception should be caught at this point");
        }
        try {
            a.addBook(c);
        } catch (DuplicateBookException e) {
            fail("No Exception should be caught at this point");
        }
        try {
            a.addBook(d);
        } catch (DuplicateBookException e) {
            fail("No Exception should be caught at this point");
        }
        BorrowRecord g = new BorrowRecord("John", "Discrete Math");
        try {
            a.addBorrowRecord(g);
        } catch (NoBookException e) {
            fail("No Exception should be caught at this point");
        }
        JsonWriter e = new JsonWriter("./data/testWriterOneBorrowRecord.json");
        try {
            e.open();
            e.write(a);
            e.close();
        } catch (FileNotFoundException ex) {
            fail("No Exception should be caught at this point");
        }

        JsonReader f = new JsonReader("./data/testWriterOneBorrowRecord.json");
        try {
            a = f.read();
        } catch (Exception ex) {
            fail("No Exception should be caught at this point");
        }
        assertEquals(3,a.sizeOfCollection());
        assertEquals(1,a.sizeOfBorrowRecord());
    }

}
