package com.andyalexa.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener{

    JButton button;
    JTextField textField;


    public MainFrame() {
        this.setTitle("Exchange Rates - Alexa Andy 2020");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JLabel label = new JLabel("Vă rugăm introduceți anul:");
        button = new JButton("Afișează");
        button.addActionListener(this);

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
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button) {
            if(textField.isValid()) {
                int year  = Integer.parseInt(textField.getText());
                try {
                    this.dispose();
                    OutputFrame outputFrame = new OutputFrame(year);
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}
