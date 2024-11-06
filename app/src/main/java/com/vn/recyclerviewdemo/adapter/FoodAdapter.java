package com.vn.recyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vn.recyclerviewdemo.R;
import com.vn.recyclerviewdemo.model.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
    private Context context;
    private ArrayList<Food> foods;

    public FoodAdapter(Context context, ArrayList<Food> foods) {
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.name.setText(foods.get(position).getName());
        holder.price.setText(String.valueOf(foods.get(position).getPrice()));
        holder.addrress.setText(foods.get(position).getAddress());
        holder.image.setImageResource(foods.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        if(foods != null)
            return foods.size();
            return 0;
    }

    public static final class FoodViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView price;
        TextView addrress;
       public FoodViewHolder(@NonNull View itemView) {
           super(itemView);
           image = itemView.findViewById(R.id.imgV);
           name = itemView.findViewById(R.id.tvname);
           price = itemView.findViewById(R.id.tvprice);
           addrress = itemView.findViewById(R.id.tvadress);
       }
   }
}

