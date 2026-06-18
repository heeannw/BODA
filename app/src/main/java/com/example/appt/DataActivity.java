package com.example.appt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private TextView categoryLabel;
    private RecyclerView recyclerView;
    private ImageView navHome, navData, navExplore, navSuggest, navMypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        categorySpinner = findViewById(R.id.categorySpinner);
        categoryLabel = findViewById(R.id.categoryLabel);
        recyclerView = findViewById(R.id.dataRecyclerView);

        navHome = findViewById(R.id.nav_home);
        navData = findViewById(R.id.nav_data);
        navExplore = findViewById(R.id.nav_explore);
        navSuggest = findViewById(R.id.nav_suggest);
        navMypage = findViewById(R.id.nav_mypage);

        setupBottomNav();

        List<String> items = new ArrayList<>();
        items.add("청소년");
        items.add("10대");
        items.add("전체");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        categorySpinner.setAdapter(adapter);

        categorySpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                categoryLabel.setText(selected);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {}
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<DataItem> dataList = new ArrayList<>();
        dataList.add(new DataItem("보이스피싱 예방 영상", "10대 피해 사례를 중심으로 제작된 공익 캠페인 영상", "#청소년"));
        dataList.add(new DataItem("청소년 금융사기 통계", "최근 5년간 피해율 변화 추이와 유형별 분석", "#통계"));
        dataList.add(new DataItem("사이버 금융사기 대응법", "SNS와 메신저를 통한 사기 예방법 안내", "#예방"));
        DataAdapter adapterRV = new DataAdapter(this, dataList);
        recyclerView.setAdapter(adapterRV);
    }

    private void setupBottomNav() {
        navHome.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            overridePendingTransition(0, 0);
        });

        navData.setOnClickListener(v -> {
            // 현재 화면이므로 이동 없음
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
