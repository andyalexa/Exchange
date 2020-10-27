import com.andyalexa.exchangerates.ExchangeAPI;
import com.andyalexa.exchangerates.ExchangeResponse;
import com.andyalexa.jsonparsing.Json;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vă rugăm introduceți anul: ");
        int year = scanner.nextInt();

        JsonNode node = Json.parse(ExchangeAPI.getJsonString(year));
        ExchangeResponse test = Json.fromJson(node, ExchangeResponse.class);

        System.out.println(test.getRates());
    }


}
