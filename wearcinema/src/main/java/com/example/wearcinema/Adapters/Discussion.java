package com.example.wearcinema.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wearcinema.Networks.Models.MoviesResponse;
import com.example.wearcinema.R;

import java.util.ArrayList;

public class Discussion extends RecyclerView.Adapter<Discussion.ViewHolder> {

    private ArrayList<MoviesResponse> movieResponses;
    private LayoutInflater inflater;
    private Context context;
    private LinearLayout linearLayout;

    public Discussion(ArrayList<MoviesResponse> movieResponse, Context context) {
        this.movieResponses = movieResponse;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Discussion.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.discussions_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoviesResponse movieResponse = movieResponses.get(position);
        holder.setTextCinema(movieResponse.getName());
    }

    @Override
    public int getItemCount() {
        return movieResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final private TextView txtDiscussions;

        private ViewHolder(View view) {
            super(view);
            this.txtDiscussions = (TextView) view.findViewById(R.id.txt_discussions);
        }

        public void setTextCinema(String text){
            this.txtDiscussions.setText(text);
        }
    }
}
