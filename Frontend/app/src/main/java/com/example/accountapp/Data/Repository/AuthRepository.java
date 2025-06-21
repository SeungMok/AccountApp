package com.example.accountapp.Data.Repository;

import com.example.accountapp.Data.Model.User;
import com.example.accountapp.Data.Source.UserDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AuthRepository {

    private final UserDao userDao;
    // 비동기 작업을 위한 Executor (실제 앱에서는 Coroutines나 RxJava 사용 권장)
    private final ExecutorService executorService;

    // 생성자를 통해 UserDao를 주입받습니다.
    public AuthRepository(UserDao userDao) {
        this.userDao = userDao;
        this.executorService = Executors.newSingleThreadExecutor(); // 단일 스레드 풀 생성
    }

    // 로그인 메서드
    public User loginUser(String email, String password) {
        // DB 접근은 메인 스레드에서 하면 안 되므로, 별도의 스레드에서 실행
        // 실제 앱에서는 LiveData, Flow 또는 Callbacks을 사용하여 비동기 결과를 처리해야 함
        try {
            return executorService.submit(() -> userDao.getUserByEmailAndPassword(email, password)).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 사용자 등록 메서드 (회원가입 시 사용)
    public long registerUser(User user) {
        try {
            return executorService.submit(() -> userDao.insertUser(user)).get();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 실패 시 -1 반환
        }
    }

    // 이메일 중복 확인 (회원가입 시 사용)
    public User getUserByEmail(String email) {
        try {
            return executorService.submit(() -> userDao.getUserByEmail(email)).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}