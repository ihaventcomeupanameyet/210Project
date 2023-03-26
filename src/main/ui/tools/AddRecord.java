package ui.tools;

import ui.LibraryGUI;
import ui.tools.frames.NewRecordForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddRecord extends Tool {

    public AddRecord(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
    }

    @Override
    public String getLabel() {
        return "Add borrow record";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new NewRecordForm(lib.getLib());
    }
}
