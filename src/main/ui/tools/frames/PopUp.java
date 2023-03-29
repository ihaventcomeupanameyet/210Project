package ui.tools.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUp extends JFrame implements ActionListener {

    // EFFECTS: create a popup with given title, message and button label
    public PopUp(String title, String message, String buttonLabel) {
        super(title);
        JPanel a = new JPanel();
        JLabel b = new JLabel();
        JButton c = new JButton(buttonLabel);
        setLayout(new BorderLayout());
        b.setText("<html>" + message.replaceAll("\n","<br/>") + "</html>");
        a.add(b);
        add(a,BorderLayout.NORTH);
        add(c,BorderLayout.SOUTH);
        c.addActionListener(this);
        //setMinimumSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    // EFFECT: close the popup once a button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
