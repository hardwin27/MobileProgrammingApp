package com.example.mobileprogrammingapp.Fragment;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mobileprogrammingapp.Activity.Login;
import com.example.mobileprogrammingapp.Activity.MainActivity;
import com.example.mobileprogrammingapp.R;
import com.example.mobileprogrammingapp.search_activity;
import com.example.mobileprogrammingapp.ui.cardAdapter;
import com.example.mobileprogrammingapp.ui.cardYcAdapter;
import com.example.mobileprogrammingapp.ui.helperClass;

import java.util.ArrayList;

public class Courses extends Fragment {

    RecyclerView recentRecycler;
    RecyclerView ycRecycler;
    RecyclerView.Adapter adapter;
    RecyclerView.Adapter adapter2;
    ImageView btnSearch;


    public Courses() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_courses, container, false);

        //hooks
        recentRecycler = view.findViewById(R.id.recent_recycler);
        ycRecycler = view.findViewById(R.id.yc_recycler);
        btnSearch = view.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent(getActivity(), search_activity.class);

                startActivity(intent3);
            }
        });

        recentRecycler();
        ycRecycler();

        return view;
    }

    private void recentRecycler(){

        recentRecycler.setHasFixedSize(true); //load cards that only seen by user
        recentRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

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
        ycRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

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