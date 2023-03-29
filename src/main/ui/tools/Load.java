package ui.tools;

import persistence.JsonReader;
import ui.LibraryGUI;
import ui.tools.frames.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

// load file button
public class Load extends Tool {
    private static final String data = "./data/Library.json";
    private JsonReader reader;

    // EFFECTS: create a load file button
    public Load(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
        reader = new JsonReader(data);
    }


    // EFFECTS: return label of the button
    @Override
    public String getLabel() {
        return "Load from file";
    }

    // MODIFIES: this
    // EFFECTS: Load library from a file
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            lib.setLib(reader.read());
            new PopUp("Load success",
                    "Load file from: " + data, "Got it!");
        } catch (IOException c) {
            System.err.println("No such file:" + data + "\n");
        } catch (Exception c) {
            //
        }
    }
}
