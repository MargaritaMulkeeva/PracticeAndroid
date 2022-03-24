package com.example.practice1.NetWork.Service;

import com.example.practice1.NetWork.Models.LoginBody;
import com.example.practice1.NetWork.Models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("login")
    Call<LoginResponse> doLogin(@Body LoginBody registerBody);
}
