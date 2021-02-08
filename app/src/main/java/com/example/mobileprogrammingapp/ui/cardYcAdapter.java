package com.example.mobileprogrammingapp.ui;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD
import com.example.mobileprogrammingapp.Dashboard;
=======
>>>>>>> master
import com.example.mobileprogrammingapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class cardYcAdapter extends RecyclerView.Adapter<cardYcAdapter.ycViewHolder> {
    ArrayList<helperClass> ycCard;

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

        GradientDrawable grad1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffD3D0CB, 0xff1B998B});
        holder.image.setImageResource(helperClass.getImage());
        holder.title.setText(helperClass.getTitle());
        holder.desc.setText(helperClass.getDesc());

    }

    @Override
    public int getItemCount() {
        return ycCard.size();
    }


    //Hold the view
    public static class ycViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public ycViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.yc_image);
            title = itemView.findViewById(R.id.yc_title);
            desc = itemView.findViewById(R.id.yc_desc);


        }
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> master
