package com.example.appt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView quizRV, contentRV, reportRV, ideaRV;
    private ImageView navHome, navData, navExplore, navSuggest, navMypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new KccDataFetcher().execute();

        quizRV = findViewById(R.id.quizRecyclerView);
        quizRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<QuizItem> quizItems = new ArrayList<>();
        quizItems.add(new QuizItem(R.drawable.app_logo, "제목1", "사이버상에서 발생하는 따돌림과 언어폭력...", "#폭력"));
        quizItems.add(new QuizItem(R.drawable.app_logo, "제목2", "사이버상에서 발생하는 따돌림과 언어폭력...", "#따돌림"));
        quizItems.add(new QuizItem(R.drawable.app_logo, "제목3", "사이버상에서 발생하는 따돌림과 언어폭력...", "#사이버"));
        quizRV.setAdapter(new QuizAdapter(quizItems));

        contentRV = findViewById(R.id.contentRecyclerView);
        contentRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<ContentItem> contentItems = new ArrayList<>();
        contentItems.add(new ContentItem(R.drawable.app_logo, "공익1", "환경 보호 캠페인", "#환경"));
        contentItems.add(new ContentItem(R.drawable.app_logo, "공익2", "기후 변화 대응", "#기후"));
        contentItems.add(new ContentItem(R.drawable.app_logo, "공익3", "자원 재활용", "#재활용"));
        contentRV.setAdapter(new ContentAdapter(contentItems, R.layout.item_content_card_blue));

        reportRV = findViewById(R.id.reportRecyclerView);
        reportRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<ContentItem> reportItems = new ArrayList<>();
        reportItems.add(new ContentItem(R.drawable.app_logo, "리포트1", "청소년 범죄 통계", "#청소년"));
        reportItems.add(new ContentItem(R.drawable.app_logo, "리포트2", "노인 빈곤 현황", "#노인"));
        reportItems.add(new ContentItem(R.drawable.app_logo, "리포트3", "저출산 영향 분석", "#저출산"));
        reportRV.setAdapter(new ContentAdapter(reportItems, R.layout.item_content_card_blue));

        ideaRV = findViewById(R.id.ideaRecyclerView);
        ideaRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<ContentItem> ideaItems = new ArrayList<>();
        ideaItems.add(new ContentItem(R.drawable.app_logo, "아이디어1", "유기동물 보호 캠페인", "#동물"));
        ideaItems.add(new ContentItem(R.drawable.app_logo, "아이디어2", "플라스틱 줄이기 운동", "#환경"));
        ideaItems.add(new ContentItem(R.drawable.app_logo, "아이디어3", "기부 플랫폼 연계", "#기부"));
        ideaRV.setAdapter(new IdeaAdapter(ideaItems));

        navHome = findViewById(R.id.nav_home);
        navData = findViewById(R.id.nav_data);
        navExplore = findViewById(R.id.nav_explore);
        navSuggest = findViewById(R.id.nav_suggest);
        navMypage = findViewById(R.id.nav_mypage);

        setupBottomNav();
    }

    private void setupBottomNav() {
        navHome.setOnClickListener(v -> {
            // 현재 화면이므로 이동 없음
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

        navMypage.setOnClickListener(v -> {
            startActivity(new Intent(this, MyPageActivity.class));
            overridePendingTransition(0, 0);
        });
    }
}