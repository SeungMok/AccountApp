plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.accountapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.accountapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.annotation)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // ViewModel 및 LiveData (MVVM의 핵심)
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2.8.0")
    // Kotlin 사용시 lifecycle-viewmodel-ktx, lifecycle-livedata-ktx 추가
    // Java 사용시 위 두 개로 충분

    // 비동기 처리 (코루틴 사용시) - Kotlin과 함께 사용되나, Java에서도 사용 가능
    // 영수증 OCR이나 이미지 처리 등 비동기 작업이 많으므로 고려.
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // 데이터 영속성 (로컬 데이터베이스 - Room)
    // 영수증 데이터를 로컬에 저장할 때 사용
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    // kapt("androidx.room:room-compiler:2.6.1") // Kotlin 사용시 kapt

    // 의존성 주입 (선택 사항이지만 규모가 커지면 강력 추천 - Hilt)
    // Hilt는 Dagger 기반의 Android용 DI 라이브러리
    // implementation("com.google.dagger:hilt-android:2.51.1")
    // annotationProcessor("com.google.dagger:hilt-compiler:2.51.1")
    // kapt("com.google.dagger:hilt-compiler:2.51.1") // Kotlin 사용시 kapt

    // 이미지 로딩 (영수증 이미지 표시용 - Glide 또는 Coil)
    // implementation("com.github.bumptech.glide:glide:4.16.0")
    // annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    // OCR (영수증 텍스트 인식) - ML Kit 또는 Tesseract 등
    // implementation("com.google.mlkit:text-recognition-korean:16.0.0") // 한국어 지원 ML Kit
    // 또는 Tesseract 등 외부 라이브러리 연동

    // Retrofit (HTTP 통신 라이브러리)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Retrofit에서 JSON 데이터를 Java/Kotlin 객체로 변환해주는 Gson 컨버터
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}