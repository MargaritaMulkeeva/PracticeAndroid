package com.example.wearcinema.Networks.Service;

import com.example.wearcinema.Networks.Models.LoginBody;
import com.example.wearcinema.Networks.Models.LoginResponse;
import com.example.wearcinema.Networks.Models.MoviesResponse;
import com.example.wearcinema.Networks.Models.RegisterBody;
import com.example.wearcinema.Networks.Models.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("login")
    Call<LoginResponse> doLogin(@Body LoginBody registerBody);
    @POST("register")
    Call<RegisterResponse> doRegistration(@Body RegisterBody registerBody);
    @GET("movies?filter=new")
    Call<List<MoviesResponse>> getMovies();
}
