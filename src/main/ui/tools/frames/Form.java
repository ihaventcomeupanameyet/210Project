package ui.tools.frames;

import model.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Form that includes a drop-down menu
public abstract class Form extends JFrame implements ActionListener {
    protected Library lib;
    protected JComboBox<String> box;
    protected JButton confirm;

    // EFFECTS: create a form
    public Form(Library lib, String text) {
        this.lib = lib;
        box = new JComboBox<>();
        populateList();
        setLayout(new BorderLayout());
        JPanel b = new JPanel();
        b.setLayout(new FlowLayout());
        JLabel label = new JLabel();
        label.setText("Select book");
        label.setLabelFor(box);
        b.add(label);
        b.add(box);
        moreComponent(b);
        add(b, BorderLayout.NORTH);
        confirm = new JButton(text);
        confirm.addActionListener(this);
        add(confirm, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: populate the list
    protected abstract void populateList();

    // MODIFIES: this
    // EFFECTS: add more components to the form if needed
    protected abstract void moreComponent(JPanel panel);
}
