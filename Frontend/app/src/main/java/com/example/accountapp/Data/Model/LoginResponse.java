package com.example.accountapp.Data.Model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("token")
    private String token;
    @SerializedName("userId")
    private String userId; // 또는 int userId; 백엔드 응답 타입에 따라

    // 기본 생성자 (Gson이 JSON을 객체로 변환할 때 필요)
    public LoginResponse() {}

    // Getter (필수)
    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    // Setter (선택 사항)
    public void setToken(String token) {
        this.token = token;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}