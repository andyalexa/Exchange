package com.andyalexa.jsonparsing;

import com.andyalexa.exchangerates.ExchangeAPI;
import com.andyalexa.jsonparsing.pojo.ResponsePOJO;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonTest {

    @Test
    void parse() throws IOException {

        JsonNode node = Json.parse(ExchangeAPI.getJsonString("2018-01-01", "2019-01-01"));

        assertEquals(node.get("base").asText(), "EUR");
    }

    @Test
    void fromJson() throws IOException {
        JsonNode node = Json.parse(ExchangeAPI.getJsonString("2018-01-01", "2019-01-01"));
        ResponsePOJO test = Json.fromJson(node, ResponsePOJO.class);


        assertEquals(test.getRates().get("2018-12-12").get("RON"), 4.6571);



    }
}