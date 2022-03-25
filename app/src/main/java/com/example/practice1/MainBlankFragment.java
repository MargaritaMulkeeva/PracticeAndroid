package com.example.practice1;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.practice1.Adapters.MoviesAdapter;
import com.example.practice1.NetWork.ApiHundler;
import com.example.practice1.NetWork.ErrorUtils;
import com.example.practice1.NetWork.Models.PhotoBody;
import com.example.practice1.NetWork.Service.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainBlankFragment extends Fragment {

    private MoviesAdapter moviesListAdapter;
    private List<PhotoBody> mMovies;
    private RecyclerView mMoviesContainer;

    private ApiService service = ApiHundler.getInstance().getService();

    public MainBlankFragment() {
        // Required empty public constructor
    }
    public static MainBlankFragment newInstance(String param1, String param2) {
        return new MainBlankFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_blank, container, false);

        fetchMovies();
        InitUI(view);
        return view;
    }
    private void InitUI(View view) {

        mMoviesContainer = view.findViewById(R.id.mainMoviesContainer);
    }

    private void fetchMovies() {
        AsyncTask.execute(() -> {
            service.fetchMovies("new").enqueue(new Callback<List<PhotoBody>>() {
                @Override
                public void onResponse(Call<List<PhotoBody>> call, Response<List<PhotoBody>> response) {
                    if (response.isSuccessful()) {
                        mMovies = response.body();
                        moviesListAdapter = new MoviesAdapter(getContext(), mMovies);

                        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                        mMoviesContainer.setLayoutManager(manager);
                        mMoviesContainer.setAdapter(moviesListAdapter);
                    } else if (response.code() == 400) {
                        String serverErrorMessage = ErrorUtils.parseError(response).message();
                        Toast.makeText(getContext(), serverErrorMessage, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Не удалось получить информацию о фильме 1", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<PhotoBody>> call, Throwable t) {
                    Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}