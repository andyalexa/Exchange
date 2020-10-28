package com.andyalexa.gui;

import com.andyalexa.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener{

    JButton button;
    JLabel label;
    JTextField textField;
    JComboBox comboBox;

    public MainFrame() {
        this.setTitle("Exchange Rates - Alexa Andy 2020");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        label = new JLabel("Vă rugăm introduceți anul (" + App.START_YEAR + "-" + App.END_YEAR + "):");

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(66,27));
        textField.setFont(new Font("Consolas", Font.PLAIN, 17));

        String[] options = {"Afisează diferența in comparație cu rata de început", "Afișează diferența succesivă"};
        button = new JButton("Ok");
        button.addActionListener(this);

        comboBox = new JComboBox(options);

        this.add(label);
        this.add(textField);
        this.add(comboBox);
        this.add(button);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button) {
                int option = comboBox.getSelectedIndex();
                try {
                    int year  = Integer.parseInt(textField.getText());
                    if (year >= App.START_YEAR && year < App.END_YEAR + 1) {
                        this.dispose();
                        boolean checkAgainstStartRate = option == 0 ? true : false;
                        new OutputFrame(year, checkAgainstStartRate);
                    } else {
                        textField.setText("");
                        JOptionPane.showMessageDialog(this, "Anul trebuie sa fie intre " + App.START_YEAR + " si " + App.END_YEAR + "!");
                    }
                } catch (NumberFormatException | IOException ex) {
                   textField.setText("");
                    JOptionPane.showMessageDialog(this, "Va rugam introduceti o valoare corecta!");
                }
        }
    }
}
