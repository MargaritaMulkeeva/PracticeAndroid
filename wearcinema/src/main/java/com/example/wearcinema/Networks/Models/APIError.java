package com.example.wearcinema.Networks.Models;

public class APIError {
    private String error;

    public APIError(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
