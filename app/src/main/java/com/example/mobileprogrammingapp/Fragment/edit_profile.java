package com.example.mobileprogrammingapp.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobileprogrammingapp.R;

public class edit_profile extends AppCompatActivity {

    Button btnUpdate;
    EditText etFullName, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        initialSetup();
    }

    private void initialSetup() {
        etEmail = findViewById(R.id.etEmail);
        etFullName = findViewById(R.id.fullName);


        btnUpdate = findViewById(R.id.btnEdit);

//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}