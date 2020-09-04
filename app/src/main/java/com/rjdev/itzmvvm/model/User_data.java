package com.rjdev.itzmvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User_data implements Serializable {
    @SerializedName("user_id")
    private String user_id;

    @SerializedName("emp_id")
    private String emp_id;

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getEmp_id ()
    {
        return emp_id;
    }

    public void setEmp_id (String emp_id)
    {
        this.emp_id = emp_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [user_id = "+user_id+", emp_id = "+emp_id+"]";
    }
}
