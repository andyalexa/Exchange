package com.andyalexa.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;


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

    // Returns a map of dates and rates for said dates
    public static Map<String, JsonNode> getMapFromNode(JsonNode node) throws  JsonProcessingException {
       return objectMapper.convertValue(node, new TypeReference<Map<String, JsonNode>>(){});
    }
}
