package com.andyalexa;

import com.andyalexa.gui.MainFrame;


import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        if (args.length > 0 && args[0].contains("no_gui")) {
            Scanner scanner = new Scanner(System.in);

            int year;

            while (true) {
                System.out.println("Va rugam introduceti anul: ");

                String input = scanner.next();
                try {
                    year = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException ne) {
                    System.out.println("Eroare, acesta nu este un numar valid!");
                }
           }

            ExchangeAPI.printRatesForYear(year);
        } else  {
            new MainFrame();
        }

    }
}
