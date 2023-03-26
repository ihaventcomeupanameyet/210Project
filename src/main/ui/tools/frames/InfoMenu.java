package ui.tools.frames;

import model.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoMenu extends JFrame implements ActionListener {
    private JButton allBook;
    private JButton availableBook;
    private JButton borrowRecord;
    private Library lib;

    public InfoMenu(Library lib) {
        this.lib = lib;
        allBook = new JButton("List all collection");
        availableBook = new JButton("List available book");
        borrowRecord = new JButton("List borrow record");
        setLayout(new GridLayout(0,1));
        setMinimumSize(new Dimension(300,400));
        add(allBook);
        add(availableBook);
        add(borrowRecord);
        allBook.addActionListener(this);
        availableBook.addActionListener(this);
        borrowRecord.addActionListener(this);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a;
        if (e.getSource() == allBook) {
            a = lib.listAllBooks();
            new PopUp("Collection Info", a, "Got it!");
        } else if (e.getSource() == availableBook) {
            a = lib.listAvailableBooks();
            new PopUp("Available books Info", a, "Got it!");
        } else {
            a = lib.listBorrowRecords();
            new PopUp("Borrow Records", a, "Got it!");
        }
    }
}
