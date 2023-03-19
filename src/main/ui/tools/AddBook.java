package ui.tools;

import model.Library;
import ui.LibraryGUI;
import ui.tools.frames.NewBook;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddBook extends Tool {

    public AddBook(Library lib, JComponent parent) {
        super(lib, parent);
    }

    @Override
    public String getLabel() {
        return "Add book to library";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new NewBook(lib);
    }
}
