package com.example.mobileprogrammingapp.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mobileprogrammingapp.Database.MySingleton;
import com.example.mobileprogrammingapp.R;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText etEmail, etPassword;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialSetup();
    }

    private void initialSetup() {
        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvRegister = findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.length() == 0) {
                    Toast.makeText(Login.this, "Please enter email", Toast.LENGTH_SHORT).show();
                } else if (password.length() == 0) {
                    Toast.makeText(Login.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else {

                    ProgressDialog pdialog = new ProgressDialog(Login.this);
                    pdialog.setCancelable(false);
                    pdialog.setMessage("Signin In...");
                    pdialog.show();

                    String url = "https://undispensed-rose.000webhostapp.com/login.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST,
                            url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            pdialog.dismiss();
                            if (response.equals("error")) {
                                Toast.makeText(Login.this, "Email or Password not found", Toast.LENGTH_LONG).show();
                            } else {
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                intent.putExtra("username",response);
                                intent.putExtra("email",email);
                                startActivity(intent);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            pdialog.dismiss();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("email", email);
                            params.put("password", password);
                            return params;
                        }
                    };
                    MySingleton.getInstance(Login.this).addToRequestque(stringRequest);

                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Registration.class));
            }
        });
    }


}