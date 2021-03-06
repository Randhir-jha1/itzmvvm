package com.rjdev.itzmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rjdev.itzmvvm.model.Result;
import com.rjdev.itzmvvm.model.UserResponse;
import com.rjdev.itzmvvm.repository.HomeRepository;
import com.rjdev.itzmvvm.repository.LoginRepository;

public class HomeViewModel extends AndroidViewModel {
    private HomeRepository homeRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        homeRepository = new HomeRepository(application);
    }

    public LiveData<UserResponse> getUserResponseLiveData(String location, String date, String month, String year){
        return homeRepository.getUserResponseData(location,date,month,year);
    }
}
