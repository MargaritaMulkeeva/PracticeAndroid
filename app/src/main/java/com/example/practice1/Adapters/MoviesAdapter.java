package com.example.practice1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.Chat.ChatBlankFragment;
import com.example.practice1.NetWork.Models.MovieResponse;
import com.example.practice1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    public class MovieHolder extends RecyclerView.ViewHolder {

        //необходимые переменные
        private TextView mTitle;
        private ImageView mPreview;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            //объявление переменных
            mTitle = itemView.findViewById(R.id.movie_title);
            mPreview = itemView.findViewById(R.id.movie_preview);
        }

        public void setMovieTitle(String title) {
            mTitle.setText(title);
        }

        public void setMoviePreview(String imageUrl) {
            Picasso.with(mContext)
                    .load(imageUrl).into(mPreview);
        }
    }

    //необходимые переменныед
    private List<MovieResponse> mMovies;
    private Context mContext;

    public MoviesAdapter(Context context, List<MovieResponse> movies) {
        mContext = context;
        mMovies = movies;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_list_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        final MovieResponse movie = mMovies.get(position);

        holder.setMovieTitle(movie.getName());
        holder.setMoviePreview("http://cinema.areas.su/up/images/" + movie.getPoster());
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}
