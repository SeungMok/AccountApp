package com.example.accountapp.Data.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Room 데이터베이스의 테이블로 사용될 것임을 나타냅니다.
@Entity(tableName = "users")
public class User {

    // 생성자 (Room이 객체를 만들 때 사용)
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    // Setter 메서드 (Room이 ID를 설정할 때 필요)
    public void setId(int id) {
        this.id = id;
    }
    // toString() 메서드 (선택 사항이지만 디버깅에 유용)
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String email;
    private String password;
}