package ui.tools.frames;

import exception.NoBookException;
import model.Book;
import model.BorrowRecord;
import model.Library;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

// Form to add a new borrow record
public class NewRecordForm extends Form {
    private JTextField name;

    // EFFECTS: create a new record form
    public NewRecordForm(Library lib) {
        super(lib, "New borrow record");
    }

    // MODIFIES: this
    // EFFECTS: add a borrow record to the library with given name in the text field and selected book
    @Override
    public void actionPerformed(ActionEvent e) {
        BorrowRecord a = new BorrowRecord(name.getText(), (String) box.getSelectedItem());
        try {
            lib.addBorrowRecord(a);
            new JOptionPane().showMessageDialog(this,
                    "Added borrow record!", "Done", JOptionPane.PLAIN_MESSAGE);
            dispose();
        } catch (NoBookException ex) {
            new JOptionPane().showMessageDialog(this,
                    "Fail to add to borrow record", "No book found!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: populate the drop-down menu with book names that is available
    @Override
    protected void populateList() {
        List<Book> temp = lib.getAllBooks();
        for (Book a : temp) {
            if (a.isAvailable()) {
                box.addItem(a.getName());
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: set size,label of text field and add it to the panel
    @Override
    protected void moreComponent(JPanel panel) {
        Dimension textSize = new Dimension(250,40);
        name = new JTextField();
        name.setPreferredSize(textSize);
        JLabel label = new JLabel();
        label.setText("Enter borrower's name: ");
        label.setLabelFor(name);
        panel.add(label);
        panel.add(name);
        try {
            label = new JLabel(new ImageIcon(ImageIO.read(new File("./data/Record.jpg"))));
            label.setPreferredSize(new Dimension(300,300));
            panel.add(label);
        } catch (IOException e) {
            new JOptionPane().showMessageDialog(this,
                    "Fail to load back ground", "No background!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
