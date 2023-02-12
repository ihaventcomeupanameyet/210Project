package ui;

import exception.DuplicateBookException;
import exception.NoBookException;
import model.*;

import java.util.Scanner;

public class LibraryAPP {
    private Library lib;
    private Scanner input;
    private Boolean run;
    private String command;

    // EFFECTS: run the library app
    public LibraryAPP() {
        init();
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: process user input
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void runApp() {
        while (run) {
            displayMenu();
            command = input.nextLine().toLowerCase();
            if  (command.equals("a")) {
                try {
                    addBook();
                } catch (Exception e) {
                    System.err.println("Year should be a integer!\n");
                }
            } else if (command.equals("b")) {
                removeBook();
            } else if (command.equals("c")) {
                listInfo();
            } else if (command.equals("d")) {
                addBorrowRecord();
            } else if (command.equals("e")) {
                info();
            } else if (command.equals("f")) {
                returnBook();
            } else if (command.equals("q")) {
                run = false;
            } else {
                System.out.println("Invalid command, try again.");
            }
        }
        System.out.println("Program Terminated, Good Bye.\n");
    }

    // MODIFIES: this
    // EFFECTS: initialize library
    private void init() {
        lib = new Library();
        input = new Scanner(System.in);
        run = true;
        command = null;
        Book b = new Book("Discrete Math", "UBC Book store", "Math Nerd", 2020);
        Book c = new Book("Linear Algebra", "UBC Book store", "Math Nerd", 2020);
        Book d = new Book("Calculus III", "UBC Book store", "Math Nerd", 2020);
        try {
            lib.addBook(b);
        } catch (DuplicateBookException e) {
            //
        }
        try {
            lib.addBook(c);
        } catch (DuplicateBookException e) {
            //
        }
        try {
            lib.addBook(d);
        } catch (DuplicateBookException e) {
            //
        }
    }

    // EFFECTS: Display menu
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add a new book to library");
        System.out.println("\tb -> Remove a book from library");
        System.out.println("\tc -> List a book's detailed info");
        System.out.println("\td -> Add a borrow record");
        System.out.println("\te -> List detailed info about library collection");
        System.out.println("\tf -> Remove a borrow record");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS:  try to add new book, will do nothing if book with same name is
    // already in the library
    private void addBook() {
        String name;
        String publisher;
        String authorName;
        int publishYear;
        System.out.println("Enter book name: ");
        name = input.nextLine();
        System.out.println("Enter publisher: ");
        publisher = input.nextLine();
        System.out.println("Enter author name: ");
        authorName = input.nextLine();
        System.out.println("Enter year published: ");
        publishYear = Integer.parseInt(input.nextLine());
        Book b = new Book(name,publisher,authorName,publishYear);
        try {
            lib.addBook(b);
        } catch (DuplicateBookException e) {
            System.err.println("We had this book already!\n");
        }
    }

    // MODIFIES: this
    // EFFECTS:  try to remove a book, will do nothing if book is not available or not in the library
    private void removeBook() {
        String name;
        System.out.println("Enter book name: ");
        name = input.nextLine();
        try {
            if (lib.removeBook(name))  {
                System.out.println("Book remove successfully!\n");
            } else {
                System.out.println("Book remove attempt fails since the book is not available now.\n");
            }
        } catch (NoBookException e) {
            System.err.println("Given book name can not be found.\n");
        }
    }

    // EFFECTS: try to list a book's info with given name, will do nothing if book can't be found.
    private void listInfo() {
        String name;
        System.out.println("Enter book name: ");
        name = input.nextLine();
        try {
            System.out.println(lib.listBookInfo(name) + "\n");
        } catch (NoBookException e) {
            System.err.println("Given book name can not be found. \n");
        }
    }

    // MODIFIES: this
    // EFFECTS: try to add a borrow record
    private void addBorrowRecord() {
        String name;
        String bookName;
        System.out.println("Enter borrower's name: ");
        name = input.nextLine();
        System.out.println("Enter book name: ");
        bookName = input.nextLine();
        BorrowRecord a = new BorrowRecord(name,bookName);
        try {
            if (lib.addBorrowRecord(a)) {
                System.out.println("Record added!");
            } else {
                System.out.println("Book requested is currently not available");
            }
        } catch (NoBookException e) {
            System.err.println("Given book name can not be found. \n");
        }
    }

    // EFFECTS: Listing different info related to library base on user input
    private void info() {
        String command;
        Boolean run = true;
        while (run) {
            displayInfoMenu();
            command = input.nextLine().toLowerCase();
            if (command.equals("a")) {
                System.out.println(lib.listAllBooks());
                run = false;
            } else if (command.equals("b")) {
                System.out.println(lib.listBorrowRecords());
                run = false;
            } else if (command.equals("c")) {
                System.out.println(lib.listAvailableBooks());
                run = false;
            } else if (command.equals("q")) {
                run = false;
            } else {
                System.out.println("Invalid command, try again.");
            }
        }
    }

    // EFFECTS: print an info option menu on screen
    private void displayInfoMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> List all book belongs to the library");
        System.out.println("\tb -> List all borrowed book with it's expected return date");
        System.out.println("\tc -> List all book that is available at the moment");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: try to return a book and delete borrow record from library
    private void returnBook() {
        String bookName;
        System.out.println("Enter book name: ");
        bookName = input.nextLine();
        try {
            if (lib.returnBook(bookName)) {
                System.out.println("Book return within expected return date.\n");
            } else {
                System.out.println("Book return after expected return date, "
                        + lib.getFine() + "dollar fine is applied.\n");
            }
        } catch (NoBookException e) {
            System.err.println("Given book name can not be found in borrow record. \n");
        }
    }
}
