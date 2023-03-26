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
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initTools() {
        JPanel toolArea = new JPanel();
        toolArea.setLayout(new GridLayout(0,1));
        toolArea.setSize(new Dimension(0, 0));
        add(toolArea, BorderLayout.CENTER);

        Save save = new Save(this, toolArea);
        toolList.add(save);

        Load load = new Load(this, toolArea);
        toolList.add(load);

        AddBook addBook = new AddBook(this, toolArea);
        toolList.add(addBook);

        ListInfo info = new ListInfo(this,toolArea);
        toolList.add(info);

        AddRecord addRecord = new AddRecord(this,toolArea);
        toolList.add(addRecord);

        RemoveBook remove = new RemoveBook(this,toolArea);
        toolList.add(remove);

        RemoveRecord removeRecord = new RemoveRecord(this,toolArea);
        toolList.add(removeRecord);
    }

    public Library getLib() {
        return lib;
    }

    public void setLib(Library lib) {
        this.lib = lib;
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}
