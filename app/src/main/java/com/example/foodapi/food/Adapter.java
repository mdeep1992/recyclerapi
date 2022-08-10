package com.example.foodapi.food;

import android.content.Context;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder>  {

    List<Record> list;
    private Context context;
    MyOnClick myOnClick;

    public Adapter(Context context, List<Record> list , MyOnClick myclick) {
        this.context = context;
        this.list = list;
        this.myOnClick  = myclick;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.name.setText(list.get(position).getName());
        // holder.image.setImageResource((list.get(position).getImage()));
        Log.i("imageurl>>>", list.get(position).getImage());
        holder.description.setText(list.get(position).getDescription());

        Picasso.with(context).load(list.get(position).getImage()).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView name, description;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.row_image);
            name = itemView.findViewById(R.id.row_txtname);
            description = itemView.findViewById(R.id.row_txtaddress);
            itemView.setOnClickListener(this);

        }



        @Override
        public void onClick(View view) {


            myOnClick.onClick(view, list.get(getAdapterPosition()));

/*
            Intent intent = new Intent(context, FoodActivity.class);
            intent.putExtra("image", list.get(getAdapterPosition()).getImage());
            intent.putExtra("heading", list.get(getAdapterPosition()).getHeadline());
            intent.putExtra("desc", list.get(getAdapterPosition()).getDescription());
            intent.putExtra("protein", list.get(getAdapterPosition()).getProteins());
            intent.putExtra("fat", list.get(getAdapterPosition()).getFats());
            intent.putExtra("calorie", list.get(getAdapterPosition()).getCalories());
            context.startActivity(intent);*/

        }
    }


}


