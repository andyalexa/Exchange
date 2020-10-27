package com.andyalexa.jsonparsing;

import com.andyalexa.jsonparsing.pojo.RatePOJO;
import com.andyalexa.jsonparsing.pojo.ResponsePOJO;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class JsonTest {

    String getJsonString() {
        String urlString = "https://api.exchangeratesapi.io/history?start_at=2018-01-01&end_at=2019-01-01&symbols=RON&base=EUR";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString)).build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

    }

    @Test
    void parse() throws IOException {

        JsonNode node = Json.parse(getJsonString());

        assertEquals(node.get("base").asText(), "EUR");
    }

    @Test
    void fromJson() throws IOException {
        JsonNode node = Json.parse(getJsonString());
        JsonNode node2 = node.get("rates");
        ResponsePOJO test = Json.fromJson(node, ResponsePOJO.class);

        RatePOJO rate =  Json.fromJson(node2, RatePOJO.class);

        // assertEquals(test.getRates().get("2018-12-12").getRON(), 4.6571f);

        System.out.println(rate.getRON());

    }
}