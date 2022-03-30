package com.example.practice1.NetWork.Service;

import com.example.practice1.NetWork.Models.LoginBody;
import com.example.practice1.NetWork.Models.LoginResponse;
import com.example.practice1.NetWork.Models.MovieResponse;
import com.example.practice1.NetWork.Models.RegisterBody;
import com.example.practice1.NetWork.Models.RegistrationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("login")
    Call<LoginResponse> doLogin(@Body LoginBody registerBody);

    @POST("register")
    Call<RegistrationResponse> goRegistration(@Body RegisterBody registerBody);

    @GET("movies")
    Call<List<MovieResponse>> fetchMovies(@Query("filter") String filter);
}
