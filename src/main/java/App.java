import com.andyalexa.exchangerates.ExchangeAPI;
import com.andyalexa.gui.MainFrame;


import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Va rugam introduceti anul: ");
            int year = scanner.nextInt();

            ExchangeAPI.printRatesForYear(year);
        } else {
            new MainFrame();
        }

    }
}
