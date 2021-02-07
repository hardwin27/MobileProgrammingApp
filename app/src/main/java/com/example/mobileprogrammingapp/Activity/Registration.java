package com.example.mobileprogrammingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Registration extends AppCompatActivity {

    Button btnRegistration;
    EditText etEmail, etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initialSetup();
    }

    private void initialSetup() {
        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnRegistration = findViewById(R.id.btnRegistration);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog pdialog = new ProgressDialog(Registration.this);
                pdialog.setCancelable(false);
                pdialog.setMessage("Signing Up...");
                pdialog.show();

                String email = etEmail.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                String url = "http://undispensed-rose.000webhostapp.com/registration.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Registration.this, response, Toast.LENGTH_SHORT).show();
                        pdialog.dismiss();
                        if (response.equals("success")) {
                            finish();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registration.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        pdialog.dismiss();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("email", email);
                        params.put("username", username);
                        params.put("password", password);
                        return params;
                    }
                };
                MySingleton.getInstance(Registration.this).addToRequestque(stringRequest);

            }
        });
    }
}