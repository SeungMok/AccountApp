package com.example.accountapp.Data.Model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("email") // JSON 키와 필드명이 다를 경우 사용
    private String email;
    @SerializedName("password")
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getter (필수)
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setter (선택 사항이지만 Gson이 객체를 만들 때 필요할 수 있음)
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}