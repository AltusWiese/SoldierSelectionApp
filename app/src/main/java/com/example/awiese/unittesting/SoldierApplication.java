package com.example.awiese.unittesting;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.awiese.unittesting.utils.MySingleton;

public class SoldierApplication extends Application {

   // public static MySingleton singleton;
    private MySingleton singleton = new MySingleton();
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton.init(this);

        Log.d("SoldierApp", "I was created!");

    }
    public static Context getAppContext() {
        return appContext;
    }

    public static void getSoldierRepository() {
         MySingleton.getInstance().getSoldierRepository();

    }
}
