package com.example.wearcinema.Networks.Models;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
