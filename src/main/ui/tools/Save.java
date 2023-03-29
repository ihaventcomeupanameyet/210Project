package ui.tools;

import persistence.JsonWriter;
import ui.LibraryGUI;
import ui.tools.frames.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

// class level comment: Button for save changes to a file
public class Save extends Tool {
    private static final String data = "./data/Library.json";
    private JsonWriter writer;

    // EFFECTS: create a save button
    public Save(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
        writer = new JsonWriter("./data/Library.json");
    }

    // EFFECTS: return label of the button
    @Override
    public String getLabel() {
        return "Save changes";
    }

    // MODIFIES: this
    // EFFECTS: save change to a file
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            writer.open();
            writer.write(lib.getLib());
            writer.close();
            new PopUp("Save success",
                    "Save change to: " + data, "Got it!");
        } catch (FileNotFoundException f) {
            System.err.println("No such file:" + data + "\n");
        }
    }
}
