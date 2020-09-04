package com.rjdev.itzmvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UsersDataModel implements Serializable {

    @SerializedName("d13")
    private String d_i;
    @SerializedName("total_present")
    private String total_present;

    @SerializedName("month")
    private String month;

    @SerializedName("year")
    private String year;

    @SerializedName("employee_id")
    private String employee_id;

    @SerializedName("name")
    private String name;

    @SerializedName("total_absent")
    private String total_absent;

    @SerializedName("id")
    private String id;

    @SerializedName("location_name")
    private String location_name;


    @SerializedName("location_id")
    private String location_id;

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getD_I ()
    {
        return d_i;
    }

    public void setD_I (String d_i)
    {
        this.d_i = d_i;
    }

    public String getTotal_present ()
    {
        return total_present;
    }

    public void setTotal_present (String total_present)
    {
        this.total_present = total_present;
    }

    public String getMonth ()
    {
        return month;
    }

    public void setMonth (String month)
    {
        this.month = month;
    }

    public String getYear ()
    {
        return year;
    }

    public void setYear (String year)
    {
        this.year = year;
    }

    public String getEmployee_id ()
    {
        return employee_id;
    }

    public void setEmployee_id (String employee_id)
    {
        this.employee_id = employee_id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getTotal_absent ()
    {
        return total_absent;
    }

    public void setTotal_absent (String total_absent)
    {
        this.total_absent = total_absent;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }
}
