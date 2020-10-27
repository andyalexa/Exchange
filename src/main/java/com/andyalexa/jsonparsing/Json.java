package com.andyalexa.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;


public class Json {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return defaultObjectMapper;
    }

    public static JsonNode parse(String source) throws IOException {
        return objectMapper.readTree(source);
    }

    // Returns a map of dates and their respecting rates
    public static TreeMap<Date, JsonNode> getMapFromNode(JsonNode node) throws  JsonProcessingException {
       return objectMapper.convertValue(node, new TypeReference<TreeMap<Date, JsonNode>>(){});
    }
}
