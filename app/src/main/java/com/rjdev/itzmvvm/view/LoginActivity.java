package com.rjdev.itzmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rjdev.itzmvvm.R;
import com.rjdev.itzmvvm.databinding.ActivityLoginBinding;
import com.rjdev.itzmvvm.model.Result;
import com.rjdev.itzmvvm.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loginUser();
            }
        });
    }
    private void loginUser(){
        String userid = loginBinding.inputEmail.getText().toString();
        String password = loginBinding.inputPassword.getText().toString();

        loginViewModel.getLoginResponseLiveData(userid,password,"eePUlricSEk:APA91bEN9ncQmQNpt6IoaMXEnMsYH7TPhsbkL" +
                "jNJbJqaZJgG8nNnV1TCYDbL8BuX6aRfYFbseh87HI5oGGkr14nttZVxdzhLM2AHCWdJJeUsB8voM09urDe5YU5oY_1nXdTdPgJCiAXD","866783041257050").observe(this, loginApiResponse -> {
            if (loginApiResponse.getResponseCode().matches("200")) {

                Toast.makeText(this, loginApiResponse.getUser_data().getUser_id(), Toast.LENGTH_SHORT).show();

            }else {

                Toast.makeText(this, loginApiResponse.getResponseMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}