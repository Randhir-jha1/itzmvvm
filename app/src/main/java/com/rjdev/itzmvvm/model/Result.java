package com.rjdev.itzmvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    @SerializedName("ResponseCode")
    private String ResponseCode;

    @SerializedName("User_data")
    private User_data User_data;

    @SerializedName("ResponseMessage")
    private String ResponseMessage;

    public String getResponseCode ()
    {
        return ResponseCode;
    }

    public void setResponseCode (String ResponseCode)
    {
        this.ResponseCode = ResponseCode;
    }

    public User_data getUser_data ()
    {
        return User_data;
    }

    public void setUser_data (User_data User_data)
    {
        this.User_data = User_data;
    }

    public String getResponseMessage ()
    {
        return ResponseMessage;
    }

    public void setResponseMessage (String ResponseMessage)
    {
        this.ResponseMessage = ResponseMessage;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ResponseCode = "+ResponseCode+", User_data = "+User_data+", ResponseMessage = "+ResponseMessage+"]";
    }
}
