package com.example.accountapp.Data.Source;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.accountapp.Data.Model.User; // User 모델 클래스 임포트

// 데이터베이스를 정의합니다.
// entities: 이 데이터베이스에 포함될 엔티티(테이블) 목록
// version: 데이터베이스 버전 (스키마 변경 시마다 증가시켜야 함)
// exportSchema: 스키마를 파일로 내보낼지 여부 (일반적으로 false)
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // 데이터베이스에 포함될 DAO 인터페이스들을 정의합니다.
    public abstract UserDao userDao();

    // 싱글톤 패턴을 사용하여 데이터베이스 인스턴스를 하나만 유지합니다.
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "receipts_app_database") // 데이터베이스 이름 지정
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}