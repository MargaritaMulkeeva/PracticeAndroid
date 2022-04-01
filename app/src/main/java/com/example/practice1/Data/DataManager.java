package com.example.practice1.Data;

public class DataManager {

    //переменные
    private static String token;
    private static String mUserName;

    //геттеры и сеттеры для перемееных
    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        DataManager.token = token;
    }

    public static String getUserName() {
        return mUserName;
    }

    public static void setUserName(String mUserName) {
        DataManager.mUserName = mUserName;
    }
}
