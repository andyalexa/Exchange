package com.andyalexa.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener{

    JButton button;
    JLabel label;
    JTextField textField;


    public MainFrame() {
        this.setTitle("Exchange Rates - Alexa Andy 2020");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        label = new JLabel("Vă rugăm introduceți anul:");

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(66,27));
        textField.setFont(new Font("Consolas", Font.PLAIN, 17));

        button = new JButton("Afișează");
        button.addActionListener(this);


        this.add(label);
        this.add(textField);
        this.add(button);
        this.pack();
        this.setSize(new Dimension(400,85));
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button) {
            if(textField.isValid()) {
                int year  = Integer.parseInt(textField.getText());
                try {
                    this.dispose();
                    new OutputFrame(year);
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}
