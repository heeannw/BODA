package com.example.appt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuizSuggestStep1Activity extends AppCompatActivity {

    private Button btnNext;
    private RecyclerView recyclerContent;

    // 하단 네비게이션
    private ImageView navHome, navData, navExplore, navSuggest, navMypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_suggest_step1);

        // 다음 버튼
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizSuggestStep2Activity.class);
            startActivity(intent);
        });

        // RecyclerView 설정
        recyclerContent = findViewById(R.id.recyclerContent);
        recyclerContent.setLayoutManager(new LinearLayoutManager(this));

        // 리스트 데이터
        List<QuizContentItem> contentList = new ArrayList<>();
        contentList.add(new QuizContentItem(
                "청소년 음주예방 광고",
                "사이버에서 발생하는 따돌림과 언어폭력 문제를 다룬 콘텐츠",
                "#청소년 #광고",
                R.drawable.app_logo
        ));
        contentList.add(new QuizContentItem(
                "장애인 인식 개선 광고",
                "장애에 대한 편견을 줄이는 내용의 교육 영상",
                "#장애인 #인식개선",
                R.drawable.app_logo
        ));
        contentList.add(new QuizContentItem(
                "노인 학대 예방 콘텐츠",
                "고령자에 대한 부당한 대우를 주제로 한 공익 영상",
                "#고령화 #노인학대",
                R.drawable.app_logo
        ));

        QuizContentAdapter adapter = new QuizContentAdapter(contentList);
        recyclerContent.setAdapter(adapter);

        // 하단 메뉴 연결
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
            // 현재 화면이므로 이동 생략 가능
        });

        navMypage.setOnClickListener(v -> {
            startActivity(new Intent(this, MyPageActivity.class));
            overridePendingTransition(0, 0);
        });
    }
}
