package com.example.appt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizSuggestStep2Activity extends AppCompatActivity {

    Button btnNext;
    RadioButton btnO, btnX;
    CheckBox checkboxEtc;
    EditText editEtcInput;
    EditText editExplanation;
    TextView txtEditExplanation;

    ImageView navHome, navData, navExplore, navSuggest, navMypage;

    boolean isOSelected = false;
    boolean isXSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_suggest_step2);

        // 기본 요소 초기화
        btnNext = findViewById(R.id.btnNext);
        btnO = findViewById(R.id.btnO);
        btnX = findViewById(R.id.btnX);
        checkboxEtc = findViewById(R.id.checkboxEtc);
        editEtcInput = findViewById(R.id.editEtcInput);
        editExplanation = findViewById(R.id.editExplanation);
        txtEditExplanation = findViewById(R.id.txtEditExplanation);

        // O/X 선택 처리
        btnO.setOnClickListener(v -> {
            isOSelected = true;
            isXSelected = false;
            btnO.setChecked(true);
            btnX.setChecked(false);
        });

        btnX.setOnClickListener(v -> {
            isOSelected = false;
            isXSelected = true;
            btnO.setChecked(false);
            btnX.setChecked(true);
        });

        // 해설 수정하기 클릭 시 EditText 활성화
        txtEditExplanation.setOnClickListener(v -> {
            editExplanation.setEnabled(true);
            editExplanation.requestFocus();
            editExplanation.setBackgroundResource(android.R.drawable.edit_text);
        });

        // 기타 입력 체크 시 EditText 활성화
        checkboxEtc.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editEtcInput.setEnabled(isChecked);
            if (isChecked) {
                editEtcInput.requestFocus();
                editEtcInput.setBackgroundResource(android.R.drawable.edit_text);
            } else {
                editEtcInput.setText("");
                editEtcInput.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            }
        });

        // 다음 버튼 클릭 시 처리
        btnNext.setOnClickListener(v -> {
            if (!isOSelected && !isXSelected) {
                Toast.makeText(this, "정답을 선택해주세요", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(this, QuizPreviewActivity.class));
            }
        });

        // ✅ 하단 네비게이션 바 처리
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

        navMypage.setOnClickListener(v -> {
            startActivity(new Intent(this, MyPageActivity.class));
            overridePendingTransition(0, 0);
        });
    }
}
