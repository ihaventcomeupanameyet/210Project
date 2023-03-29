package ui.tools;

import ui.LibraryGUI;
import ui.tools.frames.NewBook;

import javax.swing.*;
import java.awt.event.ActionEvent;

// add book button
public class AddBook extends Tool {

    // EFFECTS: create an add book button
    public AddBook(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
    }

    // EFFECTS: return label of the button
    @Override
    public String getLabel() {
        return "Add book to library";
    }

    // MODIFIES: this
    // EFFECTS: load a form for user to add a new book to the library
    @Override
    public void actionPerformed(ActionEvent e) {
        new NewBook(lib.getLib());
    }
}
