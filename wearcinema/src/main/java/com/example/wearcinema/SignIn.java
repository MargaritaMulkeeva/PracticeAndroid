package com.example.wearcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wearcinema.Networks.ApiHandler;
import com.example.wearcinema.Networks.ErrorUtils;
import com.example.wearcinema.Networks.Models.LoginBody;
import com.example.wearcinema.Networks.Models.LoginResponse;
import com.example.wearcinema.Networks.Service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {


    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private String token;
    Button btnSignIn;

    private static final String TAG = "SignIn";
    EditText editEmail, editPassword;

    ApiService service = ApiHandler.getInstance().getService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editor = getSharedPreferences("token", MODE_PRIVATE).edit();
        preferences = getSharedPreferences("token", MODE_PRIVATE);
        token = preferences.getString("token", "");
        if(token != ""){
            Intent intent = new Intent(SignIn.this, MainActivity.class);
            startActivity(intent);
        }

        initializeViews();
    }
    private void initializeViews() {
        btnSignIn = findViewById(R.id.btn_signIn);

        editEmail = findViewById(R.id.et_email);
        editPassword = findViewById(R.id.et_password);

        findViewById(R.id.btn_signIn).setOnClickListener(view -> {
            doLogin();
        });
    }

    private void doLogin(){

        AsyncTask.execute(() -> {
            service.doLogin(getLoginData()).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                    if (response.isSuccessful()) {
                        editor.putString("token", response.body().getToken()).apply();
                        Toast.makeText(getApplicationContext(), "Авторизация прошла успешно! Держи свой токен: " + response.body().getToken(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignIn.this, MainActivity.class);
                        startActivity(intent);
                    } else if (response.code() == 400){
                        String serverErrorMessage = ErrorUtils.parseError(response).getError();
                        Toast.makeText(getApplicationContext(), serverErrorMessage, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Произошла неизвестная ошибка! Попробуйте позже", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private LoginBody getLoginData() {
        return new LoginBody(editEmail.getText().toString(), editPassword.getText().toString());
    }
}