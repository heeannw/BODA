package com.example.appt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class IdeaPageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContentAdapter adapter;
    private List<ContentItem> contentList;

    private Button btnAd, btnVideo, btnIssue;
    private EditText searchInput;
    private TextView resultCount;
    private ImageView filterButton;
    private ImageView navHome, navData, navExplore, navSuggest, navMypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_page);

        recyclerView = findViewById(R.id.recyclerContent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAd = findViewById(R.id.btnAd);
        btnVideo = findViewById(R.id.btnVideo);
        btnIssue = findViewById(R.id.btnIssue);
        searchInput = findViewById(R.id.searchInput);
        resultCount = findViewById(R.id.resultCount);
        filterButton = findViewById(R.id.filterButton);

        navHome = findViewById(R.id.nav_home);
        navData = findViewById(R.id.nav_data);
        navExplore = findViewById(R.id.nav_explore);
        navSuggest = findViewById(R.id.nav_suggest);
        navMypage = findViewById(R.id.nav_mypage);

        setupCategoryButtons();
        setupFilterButton();
        setupBottomNav();

        contentList = new ArrayList<>();
        contentList.add(new ContentItem(R.drawable.app_logo, "학교폭력 예방 아이디어", "VR 콘텐츠로 체험하는 피해자 관점", "#아이디어 #VR"));
        contentList.add(new ContentItem(R.drawable.app_logo, "디지털 중독 예방 캠페인", "앱 사용시간 조절 게임 기반 캠페인", "#디지털 #중독"));
        contentList.add(new ContentItem(R.drawable.app_logo, "공익광고 참여 이벤트", "청소년이 직접 만드는 UCC 광고 공모전", "#참여 #UCC"));

        adapter = new ContentAdapter(contentList, R.layout.item_content_list_yellow);
        recyclerView.setAdapter(adapter);

        resultCount.setText("총 " + contentList.size() + "건");
    }

    private void setupCategoryButtons() {
        Button[] buttons = {btnAd, btnVideo, btnIssue};

        btnAd.setActivated(true);

        for (Button btn : buttons) {
            btn.setOnClickListener(v -> {
                for (Button b : buttons) {
                    b.setActivated(false);
                }
                btn.setActivated(true);
            });
        }
    }

    private void setupFilterButton() {
        filterButton.setOnClickListener(v -> {
            String[] options = {"공익 콘텐츠", "사회문제 리포트", "아이디어"};

            new AlertDialog.Builder(this)
                    .setTitle("화면 선택")
                    .setItems(options, (dialog, which) -> {
                        switch (which) {
                            case 0:
                                startActivity(new Intent(this, ExploreContentActivity.class));
                                break;
                            case 1:
                                startActivity(new Intent(this, SocialIssueReportActivity.class));
                                break;
                            case 2:
                                break;
                        }
                    })
                    .show();
        });
    }

    private void setupBottomNav() {
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

        navMypage.setOnClickListener(v -> {
            startActivity(new Intent(this, MyPageActivity.class));
            overridePendingTransition(0, 0);
        });
    }
}