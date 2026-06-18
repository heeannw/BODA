package com.example.appt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyPageActivity extends AppCompatActivity {

    RecyclerView recycler_my_quiz, recycler_interest_ad;
    Button btn_logout;

    // 하단 네비게이션 뷰
    private ImageView navHome, navData, navExplore, navSuggest, navMypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        // 뷰 연결
        recycler_my_quiz = findViewById(R.id.recycler_my_quiz);
        recycler_interest_ad = findViewById(R.id.recycler_interest_ad);
        btn_logout = findViewById(R.id.btn_logout);

        // 레이아웃 매니저 설정
        recycler_my_quiz.setLayoutManager(new LinearLayoutManager(this));
        recycler_interest_ad.setLayoutManager(new LinearLayoutManager(this));

        // 리스트 데이터 설정 (임시 데이터 예시)
        List<QuizContentItem> myQuizList = new ArrayList<>();
        myQuizList.add(new QuizContentItem("청소년 음주 예방", "음주 위험 경각심", "#청소년 #예방", R.drawable.app_logo));
        myQuizList.add(new QuizContentItem("장애인 인식 개선", "편견 없애기", "#장애인 #인식", R.drawable.app_logo));

        List<QuizContentItem> interestAdList = new ArrayList<>();
        interestAdList.add(new QuizContentItem("노인 학대 예방", "고령자 보호 콘텐츠", "#노인 #인권", R.drawable.app_logo));

        // 어댑터 연결
        QuizContentAdapter quizAdapter = new QuizContentAdapter(myQuizList);
        QuizContentAdapter adAdapter = new QuizContentAdapter(interestAdList);
        recycler_my_quiz.setAdapter(quizAdapter);
        recycler_interest_ad.setAdapter(adAdapter);

        // 로그아웃 버튼 클릭 처리
        btn_logout.setOnClickListener(v -> {
            Toast.makeText(this, "로그아웃되었습니다", Toast.LENGTH_SHORT).show();
        });

        setupBottomNav();
    }

    private void setupBottomNav() {
        navHome = findViewById(R.id.nav_home);
        navData = findViewById(R.id.nav_data);
        navExplore = findViewById(R.id.nav_explore);
        navSuggest = findViewById(R.id.nav_suggest);
        navMypage = findViewById(R.id.nav_mypage);

        navHome.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            overridePendingTransition(0, 0);
        });

        navData.setOnClickListener(v -> {
            startActivity(new Intent(this, DataActivity.class));
            overridePendingTransition(0, 0);
        });

        navExplore.setOnClickListener(v -> {
            startActivity(new Intent(this, ExploreContentActivity.class));
            overridePendingTransition(0, 0);
        });

        navSuggest.setOnClickListener(v -> {
            startActivity(new Intent(this, QuizSuggestStep1Activity.class));
            overridePendingTransition(0, 0);
        });

        // 현재는 마이페이지이므로 navMypage 클릭은 처리 생략
    }
}
