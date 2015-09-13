package com.alewar.jason.core;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alvaro on 12/09/15.
 */
public class ParkIP extends Application {

    private String TAG = ParkIP.class.getCanonicalName();
    private static Context context;
    private static ParkIP application;
    private static ParkIPUser user;

    private static SQLiteOpenHelper dbHelper;
    private static SQLiteDatabase database;

    public void onCreate(){
        super.onCreate();
        ParkIP.context = getApplicationContext();
        ParkIP.application = this;
        dbHelper = new ParkIPDBHelper(this);
        database = dbHelper.getWritableDatabase();
        user = new ParkIPUser();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        dbHelper.close();
        dbHelper = null;
    }

    public static ParkIP getApplication(){ return ParkIP.application; }

    public static Context getContext(){
        return ParkIP.context;
    }

    public static ParkIPUser getUser(){ return ParkIP.user; }

    public static SQLiteDatabase getDatabaseInstance(){ return ParkIP.database; }

}