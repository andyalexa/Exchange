package com.andyalexa;

import com.andyalexa.exchangerates.ExchangeAPI;
import com.andyalexa.jsonparsing.Json;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

public class App {

    public static void main(String[] args) throws IOException {
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
                    double currentRate = v.get("RON").asDouble();
                    double difference = currentRate - startRate;

                    System.out.println(simpleDateFormat.format(k) + " -> " + String.format("%.04f", currentRate) + " [" + String.format("%.04f", difference) + "]" );
        });

    }


}
