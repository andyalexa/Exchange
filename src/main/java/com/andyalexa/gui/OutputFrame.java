package com.andyalexa.gui;

import com.andyalexa.ExchangeAPI;
import com.andyalexa.thirdparty.TextAreaOutputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;

public class OutputFrame extends JFrame implements ActionListener {

    JButton button;

    public OutputFrame(String base, String symbol, int year, boolean checkAgainstStartRate, boolean showOperations) throws IOException {
        this.setTitle("Exchange Rates - Alexa Andy 2020");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea ta = new JTextArea();
        TextAreaOutputStream taos = new TextAreaOutputStream( ta, 999 );
        PrintStream ps = new PrintStream( taos );
        System.setOut( ps );
        System.setErr( ps );

        button = new JButton("Inapoi");
        button.addActionListener(this);

        this.add( new JScrollPane( ta )  );
        this.add(button, BorderLayout.SOUTH);
        this.pack();
        this.setSize(800,600);
        this.setLocationRelativeTo(null);

        ExchangeAPI.printRatesForYear(base, symbol, year, checkAgainstStartRate, showOperations);
        this.setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            this.dispose();
            new MainFrame();
        }
    }
}
