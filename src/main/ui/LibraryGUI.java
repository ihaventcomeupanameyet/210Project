package ui;

import model.Event;
import model.EventLog;
import model.Library;
import ui.tools.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class LibraryGUI extends JFrame implements WindowListener {
    private static final int width = 1000;
    private static final int height = 750;
    private List<Tool> toolList;
    private Library lib;

    public LibraryGUI() {
        toolList = new ArrayList<>();
        lib = new Library();
        setTitle("Library APP");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
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

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        EventLog a = EventLog.getInstance();
        for (Event b : a) {
            System.out.println(b + "\n");
        }
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
