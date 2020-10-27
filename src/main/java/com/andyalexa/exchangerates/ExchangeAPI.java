package com.andyalexa.exchangerates;

import com.andyalexa.jsonparsing.Json;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

public class ExchangeAPI {

    public static String getJsonString(int year) {

        String startDate = year + "-01-01";
        String endDate = (year + 1) + "-01-01";

        String urlString = "https://api.exchangeratesapi.io/history?start_at=" + startDate + "&end_at=" + endDate + "&symbols=RON&base=EUR";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString)).build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

    }

    public static void printRatesForYear(int year) throws IOException {
        // Store rate information in a Map
        JsonNode node = Json.parse(ExchangeAPI.getJsonString(year));
        TreeMap<Date, JsonNode> rates = Json.getMapFromNode(node.get("rates"));

        // Date formatting
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        double startRate = rates.firstEntry().getValue().get("RON").asDouble();

        rates.forEach((k,v) -> {
            double currentRate = v.get("RON").asDouble();
            double difference = currentRate - startRate;

            System.out.println(simpleDateFormat.format(k) + " -> " + String.format("%.04f", currentRate) + " [" + String.format("%.04f", difference) + "]" );
        });
    }
}
