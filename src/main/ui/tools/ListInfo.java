package ui.tools;

import model.Library;
import ui.LibraryGUI;
import ui.tools.frames.InfoMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ListInfo extends Tool {

    public ListInfo(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
    }

    @Override
    public String getLabel() {
        return "List information";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new InfoMenu(lib.getLib());
    }
}
