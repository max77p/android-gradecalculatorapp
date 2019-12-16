package com.ut.shansgradecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReportActivity extends AppCompatActivity {
    private final static String TAG = "GradeCalculator";
    private Bundle bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        setGrade("ios", R.id.iosGrade);
        setGrade("android", R.id.androidGrade);
        setGrade("swift", R.id.swiftGrade);
        setGrade("java", R.id.javaGrade);
        setGrade("grade", R.id.grade);
        setGrade(TAG, R.id.tag);
    }

    private void setGrade(String name, int id) {
        TextView grade = findViewById(id);
        Intent intent = getIntent();
        bd = intent.getExtras();

        if (bd != null) {
            grade.setText(bd.getString(name));
        }
    }
}