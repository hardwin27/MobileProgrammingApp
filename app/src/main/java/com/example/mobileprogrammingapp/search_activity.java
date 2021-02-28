package com.example.mobileprogrammingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.example.mobileprogrammingapp.Object.CourseObj;
import com.example.mobileprogrammingapp.ui.cardSearchRes;
import com.example.mobileprogrammingapp.ui.cardYcAdapter;
import com.example.mobileprogrammingapp.ui.helperClass;

import java.util.ArrayList;

public class search_activity extends AppCompatActivity {
     SearchView searchField;
     ImageButton searchBtn;
     RecyclerView searchResRecycler;
     cardSearchRes adapter;

     ArrayList<helperClass> arrayList = new ArrayList<>();

     public search_activity(){

     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);

        ArrayList<CourseObj> courses = CourseObj.getAll();

        for (CourseObj obj : courses) {
            arrayList.add(new helperClass(R.drawable.download, obj.title, obj.desc, obj.url));
        }

        searchField = findViewById(R.id.search_field);
        searchBtn = (ImageButton) findViewById(R.id.searchBtn);

        searchResRecycler = (RecyclerView) findViewById(R.id.search_res);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        searchResRecycler.setLayoutManager(layoutManager);
        searchResRecycler.setHasFixedSize(true);
        searchRecycler();

        searchField.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<helperClass> filterList = new ArrayList<>();

                for (helperClass item : arrayList) {
                    String title = item.getTitle().toLowerCase();
                    if (title.contains(s.toLowerCase())) {
                        filterList.add(item);
                    }
                }
                if (adapter != null) {
                    adapter.filter(filterList);
                }
                return true;
            }
        });
    }

    private void searchRecycler(){

        searchResRecycler.setHasFixedSize(true); //load cards that only seen by user
        searchResRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        //pass the arrayList to adapter
        adapter = new cardSearchRes(arrayList);
        searchResRecycler.setAdapter(adapter);


    }
}