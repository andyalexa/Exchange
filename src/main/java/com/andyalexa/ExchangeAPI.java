package com.andyalexa;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class ExchangeAPI {

    public static String getJsonString(int year, String base , String symbol) {

        String startDate = year + "-01-01";
        String endDate = (year + 1) + "-01-01";

        String urlString = "https://api.exchangeratesapi.io/history?start_at=" + startDate + "&end_at=" + endDate + "&symbols=" + symbol +"&base=" + base;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString)).build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

    }

    public static void printRatesForYear(String base, String symbol, int year, boolean checkAgainstStartRate, boolean showOperations) throws IOException {
        // Store rate information in a Map
        JsonNode node = Json.parse(ExchangeAPI.getJsonString(year, base, symbol));

        TreeMap<Date, JsonNode> rates = Json.getMapFromNode(node.get("rates"));

        if (rates != null) {
            // Date formatting
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            double startRate = rates.firstEntry().getValue().get(symbol).asDouble();
            double lastRate = startRate;

            // Check how many times the base currency has increased or decreased
            int nIncrease = 0;
            int nDecrease = 0;

            for (Map.Entry<Date, JsonNode> entry : rates.entrySet()) {
                Date k = entry.getKey();
                JsonNode v = entry.getValue();

                double currentRate = v.get(symbol).asDouble();
                double difference = checkAgainstStartRate ? startRate - currentRate : currentRate - lastRate;

                if (difference > 0.0) {
                    nIncrease++;
                } else if (difference < 0.0) {
                    nDecrease++;
                }

                if (showOperations) {
                    System.out.println("("+ simpleDateFormat.format(k) + ") 1,0000 " + base + " -> " + symbol + " " + String.format("%.04f", currentRate) + " [" + String.format("%.04f", difference) + "]");
                }

                lastRate = currentRate;
            }

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("In anul " + year + " " + base + " in raport cu " + symbol + " a crescut de " + nIncrease + " ori " + "si a scazut de " + nDecrease + " ori.");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

        } else {
            System.out.println("Nu exista date pentru optiunile selectate!");
        }
    }
}
