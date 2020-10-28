package com.andyalexa;

import com.andyalexa.gui.MainFrame;


import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class App {

    public static final int START_YEAR = 2006;
    public static final int END_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    public static final String[] SYMBOLS = {"CAD",
            "HKD",
            "ISK",
            "PHP",
            "DKK",
            "HUF",
            "CZK",
            "AUD",
            "RON",
            "SEK",
            "IDR",
            "INR",
            "BRL",
            "RUB",
            "HRK",
            "JPY",
            "THB",
            "CHF",
            "SGD",
            "PLN",
            "BGN",
            "TRY",
            "CNY",
            "NOK",
            "NZD",
            "ZAR",
            "USD",
            "MXN",
            "ILS",
            "GBP",
            "KRW",
            "MYR",
            "EUR"};

    public static void main(String[] args) throws IOException {

        if (args.length > 0 && args[0].contains("no_gui")) {
            Scanner scanner = new Scanner(System.in);
            int year;

            while (true) {
                System.out.println("Va rugam introduceti anul (" + App.START_YEAR + "-" + App.END_YEAR + "):");

                String input = scanner.next();
                try {
                    year = Integer.parseInt(input);
                    if (year >= START_YEAR && year < END_YEAR + 1) {
                        break;
                    }
                } catch (NumberFormatException ne) {
                    System.out.println("Va rugam introduceti o valoare corecta!");
                }
           }

            int option;
            while (true) {
                System.out.println("Va rugam selectati o optiune:");
                System.out.println("---------------------------------------------------------");
                System.out.println("1. Afiseaza rezultatul si operatiile");
                System.out.println("2. Afiseaza rezultatul fara operatii");
                System.out.println("3. Afiseaza diferenta dintre rata zilnica si cea initiala");


                String input = scanner.next();
                try {
                    option = Integer.parseInt(input);
                    if (option >= 1  && option < 4) {
                        break;
                    }
                } catch (NumberFormatException ne) {
                    System.out.println("Valoare incorecta!");
                }
            }

            String base = Utility.getCurrency(scanner, "Va rugam selectati moneda de baza");
            String symbol = Utility.getCurrency(scanner, "Va rugam selectati moneda de comparatie");


            boolean showOperations = option == 1;
            boolean checkAgainstStartRate = option == 3;

            ExchangeAPI.printRatesForYear(base, symbol, year, checkAgainstStartRate, showOperations);
        } else  {
            new MainFrame();
        }
    }
}
