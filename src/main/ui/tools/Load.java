package ui.tools;

import model.Library;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.LibraryGUI;
import ui.tools.frames.PopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Load extends Tool {
    private static final String data = "./data/Library.json";
    private JsonReader reader;

    public Load(LibraryGUI lib, JComponent parent) {
        super(lib, parent);
        reader = new JsonReader(data);
    }


    @Override
    public String getLabel() {
        return "Load from file";
    }

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
