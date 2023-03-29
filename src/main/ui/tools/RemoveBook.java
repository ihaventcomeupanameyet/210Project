package ui.tools;

import ui.LibraryGUI;
import ui.tools.frames.RemoveBookForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

// remove book button
public class RemoveBook extends Tool {

    // EFFECTS: create a remove book button
    public RemoveBook(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
    }

    // EFFECTS: return label of the button
    @Override
    public String getLabel() {
        return "Remove Book";
    }

    // MODIFIES: this
    // EFFECTS: load a from for user inorder to remove a book
    @Override
    public void actionPerformed(ActionEvent e) {
        new RemoveBookForm(lib.getLib());
    }
}
