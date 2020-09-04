package com.rjdev.itzmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rjdev.itzmvvm.model.Result;
import com.rjdev.itzmvvm.repository.LoginRepository;

public class LoginViewModel extends AndroidViewModel {
    private LoginRepository loginRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepository = new LoginRepository(application);
    }

    public LiveData<Result> getLoginResponseLiveData(String email, String password,String fcm,String imei) {
        return loginRepository.getLoginResponseData(email,password,fcm,imei);
    }
}
