package com.example.awiese.unittesting;

import android.app.Application;
import android.util.Log;

import com.example.awiese.unittesting.utils.MySingleton;

public class SoldierApplication extends Application {

    private final MySingleton singleton = new MySingleton();

    @Override
    public void onCreate() {
        super.onCreate();
        singleton.init(this);

        Log.d("SoldierApp", "I was created!");

    }

    public static void getSoldierRepository() {
        MySingleton.getInstance().getSoldierRepository();

    }
}
