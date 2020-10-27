package com.andyalexa.jsonparsing;

import com.andyalexa.exchangerates.ExchangeAPI;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonTest {

    @Test
    void parse() throws IOException {

        JsonNode node = Json.parse(ExchangeAPI.getJsonString(2018));

        assertEquals(node.get("base").asText(), "EUR");
    }

}