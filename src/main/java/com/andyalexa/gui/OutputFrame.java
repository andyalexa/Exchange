package com.andyalexa.gui;

import com.andyalexa.thirdparty.TextAreaOutputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class OutputFrame extends JFrame implements ActionListener {

    public OutputFrame() throws InterruptedException{
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

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
