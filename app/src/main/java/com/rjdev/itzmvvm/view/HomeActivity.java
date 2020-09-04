package com.rjdev.itzmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.rjdev.itzmvvm.R;
import com.rjdev.itzmvvm.adapter.UsersDataAdapter;
import com.rjdev.itzmvvm.databinding.ActivityHomeBinding;
import com.rjdev.itzmvvm.viewmodel.HomeViewModel;
import com.rjdev.itzmvvm.viewmodel.LoginViewModel;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding homeBinding;
    private HomeViewModel homeViewModel;
    private UsersDataAdapter usersDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        locinitViewsEvent();


    }
    private void locinitViewsEvent() {


        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        homeBinding.rvUserlist.setLayoutManager(horizontalLayoutManager);
        homeBinding.rvUserlist.setHasFixedSize(true);
        loaddata();
    }
    private void loaddata(){


        homeViewModel.getUserResponseLiveData("2","13","8","2020").observe(this, userResponse -> {
            if (userResponse.getResponseCode().matches("200")) {

                Log.i("TESESE",String.valueOf(userResponse.getUsersDataModel().size()));
                usersDataAdapter = new UsersDataAdapter(userResponse.getUsersDataModel(),HomeActivity.this);
                homeBinding.rvUserlist.setAdapter(usersDataAdapter);


            }else {

                Toast.makeText(this, userResponse.getResponseMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
