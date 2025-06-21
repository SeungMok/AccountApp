package com.example.accountapp.Data.Source.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // GCP 가상 서버의 기본 URL (반드시 마지막에 / 를 붙여야 함!)
    // TODO: 실제 GCP 서버의 IP 주소 또는 도메인 이름으로 변경하세요.
    private static final String BASE_URL = "http://34.60.144.29:8080/";
    // 예시: "http://34.123.45.67:8080/" 또는 "https://api.yourreceiptsapp.com/"

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // API 서버의 기본 URL 설정
                    .addConverterFactory(GsonConverterFactory.create()) // JSON 변환기 (Gson) 설정
                    .build();
        }
        return retrofit;
    }

    public static AuthApiService getAuthApiService() {
        return getClient().create(AuthApiService.class);
    }
}