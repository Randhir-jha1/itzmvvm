package com.rjdev.itzmvvm.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPresencesUtility {
    //SharedPreferences file name
    private static String SHARED_PREFS_FILE_NAME = "mark_app_shared_prefs";

    private Context context;


    public SharedPresencesUtility(Context context) {
        this.context = context;
    }

    public static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }



    public static void setEmpId(Context context, String value) {
        getPrefs(context).edit().putString("emp_id_str", value).commit();
    }
    public static String getEmpId(Context context) {
        return getPrefs(context).getString("emp_id_str", "");
    }
    public static String getUserName(Context context) {
        return getPrefs(context).getString("user_name_str", "");
    }
    //Strings
    public static void setUserName(Context context, String value) {
        getPrefs(context).edit().putString("user_name_str", value).commit();
    }
    public static String getUserDesignation(Context context) {
        return getPrefs(context).getString("user_designation_str", "");
    }


    //Strings
    public static void setUserDesignation(Context context, String value) {
        getPrefs(context).edit().putString("user_designation_str", value).commit();
    }
    public static void setLocationId(Context context, String value) {
        getPrefs(context).edit().putString("user_loc_id", value).commit();
    }
    public static String getLocationId(Context context) {
        return getPrefs(context).getString("user_loc_id", "1");
    }



}
