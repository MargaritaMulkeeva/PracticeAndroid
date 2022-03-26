package com.example.practice1.NetWork.Service;

import com.example.practice1.NetWork.Models.UserInfoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiProfileService {
    @GET("user")
    Call<List<UserInfoResponse>> getData(@Header("Authorization") String token);
}
