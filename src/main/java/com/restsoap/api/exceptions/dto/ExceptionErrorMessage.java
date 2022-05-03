package com.restsoap.api.exceptions.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExceptionErrorMessage {

    private String message;
    private int states;
    private String discerption;
    

    public ExceptionErrorMessage(String message, int states, String discerption) {
        this.message = message;
        this.states = states;
        this.discerption = discerption;
    }

    public ExceptionErrorMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

    public String getDiscerption() {
        return discerption;
    }

    public void setDiscerption(String discerption) {
        this.discerption = discerption;
    }
}
