package com.example.mobileprogrammingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mobileprogrammingapp.R;

public class courseDetail extends AppCompatActivity {

    TextView detailHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        detailHead = findViewById(R.id.detail_head);

        Intent I = getIntent();
        String title = I.getStringExtra("title");

        detailHead.setText(title);
    }
}