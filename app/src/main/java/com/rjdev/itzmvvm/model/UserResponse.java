package com.rjdev.itzmvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class UserResponse implements Serializable {

    @SerializedName("ResponseCode")
    private String ResponseCode;

    @SerializedName("Response")
    private ArrayList<UsersDataModel> UsersDataModel;

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

    public ArrayList<UsersDataModel> getUsersDataModel ()
    {
        return UsersDataModel;
    }

    public void setUsersDataModel (ArrayList<UsersDataModel> UsersDataModel)
    {
        this.UsersDataModel = UsersDataModel;
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
        return "ClassPojo [ResponseCode = "+ResponseCode+", UsersDataModel = "+UsersDataModel+", ResponseMessage = "+ResponseMessage+"]";
    }
}
