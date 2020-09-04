package com.rjdev.itzmvvm.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rjdev.itzmvvm.model.Result;
import com.rjdev.itzmvvm.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    private static final String TAG = LoginRepository.class.getSimpleName();
    private Application application;

    public LoginRepository(Application application) {
        this.application = application;
    }

    public LiveData<Result> getLoginResponseData(String email, String password,String fcm,String imei) {
        final MutableLiveData<Result> mutableLiveData = new MutableLiveData<>();
        RetrofitClient.getInstance().getApi().logInUser(email, password,fcm,imei).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                Log.d(TAG, "onResponse: Succeeded");

                Result loginResponse = new Result();
                if(response.code() == 200){
                    Log.i("LLLLLLLLLLL","INSIDE");
                    loginResponse = response.body();
                }
                else {

                    loginResponse.setResponseMessage("Incorrect Password");

                }
                mutableLiveData.setValue(loginResponse);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d(TAG, t.getMessage());

            }


        });

        return mutableLiveData;
    }
}
