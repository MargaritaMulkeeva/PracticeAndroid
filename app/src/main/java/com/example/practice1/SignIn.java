package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice1.NetWork.ApiHundler;
import com.example.practice1.NetWork.ErrorUtils;
import com.example.practice1.NetWork.Models.LoginBody;
import com.example.practice1.NetWork.Models.LoginResponse;
import com.example.practice1.NetWork.Service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {

    Button btnSignIn;
    Button btnSignUp;

    EditText etEmail;
    EditText etPassword;

    private static final String TAG = "SignIn";
    EditText editEmail, editPassword;

    ApiService service = ApiHundler.getInstance().getService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initializeViews();

        btnSignUp = findViewById(R.id.btn_signUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
    private void initializeViews() {
        btnSignIn = findViewById(R.id.btn_signIn);

        btnSignUp = findViewById(R.id.btn_signUp);
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
                        Intent intent = new Intent(SignIn.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Авторизация прошла успешно! Держи свой токен: " + response.body().getToken(), Toast.LENGTH_SHORT).show();
                    } else if (response.code() == 400){
                        String serverErrorMessage = ErrorUtils.parseError(response).message();
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