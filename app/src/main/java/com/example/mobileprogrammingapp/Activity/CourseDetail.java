package com.example.mobileprogrammingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobileprogrammingapp.Fragment.edit_profile;
import com.example.mobileprogrammingapp.R;

public class CourseDetail extends AppCompatActivity {

    TextView detailHead;
    Button btnTakeQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        detailHead = findViewById(R.id.detail_head);

        Intent I = getIntent();
        String title = I.getStringExtra("title");

        detailHead.setText(title);

        initialSetup();
    }

    private void initialSetup(){

        btnTakeQuiz = findViewById(R.id.btnTakeQuiz);

        btnTakeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CourseDetail.this, CourseQuiz.class));
            }
        });

    }
}