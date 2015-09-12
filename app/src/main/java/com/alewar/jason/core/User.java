package com.alewar.jason.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by alvaro on 12/09/15.
 */
public class User {
    private static final String TAG = User.class.getCanonicalName();

    private static final String COL_EMAIL = "email";
    private static final String COL_USERNAME = "user_name";
    private static final String COL_PHONE_NUMBER = "phone_number";
    private static final String USER_PREFERENCES = "user_prefs";
    private static final String LAST_PICKED_COUNTRY_INDEX = "country_index";

    private final SharedPreferences sharedPreferences;

    User() {
        sharedPreferences = ParkIP.getApplication().getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void setName(String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(COL_USERNAME, username);
        editor.apply();
        Log.v(TAG, "setName=" + username);
    }

    public void setEmail(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(COL_EMAIL, email);
        editor.apply();
        Log.v(TAG, "setEmail=" + email);
    }

    public void setPhoneNumber(String phoneNumber){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(COL_PHONE_NUMBER, phoneNumber);
        editor.apply();
        Log.v(TAG, "setPhoneNumber=" + phoneNumber);
    }

    public void setLastPickedCountryIndex(int countryIndex){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(LAST_PICKED_COUNTRY_INDEX, countryIndex);
        editor.apply();
        Log.v(TAG, "setLastCountryIndex=" + String.valueOf(countryIndex));
    }

    public String getUsername() {
        String name = sharedPreferences.getString(COL_USERNAME, null);
        if(name != null) {
            return name;
        }else{
            return "";
        }
    }

    public String getEmail() {
        String email = sharedPreferences.getString(COL_EMAIL, null);
        if (email != null) {
            return email;
        }else{
            return "";
        }
    }

    public String getPhoneNumber(){
        String phoneNumber = sharedPreferences.getString(COL_PHONE_NUMBER, null);
        if(phoneNumber != null) {
            return phoneNumber;
        }else{
            return "";
        }
    }

    public int getCountryIndex() {
        return sharedPreferences.getInt(LAST_PICKED_COUNTRY_INDEX, 0);
    }
}
