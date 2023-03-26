package ui.tools.frames;

import exception.NoBookException;
import model.Book;
import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class RemoveBookForm extends Form {
    public RemoveBookForm(Library lib) {
        super(lib, "Remove book");
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            boolean a = lib.removeBook((String) box.getSelectedItem());
            if (a) {
                new PopUp("Remove success",
                        "You have removed this book from our collection", "Got it!");
            } else {
                new PopUp("Remove fail",
                        "This book is currently not available, ","Got it!");
            }
        } catch (NoBookException ex) {
            new JOptionPane().showMessageDialog(this,
                    "Fail to remove book", "No book found!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
