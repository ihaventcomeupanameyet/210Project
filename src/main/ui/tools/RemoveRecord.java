package ui.tools;

import ui.LibraryGUI;
import ui.tools.frames.RemoveRecordForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

// Remove record button
public class RemoveRecord extends Tool {

    // EFFECTS: create a remove record button
    public RemoveRecord(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
    }

    // EFFECTS: return label of the button
    @Override
    public String getLabel() {
        return "Remove record";
    }

    // MODIFIES: this
    // EFFECTS: load a from for user inorder to remove a record
    @Override
    public void actionPerformed(ActionEvent e) {
        new RemoveRecordForm(lib.getLib());
    }
}
