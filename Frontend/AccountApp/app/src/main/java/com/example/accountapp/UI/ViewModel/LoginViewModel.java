package com.example.accountapp.UI.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.accountapp.Data.Model.User;
import com.example.accountapp.Data.Repository.AuthRepository;
import com.example.accountapp.Data.Source.AppDatabase;
import com.example.accountapp.Data.Source.UserDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginViewModel extends AndroidViewModel {

    private final AuthRepository authRepository;
    private final ExecutorService viewModelExecutor; // ViewModel 내부 비동기 처리를 위한 Executor

    // LiveData: UI가 관찰할 수 있는 로그인 결과 (성공, 실패, 에러 메시지)
    private final MutableLiveData<Boolean> _loginSuccess = new MutableLiveData<>();
    public LiveData<Boolean> loginSuccess = _loginSuccess; // 읽기 전용 LiveData 노출

    private final MutableLiveData<String> _errorMessage = new MutableLiveData<>();
    public LiveData<String> errorMessage = _errorMessage;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        // Repository 인스턴스 생성 (나중에 DI로 대체)
        UserDao userDao = AppDatabase.getDatabase(application).userDao();
        authRepository = new AuthRepository(userDao);

        viewModelExecutor = Executors.newSingleThreadExecutor(); // ViewModel 내 비동기 작업용
    }

    // 로그인 로직
    public void login(String email, String password) {
        // 비동기적으로 로그인 시도
        viewModelExecutor.execute(() -> {
            User user = authRepository.loginUser(email, password);
            if (user != null) {
                // 로그인 성공
                _loginSuccess.postValue(true); // UI 스레드에서 LiveData 업데이트
            } else {
                // 로그인 실패
                _loginSuccess.postValue(false);
                _errorMessage.postValue("이메일 또는 비밀번호가 일치하지 않습니다.");
            }
        });
    }

    // ViewModel이 파괴될 때 Executor를 종료합니다.
    @Override
    protected void onCleared() {
        super.onCleared();
        if (!viewModelExecutor.isShutdown()) {
            viewModelExecutor.shutdown();
        }
    }
}