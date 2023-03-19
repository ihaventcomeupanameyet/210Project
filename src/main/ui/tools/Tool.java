package ui.tools;

import model.Library;
import ui.LibraryGUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class Tool implements ActionListener {
    protected JButton button;
    protected Library lib;

    public Tool(Library lib, JComponent parent) {
        this.lib = lib;
        button = new JButton(getLabel());
        button.addActionListener(this);
        parent.add(button);
    }

    public abstract String getLabel();
}
