package com.example.mobileprogrammingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.mobileprogrammingapp.ui.cardSearchRes;
import com.example.mobileprogrammingapp.ui.cardYcAdapter;
import com.example.mobileprogrammingapp.ui.helperClass;

import java.util.ArrayList;

public class search_activity extends AppCompatActivity {
     EditText searchField;
     ImageButton searchBtn;
     RecyclerView searchResRecycler;
    RecyclerView.Adapter adapter;

     public search_activity(){

     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);

        searchField = (EditText) findViewById(R.id.search_field);
        searchBtn = (ImageButton) findViewById(R.id.searchBtn);

        searchResRecycler = (RecyclerView) findViewById(R.id.search_res);
        searchRecycler();
    }

    private void searchRecycler(){

        searchResRecycler.setHasFixedSize(true); //load cards that only seen by user
        searchResRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        ArrayList<helperClass> cardSearch = new ArrayList<>();

        cardSearch.add(new helperClass(R.drawable.download, "Course 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        cardSearch.add(new helperClass(R.drawable.download, "Course 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        cardSearch.add(new helperClass(R.drawable.download, "Course 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        cardSearch.add(new helperClass(R.drawable.download, "Course 4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        cardSearch.add(new helperClass(R.drawable.download, "Course 5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));

        //pass the arrayList to adapter
        adapter = new cardSearchRes(cardSearch);
        searchResRecycler.setAdapter(adapter);




    }
}