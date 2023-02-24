package persistence;

import exception.DuplicateBookException;
import exception.NoBookException;
import model.Book;
import model.BorrowRecord;
import model.Library;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

// Class that read and load the data file
// Method read and readFile cited from JsonSerializationDemo with some minor change
public class JsonReader {
    private String file;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String file) {
        this.file = file;
    }

    // EFFECTS: reads library from file and returns it;
    // throws IOException if an error occurs reading data from file, note that NoBookException
    // and DuplicateBookException will not be thrown since only valid state of program
    // can be stored
    public Library read() throws IOException, NoBookException, DuplicateBookException {
        String jsonData = readFile(file);
        JSONObject a = new JSONObject(jsonData);
        return toLibrary(a);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: Convert JSONObject to library and return it, note that NoBookException
    // and DuplicateBookException will not be thrown since only valid state of program
    // can be stored
    private Library toLibrary(JSONObject a) throws DuplicateBookException, NoBookException {
        Library b = new Library();
        addBooks(b,a.getJSONArray("allBooks"));
        addRecords(b,a.getJSONArray("records"));
        return b;
    }

    // MODIFIES: a
    // EFFECTS: covert JSON objects to book and then add them to library
    private void addBooks(Library a, JSONArray b) throws DuplicateBookException {
        for (Object c : b) {
            JSONObject d = (JSONObject) c;
            a.addBook(toBook(d));
        }
    }

    // MODIFIES: a
    // EFFECTS: covert JSON objects to borrow records and then add them to library
    private void addRecords(Library a, JSONArray b) throws NoBookException {
        for (Object c : b) {
            JSONObject d = (JSONObject) c;
            a.addBorrowRecord(toRecord(d));
        }
    }

    // EFFECTS: covert JSON objects to book and return it
    private Book toBook(JSONObject a) {
        String name = a.getString("name");
        String publisher = a.getString("publisher");
        String authorName = a.getString("authorName");
        int yearPublished = a.getInt("yearPublished");
        return new Book(name,publisher,authorName,yearPublished);
    }

    // EFFECTS: covert JSON objects to borrow record and return it
    private BorrowRecord toRecord(JSONObject a) {
        String name = a.getString("name");
        String bookName = a.getString("bookName");

        int borrowYear = a.getInt("borrowYear");
        int borrowMonth = a.getInt("borrowMonth");
        int borrowDay = a.getInt("borrowDay");

        int returnYear = a.getInt("returnYear");
        int returnMonth = a.getInt("returnMonth");
        int returnDay = a.getInt("returnDay");

        BorrowRecord b = new BorrowRecord(name,bookName);
        b.setBorrowDate(LocalDate.now().withYear(borrowYear).withMonth(borrowMonth).withDayOfMonth(borrowDay));
        b.setExpectedReturnDate(LocalDate.now().withYear(returnYear).withMonth(returnMonth).withDayOfMonth(returnDay));
        return b;
    }
}
