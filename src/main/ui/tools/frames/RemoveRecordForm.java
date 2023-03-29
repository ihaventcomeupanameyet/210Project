package ui.tools.frames;

import exception.NoBookException;
import model.BorrowRecord;
import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

// form to return book
public class RemoveRecordForm extends Form {

    // create a remove record form
    public RemoveRecordForm(Library lib) {
        super(lib, "Remove record");
    }

    // MODIFIES: this
    // EFFECTS: return a book to the library
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Boolean a = lib.returnBook((String) box.getSelectedItem());
            if (a) {
                new PopUp("Return success",
                        "Book return within expected return date.", "Got it!");
            } else {
                new PopUp("Return success",
                        "Book return after expected return date, "
                                + lib.getFine() + "dollar fine is applied.", "Got it!");
            }
            dispose();
        } catch (NoBookException ex) {
            new JOptionPane().showMessageDialog(this,
                    "Fail to return book", "No book found!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: populate the drop-down menu with book names that is not available(i.e. borrowed by someone)
    @Override
    protected void populateList() {
        List<BorrowRecord> temp = lib.getRecords();
        for (BorrowRecord a : temp) {
            box.addItem(a.getBookName());
        }
    }

    @Override
    protected void moreComponent(JPanel panel) {

    }
}
