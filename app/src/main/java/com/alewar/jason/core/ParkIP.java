package com.alewar.jason.core;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by alvaro on 12/09/15.
 */
public class ParkIP extends Application {

    private String TAG = ParkIP.class.getCanonicalName();
    private static Context context;
    private static ParkIP application;
    private static User user;

    public void onCreate(){
        super.onCreate();
        ParkIP.context = getApplicationContext();
        ParkIP.application = this;
        user = new User();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static ParkIP getApplication(){ return ParkIP.application; }

    public static User getUser(){ return ParkIP.user; }

}