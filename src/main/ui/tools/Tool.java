package ui.tools;

import ui.LibraryGUI;

import javax.swing.*;
import java.awt.event.ActionListener;

// class level comment: abstract class for all the button in the main menu
public abstract class Tool implements ActionListener {
    protected JButton button;
    protected LibraryGUI lib;

    // EFFECTS: create a new Tool
    public Tool(LibraryGUI lib, JComponent parent) {
        this.lib = lib;
        button = new JButton(getLabel());
        button.addActionListener(this);
        parent.add(button);
    }

    //EFFECTS: return the label of the tool
    public abstract String getLabel();
}
