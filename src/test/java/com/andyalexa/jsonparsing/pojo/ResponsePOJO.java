package com.andyalexa.jsonparsing.pojo;

import java.util.Map;

public class ResponsePOJO {

    private Map<String, RatePOJO> rates;
    private String start_at;
    private String base;
    private String end_at;

    public Map<String, RatePOJO> getRates() {
        return rates;
    }

    public void setRates(Map<String, RatePOJO> rates) {
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
