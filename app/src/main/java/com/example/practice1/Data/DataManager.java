package com.example.practice1.Data;

public class DataManager {
    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        DataManager.token = token;
    }
}
