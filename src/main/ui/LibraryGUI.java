package ui;

import model.Library;
import ui.tools.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryGUI extends JFrame {
    private static final int width = 1000;
    private static final int height = 750;
    private List<Tool> toolList;
    private Library lib;

    public LibraryGUI() {
        toolList = new ArrayList<>();
        lib = new Library();
        setTitle("Library APP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(width,height));
        initTools();
        setVisible(true);
    }

    public void initTools() {
        JPanel toolArea = new JPanel();
        toolArea.setLayout(new GridLayout(0,1));
        toolArea.setSize(new Dimension(0, 0));
        add(toolArea, BorderLayout.CENTER);

        Save save = new Save(lib, toolArea);
        toolList.add(save);

        Load load = new Load(lib, toolArea);
        toolList.add(load);

        AddBook addBook = new AddBook(lib, toolArea);
        toolList.add(addBook);
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}
