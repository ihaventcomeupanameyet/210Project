package ui.tools;

import ui.LibraryGUI;
import ui.tools.frames.NewRecordForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

// add record button
public class AddRecord extends Tool {

    // EFFECTS: create an add record button
    public AddRecord(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
    }

    // EFFECTS: return label of the button
    @Override
    public String getLabel() {
        return "Add borrow record";
    }

    // MODIFIES: this
    // EFFECTS: load a form for user to add a new borrow record
    @Override
    public void actionPerformed(ActionEvent e) {
        new NewRecordForm(lib.getLib());
    }
}
