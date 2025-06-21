package com.example.accountapp.Data.Source;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.accountapp.Data.Model.User; // User 모델 클래스 임포트

@Dao // Room DAO 인터페이스임을 나타냅니다.
public interface UserDao {

    // 새로운 사용자 삽입 (회원가입 시 사용)
    // onConflict = OnConflictStrategy.REPLACE: 충돌 발생 시 기존 데이터 대체
    @Insert
    long insertUser(User user); // 삽입된 Row의 ID를 반환 (long 타입)

    // 이메일과 비밀번호로 사용자 조회 (로그인 시 사용)
    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    User getUserByEmailAndPassword(String email, String password);

    // 이메일로 사용자 조회 (아이디 중복 확인 등)
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    User getUserByEmail(String email);
}