package persistence;


import model.Library;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {
    @Test
    public void testReaderNoSuchFile() {
        JsonReader a = new JsonReader("./data/noSuchFile.json");
        try {
            a.read();
            fail("should not get this point");
        } catch (IOException e) {
            //Pass
        } catch (Exception e) {
            fail("No Exception should be caught at this point");
        }
    }

    @Test
    public void testReaderEmptyLibrary() {
        JsonReader a = new JsonReader("./data/testReaderEmptyLib.json");
        Library b;
        try {
            b = a.read();
            assertEquals(0,b.sizeOfCollection());
            assertEquals(0,b.sizeOfBorrowRecord());
        } catch (Exception e) {
            fail("No Exception should be caught at this point");
        }
    }

    @Test
    public void testReaderNoBorrowRecords() {
        JsonReader a = new JsonReader("./data/testReaderNoBorrowRecords.json");
        Library b;
        try {
            b = a.read();
            assertEquals(3,b.sizeOfCollection());
            assertEquals(0,b.sizeOfBorrowRecord());
        } catch (Exception e) {
            fail("No Exception should be caught at this point");
        }
    }

    @Test
    public void testReaderOneBorrowRecords() {
        JsonReader a = new JsonReader("./data/testReaderOneBorrowRecords.json");
        Library b;
        try {
            b = a.read();
            assertEquals(3,b.sizeOfCollection());
            assertEquals(1,b.sizeOfBorrowRecord());
        }  catch (Exception e) {
            fail("No Exception should be caught at this point");
        }
    }
}
