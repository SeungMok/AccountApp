package com.smlee.AccountApp.controller;
import com.smlee.AccountApp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/db")
    public String checkDatabase() {
        try {
            long count = userRepository.count();
            return "✅ DB 연결 성공! 사용자 수: " + count;
        } catch (Exception e) {
            return "❌ DB 연결 실패: " + e.getMessage();
        }
    }
}
