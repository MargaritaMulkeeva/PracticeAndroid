package com.example.practice1.NetWork;

import com.example.practice1.NetWork.Service.ApiProfileService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileHundler {
    private static ProfileHundler mInstance;
    private static final String BASEURL = "http://cinema.areas.su/";
    private Retrofit retrofit;

    public ProfileHundler() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ErrorUtils.retrofit = retrofit;
    }

    public static ProfileHundler getInstance() {
        if (mInstance == null) {
            mInstance = new ProfileHundler();
        }

        return mInstance;
    }

    public ApiProfileService getProfileService() {
        return retrofit.create(ApiProfileService.class);
    }
}
