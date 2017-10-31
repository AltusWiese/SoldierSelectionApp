package com.example.awiese.unittesting.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.model.SoldierUnitModel;


@Database(entities = {SoldierUnitModel.class}, version = 1, exportSchema = false)

public abstract class SoldierDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "soldier";
    private static final Object LOCK = new Object();
    private static volatile SoldierDatabase sInstance;

    public static SoldierDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            SoldierDatabase.class, SoldierDatabase.DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }

    public abstract SoldierDao soldierDao();



}
