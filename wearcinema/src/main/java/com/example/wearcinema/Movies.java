package com.example.wearcinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.wearcinema.Adapters.MovieAdapter;
import com.example.wearcinema.Networks.Models.MoviesResponse;
import com.example.wearcinema.Networks.MovieHandler;
import com.example.wearcinema.Networks.Service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Movies extends AppCompatActivity {

    private ArrayList<MoviesResponse> movieResponses;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MovieAdapter movieAdapter;

    private ApiService serviceMovie = MovieHandler.getInstance().getService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        recyclerView = findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getMovies();
    }

    private void getMovies() {
        AsyncTask.execute(() -> {
            serviceMovie.getMovies().enqueue(new Callback<List<MoviesResponse>>() {
                @Override
                public void onResponse(Call<List<MoviesResponse>> call, Response<List<MoviesResponse>> response) {
                    if(response.isSuccessful()){
                        movieResponses = new ArrayList<>(response.body());
                        movieAdapter = new MovieAdapter(movieResponses, Movies.this);
                        recyclerView.setAdapter(movieAdapter);
                        movieAdapter.notifyDataSetChanged();
                    } else if (response.code() == 400) {
                        Toast.makeText(Movies.this, "ПРоизошла ошибка", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Movies.this, "Произошла неизвестная ошибка", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<MoviesResponse>> call, Throwable t) {
                    Toast.makeText(Movies.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("SomeFragment", "onFailure: " + t.getLocalizedMessage());
                }
            });
        });
    }
}