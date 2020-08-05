package com.example.yota;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PosterRecyclerViewAdapter extends RecyclerView.Adapter<PosterRecyclerViewAdapter.MyViewHolder> {

    protected ArrayList<String> mDataSet;
    protected Context context;
    protected LayoutInflater mInflater;


    public PosterRecyclerViewAdapter(ArrayList<String> titles, Context context) {
        this.mDataSet = titles;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recyclerview_poster_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


//        holder.falsvoriteView.setVisibility(mDataSet.get(position).getFavotite() ? View.VISIBLE : View.INVISIBLE);


    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

//        View favoriteView;

        MyViewHolder(View itemView) {
            super(itemView);
//            favoriteView = itemView.findViewById(R.id.favorite_view);
        }
    }
}