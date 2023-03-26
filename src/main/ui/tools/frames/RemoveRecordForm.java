package ui.tools.frames;

import exception.NoBookException;
import model.BorrowRecord;
import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class RemoveRecordForm extends Form {

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public RemoveRecordForm(Library lib) {
        super(lib, "Remove record");
    }

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
