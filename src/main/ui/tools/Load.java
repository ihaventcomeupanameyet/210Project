package ui.tools;

import model.Library;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.LibraryGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Load extends Tool {
    private static final String data = "./data/Library.json";
    private JsonReader reader;

    public Load(Library lib, JComponent parent) {
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
            lib = reader.read();
        } catch (IOException c) {
            System.err.println("No such file:" + data + "\n");
        } catch (Exception c) {
            //
        }
    }
}
