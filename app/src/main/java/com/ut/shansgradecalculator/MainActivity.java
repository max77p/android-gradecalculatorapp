package com.ut.shansgradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "GradeCalculator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button minBtn = findViewById(R.id.minBtn);
        minBtn.setOnClickListener(this);
        Button maxBtn = findViewById(R.id.maxBtn);
        maxBtn.setOnClickListener(this);
        Button avgBtn = findViewById(R.id.avgBtn);
        avgBtn.setOnClickListener(this);
    }

    private void generateReport(int id) {
        String grade;
        String tag;
        switch (id) {
            case R.id.minBtn:
                grade = getMin();
                tag = "MIN";
                break;
            case R.id.maxBtn:
                grade = getMax();
                tag = "MAX";
                break;
            case R.id.avgBtn:
                grade = getAverage();
                tag = "AVG";
                break;
            default:
                grade = "0";
                tag = "";
                break;
        }

        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("ios", getGrade(R.id.iosField));
        intent.putExtra("android", getGrade(R.id.androidField));
        intent.putExtra("swift", getGrade(R.id.swiftField));
        intent.putExtra("java", getGrade(R.id.javaField));
        intent.putExtra("grade", grade);
        intent.putExtra(TAG, tag);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        generateReport(v.getId());
    }

    private String getAverage() {
        Double iosScore = Double.valueOf(getGrade(R.id.iosField));
        Double androidScore = Double.valueOf(getGrade(R.id.androidField));
        Double swiftScore = Double.valueOf(getGrade(R.id.swiftField));
        Double javaScore = Double.valueOf(getGrade(R.id.javaField));
        Double[] grades = {iosScore, androidScore, swiftScore, javaScore};
        Double sum = 0.0;
        for (Double grade : grades)
            sum += grade;
        Double avg = sum / grades.length;
        return avg.toString();
    }

    private String getMax() {
        Double iosScore = Double.valueOf(getGrade(R.id.iosField));
        Double androidScore = Double.valueOf(getGrade(R.id.androidField));
        Double swiftScore = Double.valueOf(getGrade(R.id.swiftField));
        Double javaScore = Double.valueOf(getGrade(R.id.javaField));
        Double[] grades = {iosScore, androidScore, swiftScore, javaScore};
        Double max = grades[0];
        for (Double grade : grades)
            max = Math.max(max, grade);
        return max.toString();
    }

    private String getMin() {
        Double iosScore = Double.valueOf(getGrade(R.id.iosField));
        Double androidScore = Double.valueOf(getGrade(R.id.androidField));
        Double swiftScore = Double.valueOf(getGrade(R.id.swiftField));
        Double javaScore = Double.valueOf(getGrade(R.id.javaField));
        Double[] grades = {iosScore, androidScore, swiftScore,javaScore};
        Double min = grades[0];
        for (Double grade : grades)
            min = Math.min(min, grade);
        return min.toString();
    }

    private String getGrade(int id) {
        EditText grade = findViewById(id);
        if (!TextUtils.isEmpty(grade.getText().toString())) {
            return grade.getText().toString();
        }
        return "0";
    }
}
