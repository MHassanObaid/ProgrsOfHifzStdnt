package com.example.progrsofhifzstdnt;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyVH> {


    List<HafizStudent> friendsList;
     //HafizStudent friendsList;

    public MyRecyclerViewAdapter(Context context , List<HafizStudent> friendsList) {

        this.friendsList = friendsList;
        this.friendsList = friendsList;
    }



    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleritem, parent, false);
        return new MyVH(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=friendsList.get(position);
        holder.nameText.setText(holder.data.getName());
        holder.ageText.setText(String.valueOf(holder.data.getAge()));
        holder.classText.setText(holder.data.getClas());
         holder.sabaqText.setText(String.valueOf(holder.data.getSabaqPara())+String.valueOf(holder.data.getSabaqStVrse())+String.valueOf(holder.data.getSabaqLsVrse()));
        holder.sabaqiText.setText(String.valueOf(holder.data.getSabaqi()));
        holder.ManzilText.setText(holder.data.getManzil());

         //holder.textViewCity.setText(holder.data.getCity());
    }


    @Override
    public int getItemCount() {
        return friendsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder
    {


         TextView nameText;
        TextView ageText;
        TextView classText;
        TextView sabaqText;

        TextView sabaqiText;
        TextView ManzilText;

        HafizStudent data;
        public MyVH(View itemView)
        {
               super(itemView);
               nameText = itemView.findViewById(R.id.textView1);
            ageText = itemView.findViewById(R.id.textView2);
            classText = itemView.findViewById(R.id.textView3);
            sabaqText = itemView.findViewById(R.id.textView5);
            sabaqiText = itemView.findViewById(R.id.textView8);
            ManzilText = itemView.findViewById(R.id.textView9);

        }

    }


}
