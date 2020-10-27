import com.andyalexa.exchangerates.ExchangeAPI;
import com.andyalexa.gui.OutputFrame;
import com.andyalexa.jsonparsing.Json;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

public class App {


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws IOException, InterruptedException {

        if (false) {
            // Console Input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Va rugam introduceti anul: ");
            int year = scanner.nextInt();

            // Date formatting
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            // Store rate information in a Map
            JsonNode node = Json.parse(ExchangeAPI.getJsonString(year));
            TreeMap<Date, JsonNode> rates = Json.getMapFromNode(node.get("rates"));

            double startRate = rates.firstEntry().getValue().get("RON").asDouble();

            rates.forEach((k,v) -> {
                String color = ANSI_WHITE;

                if (v.get("RON").asDouble() > startRate) {
                    color = ANSI_GREEN;
                } else if (v.get("RON").asDouble() < startRate) {
                    color = ANSI_RED;
                }
                System.out.println(color + "Data: " + simpleDateFormat.format(k) + " Rata: " + v.get("RON"));
            });
        } else {
            // MainFrame frame = new MainFrame();
            OutputFrame test = new OutputFrame();

            // Date formatting
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            // Store rate information in a Map
            JsonNode node = Json.parse(ExchangeAPI.getJsonString(2018));
            TreeMap<Date, JsonNode> rates = Json.getMapFromNode(node.get("rates"));

            double startRate = rates.firstEntry().getValue().get("RON").asDouble();

            rates.forEach((k,v) -> {
                String symbol = "(==) ";
                if (v.get("RON").asDouble() > startRate) {
                    symbol = "(/\\) ";
                } else if (v.get("RON").asDouble() < startRate) {
                    symbol = "(\\/) ";
                }
                System.out.println(symbol + "Data: " + simpleDateFormat.format(k) + " Rata: " + v.get("RON"));
            });
        }

    }
}
