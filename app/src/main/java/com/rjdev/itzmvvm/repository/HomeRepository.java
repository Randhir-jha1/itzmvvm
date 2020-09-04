package com.rjdev.itzmvvm.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rjdev.itzmvvm.model.Result;
import com.rjdev.itzmvvm.model.UserResponse;
import com.rjdev.itzmvvm.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    private static final String TAG = HomeRepository.class.getSimpleName();
    private Application application;

    public HomeRepository(Application application) {
        this.application = application;
    }

    public LiveData<UserResponse> getUserResponseData(String location, String date, String month, String year) {
        final MutableLiveData<UserResponse> mutableLiveData = new MutableLiveData<>();
        RetrofitClient.getInstance().getApi().loaduser(location, date,month,year).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                Log.d(TAG, "onResponse: Succeeded");

                UserResponse userResponse = new UserResponse();
                if(response.code() == 200){
                    Log.i("LLLLLLLLLLL","INSIDE");
                    userResponse = response.body();
                }
                else {

                    userResponse.setResponseMessage("Response Error");

                }
                mutableLiveData.setValue(userResponse);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());

            }


        });

        return mutableLiveData;
    }
}
