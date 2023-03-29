package ui.tools.frames;

import exception.DuplicateBookException;
import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class NewBook extends JFrame implements ActionListener {
    private JButton add;
    private Library lib;
    private JTextField name;
    private JTextField author;
    private JTextField publisher;
    private JTextField yearPublished;
    private JPanel panel;

    // form to add book to the library
    public NewBook(Library lib) {
        this.lib = lib;
        panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        panel.setSize(new Dimension(0, 0));
        setLayout(new BorderLayout());
        setResizable(false);
        setTextField();
        try {
            JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File("./data/Library.jpg"))));
            label.setPreferredSize(new Dimension(300,300));
            add(label);
        } catch (IOException e) {
            new JOptionPane().showMessageDialog(this,
                    "Fail to load back ground", "No background!", JOptionPane.PLAIN_MESSAGE);
        }
        add = new JButton("Add to library");
        add.addActionListener(this);
        add(panel,BorderLayout.NORTH);
        add(add, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    // MODIFIES: this
    // EFFECTS: Set size and label for the text field
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void setTextField() {
        Dimension textSize = new Dimension(250,40);
        name = new JTextField();
        name.setPreferredSize(textSize);
        JLabel label = new JLabel("Book name: ");
        label.setLabelFor(name);
        panel.add(label);
        panel.add(name);
        author = new JTextField();
        author.setPreferredSize(textSize);
        label = new JLabel("Author name: ");
        label.setLabelFor(author);
        panel.add(label);
        panel.add(author);
        publisher = new JTextField();
        publisher.setPreferredSize(textSize);
        label = new JLabel("publisher: ");
        label.setLabelFor(publisher);
        panel.add(label);
        panel.add(publisher);
        yearPublished = new JTextField();
        yearPublished.setPreferredSize(textSize);
        label = new JLabel("Year published: ");
        label.setLabelFor(yearPublished);
        panel.add(label);
        panel.add(yearPublished);
    }

    // MODIFIES: this
    // EFFECTS: add new book to the library, unless there is already a book with same name or invalid input detected
    // for the published year
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Book temp = new Book(name.getText(), publisher.getText(),
                    author.getText(), Integer.parseInt(yearPublished.getText()));
            lib.addBook(temp);
            new JOptionPane().showMessageDialog(this,
                    "New book added!", "Done", JOptionPane.PLAIN_MESSAGE);
            dispose();
        } catch (DuplicateBookException ex) {
            new JOptionPane().showMessageDialog(this,
                    "We already have this book!", "Fail to add to library", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception c) {
            new JOptionPane().showMessageDialog(this,
                    "Should input integer for published year", "Bad input", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
