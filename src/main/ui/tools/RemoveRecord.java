package ui.tools;

import ui.LibraryGUI;
import ui.tools.frames.RemoveRecordForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveRecord extends Tool {

    public RemoveRecord(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
    }

    @Override
    public String getLabel() {
        return "Remove record";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new RemoveRecordForm(lib.getLib());
    }
}
