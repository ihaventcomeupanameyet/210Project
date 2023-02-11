package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    Book a;
    @BeforeEach
    void setUp() {
        a = new Book("Discrete Math", "UBC Book store", "Math Nerd", 2020);
    }

    @Test
    void TestConstructor() {
        assertEquals("Discrete Math", a.getName());
        assertEquals("UBC Book store", a.getPublisher());
        assertEquals("Math Nerd", a.getAuthorName());
        assertEquals(2020, a.getYearPublished());
        assertTrue(a.isAvailable());
    }

    @Test
    void TestSetAvailable() {
        assertTrue(a.isAvailable());
        a.setAvailable(false);
        assertFalse(a.isAvailable());
    }

    @Test
    void TestGetInfo() {
        String b = "Book name: " + a.getName() + " Author:"
                + a.getAuthorName() + " Publisher: " + a.getPublisher() + " Year published: " + a.getYearPublished();
        assertEquals(b, a.getInfo());
    }
}
