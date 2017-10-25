package com.example.awiese.unittesting.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.awiese.unittesting.model.SoldierUnitModel;

import java.util.List;


@Dao
public interface SoldierDao {

    @Query(" SELECT * FROM " + SoldierUnitModel.TABLE_NAME)
    LiveData<List<SoldierUnitModel>> getAllSoldiers();

    @Query(" SELECT * FROM " + SoldierUnitModel.TABLE_NAME + " WHERE " + SoldierUnitModel.SOLDIER_AIM + " > :minAim")
    LiveData<List<SoldierUnitModel>> getBestMarksmanSoldiers(int minAim);

    @Query(" SELECT * FROM " + SoldierUnitModel.TABLE_NAME + " WHERE " + SoldierUnitModel.SOLDIER_SPEED + " > :minSpeed")
    LiveData<List<SoldierUnitModel>> getFastestSoldiers(int minSpeed);

    @Query(" SELECT * FROM " + SoldierUnitModel.TABLE_NAME + " WHERE " + SoldierUnitModel.SOLDIER_WILL + " > :minWill")
    LiveData<List<SoldierUnitModel>> getMostStrongWilledSoldiers(int minWill);

    @Query(" SELECT * FROM " + SoldierUnitModel.TABLE_NAME + " WHERE " + SoldierUnitModel.SOLDIER_DEFENSE + " > :minDefense")
    LiveData<List<SoldierUnitModel>> getMostHardenedSoldiers(int minDefense);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNewSoldier(SoldierUnitModel soldierUnitModel);
}
