package com.example.wearcinema.Networks.Models;

import com.google.gson.annotations.SerializedName;

public class RegisterBody {

    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;

    public RegisterBody(String email, String password, String firstName, String lastName){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
