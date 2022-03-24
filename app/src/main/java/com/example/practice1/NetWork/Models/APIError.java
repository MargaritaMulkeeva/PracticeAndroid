package com.example.practice1.NetWork.Models;

public class APIError {
    private String error;

    public APIError(String error) {
        this.error = error;
    }

    public String message() {
        return error;
    }
}
