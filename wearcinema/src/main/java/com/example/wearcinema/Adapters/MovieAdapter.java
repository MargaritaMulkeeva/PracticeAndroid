package com.example.wearcinema.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wearcinema.Networks.Models.MoviesResponse;
import com.example.wearcinema.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private ArrayList<MoviesResponse> movieResponses;
    private LayoutInflater inflater;
    private Context context;
    private LinearLayout linearLayout;

    public MovieAdapter(ArrayList<MoviesResponse> movieResponse, Context context) {
        this.movieResponses = movieResponse;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.movies_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoviesResponse movieResponse = movieResponses.get(position);
        holder.setTextCinema(movieResponse.getName());
        Picasso.with(context).load("http://cinema.areas.su/up/images/" + movieResponse.getPoster()).into(holder.coverCinema);
    }

    @Override
    public int getItemCount() {
        return movieResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final private ImageView coverCinema;
        final private TextView txtCinema;

        private ViewHolder(View view) {
            super(view);
            this.coverCinema = (ImageView) view.findViewById(R.id.film_image);
            this.txtCinema = (TextView) view.findViewById(R.id.film_title);
        }

        public void setTextCinema(String text){
            this.txtCinema.setText(text);
        }
    }
}
