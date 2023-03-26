package ui.tools;

import model.Library;
import ui.LibraryGUI;
import ui.tools.frames.Form;
import ui.tools.frames.RemoveBookForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveBook extends Tool {

    public RemoveBook(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
    }

    @Override
    public String getLabel() {
        return "Remove Book";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new RemoveBookForm(lib.getLib());
    }
}
