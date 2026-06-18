package com.example.appt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPreviewActivity extends AppCompatActivity {

    private ImageView btnO, btnX;
    private Button btnTempSave, btnFinalSave;

    private boolean isOSelected = false;
    private boolean isXSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_preview);

        btnO = findViewById(R.id.btnO);
        btnX = findViewById(R.id.btnX);
        btnTempSave = findViewById(R.id.btnTempSave);
        btnFinalSave = findViewById(R.id.btnFinalSave);

        btnO.setOnClickListener(v -> {
            isOSelected = true;
            isXSelected = false;
            btnO.setBackgroundResource(R.drawable.category_button_selector_yellow);
            btnX.setBackgroundResource(R.drawable.category_unselected);
        });

        btnX.setOnClickListener(v -> {
            isOSelected = false;
            isXSelected = true;
            btnX.setBackgroundResource(R.drawable.category_button_selector_yellow);
            btnO.setBackgroundResource(R.drawable.category_unselected);
        });

        btnTempSave.setOnClickListener(v -> {
            Toast.makeText(this, "임시저장되었습니다", Toast.LENGTH_SHORT).show();
            // 홈으로 이동
            Intent intent = new Intent(QuizPreviewActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 이전 액티비티 스택 제거
            startActivity(intent);
        });

        btnFinalSave.setOnClickListener(v -> {
            Toast.makeText(this, "저장되었습니다", Toast.LENGTH_SHORT).show();
            // 홈으로 이동
            Intent intent = new Intent(QuizPreviewActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 이전 액티비티 스택 제거
            startActivity(intent);
        });
    }
}
