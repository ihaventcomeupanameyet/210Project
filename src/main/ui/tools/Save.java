package ui.tools;

import model.Library;
import persistence.JsonWriter;
import ui.LibraryGUI;
import ui.tools.frames.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class Save extends Tool {
    private static final String data = "./data/Library.json";
    private JsonWriter writer;

    public Save(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
        writer = new JsonWriter("./data/Library.json");
    }

    @Override
    public String getLabel() {
        return "Save changes";
    }

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
