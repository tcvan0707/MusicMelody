package com.example.musicmelody.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicmelody.R;
import com.example.musicmelody.model.charts.Track;
import com.example.musicmelody.model.search.Hit;
import com.example.musicmelody.util.OnItemClickListener;
import com.jackandphantom.androidlikebutton.AndroidLikeButton;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    ArrayList<Hit> data;
    Context context;
    OnItemClickListener listener;

    public SearchAdapter(Context context, ArrayList<Hit> data,OnItemClickListener listener){
        this.data=data;
        this.context=context;
        this.listener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTrack().getTitle());
        holder.subtitle.setText(data.get(position).getTrack().getSubtitle());
        Glide.with(context).load(data.get(position).getTrack().getImages().getBackground()).into(holder.image);
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView subtitle;
        public AppCompatImageView image;
        public AndroidLikeButton like;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            image = (AppCompatImageView) itemView.findViewById(R.id.image);
            like = (AndroidLikeButton) itemView.findViewById(R.id.like);

        }
    }
}