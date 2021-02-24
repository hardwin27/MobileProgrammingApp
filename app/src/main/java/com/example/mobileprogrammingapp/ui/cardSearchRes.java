package com.example.mobileprogrammingapp.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogrammingapp.Activity.CourseDetail;
import com.example.mobileprogrammingapp.R;

import java.util.ArrayList;

public class cardSearchRes extends RecyclerView.Adapter<cardSearchRes.searchCardViewHolder> {

    static ArrayList<helperClass> cardSearch;

    public cardSearchRes(ArrayList<helperClass> cardSearch) {
        this.cardSearch = cardSearch;
    }

    @NonNull
    @Override
    public searchCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creating simple view pointing to your_courses.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.your_courses, parent, false);


        //pass the design to recentViewHolder and return it
        searchCardViewHolder searchViewHolder = new searchCardViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull searchCardViewHolder holder, int position) {
        //asign helperClass values which contain images, title, and desc on position each time depends on number of elements
        helperClass helperClass = cardSearch.get(position);

        holder.image.setImageResource(helperClass.getImage());
        holder.title.setText(helperClass.getTitle());
        holder.desc.setText(helperClass.getDesc());
    }

    @Override
    public int getItemCount() {
        return cardSearch.size();
    }


    //Hold the view
    public static class searchCardViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public searchCardViewHolder(@NonNull View itemView) {
            super(itemView);

            //setOnClickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //start new intent

                    Intent I = new Intent(v.getContext(), CourseDetail.class);
                    I.putExtra("title", title.getText().toString());
                    v.getContext().startActivity(I); //Start next activity

                }
            });

            //hooks
            image = itemView.findViewById(R.id.yc_image);
            title = itemView.findViewById(R.id.yc_title);
            desc = itemView.findViewById(R.id.yc_desc);


        }
    }
}
