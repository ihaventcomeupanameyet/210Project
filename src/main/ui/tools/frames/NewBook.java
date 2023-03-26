package ui.tools.frames;

import exception.DuplicateBookException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBook extends JFrame implements ActionListener {
    private JButton add;
    private Library lib;
    private JTextField name;
    private JTextField author;
    private JTextField publisher;
    private JTextField yearPublished;
    private JPanel panel;

    public NewBook(Library lib) {
        this.lib = lib;
        panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        panel.setSize(new Dimension(0, 0));
        setLayout(new BorderLayout());
        //setMinimumSize(new Dimension(300, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTextField();
        add = new JButton("Add to library");
        add.addActionListener(this);
        add(panel,BorderLayout.NORTH);
        add(add, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


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
                    "Should input integer for publish year", "Bad input", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
