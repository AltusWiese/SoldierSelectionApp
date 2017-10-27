package com.example.awiese.unittesting.utils;

import android.content.Context;

import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.db.SoldierDatabase;
import com.example.awiese.unittesting.repository.SoldierRepository;
import com.example.awiese.unittesting.repository.SoldierRepositoryImpl;

public class MySingleton {

    private static MySingleton instance;
    private static  Context context;
    private SoldierDao soldierDao;
    private SoldierRepository soldierRepository;

    //a private constructor so no instances can be made outside this class
    public MySingleton() {}


    public static synchronized MySingleton getInstance() {
        if(instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
    public void init(Context context) {
        this.context = context.getApplicationContext();
    }

    public void getSoldierRepository() {
        //Context context = SoldierApplication.getAppContext();
        soldierDao = SoldierDatabase.getInstance(context).soldierDao();
        soldierRepository = new SoldierRepositoryImpl(soldierDao);

    }

}
