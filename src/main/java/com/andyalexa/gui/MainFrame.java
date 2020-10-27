package com.andyalexa.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JButton button;
    JTextField textField;


    public MainFrame() {
        this.setTitle("Exchange Rates - Alexa Andy 2020");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JLabel label = new JLabel("Vă rugăm introduceți anul:");
        button = new JButton("Afișează");

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(66,27));
        textField.setFont(new Font("Consolas", Font.PLAIN, 17));

        this.add(textField);
        this.add(label);
        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            button.setEnabled(false);
            textField.setEditable(false);
        }
    }
}
