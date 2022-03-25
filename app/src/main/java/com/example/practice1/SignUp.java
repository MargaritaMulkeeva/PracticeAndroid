package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice1.NetWork.ApiHundler;
import com.example.practice1.NetWork.ErrorUtils;
import com.example.practice1.NetWork.Models.RegisterBody;
import com.example.practice1.NetWork.Models.RegistrationResponse;
import com.example.practice1.NetWork.Service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    private static final String TAG = "Registration";

    EditText et_name, et_lastname, et_email, et_password;
    Button btn_signIn;

    ApiService service = ApiHundler.getInstance().getService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initializeViews();
        btn_signIn = findViewById(R.id.btn_signIn);
        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });
    }

    private void initializeViews() {
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_name = findViewById(R.id.et_name);
        et_lastname = findViewById(R.id.et_lastname);

        findViewById(R.id.btn_logIn).setOnClickListener(view -> {
            goRegistration();
        });
    }

    private void goRegistration() {
        AsyncTask.execute(() -> {
            service.goRegistration(getRegistrationData()).enqueue(new Callback<RegistrationResponse>() {
                @Override
                public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                    if (response.isSuccessful()) {
                        Intent intent = new Intent(SignUp.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        Log.d(TAG, "onResponse: " + getApplicationContext());
                        Toast.makeText(getApplicationContext(), "Регистрация успешна!", Toast.LENGTH_LONG).show();
                    } else if (response.code() == 400) {
                        String serviceErrorMessage = ErrorUtils.parseError(response).message();
                        Toast.makeText(getApplicationContext(), serviceErrorMessage, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Произошла ошибка!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });
    }

    private RegisterBody getRegistrationData() {
        return new RegisterBody(et_email.getText().toString(), et_password.getText().toString(), et_name.getText().toString(), et_lastname.getText().toString());
    }

    public void goLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
