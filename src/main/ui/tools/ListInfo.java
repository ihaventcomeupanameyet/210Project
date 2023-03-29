package ui.tools;

import ui.LibraryGUI;
import ui.tools.frames.InfoMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;

// list info button
public class ListInfo extends Tool {

    //EFFECTS: create a list info button
    public ListInfo(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
    }

    //EFFECTS: return label of the button
    @Override
    public String getLabel() {
        return "List information";
    }

    // EFFECTS: load a form to list detail information about the library
    @Override
    public void actionPerformed(ActionEvent e) {
        new InfoMenu(lib.getLib());
    }
}
