package com.example.mobileprogrammingapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobileprogrammingapp.Activity.Login;
import com.example.mobileprogrammingapp.Activity.Registration;
import com.example.mobileprogrammingapp.R;
import com.example.mobileprogrammingapp.search_activity;

public class Profile extends Fragment {

    Button edit;
    TextView tvUsername, tvFullName, tvEmail;
    String username, email;

    public Profile(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initialSetup(view);
        return view;
    }

    private void initialSetup(View view) {
        tvUsername = view.findViewById(R.id.user_name);
        tvFullName = view.findViewById(R.id.tvFullName);
        tvEmail = view.findViewById(R.id.tvEmail);

        tvUsername.setText(username);
        tvFullName.setText(username);
        tvEmail.setText(email);

        edit = view.findViewById(R.id.btnEdit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getActivity(), edit_profile.class);
                startActivity(intent4);
            }
        });
    }
}