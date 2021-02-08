package com.example.mobileprogrammingapp.ui;

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

// card adapter is the text and view holder is the design
public class cardAdapter extends RecyclerView.Adapter<cardAdapter.recentViewHolder> {

    ArrayList<helperClass> recentCard;

    public cardAdapter(ArrayList<helperClass> recentCard) {
        this.recentCard = recentCard;
    }

    @NonNull
    @Override

    public recentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //creating simple view pointing to recent_card_design
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_card_design, parent, false);


        //pass the design to recentViewHolder and return it
        recentViewHolder recentViewHolder = new recentViewHolder(view);
        return recentViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull recentViewHolder holder, int position) {

        //asign helperClass values which contain images, title, and desc on position each time depends on number of elements
        helperClass helperClass = recentCard.get(position);

        holder.image.setImageResource(helperClass.getImage());
        holder.title.setText(helperClass.getTitle());
        holder.desc.setText(helperClass.getDesc());

    }

    @Override
    public int getItemCount() {
        return recentCard.size();

    }

    //Hold the view
    public static class recentViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public recentViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.recent_card_image);
            title = itemView.findViewById(R.id.recent_card_title);
            desc = itemView.findViewById(R.id.recent_desc_card);


        }
    }



<<<<<<< HEAD
}
=======
}
>>>>>>> master
