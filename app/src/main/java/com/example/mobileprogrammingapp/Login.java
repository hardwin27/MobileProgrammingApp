package com.example.mobileprogrammingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    LinearLayout btnGoogle;
    EditText etUsername;
    TextView textAppName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialSetup();
    }

    private void initialSetup() {
        etUsername = findViewById(R.id.etUsername);
        textAppName = findViewById(R.id.textAppName);

        btnGoogle = findViewById(R.id.google_registrasi);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = etUsername.getText().toString();
                textAppName.setText(s);
                Toast.makeText(Login.this, "Login with Google", Toast.LENGTH_SHORT).show();
            }
        });
    }


}