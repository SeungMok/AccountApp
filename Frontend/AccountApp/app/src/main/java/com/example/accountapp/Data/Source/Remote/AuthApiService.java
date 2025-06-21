package com.example.accountapp.Data.Source.Remote;

import com.example.accountapp.Data.Model.LoginRequest;
import com.example.accountapp.Data.Model.LoginResponse;

import retrofit2.Call; // 중요: retrofit2.Call 임포트
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AuthApiService {

    // POST 요청을 /api/auth/login 엔드포인트로 보냅니다.
    // @Body 어노테이션은 LoginRequest 객체를 JSON 본문으로 직렬화하여 보냅니다.
    // Call<LoginResponse>는 API 호출 결과를 LoginResponse 객체로 비동기적으로 받을 것임을 나타냅니다.
    @GET("/users") // 백엔드 API의 실제 로그인 엔드포인트 경로로 변경하세요.
    Call<LoginResponse> login(@Body LoginRequest request);

    // TODO: 회원가입, 비밀번호 찾기 등 다른 API 엔드포인트도 여기에 추가할 수 있습니다.
    // @POST("api/auth/register")
    // Call<RegisterResponse> register(@Body RegisterRequest request);
}