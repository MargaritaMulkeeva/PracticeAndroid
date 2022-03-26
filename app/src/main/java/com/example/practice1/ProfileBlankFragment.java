package com.example.practice1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.practice1.NetWork.Models.UserInfoResponse;
import com.example.practice1.NetWork.ProfileHundler;
import com.example.practice1.NetWork.Service.ApiProfileService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileBlankFragment extends Fragment {
    private SharedPreferences sharedPreferences;
    private String token;
    private String TAG = "Привет!";
    ApiProfileService service = ProfileHundler.getInstance().getProfileService();
    TextView txtFirstName, txtLastName, txtEmail;


    public ProfileBlankFragment() {
        // Required empty public constructor
    }

    public static ProfileBlankFragment newInstance(String param1, String param2) {
        ProfileBlankFragment fragment = new ProfileBlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_blank, container, false);
        txtFirstName = view.findViewById(R.id.txt_name);
        txtLastName = view.findViewById(R.id.txt_lastname);
        txtEmail = view.findViewById(R.id.txt_email);
        view.findViewById(R.id.btn_exit).setOnClickListener(v -> {
            sharedPreferences= getContext().getSharedPreferences("token",Context.MODE_PRIVATE);
            sharedPreferences.edit().remove("token").commit();
            startActivity(new Intent(getContext(), MainActivity.class));
        });
        AsyncTask.execute(() -> {
            service.getData(token).enqueue(new Callback<List<UserInfoResponse>>() {
                @Override
                public void onResponse(Call<List<UserInfoResponse>> call, Response<List<UserInfoResponse>> response) {
                    txtFirstName.setText(response.body().get(0).getFirstName());
                    txtLastName.setText(response.body().get(0).getLastName());
                    txtEmail.setText(response.body().get(0).getEmail());
                }

                @Override
                public void onFailure(Call<List<UserInfoResponse>> call, Throwable t) {
                    Log.d(TAG, "onFailure: Что-то пошло не так");
                }
            });
        });
        return view;
    }
}