package com.example.mobileprogrammingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.mobileprogrammingapp.ui.cardAdapter;
import com.example.mobileprogrammingapp.ui.cardYcAdapter;
import com.example.mobileprogrammingapp.ui.helperClass;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    RecyclerView recentRecycler;
    RecyclerView ycRecycler;
    RecyclerView.Adapter adapter;
    RecyclerView.Adapter adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //hooks
        recentRecycler = findViewById(R.id.recent_recycler);
        ycRecycler = findViewById(R.id.yc_recycler);

        recentRecycler();
        ycRecycler();

    }

    private void recentRecycler(){

        recentRecycler.setHasFixedSize(true); //load cards that only seen by user
        recentRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<helperClass> recentCard = new ArrayList<>();

        recentCard.add(new helperClass(R.drawable.download, "Course 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        recentCard.add(new helperClass(R.drawable.download, "Course 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        recentCard.add(new helperClass(R.drawable.download, "Course 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));

        //pass the arrayList to adapter
        adapter = new cardAdapter(recentCard);
        recentRecycler.setAdapter(adapter);

        GradientDrawable grad1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffD3D0CB, 0xff1B998B});
    }

    private void ycRecycler(){

        ycRecycler.setHasFixedSize(true); //load cards that only seen by user
        ycRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<helperClass> ycCard = new ArrayList<>();

        ycCard.add(new helperClass(R.drawable.download, "Course 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        ycCard.add(new helperClass(R.drawable.download, "Course 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        ycCard.add(new helperClass(R.drawable.download, "Course 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        ycCard.add(new helperClass(R.drawable.download, "Course 4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));
        ycCard.add(new helperClass(R.drawable.download, "Course 5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam diam"));

        //pass the arrayList to adapter
        adapter2 = new cardYcAdapter(ycCard);
        ycRecycler.setAdapter(adapter2);


        GradientDrawable grad1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffD3D0CB, 0xff1B998B});

    }
}