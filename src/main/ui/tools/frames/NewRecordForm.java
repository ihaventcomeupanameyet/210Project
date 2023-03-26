package ui.tools.frames;

import exception.NoBookException;
import model.Book;
import model.BorrowRecord;
import model.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class NewRecordForm extends Form {
    private JTextField name;

    public NewRecordForm(Library lib) {
        super(lib, "New borrow record");
    }

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

    @Override
    protected void populateList() {
        List<Book> temp = lib.getAllBooks();
        for (Book a : temp) {
            if (a.isAvailable()) {
                box.addItem(a.getName());
            }
        }
    }

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
    }
}
