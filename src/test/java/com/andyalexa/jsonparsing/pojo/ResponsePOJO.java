package com.andyalexa.jsonparsing.pojo;

import com.fasterxml.jackson.databind.JsonNode;

public class ResponsePOJO {

    private JsonNode rates;
    private String start_at;
    private String base;
    private String end_at;

    public JsonNode getRates() {
        return rates;
    }

    public void setRates(JsonNode rates) {
        this.rates = rates;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }


}
