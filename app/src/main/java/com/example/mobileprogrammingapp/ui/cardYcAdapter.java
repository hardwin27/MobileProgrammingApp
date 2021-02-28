package com.example.mobileprogrammingapp.ui;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileprogrammingapp.Activity.CourseDetail;
import com.example.mobileprogrammingapp.R;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class cardYcAdapter extends RecyclerView.Adapter<cardYcAdapter.ycViewHolder> {
    static ArrayList<helperClass> ycCard;

    public cardYcAdapter(ArrayList<helperClass> ycCard) {
        this.ycCard = ycCard;
    }

    @NonNull
    @Override
    public ycViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creating simple view pointing to recent_card_design
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.your_courses, parent, false);

        //pass the design to recentViewHolder and return it
        ycViewHolder ycViewHolder = new ycViewHolder(view);
        return ycViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ycViewHolder holder, int position) {
        //asign helperClass values which contain images, title, and desc on position each time depends on number of elements
        helperClass helperClass = ycCard.get(position);

        holder.image.setImageResource(helperClass.getImage());
        holder.title.setText(helperClass.getTitle());
        holder.desc.setText(helperClass.getDesc());
        holder.url.setText(helperClass.url);
    }

    @Override
    public int getItemCount() {
        return ycCard.size();
    }


    //Hold the view
    public static class ycViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc, url;

        public ycViewHolder(@NonNull View itemView) {
            super(itemView);

            //setOnClickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //start new intent
                    Intent I = new Intent(v.getContext(), CourseDetail.class);
                    I.putExtra("title", title.getText().toString());
                    I.putExtra("url", url.getText().toString());
                    v.getContext().startActivity(I); //Start next activity
                }
            });

            //hooks
            image = itemView.findViewById(R.id.yc_image);
            title = itemView.findViewById(R.id.yc_title);
            desc = itemView.findViewById(R.id.yc_desc);
            url = itemView.findViewById(R.id.yc_url);

        }
    }

}


