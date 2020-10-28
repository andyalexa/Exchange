package com.andyalexa;

import java.util.Scanner;

public class Utility {
    public static boolean contains(String[] arr, String targetValue) {
        for (String s: arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }
    public static void  printArray(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }

    public static String getCurrency(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            System.out.println("Introduceti codul din 3 litere sau tastati \"ajutor\" pentru afisarea tuturor monezilor:");

            String input = scanner.next();

            if (Utility.contains(App.SYMBOLS, input)) {
                return input;
            } else if (input.equals("ajutor")) {
                System.out.println("---------------");
                Utility.printArray(App.SYMBOLS);
                System.out.println("---------------");
            }
        }
    }
}
