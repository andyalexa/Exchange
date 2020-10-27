package com.andyalexa.gui;

import com.andyalexa.exchangerates.ExchangeAPI;
import com.andyalexa.thirdparty.TextAreaOutputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;

public class OutputFrame extends JFrame implements ActionListener {

    public OutputFrame(int year) throws IOException {
        this.setTitle("Exchange Rates - Alexa Andy 2020");
        this.add( new JLabel(" Output" ), BorderLayout.NORTH );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea ta = new JTextArea();
        TextAreaOutputStream taos = new TextAreaOutputStream( ta, 999 );
        PrintStream ps = new PrintStream( taos );
        System.setOut( ps );
        System.setErr( ps );


        this.add( new JScrollPane( ta )  );

        this.pack();
        this.setVisible( true );
        this.setSize(800,600);

        ExchangeAPI.printRatesForYear(year);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
