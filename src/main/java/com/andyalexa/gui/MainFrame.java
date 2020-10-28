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

        label = new JLabel("Vă rugăm introduceți anul (1999-2020):");

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
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button) {
                try {
                    int year  = Integer.parseInt(textField.getText());
                    if (year >= 1999 && year < 2021) {
                        this.dispose();
                        new OutputFrame(year);
                    } else {
                        textField.setText("");
                        JOptionPane.showMessageDialog(this, "Anul trebuie sa fie intre 1999 si 2020");
                    }
                } catch (NumberFormatException | IOException ex) {
                   textField.setText("");
                    JOptionPane.showMessageDialog(this, "Va rugam introduceti o valoare corecta!");
                }
        }
    }
}
