import com.andyalexa.exchangerates.ExchangeAPI;
import com.andyalexa.jsonparsing.Json;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vă rugăm introduceți anul: ");
        int year = scanner.nextInt();

        JsonNode node = Json.parse(ExchangeAPI.getJsonString(year));

        // ExchangeResponse response = Json.fromJson(node, ExchangeResponse.class);
        //System.out.println(response.getRates().toPrettyString());

        Map<String, JsonNode> rates = Json.getMapFromNode(node.get("rates"));

        rates.forEach((k,v) -> System.out.println("Date:" + k + " Value: " + v.get("RON")));
    }


}
