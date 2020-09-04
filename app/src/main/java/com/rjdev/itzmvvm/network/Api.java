package com.rjdev.itzmvvm.network;


import com.rjdev.itzmvvm.model.Result;
import com.rjdev.itzmvvm.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface Api {

    @FormUrlEncoded
    @POST("?apicall=loginUser")
    Call<Result> logInUser(@Field("EMP_ID") String name,
                            @Field("EMP_PASSWORD") String email,
                            @Field("FCM_ID") String fcm,
                            @Field("IMEI_NO") String imei);

     @FormUrlEncoded
     @POST("?apicall=getuserslistmanager")
     Call<UserResponse> loaduser(@Field("location_id") String location_id,
                                  @Field("t_date") String t_date,
                                  @Field("t_month") String t_month,
                                  @Field("t_year") String t_year);

}
