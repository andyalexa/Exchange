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
    JComboBox baseComboBox;
    JComboBox symbolComboBox;

    public MainFrame() {
        this.setTitle("Exchange Rates - Alexa Andy 2020");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        label = new JLabel("Vă rugăm introduceți anul (" + App.START_YEAR + "-" + App.END_YEAR + "):");

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(66,27));
        textField.setFont(new Font("Consolas", Font.PLAIN, 17));

        String[] options = {"Afișează rezultatul și operațiile",
                            "Afisează rezultatul fără operații",
                            "Afișează diferența dintre rata zilnică și cea inițială"};

        button = new JButton("Ok");
        button.addActionListener(this);

        comboBox = new JComboBox(options);
        baseComboBox = new JComboBox(App.SYMBOLS);
        symbolComboBox = new JComboBox(App.SYMBOLS);

        baseComboBox.setSelectedItem("EUR");
        symbolComboBox.setSelectedItem("RON");

        this.add(label);
        this.add(textField);
        this.add(baseComboBox);
        this.add(symbolComboBox);
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
                String base = baseComboBox.getSelectedItem().toString();
                String symbol = symbolComboBox.getSelectedItem().toString();
                try {
                    int year  = Integer.parseInt(textField.getText());
                    if (year >= App.START_YEAR && year < App.END_YEAR + 1) {
                        boolean checkAgainstStartRate = option == 2;
                        boolean showOperations = option == 0;

                        if (!base.equals(symbol)) {
                            this.dispose();
                            new OutputFrame(base, symbol, year, checkAgainstStartRate, showOperations);
                        } else {
                            JOptionPane.showMessageDialog(this, "Selectează două perechi de monezi diferite!");
                        }
                    } else {
                        textField.setText("");
                        JOptionPane.showMessageDialog(this, "Anul trebuie sa fie între " + App.START_YEAR + " și " + App.END_YEAR + "!");
                    }
                } catch (NumberFormatException | IOException ex) {
                    textField.setText("");
                    JOptionPane.showMessageDialog(this, "Va rugăm introduceti o valoare corectă!");
                }
        }
    }
}
