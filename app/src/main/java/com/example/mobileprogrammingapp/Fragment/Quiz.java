package com.example.mobileprogrammingapp.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mobileprogrammingapp.Activity.Login;
import com.example.mobileprogrammingapp.Activity.MainActivity;
import com.example.mobileprogrammingapp.Activity.Questioner;
import com.example.mobileprogrammingapp.Database.MySingleton;
import com.example.mobileprogrammingapp.Object.Question;
import com.example.mobileprogrammingapp.Object.QuestionManager;
import com.example.mobileprogrammingapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Quiz extends Fragment {

    Button btnAssesment;

    public Quiz() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        btnAssesment = view.findViewById(R.id.btnAssesment);
        btnAssesment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Questioner.class));
                getActivity().finish();
            }
        });

        return view;
    }


}