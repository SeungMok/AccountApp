package com.example.accountapp.UI.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.accountapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider; // ViewModel 사용을 위한 임포트

import com.google.android.material.textfield.TextInputEditText;
import com.example.accountapp.MainActivity; // 여러분의 메인 Activity 경로
import com.example.accountapp.UI.ViewModel.LoginViewModel; // LoginViewModel 임포트
import com.example.accountapp.Data.Model.User; // User 모델 임포트 (테스트용)
import com.example.accountapp.Data.Source.AppDatabase; // DB 초기화용 임포트

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // ViewModel 초기화
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // 뷰 ID 연결
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnSignin);
        tvFindPassword = findViewById(R.id.tvFindIDPW);

        // TODO: 초기 사용자 등록 (테스트용, 실제 앱에서는 회원가입 시 DB에 저장)
        // 이 코드는 앱이 처음 실행될 때 "test@example.com" 사용자를 DB에 추가합니다.
        // 앱을 여러 번 실행할 때는 주석 처리하거나, 회원가입 기능을 통해 사용자를 추가해야 합니다.
        // 테스트용으로 한 번만 실행되도록 하거나, 앱 제거 후 재설치 시 다시 실행되게 할 수 있습니다.
        new Thread(() -> {
            User existingUser = AppDatabase.getDatabase(getApplicationContext()).userDao().getUserByEmail("test@example.com");
            if (existingUser == null) {
                AppDatabase.getDatabase(getApplicationContext()).userDao().insertUser(new User("test@example.com", "password123"));
                runOnUiThread(() -> Toast.makeText(this, "테스트 사용자 등록됨: test@example.com / password123", Toast.LENGTH_LONG).show());
            }
        }).start();


        // ViewModel의 loginSuccess LiveData를 관찰
        loginViewModel.loginSuccess.observe(this, isSuccess -> {
            if (isSuccess) {
                Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class); // 여러분의 메인 Activity로 이동
                startActivity(intent);
                finish(); // 로그인 액티비티는 종료
            } else {
                // 로그인 실패 시 에러 메시지는 errorMessage LiveData에서 처리
            }
        });

        // ViewModel의 errorMessage LiveData를 관찰
        loginViewModel.errorMessage.observe(this, message -> {
            if (message != null && !message.isEmpty()) {
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });


        // 로그인 버튼 클릭 리스너
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("유효한 이메일을 입력해주세요.");
                    etEmail.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    etPassword.setError("비밀번호를 입력해주세요.");
                    etPassword.requestFocus();
                    return;
                }

                // ViewModel의 로그인 메서드 호출
                loginViewModel.login(email, password);
            }
        });

        // 회원가입 버튼 클릭 리스너 (RegisterActivity는 직접 만드셔야 합니다)
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "회원가입 페이지로 이동 (미구현)", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                // startActivity(intent);
            }
        });

        // 아이디/비밀번호 찾기 텍스트뷰 클릭 리스너 (FindAccountActivity는 직접 만드셔야 합니다)
        tvFindPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "아이디/비밀번호 찾기 페이지로 이동 (미구현)", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(LoginActivity.this, FindAccountActivity.class);
                // startActivity(intent);
            }
        });

    }
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;
    private TextView tvFindPassword;
    private LoginViewModel loginViewModel;

}