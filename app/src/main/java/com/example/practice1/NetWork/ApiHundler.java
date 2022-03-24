package com.example.practice1.NetWork;

import com.example.practice1.NetWork.Service.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHundler {

    private static ApiHundler mInstance;
    private static final String BASE_URL="http://cinema.areas.su/auth/";

    private Retrofit retrofit;

    public ApiHundler(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create()) // говорим ретрофиту что будем использовать GsonConverterFactory чтобы конвертировать json в наши java-классы
                .build();

        ErrorUtils.retrofit = retrofit;
    }

    public static ApiHundler getInstance() {
        if (mInstance == null) {
            mInstance = new ApiHundler();
        }
        return mInstance;
    }

    public ApiService getService() {
        return retrofit.create(ApiService.class);
    }
}
